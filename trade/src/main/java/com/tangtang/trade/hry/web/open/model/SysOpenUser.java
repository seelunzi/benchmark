
package com.tangtang.trade.hry.web.open.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "sys_open_user")
public class SysOpenUser extends BaseModel {
    private static final long serialVersionUID = 1L;

    @Id

    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "passWord")
    private String passWord;

    @Column(name = "appKey")
    private String appKey;

    @Column(name = "secret")
    private String secret;


    public String getPassWord() {
        /*  28 */
        return this.passWord;

    }


    public void setPassWord(String passWord) {
        /*  32 */
        this.passWord = passWord;

    }


    public String getAppKey() {
        /*  36 */
        return this.appKey;

    }


    public void setAppKey(String appKey) {
        /*  40 */
        this.appKey = appKey;

    }


    public Long getId() {
        /*  75 */
        return this.id;

    }


    public void setId(Long id) {
        /*  86 */
        this.id = id;

    }


    public String getUserName() {
        /*  97 */
        return this.userName;

    }


    public void setUserName(String userName) {
        /* 108 */
        this.userName = userName;

    }


    public String getSecret() {
        /* 120 */
        return this.secret;

    }


    public void setSecret(String secret) {
        /* 131 */
        this.secret = secret;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\open\model\SysOpenUser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */