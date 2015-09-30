package net.trustie.github;

/**
 * Created by g1a@pdl on 2015/9/29 10:23.
 */
public class GithubApi {
    private int id_db;
    private int id;
    private int isdown;
    private String url;
    private String name;
    private String full_name;
    private String description;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String homepage;
    private String language;
    private int size;
    private int stargazers_count;
    private int watchers_count;
    private String has_issues;
    private String has_downloads;
    private String has_wiki;
    private String has_pages;
    private int forks_count;
    private int open_issues_count;
    private int forks;
    private int open_issues;
    private int watchers;
    private int network_count;
    private int subscribers_count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
       /* if (homepage==null||homepage.equals(""))
            this.homepage = "null";
        else*/
            this.homepage = homepage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(int watchers_count) {
        this.watchers_count = watchers_count;
    }

    public String getHas_issues() {
        return has_issues;
    }

    public void setHas_issues(String has_issues) {
        this.has_issues = has_issues;
    }

    public String getHas_downloads() {
        return has_downloads;
    }

    public void setHas_downloads(String has_downloads) {
        this.has_downloads = has_downloads;
    }

    public String getHas_wiki() {
        return has_wiki;
    }

    public void setHas_wiki(String has_wiki) {
        this.has_wiki = has_wiki;
    }

    public String getHas_pages() {
        return has_pages;
    }

    public void setHas_pages(String has_pages) {
        this.has_pages = has_pages;
    }

    public int getForks_count() {
        return forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }

    public int getOpen_issues_count() {
        return open_issues_count;
    }

    public void setOpen_issues_count(int open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public int getNetwork_count() {
        return network_count;
    }

    public void setNetwork_count(int network_count) {
        this.network_count = network_count;
    }

    public int getSubscribers_count() {
        return subscribers_count;
    }

    public void setSubscribers_count(int subscribers_count) {
        this.subscribers_count = subscribers_count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId_db() {
        return id_db;
    }

    public void setId_db(int id_db) {
        this.id_db = id_db;
    }

    public int getIsdown() {
        return isdown;
    }

    public void setIsdown(int isdown) {
        this.isdown = isdown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
