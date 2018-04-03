
package com.tangtang.trade.hry.core.mvc.model.log;


import hry.core.mvc.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "app_log_login")
public class AppLogLogin
        extends BaseModel {

    @Id

    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "loginTime")
    private String loginTime;

    @Column(name = "ip")
    private String ip;

    @Column(name = "状态")
    private String status;


    public Long getId() {
        /*  58 */
        return this.id;

    }


    public void setId(Long id) {
        /*  66 */
        this.id = id;

    }


    public Long getUserId() {
        /*  74 */
        return this.userId;

    }


    public void setUserId(Long userId) {
        /*  82 */
        this.userId = userId;

    }


    public String getUserName() {
        /*  90 */
        return this.userName;

    }


    public void setUserName(String userName) {
        /*  98 */
        this.userName = userName;

    }


    public String getLoginTime() {
        /* 106 */
        return this.loginTime;

    }


    public void setLoginTime(String loginTime) {
        /* 114 */
        this.loginTime = loginTime;

    }


    public String getIp() {
        /* 122 */
        return this.ip;

    }


    public void setIp(String ip) {
        /* 130 */
        this.ip = ip;

    }


    public String getStatus() {
        /* 141 */
        return this.status;

    }


    public void setStatus(String status) {
        /* 149 */
        this.status = status;

    }


    public String getType() {
        /* 157 */
        return this.type;

    }


    public void setType(String type) {
        /* 165 */
        this.type = type;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\log\AppLogLogin.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */