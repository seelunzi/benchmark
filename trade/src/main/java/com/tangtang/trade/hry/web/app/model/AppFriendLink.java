
package com.tangtang.trade.hry.web.app.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_friendlink")
public class AppFriendLink
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "linkUrl")
    private String linkUrl;

    @Column(name = "picturePath")
    private String picturePath;

    @Column(name = "status")
    private Integer status;

    @Column(name = "isPicture")
    private Integer isPicture;

    @Column(name = "website")
    private String website;


    public String getWebsite() {
        /*  54 */
        return this.website;

    }


    /*  57 */
    public void setWebsite(String website) {
        this.website = website;
    }


    public AppFriendLink() {
    }


    public Long getId() {
        /*  63 */
        return this.id;

    }


    /*  66 */
    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        /*  69 */
        return this.name;

    }


    /*  72 */
    public void setName(String name) {
        this.name = name;
    }


    public String getLinkUrl() {
        /*  75 */
        return this.linkUrl;

    }


    /*  78 */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }


    public String getPicturePath() {
        /*  81 */
        return this.picturePath;

    }


    /*  84 */
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }


    public Integer getStatus() {
        /*  87 */
        return this.status;

    }


    /*  90 */
    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getIsPicture() {
        /*  93 */
        return this.isPicture;

    }


    /*  96 */
    public void setIsPicture(Integer isPicture) {
        this.isPicture = isPicture;
    }


    public String toString() {
        /* 100 */
        return "AppFrientLink [id=" + this.id + ", name=" + this.name + ", linkUrl=" + this.linkUrl + ", picturePath=" + this.picturePath + ", status=" + this.status + ", isPicture=" + this.isPicture + "]";

    }


    public AppFriendLink(Long id, String name, String linkUrl, String picturePath, Integer status, Integer isPicture) {
        /* 107 */
        this.id = id;
        /* 108 */
        this.name = name;
        /* 109 */
        this.linkUrl = linkUrl;
        /* 110 */
        this.picturePath = picturePath;
        /* 111 */
        this.status = status;
        /* 112 */
        this.isPicture = isPicture;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppFriendLink.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */