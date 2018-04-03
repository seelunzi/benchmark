
package com.tangtang.trade.hry.manage.init.model;


import hry.core.mvc.model.MgrBaseModel;

import javax.persistence.*;


@Table(name = "mgr_app_resource")
public class MgrAppResource
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


    public Long getId() {
        /*  64 */
        return this.id;

    }


    public void setId(Long id) {
        /*  71 */
        this.id = id;

    }


    public String getName() {
        /*  79 */
        return this.name;

    }


    public void setName(String name) {
        /*  86 */
        this.name = name;

    }


    public String getUrl() {
        /*  93 */
        return this.url;

    }


    public void setUrl(String url) {
        /* 100 */
        this.url = url;

    }


    public String getClassName() {
        /* 107 */
        return this.className;

    }


    public void setClassName(String className) {
        /* 114 */
        this.className = className;

    }


    public String getMethodName() {
        /* 121 */
        return this.methodName;

    }


    public void setMethodName(String methodName) {
        /* 128 */
        this.methodName = methodName;

    }


    public String getSysName() {
        /* 135 */
        return this.sysName;

    }


    public void setSysName(String sysName) {
        /* 142 */
        this.sysName = sysName;

    }


    public String getIsLock() {
        /* 149 */
        return this.isLock;

    }


    public void setIsLock(String isLock) {
        /* 156 */
        this.isLock = isLock;

    }


    public String getIsDelete() {
        /* 163 */
        return this.isDelete;

    }


    public void setIsDelete(String isDelete) {
        /* 170 */
        this.isDelete = isDelete;

    }


    public String getAppName() {
        /* 177 */
        return this.appName;

    }


    public void setAppName(String appName) {
        /* 184 */
        this.appName = appName;

    }


    public String getMkey() {
        /* 191 */
        return this.mkey;

    }


    public void setMkey(String mkey) {
        /* 198 */
        this.mkey = mkey;

    }


    public String getPkey() {
        /* 205 */
        return this.pkey;

    }


    public void setPkey(String pkey) {
        /* 212 */
        this.pkey = pkey;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\manage\init\model\MgrAppResource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */