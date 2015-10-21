package net.trustie.github;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
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
public class GithubPomLibsCrawler {

    final Site site = Site.me().setRetryTimes(2).setTimeOut(120000).setSleepTime(1000).setDomain("github.com")
            .setUserAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").setCharset("UTF-8");
    final String token_access0="?access_token=877738b0ede13b627605e301dd4f00725697ca0d";
    final String token_access1="?access_token=8368357f10e6318309b7e278b900e375f73421bd";
    final String token_access2="?access_token=6ac08b18aa04a36b602957be808a813900487173";
    final String token_access3="?access_token=e94b02919d147be8df7dfc5ede4de92c3a75b1b4";
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
                List<String> poms=new ArrayList<String>();
                String currentUrl=page.getUrl().replace("https://raw.githubusercontent.com","https://github.com").
                        replace("/master/pom.xml", "/blob/master/pom.xml").get();
                if(page.getStatusCode()!=200){
                    page.setSkip(true);
                    dao.updatePom(currentUrl,poms.toString(),-1);
                    return;
                }
                try {
                    List<Element> elements=new ArrayList<Element>();
                    // 必须加上trim去开头，也就是说第一个字符必须是<?xml......
                    Document document = DocumentHelper.parseText(page.getRawText().trim());
                    Element dependencies = document.getRootElement().element("dependencies");
                    Element dependencyManagement = document.getRootElement().element("dependencyManagement");

                    if(dependencies==null){
                        // 没dependencies，也要有上游的dependencyManagement
                        if(dependencyManagement!=null){
                            dependencies=dependencyManagement.element("dependencies");
                            elements=dependencies.elements("dependency");
                        }else{
                            // 虽然有pom文件，也可能没依赖
                            dao.updatePom(currentUrl,poms.toString(),1);
                            dao.insertPomHtml(currentUrl,page.getRawText());
                            return;
                        }
                    }else{
                        // 先取dependency
                        elements=dependencies.elements("dependency");
                        // 有些pom同时存在dependencyManagement和dependencies
                        if(dependencyManagement!=null){
                            List<Element> elements1=dependencyManagement.element("dependencies").elements("dependency");
                            for (Element element : elements1) {
                                elements.add((Element)element.clone());
                            }
                        }
                    }

                    for (Element element : elements) {
                        // version可能不存在
                        Element ver=element.element("version");
                        String version="0.0.0";
                        if (ver!=null){
                            version=ver.getText().trim();
                        }
                        if(version.startsWith("$")){
                            Element properties = document.getRootElement().element("properties");
                            if(properties!=null) {
                                Element elementVersion = properties.element(version.replace("$", "").replace("{", "").replace("}", ""));
                                // elementVersion可能不存在，作者同志写的五花八门
                                if (elementVersion != null) {
                                    version = elementVersion.getText();
                                }
                            }else {
                                version="0.0.0";
                            }

                        }
                        poms.add("{" + element.element("groupId").getText().trim() + "-}" +
                                element.element("artifactId").getText().trim() + "-" + version);
                    }

                    dao.updatePom(currentUrl,poms.toString(),1);
                    dao.insertPomHtml(currentUrl,page.getRawText());

                } catch (Exception e) {
                    dao.updatePom(currentUrl,poms.toString(),0);
                    e.printStackTrace();
                }finally {
                    page.addTargetRequest(dao.getOnePomUrl().replaceFirst("https://github.com", "https://raw.githubusercontent.com").
                            replaceFirst("blob/",""));
                }
            }
            public Site getSite() {return site;}
        //}).addUrl(dao.getPomUrl().replaceFirst("api.","").replaceFirst("repos/","")).thread(1).run();
        }).addUrl(dao.getOnePomUrl().
                replaceFirst("https://github.com", "https://raw.githubusercontent.com").
                replaceFirst("blob/","")).run();

    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/applicationContext.xml");
        while (true) {
            applicationContext.getBean(GithubPomLibsCrawler.class).run();
            System.out.println("next stage!");
       }

    }


}
