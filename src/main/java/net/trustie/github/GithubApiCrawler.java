package net.trustie.github;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by g1a@pdl on 2015/9/29 13:56.
 */
@Component
public class GithubApiCrawler {

    final Site site = Site.me().setRetryTimes(2).setTimeOut(120000).setSleepTime(1000).setDomain("github.com")
            .setUserAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");

    final String token="?access_token=877738b0ede13b627605e301dd4f00725697ca0d";
    final String token_cmw="?access_token=8368357f10e6318309b7e278b900e375f73421bd";
    @Resource
    private GithubDao dao;
    private Logger logger = Logger.getLogger(this.getClass());

    public void run() {
        // 404页面也下载
        Set<Integer> set = new HashSet<Integer>();
        set.addAll(Arrays.asList(new Integer[]{200,404,403,503,500,502,504,400}));
        site.setAcceptStatCode(set);
        Spider.create(new PageProcessor() {
           public void process(Page page) {
               GithubApi githubApi = new GithubApi();
               int id_db = dao.findIdbyUrl(page.getUrl().regex("(.*)\\?access_token").toString());
               if (page.getStatusCode() == 200) {
                   logger.info("Fetched! " + page.getUrl().regex("(.*)\\?access_token"));
                   String apiJson = page.getRawText();
                   githubApi = JSON.parseObject(apiJson, GithubApi.class);
                   githubApi.setIsdown(1);
                   githubApi.setId_db(id_db);
               } else {
                   githubApi.setIsdown(0);
                   githubApi.setId_db(id_db);
               }
               // 更新抓取信息
               dao.updateApiInfo(githubApi);
               // 加入下一个任务
               page.addTargetRequest(dao.getApiUrl()+token_cmw);
               page.putField("repo", githubApi);
               page.putField("api", page.getRawText());

           }

           public Site getSite() {
               return site;
           }
       }).addPipeline(new Pipeline() {
           public void process(ResultItems resultItems, Task task) {
               // 将api_json持久化
               GithubApi githubApi = (GithubApi) resultItems.get("repo");
               try {
                   dao.insertRepoApi(githubApi.getId(), (String) resultItems.get("api"));
                   logger.info("save success:" + githubApi.getFull_name());
               } catch (Exception ex) {
                   logger.error("save failed:" + ex.toString());
               }

           }
       }).addUrl(dao.getApiUrl()+token_cmw).run();

    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/applicationContext.xml");
        while (true) {
            applicationContext.getBean(GithubApiCrawler.class).run();
            System.out.println("next stage!");
        }

    }


}
