/*     */
package com.tangtang.trade.hry.exchange.account.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;
import hry.customer.person.model.AppPersonInfo;

import javax.persistence.*;
import java.math.BigDecimal;

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
@Table(name = "ex_digitalmoney_account")
/*     */ public class ExDigitalmoneyAccount
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
    @Version
    /*     */ private Integer version;
    /*     */
    @Column(name = "customerId")
    /*     */ private Long customerId;
    /*     */
    @Column(name = "hotMoney")
    /*     */ private BigDecimal hotMoney;
    /*     */
    @Column(name = "coldMoney")
    /*     */ private BigDecimal coldMoney;
    /*     */
    @Column(name = "userName")
    /*     */ private String userName;
    /*     */
    @Column(name = "trueName")
    /*     */ private String trueName;
    /*     */
    @Column(name = "surname")
    /*     */ private String surname;
    /*     */
    @Column(name = "currencyType")
    /*     */ private String currencyType;
    /*     */
    @Column(name = "coinCode")
    /*     */ private String coinCode;
    /*     */
    @Column(name = "website")
    /*     */ private String website;
    /*     */
    @Column(name = "coinName")
    /*     */ private String coinName;
    /*     */
    @Column(name = "accountNum")
    /*     */ private String accountNum;
    /*     */
    @Column(name = "status")
    /*     */ private Integer status;
    /*     */
    @Column(name = "publicKey")
    /*     */ private String publicKey;
    /*     */
    @Column(name = "privateKey")
    /*     */ private String privateKey;
    /*     */
    @Column(name = "lendMoney")
    /*     */ private BigDecimal lendMoney;
    /*     */
    @Column(name = "disableMoney")
    /*     */ private BigDecimal disableMoney;
    /*     */
    @Column(name = "psitioNaveragePrice")
    /*     */ private BigDecimal psitioNaveragePrice;
    /*     */
    @Column(name = "psitioProtectPrice")
    /*     */ private BigDecimal psitioProtectPrice;
    /*     */
    @Column(name = "sumCost")
    /*     */ private BigDecimal sumCost;
    /*     */
    @Transient
    /*     */ private AppPersonInfo appPersonInfo;
    /*     */
    @Transient
    /*     */ private BigDecimal positionAvePrice;
    /*     */
    @Transient
    /*     */ private BigDecimal floatprofitandlossMoney;
    /*     */
    @Transient
    /*     */ private BigDecimal floatprofitandlossMoneyRate;
    /*     */
    @Transient
    /*     */ private BigDecimal rmbLendMoneySum;
    /*     */
    @Transient
    /*     */ private BigDecimal sumRmbfund;
    /*     */
    @Transient
    /*     */ private BigDecimal rmbAccountNetAsse;
    /*     */
    @Transient
    /*     */ private BigDecimal CoinNum;

    /*     */
    /*     */
    public String getSurname()
    /*     */ {
        /* 119 */
        return this.surname;
        /*     */
    }

    /*     */
    /*     */
    public void setSurname(String surname) {
        /* 123 */
        this.surname = surname;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getRmbAccountNetAsse() {
        /* 127 */
        return this.rmbAccountNetAsse;
        /*     */
    }

    /*     */
    /*     */
    public void setRmbAccountNetAsse(BigDecimal rmbAccountNetAsse) {
        /* 131 */
        this.rmbAccountNetAsse = rmbAccountNetAsse;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getRmbLendMoneySum() {
        /* 135 */
        return this.rmbLendMoneySum;
        /*     */
    }

    /*     */
    /*     */
    public void setRmbLendMoneySum(BigDecimal rmbLendMoneySum) {
        /* 139 */
        this.rmbLendMoneySum = rmbLendMoneySum;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getSumRmbfund() {
        /* 143 */
        return this.sumRmbfund;
        /*     */
    }

    /*     */
    /*     */
    public void setSumRmbfund(BigDecimal sumRmbfund) {
        /* 147 */
        this.sumRmbfund = sumRmbfund;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getFloatprofitandlossMoney()
    /*     */ {
        /* 155 */
        return this.floatprofitandlossMoney;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setFloatprofitandlossMoney(BigDecimal floatprofitandlossMoney)
    /*     */ {
        /* 163 */
        this.floatprofitandlossMoney = floatprofitandlossMoney;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getFloatprofitandlossMoneyRate()
    /*     */ {
        /* 171 */
        return this.floatprofitandlossMoneyRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setFloatprofitandlossMoneyRate(BigDecimal floatprofitandlossMoneyRate)
    /*     */ {
        /* 180 */
        this.floatprofitandlossMoneyRate = floatprofitandlossMoneyRate;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getPositionAvePrice()
    /*     */ {
        /* 188 */
        return this.positionAvePrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setPositionAvePrice(BigDecimal positionAvePrice)
    /*     */ {
        /* 196 */
        this.positionAvePrice = positionAvePrice;
        /*     */
    }

    /*     */
    /*     */
    public String getTrueName() {
        /* 200 */
        return this.trueName;
        /*     */
    }

    /*     */
    /*     */
    public void setTrueName(String trueName) {
        /* 204 */
        this.trueName = trueName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getSumCost()
    /*     */ {
        /* 212 */
        return this.sumCost;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setSumCost(BigDecimal sumCost)
    /*     */ {
        /* 220 */
        this.sumCost = sumCost;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public AppPersonInfo getAppPersonInfo()
    /*     */ {
        /* 228 */
        return this.appPersonInfo;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getPsitioNaveragePrice()
    /*     */ {
        /* 236 */
        return this.psitioNaveragePrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setPsitioNaveragePrice(BigDecimal psitioNaveragePrice)
    /*     */ {
        /* 244 */
        this.psitioNaveragePrice = psitioNaveragePrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getPsitioProtectPrice()
    /*     */ {
        /* 252 */
        return this.psitioProtectPrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setPsitioProtectPrice(BigDecimal psitioProtectPrice)
    /*     */ {
        /* 260 */
        this.psitioProtectPrice = psitioProtectPrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setAppPersonInfo(AppPersonInfo appPersonInfo)
    /*     */ {
        /* 268 */
        this.appPersonInfo = appPersonInfo;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getLendMoney() {
        /* 272 */
        if (this.lendMoney == null) {
            /* 273 */
            return BigDecimal.ZERO;
            /*     */
        }
        /* 275 */
        return this.lendMoney;
        /*     */
    }

    /*     */
    /*     */
    public void setLendMoney(BigDecimal lendMoney) {
        /* 279 */
        this.lendMoney = lendMoney;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getCoinName()
    /*     */ {
        /* 286 */
        return this.coinName;
        /*     */
    }

    /*     */
    /*     */
    public void setCoinName(String coinName) {
        /* 290 */
        this.coinName = coinName;
        /*     */
    }

    /*     */
    /*     */
    public Long getId() {
        /* 294 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    public void setId(Long id) {
        /* 298 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    public Integer getVersion() {
        /* 302 */
        return this.version;
        /*     */
    }

    /*     */
    /*     */
    public void setVersion(Integer version) {
        /* 306 */
        this.version = version;
        /*     */
    }

    /*     */
    /*     */
    public Long getCustomerId() {
        /* 310 */
        return this.customerId;
        /*     */
    }

    /*     */
    /*     */
    public void setCustomerId(Long customerId) {
        /* 314 */
        this.customerId = customerId;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getHotMoney() {
        /* 318 */
        if (this.hotMoney == null) {
            /* 319 */
            return BigDecimal.ZERO;
            /*     */
        }
        /* 321 */
        return this.hotMoney;
        /*     */
    }

    /*     */
    /*     */
    public void setHotMoney(BigDecimal hotMoney) {
        /* 325 */
        this.hotMoney = hotMoney;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getColdMoney() {
        /* 329 */
        if (this.coldMoney == null) {
            /* 330 */
            return BigDecimal.ZERO;
            /*     */
        }
        /* 332 */
        return this.coldMoney;
        /*     */
    }

    /*     */
    /*     */
    public void setColdMoney(BigDecimal coldMoney) {
        /* 336 */
        this.coldMoney = coldMoney;
        /*     */
    }

    /*     */
    /*     */
    public String getUserName() {
        /* 340 */
        return this.userName;
        /*     */
    }

    /*     */
    /*     */
    public void setUserName(String userName) {
        /* 344 */
        this.userName = userName;
        /*     */
    }

    /*     */
    /*     */
    public String getCurrencyType() {
        /* 348 */
        return this.currencyType;
        /*     */
    }

    /*     */
    /*     */
    public void setCurrencyType(String currencyType) {
        /* 352 */
        this.currencyType = currencyType;
        /*     */
    }

    /*     */
    /*     */
    public String getAccountNum() {
        /* 356 */
        return this.accountNum;
        /*     */
    }

    /*     */
    /*     */
    public void setAccountNum(String accountNum) {
        /* 360 */
        this.accountNum = accountNum;
        /*     */
    }

    /*     */
    /*     */
    public Integer getStatus() {
        /* 364 */
        return this.status;
        /*     */
    }

    /*     */
    /*     */
    public void setStatus(Integer status) {
        /* 368 */
        this.status = status;
        /*     */
    }

    /*     */
    /*     */
    public String getPublicKey() {
        /* 372 */
        return this.publicKey;
        /*     */
    }

    /*     */
    /*     */
    public void setPublicKey(String publicKey) {
        /* 376 */
        this.publicKey = publicKey;
        /*     */
    }

    /*     */
    /*     */
    public String getPrivateKey() {
        /* 380 */
        return this.privateKey;
        /*     */
    }

    /*     */
    /*     */
    public void setPrivateKey(String privateKey) {
        /* 384 */
        this.privateKey = privateKey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public String getCoinCode()
    /*     */ {
        /* 390 */
        return this.coinCode;
        /*     */
    }

    /*     */
    /*     */
    public void setCoinCode(String coinCode) {
        /* 394 */
        this.coinCode = coinCode;
        /*     */
    }

    /*     */
    /*     */
    public String getWebsite() {
        /* 398 */
        return this.website;
        /*     */
    }

    /*     */
    /*     */
    public void setWebsite(String website) {
        /* 402 */
        this.website = website;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getDisableMoney() {
        /* 406 */
        return this.disableMoney;
        /*     */
    }

    /*     */
    /*     */
    public void setDisableMoney(BigDecimal disableMoney) {
        /* 410 */
        this.disableMoney = disableMoney;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public ExDigitalmoneyAccount(Long id, Integer version, Long customerId, BigDecimal hotMoney, BigDecimal coldMoney, String userName, String currencyType, String accountNum, Integer status, String publicKey, String privateKey)
    /*     */ {
        /* 418 */
        this.id = id;
        /* 419 */
        this.version = version;
        /* 420 */
        this.customerId = customerId;
        /* 421 */
        this.hotMoney = hotMoney;
        /* 422 */
        this.coldMoney = coldMoney;
        /* 423 */
        this.userName = userName;
        /* 424 */
        this.currencyType = currencyType;
        /* 425 */
        this.accountNum = accountNum;
        /* 426 */
        this.status = status;
        /* 427 */
        this.publicKey = publicKey;
        /* 428 */
        this.privateKey = privateKey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public ExDigitalmoneyAccount() {
    }

    /*     */
    /*     */
    /*     */
    public String toString()
    /*     */ {
        /* 437 */
        return "ExDigitalmoneyAccount [id=" + this.id + ", version=" + this.version + ", customerId=" + this.customerId + ", hotMoney=" + this.hotMoney + ", coldMoney=" + this.coldMoney + ", userName=" + this.userName + ", currencyType=" + this.currencyType + ", accountNum=" + this.accountNum + ", status=" + this.status + ", publicKey=" + this.publicKey + ", privateKey=" + this.privateKey + "]";
        /*     */
    }
    /*     */
}
