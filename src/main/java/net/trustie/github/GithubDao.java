package net.trustie.github;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by g1a@pdl on 2015/9/29 0:25.
 */
public interface GithubDao {

    @Select("select * from p_random where isdown is null limit 1")
    public GithubRepoDown getRepoInfo();

    @Update("update p_random set size=${size},isdown=${isdown},spend=${spend} where id=${id}")
    public int updateRepoInfo(GithubRepoDown repo);

    @Update("update repo set `name`=#{name},full_name=#{full_name},`description`=#{description}," +
            "created_at=#{created_at},updated_at=#{updated_at},pushed_at=#{pushed_at}," +
            "size=#{size},homepage=#{homepage},stargazers_count=#{stargazers_count},watchers_count=#{watchers_count}," +
            "has_issues=#{has_issues},has_downloads=#{has_downloads},has_wiki=#{has_wiki}," +
            "has_pages=#{has_pages},language=#{language}," +
            "forks_count=#{forks_count},open_issues_count=#{open_issues_count},forks=#{forks},open_issues=#{open_issues}," +
            "watchers=#{watchers},network_count=#{network_count},subscribers_count=#{subscribers_count}," +
            "`id`=#{id},isdown=#{isdown} " +
            " where id_db=#{id_db}")
    public int updateApiInfo(GithubApi repo);

    @Insert("insert into repo_api(`id`,`api`) values (#{id},#{api})")
    public int insertRepoApi(@Param("id")int id,@Param("api")String api);

    @Select("select url from repo where isdown is null limit 1")
    public String getApiUrl();

    @Select("select id_db from repo where url=#{url} and isdown is null limit 1")
    public int findIdbyUrl(@Param("url")String url);

    @Select("select url from repo_pom where isdown is null limit 1")
    public String getPomUrl();

    @Select("select id from repo_pom where url=#{url} and isdown is null limit 1")
    public int findIdbyPomUrl(@Param("url")String url);

    @Update("update repo_pom set `has_pom`=#{has_pom},`has_libs`=#{has_libs},`url_pom`=#{url_pom},`url_libs`=#{url_libs}" +
            ",`isdown`=#{isdown} " +
            "where `url`=#{url}")
    public int updatePomInfo(GithubHas pom);


    //œ¬‘ÿpom
    @Select("select url_pom from repo_set_has_pom where isdown is null limit 1")
    public String getOnePomUrl();

    @Update("update repo_set_has_pom set `isdown`=#{isdown},`pom`=#{pom} " +
            "where `url_pom`=#{url_pom}")
    public int updatePom(@Param("url_pom")String url_pom,@Param("pom")String pom,@Param("isdown")int isdown);

    @Insert("insert into repo_set_has_pom_html(`url_pom`,`html`) values (#{url_pom},#{html})")
    public int insertPomHtml(@Param("url_pom")String url_pom,@Param("html")String html);



    //œ¬‘ÿpom
    @Select("select url_libs from repo_set_has_libs where isdown is null limit 1")
    public String getOneLibsUrl();

    @Update("update repo_set_has_libs set `isdown`=#{isdown},`libs`=#{libs} " +
            "where `url_libs`=#{url_libs}")
    public int updateLibs(@Param("url_libs")String url_libs,@Param("libs")String libs,@Param("isdown")int isdown);

    /*@Insert("insert into repo_set_has_libs_html(`url_pom`,`html`) values (#{url_pom},#{html})")
    public int insertPomHtml(@Param("url_pom")String url_pom,@Param("html")String html);*/



}
