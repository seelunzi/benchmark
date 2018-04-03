
package com.tangtang.trade.hry.oauth.user.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_resource")
public class AppResource
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "mkey")
    private String mkey;

    @Column(name = "pkey")
    private String pkey;

    @Column(name = "className")
    private String className;

    @Column(name = "methodName")
    private String methodName;

    @Column(name = "sysName")
    private String sysName;

    @Column(name = "isLock")
    private String isLock;

    @Column(name = "isDelete")
    private String isDelete;

    @Column(name = "appName")
    private String appName;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "shiroUrl")
    private String shiroUrl;

    @Column(name = "type")
    private String type;


    public Long getId() {
        /*  71 */
        return this.id;

    }


    public void setId(Long id) {
        /*  79 */
        this.id = id;

    }


    public String getMkey() {
        /*  88 */
        return this.mkey;

    }


    public void setMkey(String mkey) {
        /*  96 */
        this.mkey = mkey;

    }


    public String getPkey() {
        /* 104 */
        return this.pkey;

    }


    public void setPkey(String pkey) {
        /* 112 */
        this.pkey = pkey;

    }


    public String getAppName() {
        /* 120 */
        return this.appName;

    }


    public void setAppName(String appName) {
        /* 128 */
        this.appName = appName;

    }


    public String getName() {
        /* 136 */
        return this.name;

    }


    public void setName(String name) {
        /* 144 */
        this.name = name;

    }


    public String getUrl() {
        /* 152 */
        return this.url;

    }


    public void setUrl(String url) {
        /* 160 */
        this.url = url;

    }


    public String getShiroUrl() {
        /* 168 */
        return this.shiroUrl;

    }


    public void setShiroUrl(String shiroUrl) {
        /* 176 */
        this.shiroUrl = shiroUrl;

    }


    public String getType() {
        /* 184 */
        return this.type;

    }


    public void setType(String type) {
        /* 192 */
        this.type = type;

    }


    public String getClassName() {
        /* 200 */
        return this.className;

    }


    public void setClassName(String className) {
        /* 208 */
        this.className = className;

    }


    public String getMethodName() {
        /* 216 */
        return this.methodName;

    }


    public void setMethodName(String methodName) {
        /* 224 */
        this.methodName = methodName;

    }


    public String getSysName() {
        /* 232 */
        return this.sysName;

    }


    public void setSysName(String sysName) {
        /* 240 */
        this.sysName = sysName;

    }


    public String getIsLock() {
        /* 248 */
        return this.isLock;

    }


    public void setIsLock(String isLock) {
        /* 256 */
        this.isLock = isLock;

    }


    public String getIsDelete() {
        /* 264 */
        return this.isDelete;

    }


    public void setIsDelete(String isDelete) {
        /* 272 */
        this.isDelete = isDelete;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppResource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */