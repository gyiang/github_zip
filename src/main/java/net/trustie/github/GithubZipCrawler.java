package net.trustie.github;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by g1a@pdl on 2015/9/28 21:51.
 */
// need time-out solve
@Component
public class GithubZipCrawler {

    private Logger logger =Logger.getLogger(this.getClass());
    @Resource
    private GithubDao dao;

    public void run(){
        while (true){
            downloader();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public boolean downloader(){
        // FileUtils.copyURLToFile(httpurl, f);
        GithubRepoDown gitrepo=dao.getRepoInfo();
        //Exception in thread "main" java.lang.NullPointerException
        String targetUrl=gitrepo.getUrl();
        logger.info("current task:"+targetUrl);
        long starTime=System.currentTimeMillis();
        String downloadZip=targetUrl.replace("api.","").replace("repos/","")
                +"/archive/master.zip";
        String downloadFileName="./zip/"+targetUrl.replace("https://api.github.com/repos/","")
                .replace("/","-")+"-master.zip";
        int bytesum = 0;
        int byteread = 0;
        InputStream inStream=null;
        FileOutputStream fs =null;
        try {
            URL url = new URL(downloadZip);
            URLConnection conn = url.openConnection();
            inStream = conn.getInputStream();
            fs = new FileOutputStream(downloadFileName);
            byte[] buffer = new byte[4028];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            long spend=(System.currentTimeMillis() - starTime) / 1000;
            logger.info(downloadFileName + " Fetch!" + " size:" + bytesum/1024+"k"+
                    " time:" + spend + "s");
            gitrepo.setSpend(spend);
            gitrepo.setSize(bytesum / 1024);
            gitrepo.setIsdown(1);
            dao.updateRepoInfo(gitrepo);

        } catch (Exception e) {
            gitrepo.setIsdown(0);
            dao.updateRepoInfo(gitrepo);
            logger.error(downloadFileName + " Download Error:" + e);
            return false;
        } finally{
            try {
                if(inStream!=null){
                    inStream.close();
                }
            } catch (IOException e) {
                inStream=null;
            }
            try {
                if(fs!=null){
                    fs.close();
                }
            } catch (IOException e) {
                fs=null;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/applicationContext.xml");
        applicationContext.getBean(GithubZipCrawler.class).run();
    }
}
