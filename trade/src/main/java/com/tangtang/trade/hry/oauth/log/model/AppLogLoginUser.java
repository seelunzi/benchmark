/*     */
package com.tangtang.trade.hry.oauth.log.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.util.Date;

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
@Table(name = "app_log_login_customer")
/*     */ public class AppLogLoginUser
        /*     */ extends BaseModel
        /*     */ {
    /*     */
    @Id
    /*     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*     */
    @Column(name = "id", unique = true, nullable = false)
    /*     */ private Long id;
    /*     */
    @Column(name = "customerId")
    /*     */ private Long customerId;
    /*     */
    @Column(name = "userName")
    /*     */ private String userName;
    /*     */
    @Column(name = "loginTime")
    /*     */ private Date loginTime;
    /*     */
    @Column(name = "ip")
    /*     */ private String ip;
    /*     */
    @Column(name = "isLogin")
    /*     */ private Integer isLogin;

    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  53 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /*  61 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getCustomerId()
    /*     */ {
        /*  71 */
        return this.customerId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setCustomerId(Long customerId)
    /*     */ {
        /*  79 */
        this.customerId = customerId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getUserName()
    /*     */ {
        /*  87 */
        return this.userName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setUserName(String userName)
    /*     */ {
        /*  95 */
        this.userName = userName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Date getLoginTime()
    /*     */ {
        /* 103 */
        return this.loginTime;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setLoginTime(Date loginTime)
    /*     */ {
        /* 111 */
        this.loginTime = loginTime;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getIp()
    /*     */ {
        /* 119 */
        return this.ip;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setIp(String ip)
    /*     */ {
        /* 127 */
        this.ip = ip;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getIsLogin()
    /*     */ {
        /* 135 */
        return this.isLogin;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsLogin(Integer isLogin)
    /*     */ {
        /* 143 */
        this.isLogin = isLogin;
        /*     */
    }
    /*     */
}
