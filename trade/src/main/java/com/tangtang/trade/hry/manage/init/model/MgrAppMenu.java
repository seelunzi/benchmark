
package com.tangtang.trade.hry.manage.init.model;


import hry.core.mvc.model.MgrBaseModel;

import javax.persistence.*;


@Table(name = "mgr_app_menu")
public class MgrAppMenu
        extends MgrBaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "mkey")
    private String mkey;

    @Column(name = "pkey")
    private String pkey;

    @Column(name = "appName")
    private String appName;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "shiroUrl")
    private String shiroUrl;

    @Column(name = "isOpen")
    private String isOpen;

    @Column(name = "isOutLink")
    private String isOutLink;

    @Column(name = "orderNo")
    private String orderNo;

    @Column(name = "type")
    private String type;


    public Long getId() {
        /*  64 */
        return this.id;

    }


    public void setId(Long id) {
        /*  72 */
        this.id = id;

    }


    public String getName() {
        /*  80 */
        return this.name;

    }


    public void setName(String name) {
        /*  88 */
        this.name = name;

    }


    public String getUrl() {
        /*  96 */
        return this.url;

    }


    public void setUrl(String url) {
        /* 104 */
        this.url = url;

    }


    public String getShiroUrl() {
        /* 114 */
        return this.shiroUrl;

    }


    public void setShiroUrl(String shiroUrl) {
        /* 122 */
        this.shiroUrl = shiroUrl;

    }


    public String getIsOpen() {
        /* 130 */
        return this.isOpen;

    }


    public void setIsOpen(String isOpen) {
        /* 138 */
        this.isOpen = isOpen;

    }


    public String getIsOutLink() {
        /* 146 */
        return this.isOutLink;

    }


    public void setIsOutLink(String isOutLink) {
        /* 154 */
        this.isOutLink = isOutLink;

    }


    public String getOrderNo() {
        /* 162 */
        return this.orderNo;

    }


    public void setOrderNo(String orderNo) {
        /* 170 */
        this.orderNo = orderNo;

    }


    public String getAppName() {
        /* 178 */
        return this.appName;

    }


    public void setAppName(String appName) {
        /* 186 */
        this.appName = appName;

    }


    public String getMkey() {
        /* 196 */
        return this.mkey;

    }


    public void setMkey(String mkey) {
        /* 204 */
        this.mkey = mkey;

    }


    public String getPkey() {
        /* 212 */
        return this.pkey;

    }


    public void setPkey(String pkey) {
        /* 220 */
        this.pkey = pkey;

    }


    public String getType() {
        /* 228 */
        return this.type;

    }


    public void setType(String type) {
        /* 236 */
        this.type = type;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\manage\init\model\MgrAppMenu.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */