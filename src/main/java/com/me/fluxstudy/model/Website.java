package com.me.fluxstudy.model;

/**  */
public class Website {

    /**  */
    private Integer id;

    /** 站点名称 */
    private String name;

    /**  */
    private String url;

    /** Alexa 排名 */
    private Integer alexa;

    /** 国家 */
    private String country;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAlexa() {
        return alexa;
    }

    public void setAlexa(Integer alexa) {
        this.alexa = alexa;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
