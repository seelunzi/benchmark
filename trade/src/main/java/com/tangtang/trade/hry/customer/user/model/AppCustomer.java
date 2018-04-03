
package com.tangtang.trade.hry.customer.user.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.util.Date;


@Table(name = "app_customer")
public class AppCustomer
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "passWord")
    private String passWord;

    @Column(name = "accountPassWord")
    private String accountPassWord;

    @Column(name = "isLock")
    private Integer isLock;

    @Column(name = "lockTime")
    private Date lockTime;

    @Column(name = "isChange")
    private Integer isChange;

    @Column(name = "isDelete")
    private Integer isDelete;

    @Column(name = "isReal")
    private Integer isReal;

    @Column(name = "isRealUsd")
    private Integer isRealUsd;

    @Column(name = "salt")
    private String salt;

    @Column(name = "userCode")
    private String userCode;

    @Column(name = "integral")
    private Integer integral;

    @Column(name = "type")
    private String type;

    @Transient
    private Object appPersonInfo;

    @Column(name = "referralCode")
    private String referralCode;

    @Column(name = "hasEmail")
    public Integer hasEmail;

    @Column(name = "googleKey")
    private String googleKey;

    @Column(name = "googleState")
    private Integer googleState;

    @Column(name = "googleDate")
    private Date googleDate;

    @Column(name = "isProving")
    private Integer isProving;

    @Column(name = "messIp")
    private String messIp;

    @Column(name = "passDate")
    private Date passDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phoneState")
    private Integer phoneState;

    @Column(name = "openPhone")
    private Integer openPhone;

    @Column(name = "states")
    private Integer states;

    @Column(name = "uuid")
    private String uuid;

    @Transient
    private Long customerId;

    @Transient
    private String truename;

    @Transient
    private String surname;

    @Column(name = "commendCode")
    private String commendCode;

    @Column(name = "receCode")
    private String receCode;


    public String getReceCode() {
        /* 146 */
        return this.receCode;

    }


    public void setReceCode(String receCode) {
        /* 150 */
        this.receCode = receCode;

    }


    public String getCommendCode() {
        /* 154 */
        return this.commendCode;

    }


    public void setCommendCode(String commendCode) {
        /* 158 */
        this.commendCode = commendCode;

    }


    public String getSurname() {
        /* 162 */
        return this.surname;

    }


    public void setSurname(String surname) {
        /* 166 */
        this.surname = surname;

    }


    public String getTruename() {
        /* 170 */
        return this.truename;

    }


    public void setTruename(String truename) {
        /* 174 */
        this.truename = truename;

    }


    public Long getCustomerId() {
        /* 178 */
        return this.customerId;

    }


    public void setCustomerId(Long customerId) {
        /* 182 */
        this.customerId = customerId;

    }


    public String getUuid() {
        /* 186 */
        return this.uuid;

    }


    public void setUuid(String uuid) {
        /* 190 */
        this.uuid = uuid;

    }


    public Integer getStates() {
        /* 194 */
        return this.states;

    }


    public void setStates(Integer states) {
        /* 198 */
        this.states = states;

    }


    public Integer getOpenPhone() {
        /* 204 */
        return this.openPhone;

    }


    public void setOpenPhone(Integer openPhone) {
        /* 208 */
        this.openPhone = openPhone;

    }


    public String getPhone() {
        /* 212 */
        return this.phone;

    }


    public void setPhone(String phone) {
        /* 216 */
        this.phone = phone;

    }


    public Integer getPhoneState() {
        /* 220 */
        return this.phoneState;

    }


    public void setPhoneState(Integer phoneState) {
        /* 224 */
        this.phoneState = phoneState;

    }


    public Date getPassDate() {
        /* 228 */
        return this.passDate;

    }


    public void setPassDate(Date passDate) {
        /* 232 */
        this.passDate = passDate;

    }


    public String getMessIp() {
        /* 236 */
        return this.messIp;

    }


    public void setMessIp(String messIp) {
        /* 240 */
        this.messIp = messIp;

    }


    public Integer getGoogleState() {
        /* 244 */
        return this.googleState;

    }


    public void setGoogleState(Integer googleState) {
        /* 248 */
        this.googleState = googleState;

    }


    /* 251 */
    public Date getGoogleDate() {
        return this.googleDate;
    }


    public void setGoogleDate(Date googleDate) {
        /* 255 */
        this.googleDate = googleDate;

    }


    public Integer getIsProving() {
        /* 259 */
        return this.isProving;

    }


    public void setIsProving(Integer isProving) {
        /* 263 */
        this.isProving = isProving;

    }


    public Integer getIsChange() {
        /* 271 */
        return this.isChange;

    }


    public void setIsChange(Integer isChange) {
        /* 279 */
        this.isChange = isChange;

    }


    public Integer getHasEmail() {
        /* 283 */
        return this.hasEmail;

    }


    public void setHasEmail(Integer hasEmail) {
        /* 287 */
        this.hasEmail = hasEmail;

    }


    public String getReferralCode() {
        /* 294 */
        return this.referralCode;

    }


    public void setReferralCode(String referralCode) {
        /* 301 */
        this.referralCode = referralCode;

    }


    public Long getId() {
        /* 309 */
        return this.id;

    }


    public void setId(Long id) {
        /* 317 */
        this.id = id;

    }


    public String getUserName() {
        /* 325 */
        return this.userName;

    }


    public void setUserName(String userName) {
        /* 333 */
        this.userName = userName;

    }


    public String getPassWord() {
        /* 341 */
        return this.passWord;

    }


    public void setPassWord(String passWord) {
        /* 349 */
        this.passWord = passWord;

    }


    public String getAccountPassWord() {
        /* 357 */
        return this.accountPassWord;

    }


    public void setAccountPassWord(String accountPassWord) {
        /* 365 */
        this.accountPassWord = accountPassWord;

    }


    public Integer getIsLock() {
        /* 373 */
        return this.isLock;

    }


    public void setIsLock(Integer isLock) {
        /* 381 */
        this.isLock = isLock;

    }


    public Date getLockTime() {
        /* 389 */
        return this.lockTime;

    }


    public void setLockTime(Date lockTime) {
        /* 397 */
        this.lockTime = lockTime;

    }


    public Integer getIsDelete() {
        /* 405 */
        return this.isDelete;

    }


    public void setIsDelete(Integer isDelete) {
        /* 413 */
        this.isDelete = isDelete;

    }


    public Integer getIsReal() {
        /* 421 */
        return this.isReal;

    }


    public void setIsReal(Integer isReal) {
        /* 429 */
        this.isReal = isReal;

    }


    public String getSalt() {
        /* 437 */
        return this.salt;

    }


    public void setSalt(String salt) {
        /* 445 */
        this.salt = salt;

    }


    public String getUserCode() {
        /* 453 */
        return this.userCode;

    }


    public void setUserCode(String userCode) {
        /* 461 */
        this.userCode = userCode;

    }


    public Object getAppPersonInfo() {
        /* 470 */
        return this.appPersonInfo;

    }


    public void setAppPersonInfo(Object appPersonInfo) {
        /* 478 */
        this.appPersonInfo = appPersonInfo;

    }


    public Integer getIsRealUsd() {
        /* 482 */
        return this.isRealUsd;

    }


    public void setIsRealUsd(Integer isRealUsd) {
        /* 486 */
        this.isRealUsd = isRealUsd;

    }


    public Integer getIntegral() {
        /* 494 */
        return this.integral;

    }


    public void setIntegral(Integer integral) {
        /* 502 */
        this.integral = integral;

    }


    public String getType() {
        /* 510 */
        return this.type;

    }


    public void setType(String type) {
        /* 518 */
        this.type = type;

    }


    public String getGoogleKey() {
        /* 522 */
        return this.googleKey;

    }


    public void setGoogleKey(String googleKey) {
        /* 526 */
        this.googleKey = googleKey;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\customer\user\model\AppCustomer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */