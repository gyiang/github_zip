package net.trustie.github;

/**
 * Created by g1a@pdl on 2015/10/9 16:33.
 */
public class GithubHas {
    private int id;
    private String url;
    private int has_pom=0;
    private int has_libs=0;
    private String url_pom;
    private String url_libs;
    private int isdown;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHas_pom() {
        return has_pom;
    }

    public void setHas_pom(int has_pom) {
        this.has_pom = has_pom;
    }

    public int getHas_libs() {
        return has_libs;
    }

    public void setHas_libs(int has_libs) {
        this.has_libs = has_libs;
    }

    public String getUrl_pom() {
        return url_pom;
    }

    public void setUrl_pom(String url_pom) {
        this.url_pom = url_pom;
    }

    public String getUrl_libs() {
        return url_libs;
    }

    public void setUrl_libs(String url_libs) {
        this.url_libs = url_libs;
    }
}
