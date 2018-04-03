
package com.tangtang.trade.hry.account.fund.model;

import com.tangtang.trade.hry.core.mvc.model.BaseModel;
import hry.customer.person.model.AppPersonInfo;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "app_account")
public class AppAccount
        extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "website")
    private String website;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "hotMoney")
    private BigDecimal hotMoney;

    @Column(name = "coldMoney")
    private BigDecimal coldMoney;

    @Column(name = "rewardMoney")
    private BigDecimal rewardMoney;

    @Column(name = "hasRewardMoney")
    private BigDecimal hasRewardMoney;

    @Version
    private Integer version;

    @Column(name = "accountNum")
    private String accountNum;

    @Column(name = "currencyType")
    private String currencyType;

    @Column(name = "status")
    private Integer status;

    @Column(name = "lendMoney")
    private BigDecimal lendMoney;

    @Transient
    private AppPersonInfo appPersonInfo;

    @Column(name = "trueName")
    private String trueName;

    @Column(name = "surname")
    private String surname;

    @Transient
    private BigDecimal rmbAccountNetAsse;

    @Transient
    private BigDecimal rmbLendMoneySum;

    @Transient
    private BigDecimal sumRmbfund;

    @Transient
    private BigDecimal sumCommissionMoney;

    @Transient
    private BigDecimal hotCurrency;

    @Transient
    private BigDecimal coldCurrency;


    public String getSurname() {
        /*  99 */
        return this.surname;

    }


    public void setSurname(String surname) {
        /* 103 */
        this.surname = surname;

    }


    public BigDecimal getRewardMoney() {
        /* 107 */
        return this.rewardMoney;

    }


    public void setRewardMoney(BigDecimal rewardMoney) {
        /* 111 */
        this.rewardMoney = rewardMoney;

    }


    public BigDecimal getRmbAccountNetAsse() {
        /* 119 */
        return this.rmbAccountNetAsse;

    }


    public void setRmbAccountNetAsse(BigDecimal rmbAccountNetAsse) {
        /* 127 */
        this.rmbAccountNetAsse = rmbAccountNetAsse;

    }


    public BigDecimal getRmbLendMoneySum() {
        /* 135 */
        return this.rmbLendMoneySum;

    }


    public void setRmbLendMoneySum(BigDecimal rmbLendMoneySum) {
        /* 143 */
        this.rmbLendMoneySum = rmbLendMoneySum;

    }


    public BigDecimal getSumRmbfund() {
        /* 151 */
        return this.sumRmbfund;

    }


    public void setSumRmbfund(BigDecimal sumRmbfund) {
        /* 159 */
        this.sumRmbfund = sumRmbfund;

    }


    public String getTrueName() {
        /* 167 */
        return this.trueName;

    }


    public void setTrueName(String trueName) {
        /* 175 */
        this.trueName = trueName;

    }


    public Long getId() {
        /* 182 */
        return this.id;

    }


    public void setId(Long id) {
        /* 190 */
        this.id = id;

    }


    public Long getCustomerId() {
        /* 198 */
        return this.customerId;

    }


    public void setCustomerId(Long customerId) {
        /* 206 */
        this.customerId = customerId;

    }


    public BigDecimal getLendMoney() {
        /* 214 */
        if (this.lendMoney == null) {
            /* 215 */
            return BigDecimal.ZERO;

        }
        /* 217 */
        return this.lendMoney;

    }


    public void setLendMoney(BigDecimal lendMoney) {
        /* 225 */
        this.lendMoney = lendMoney;

    }


    public String getUserName() {
        /* 233 */
        return this.userName;

    }


    public void setUserName(String userName) {
        /* 241 */
        this.userName = userName;

    }


    public BigDecimal getHotMoney() {
        /* 249 */
        if (this.hotMoney == null) {
            /* 250 */
            return BigDecimal.ZERO;

        }
        /* 252 */
        return this.hotMoney;

    }


    public void setHotMoney(BigDecimal hotMoney) {
        /* 260 */
        this.hotMoney = hotMoney;

    }


    public BigDecimal getColdMoney() {
        /* 268 */
        if (this.coldMoney == null) {
            /* 269 */
            return BigDecimal.ZERO;

        }
        /* 271 */
        return this.coldMoney;

    }


    public void setColdMoney(BigDecimal coldMoney) {
        /* 279 */
        this.coldMoney = coldMoney;

    }


    public Integer getVersion() {
        /* 287 */
        return this.version;

    }


    public void setVersion(Integer version) {
        /* 295 */
        this.version = version;

    }


    public String getAccountNum() {
        /* 303 */
        return this.accountNum;

    }


    public void setAccountNum(String accountNum) {
        /* 311 */
        this.accountNum = accountNum;

    }


    public String getCurrencyType() {
        /* 321 */
        return this.currencyType;

    }


    public void setCurrencyType(String currencyType) {
        /* 329 */
        this.currencyType = currencyType;

    }


    public Integer getStatus() {
        /* 337 */
        return this.status;

    }


    public void setStatus(Integer status) {
        /* 345 */
        this.status = status;

    }


    public String getWebsite() {
        /* 349 */
        return this.website;

    }


    public void setWebsite(String website) {
        /* 353 */
        this.website = website;

    }


    public AppPersonInfo getAppPersonInfo() {
        /* 361 */
        return this.appPersonInfo;

    }


    public void setAppPersonInfo(AppPersonInfo appPersonInfo) {
        /* 369 */
        this.appPersonInfo = appPersonInfo;

    }


    public BigDecimal getSumCommissionMoney() {
        /* 373 */
        return this.sumCommissionMoney;

    }


    public void setSumCommissionMoney(BigDecimal sumCommissionMoney) {
        /* 377 */
        this.sumCommissionMoney = sumCommissionMoney;

    }


    public BigDecimal getHotCurrency() {
        /* 381 */
        return this.hotCurrency;

    }


    public void setHotCurrency(BigDecimal hotCurrency) {
        this.hotCurrency = hotCurrency;
    }

    public BigDecimal getColdCurrency() {
        return this.coldCurrency;
    }

    public void setColdCurrency(BigDecimal coldCurrency) {
        this.coldCurrency = coldCurrency;
    }

    public BigDecimal getHasRewardMoney() {
        return this.hasRewardMoney;
    }

    public void setHasRewardMoney(BigDecimal hasRewardMoney) {
        this.hasRewardMoney = hasRewardMoney;
    }
}
