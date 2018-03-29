/*     */
package com.tangtang.trade.hry.core.mvc.model.log;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
@Table(name = "app_log")
/*     */ public class AppLog
        /*     */ extends BaseModel
        /*     */ {
    /*     */
    @Id
    /*     */
    @Column(name = "id")
    /*     */ private String id;
    /*     */
    @Column(name = "className")
    /*     */ private String className;
    /*     */
    @Column(name = "methodName")
    /*     */ private String methodName;
    /*     */
    @Column(name = "methodFullName")
    /*     */ private String methodFullName;
    /*     */
    @Column(name = "methodCnName")
    /*     */ private String methodCnName;
    /*     */
    @Column(name = "argsContent")
    /*     */ private String argsContent;
    /*     */
    @Column(name = "returnValue")
    /*     */ private String returnValue;
    /*     */
    @Column(name = "ip")
    /*     */ private String ip;
    /*     */
    @Column(name = "userName")
    /*     */ private String userName;
    /*     */
    @Column(name = "appName")
    /*     */ private String appName;
    /*     */
    @Column(name = "requestUrl")
    /*     */ private String requestUrl;
    /*     */
    @Column(name = "systemTime")
    /*     */ private String systemTime;

    /*     */
    /*     */
    public String getSystemTime()
    /*     */ {
        /*  73 */
        return this.systemTime;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setSystemTime(String systemTime)
    /*     */ {
        /*  81 */
        this.systemTime = systemTime;
        /*     */
    }

    /*     */
    /*     */
    public String getUserName() {
        /*  85 */
        return this.userName;
        /*     */
    }

    /*     */
    /*     */
    public void setUserName(String userName) {
        /*  89 */
        this.userName = userName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getId()
    /*     */ {
        /*  99 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(String id)
    /*     */ {
        /* 107 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    public String getClassName() {
        /* 111 */
        return this.className;
        /*     */
    }

    /*     */
    /*     */
    public void setClassName(String className) {
        /* 115 */
        this.className = className;
        /*     */
    }

    /*     */
    /*     */
    public String getMethodName() {
        /* 119 */
        return this.methodName;
        /*     */
    }

    /*     */
    /*     */
    public void setMethodName(String methodName) {
        /* 123 */
        this.methodName = methodName;
        /*     */
    }

    /*     */
    /*     */
    public String getMethodFullName() {
        /* 127 */
        return this.methodFullName;
        /*     */
    }

    /*     */
    /*     */
    public void setMethodFullName(String methodFullName) {
        /* 131 */
        this.methodFullName = methodFullName;
        /*     */
    }

    /*     */
    /*     */
    public String getMethodCnName() {
        /* 135 */
        return this.methodCnName;
        /*     */
    }

    /*     */
    /*     */
    public void setMethodCnName(String methodCnName) {
        /* 139 */
        this.methodCnName = methodCnName;
        /*     */
    }

    /*     */
    /*     */
    public String getArgsContent() {
        /* 143 */
        return this.argsContent;
        /*     */
    }

    /*     */
    /*     */
    public void setArgsContent(String argsContent) {
        /* 147 */
        this.argsContent = argsContent;
        /*     */
    }

    /*     */
    /*     */
    public String getReturnValue() {
        /* 151 */
        return this.returnValue;
        /*     */
    }

    /*     */
    /*     */
    public void setReturnValue(String returnValue) {
        /* 155 */
        this.returnValue = returnValue;
        /*     */
    }

    /*     */
    /*     */
    public String getIp() {
        /* 159 */
        return this.ip;
        /*     */
    }

    /*     */
    /*     */
    public void setIp(String ip) {
        /* 163 */
        this.ip = ip;
        /*     */
    }

    /*     */
    /*     */
    public String getAppName() {
        /* 167 */
        return this.appName;
        /*     */
    }

    /*     */
    /*     */
    public void setAppName(String appName) {
        /* 171 */
        this.appName = appName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getRequestUrl()
    /*     */ {
        /* 179 */
        return this.requestUrl;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setRequestUrl(String requestUrl)
    /*     */ {
        /* 187 */
        this.requestUrl = requestUrl;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\log\AppLog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */