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


}
