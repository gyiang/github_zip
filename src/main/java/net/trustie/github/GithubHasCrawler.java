package net.trustie.github;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by g1a@pdl on 2015/9/29 13:56.
 */
@Component
public class GithubHasCrawler {

    final Site site = Site.me().setRetryTimes(2).setTimeOut(120000).setSleepTime(1000).setDomain("github.com")
            .setUserAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");

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
                GithubHas githubPom=new GithubHas();
                String repo=page.getUrl().regex("github.com/(.*)").toString();

                if (page.getStatusCode() == 200) {
                    boolean flag=false;
                    if(page.getHtml().links().regex(".*/tree/master/libs?").toString()!=null){
                        githubPom.setHas_libs(1);
                        githubPom.setUrl_libs(page.getHtml().links().regex(".*/tree/master/libs?").toString());
                    }
                    if(page.getHtml().links().regex(".*/blob/master/pom.xml").toString()!=null){
                        githubPom.setHas_pom(1);
                        githubPom.setUrl_pom(page.getUrl().toString() + "/blob/master/pom.xml");
                    }
                    githubPom.setIsdown(1);
                    logger.info("save success:" + repo);
                } else {
                    githubPom.setIsdown(0);
                    System.out.println(page.getStatusCode());
                    logger.error("save failed:" + repo);
                }
                githubPom.setUrl("https://api.github.com/repos/" + repo);
                dao.updatePomInfo(githubPom);
                page.addTargetRequest(dao.getPomUrl().replaceFirst("api.", "").replaceFirst("repos/", "").toString());
                // page.putField("pom", githubPom);
                // page.putField("curreet",url);
            }
            public Site getSite() {return site;}
        }).addUrl(dao.getPomUrl().replaceFirst("api.","").replaceFirst("repos/","")).thread(5).run();
       // }).addUrl("https://github.com/netty/netty").run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/applicationContext.xml");
        while (true) {
            applicationContext.getBean(GithubHasCrawler.class).run();
            System.out.println("next stage!");
       }

    }


}
