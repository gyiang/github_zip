package net.trustie.github;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by g1a@pdl on 2015/9/29 13:56.
 */
@Component
public class GithubPomLibsCrawler_libs {

    final Site site = Site.me().setRetryTimes(2).setTimeOut(120000).setSleepTime(1000).setDomain("github.com")
            .setUserAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").setCharset("UTF-8");
    @Resource
    private GithubDao dao;
    private Logger logger = Logger.getLogger(this.getClass());

    public void run() {
        // 404页面也下载
        Set<Integer> set = new HashSet<Integer>();
        set.addAll(Arrays.asList(new Integer[]{200,404,400,403,500,502,503,504,}));
        site.setAcceptStatCode(set);
        Spider.create(new PageProcessor() {
            public void process(Page page) {
                List<String> libs=new ArrayList<String>();
                String currentUrl=page.getUrl().get();
                if(page.getStatusCode()!=200){
                    page.setSkip(true);
                    dao.updateLibs(currentUrl, libs.toString(), page.getStatusCode());
                    return;
                }
                try {

                    // 提取出jar
                    libs = page.getHtml().links().regex("lib[s]?/(.*).jar").all();
                    System.out.println("libs>>>>>>"+libs.toString());
                    dao.updateLibs(currentUrl, libs.toString(), 1);
                }catch (Exception e){
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }finally {
                    page.addTargetRequest(dao.getOneLibsUrl());
                }
            }
            public Site getSite() {return site;}
        }).addUrl(dao.getOneLibsUrl()).run();

    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/applicationContext.xml");
        while (true) {
            applicationContext.getBean(GithubPomLibsCrawler_libs.class).run();
            System.out.println("next stage!");
       }

    }


}
