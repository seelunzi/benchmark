
package com.tangtang.trade.hry.customer.person.model;

import com.tangtang.trade.hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
@Table(name = "app_person_info")
/*      */ public class AppPersonInfo
        /*      */ extends BaseModel
        /*      */ {
    /*      */
    @Id
    /*      */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*      */
    @Column(name = "id", unique = true, nullable = false)
    /*      */ private Long id;
    /*      */
    @Column(name = "customerId")
    /*      */ private Long customerId;
    /*      */
    @Column(name = "customerType")
    /*      */ private Integer customerType;
    /*      */
    @Column(name = "mobilePhone")
    /*      */ private String mobilePhone;
    /*      */
    @Column(name = "email")
    /*      */ private String email;
    /*      */
    @Column(name = "trueName")
    /*      */ private String trueName;
    /*      */
    @Column(name = "surname")
    /*      */ private String surname;
    /*      */
    @Column(name = "sex")
    /*      */ private Integer sex;
    /*      */
    @Column(name = "birthday")
    /*      */ private String birthday;
    /*      */
    @Column(name = "country")
    /*      */ private String country;
    /*      */
    @Column(name = "cardType")
    /*      */ private Integer cardType;
    /*      */
    @Column(name = "cardId")
    /*      */ private String cardId;
    /*      */
    @Column(name = "customerSource")
    /*      */ private Integer customerSource;
    /*      */
    @Column(name = "realTime")
    /*      */ private Date realTime;
    /*      */
    @Column(name = "emailCode")
    /*      */ private String emailCode;
    /*      */
    @Column(name = "cardIdUsd")
    /*      */ private String cardIdUsd;
    /*      */
    @Column(name = "cardIdValidPeriod")
    /*      */ private String cardIdValidPeriod;
    /*      */
    @Column(name = "postalAddress")
    /*      */ private String postalAddress;
    /*      */
    @Column(name = "contacts")
    /*      */ private String contacts;
    /*      */
    @Column(name = "postCode")
    /*      */ private Integer postCode;
    /*      */
    @Column(name = "stage")
    /*      */ private Integer stage;
    /*      */
    @Column(name = "contactsTel")
    /*      */ private String contactsTel;
    /*      */
    @Column(name = "handIdCardUrl")
    /*      */ private String handIdCardUrl;
    /*      */
    @Column(name = "idCardFrontUrl")
    /*      */ private String idCardFrontUrl;
    /*      */
    @Column(name = "idCardBackUrl")
    /*      */ private String idCardBackUrl;
    /*      */
    @Column(name = "handDealUrl")
    /*      */ private String handDealUrl;
    /*      */
    @Column(name = "isExamine")
    /*      */ private Integer isExamine;
    /*      */
    @Column(name = "eamineRefusalReason")
    /*      */ private String eamineRefusalReason;
    /*      */
    @Column(name = "isCancle")
    /*      */ private Integer isCancle;
    /*      */
    @Column(name = "cancleReason")
    /*      */ private String cancleReason;
    /*      */
    @Column(name = "vipUserId")
    /*      */ private Long vipUserId;
    /*      */
    @Column(name = "agentUserId")
    /*      */ private Long agentUserId;
    /*      */
    @Column(name = "vipNumber")
    /*      */ private String vipNumber;
    /*      */
    @Column(name = "agentNumber")
    /*      */ private String agentNumber;
    /*      */
    @Column(name = "vipName")
    /*      */ private String vipName;
    /*      */
    @Column(name = "agentName")
    /*      */ private String agentName;
    /*      */
    @Column(name = "papersType")
    /*      */ private String papersType;
    /*      */
    @Column(name = "withdrawCheckMoney")
    /*      */ private BigDecimal withdrawCheckMoney;
    /*      */
    @Column(name = "jkAgentType")
    /*      */ private Integer jkAgentType;
    /*      */
    @Column(name = "jkAgentName")
    /*      */ private String jkAgentName;
    /*      */
    @Column(name = "jkAgentProvince")
    /*      */ private String jkAgentProvince;
    /*      */
    @Column(name = "jkAgentProvinceCode")
    /*      */ private String jkAgentProvinceCode;
    /*      */
    @Column(name = "jkAgentCity")
    /*      */ private String jkAgentCity;
    /*      */
    @Column(name = "jkAgentCityCode")
    /*      */ private String jkAgentCityCode;
    /*      */
    @Column(name = "jkAgentCounty")
    /*      */ private String jkAgentCounty;
    /*      */
    @Column(name = "jkAgentCountyCode")
    /*      */ private String jkAgentCountyCode;
    /*      */
    @Column(name = "jkApplyState")
    /*      */ private Integer jkApplyState;
    /*      */
    @Column(name = "jkApplyType")
    /*      */ private Integer jkApplyType;
    /*      */
    @Column(name = "jkApplyAuthorizationCode")
    /*      */ private String jkApplyAuthorizationCode;
    /*      */
    @Column(name = "jkApplyAuthorizationCodeState")
    /*      */ private Integer jkApplyAuthorizationCodeState;
    /*      */
    @Column(name = "jkApplyAgentProvince")
    /*      */ private String jkApplyAgentProvince;
    /*      */
    @Column(name = "jkApplyAgentProvinceCode")
    /*      */ private String jkApplyAgentProvinceCode;
    /*      */
    @Column(name = "jkApplyAgentCity")
    /*      */ private String jkApplyAgentCity;
    /*      */
    @Column(name = "jkApplyAgentCityCode")
    /*      */ private String jkApplyAgentCityCode;
    /*      */
    @Column(name = "jkApplyAgentCounty")
    /*      */ private String jkApplyAgentCounty;
    /*      */
    @Column(name = "jkApplyAgentCountyCode")
    /*      */ private String jkApplyAgentCountyCode;
    /*      */
    @Column(name = "isGivePerAgentRecommendCoin")
    /*      */ private String isGivePerAgentRecommendCoin;
    /*      */
    @Column(name = "hasRecommendNum")
    /*      */ private Integer hasRecommendNum;
    /*      */
    @Transient
    /*      */ private BigDecimal totalAvailableMoney;
    /*      */
    @Transient
    /*      */ private BigDecimal totalFrozenMoney;
    /*      */
    @Transient
    /*      */ private BigDecimal totalRechargeMoney;
    /*      */
    @Transient
    /*      */ private BigDecimal totalWithdrawalsMoney;
    /*      */
    @Transient
    /*      */ private BigDecimal moneyChangeRate;
    /*      */
    @Transient
    /*      */ private BigDecimal profitRate;
    /*      */
    @Column(name = "personCard")
    /*      */ private String personCard;
    /*      */
    @Column(name = "frontpersonCard")
    /*      */ private String frontpersonCard;
    /*      */
    @Column(name = "personBank")
    /*      */ private String personBank;
    /*      */
    @Transient
    /*      */ private String bankName;
    /*      */
    @Transient
    /*      */ private String bankCardNumber;

    /*      */
    /*      */
    public String getPapersType()
    /*      */ {
        /*  256 */
        return this.papersType;
        /*      */
    }

    /*      */
    /*      */
    public void setPapersType(String papersType) {
        /*  260 */
        this.papersType = papersType;
        /*      */
    }

    /*      */
    /*      */
    public String getSurname() {
        /*  264 */
        return this.surname;
        /*      */
    }

    /*      */
    /*      */
    public void setSurname(String surname) {
        /*  268 */
        this.surname = surname;
        /*      */
    }

    /*      */
    /*      */
    public String getPersonCard() {
        /*  272 */
        return this.personCard;
        /*      */
    }

    /*      */
    /*      */
    public void setPersonCard(String personCard) {
        /*  276 */
        this.personCard = personCard;
        /*      */
    }

    /*      */
    /*      */
    public String getFrontpersonCard() {
        /*  280 */
        return this.frontpersonCard;
        /*      */
    }

    /*      */
    /*      */
    public void setFrontpersonCard(String frontpersonCard) {
        /*  284 */
        this.frontpersonCard = frontpersonCard;
        /*      */
    }

    /*      */
    /*      */
    public String getPersonBank() {
        /*  288 */
        return this.personBank;
        /*      */
    }

    /*      */
    /*      */
    public void setPersonBank(String personBank) {
        /*  292 */
        this.personBank = personBank;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public BigDecimal getTotalAvailableMoney()
    /*      */ {
        /*  301 */
        return this.totalAvailableMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setTotalAvailableMoney(BigDecimal totalAvailableMoney)
    /*      */ {
        /*  309 */
        this.totalAvailableMoney = totalAvailableMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public BigDecimal getTotalFrozenMoney()
    /*      */ {
        /*  317 */
        return this.totalFrozenMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setTotalFrozenMoney(BigDecimal totalFrozenMoney)
    /*      */ {
        /*  325 */
        this.totalFrozenMoney = totalFrozenMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public BigDecimal getTotalRechargeMoney()
    /*      */ {
        /*  333 */
        return this.totalRechargeMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setTotalRechargeMoney(BigDecimal totalRechargeMoney)
    /*      */ {
        /*  341 */
        this.totalRechargeMoney = totalRechargeMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public BigDecimal getTotalWithdrawalsMoney()
    /*      */ {
        /*  349 */
        return this.totalWithdrawalsMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setTotalWithdrawalsMoney(BigDecimal totalWithdrawalsMoney)
    /*      */ {
        /*  357 */
        this.totalWithdrawalsMoney = totalWithdrawalsMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public BigDecimal getMoneyChangeRate()
    /*      */ {
        /*  365 */
        return this.moneyChangeRate;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setMoneyChangeRate(BigDecimal moneyChangeRate)
    /*      */ {
        /*  373 */
        this.moneyChangeRate = moneyChangeRate;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public BigDecimal getProfitRate()
    /*      */ {
        /*  381 */
        return this.profitRate;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setProfitRate(BigDecimal profitRate)
    /*      */ {
        /*  389 */
        this.profitRate = profitRate;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Integer getJkApplyAuthorizationCodeState()
    /*      */ {
        /*  401 */
        return this.jkApplyAuthorizationCodeState;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyAuthorizationCodeState(Integer jkApplyAuthorizationCodeState)
    /*      */ {
        /*  406 */
        this.jkApplyAuthorizationCodeState = jkApplyAuthorizationCodeState;
        /*      */
    }

    /*      */
    /*      */
    public String getJkAgentProvinceCode() {
        /*  410 */
        return this.jkAgentProvinceCode;
        /*      */
    }

    /*      */
    /*      */
    public void setJkAgentProvinceCode(String jkAgentProvinceCode) {
        /*  414 */
        this.jkAgentProvinceCode = jkAgentProvinceCode;
        /*      */
    }

    /*      */
    /*      */
    public String getJkAgentCityCode() {
        /*  418 */
        return this.jkAgentCityCode;
        /*      */
    }

    /*      */
    /*      */
    public void setJkAgentCityCode(String jkAgentCityCode) {
        /*  422 */
        this.jkAgentCityCode = jkAgentCityCode;
        /*      */
    }

    /*      */
    /*      */
    public String getJkAgentCountyCode() {
        /*  426 */
        return this.jkAgentCountyCode;
        /*      */
    }

    /*      */
    /*      */
    public void setJkAgentCountyCode(String jkAgentCountyCode) {
        /*  430 */
        this.jkAgentCountyCode = jkAgentCountyCode;
        /*      */
    }

    /*      */
    /*      */
    public String getBankName() {
        /*  434 */
        return this.bankName;
        /*      */
    }

    /*      */
    /*      */
    public void setBankName(String bankName) {
        /*  438 */
        this.bankName = bankName;
        /*      */
    }

    /*      */
    /*      */
    public String getBankCardNumber() {
        /*  442 */
        return this.bankCardNumber;
        /*      */
    }

    /*      */
    /*      */
    public void setBankCardNumber(String bankCardNumber) {
        /*  446 */
        this.bankCardNumber = bankCardNumber;
        /*      */
    }

    /*      */
    /*      */
    public Integer getIsCancle() {
        /*  450 */
        return this.isCancle;
        /*      */
    }

    /*      */
    /*      */
    public void setIsCancle(Integer isCancle) {
        /*  454 */
        this.isCancle = isCancle;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public String getCancleReason()
    /*      */ {
        /*  460 */
        return this.cancleReason;
        /*      */
    }

    /*      */
    /*      */
    public void setCancleReason(String cancleReason) {
        /*  464 */
        this.cancleReason = cancleReason;
        /*      */
    }

    /*      */
    /*      */
    public Long getVipUserId() {
        /*  468 */
        return this.vipUserId;
        /*      */
    }

    /*      */
    /*      */
    public void setVipUserId(Long vipUserId) {
        /*  472 */
        this.vipUserId = vipUserId;
        /*      */
    }

    /*      */
    /*      */
    public Long getAgentUserId() {
        /*  476 */
        return this.agentUserId;
        /*      */
    }

    /*      */
    /*      */
    public void setAgentUserId(Long agentUserId) {
        /*  480 */
        this.agentUserId = agentUserId;
        /*      */
    }

    /*      */
    /*      */
    public String getVipNumber() {
        /*  484 */
        return this.vipNumber;
        /*      */
    }

    /*      */
    /*      */
    public void setVipNumber(String vipNumber) {
        /*  488 */
        this.vipNumber = vipNumber;
        /*      */
    }

    /*      */
    /*      */
    public String getAgentNumber() {
        /*  492 */
        return this.agentNumber;
        /*      */
    }

    /*      */
    /*      */
    public void setAgentNumber(String agentNumber) {
        /*  496 */
        this.agentNumber = agentNumber;
        /*      */
    }

    /*      */
    /*      */
    public String getVipName() {
        /*  500 */
        return this.vipName;
        /*      */
    }

    /*      */
    /*      */
    public void setVipName(String vipName) {
        /*  504 */
        this.vipName = vipName;
        /*      */
    }

    /*      */
    /*      */
    public String getAgentName() {
        /*  508 */
        return this.agentName;
        /*      */
    }

    /*      */
    /*      */
    public void setAgentName(String agentName) {
        /*  512 */
        this.agentName = agentName;
        /*      */
    }

    /*      */
    /*      */
    public String getEamineRefusalReason() {
        /*  516 */
        return this.eamineRefusalReason;
        /*      */
    }

    /*      */
    /*      */
    public void setEamineRefusalReason(String eamineRefusalReason) {
        /*  520 */
        this.eamineRefusalReason = eamineRefusalReason;
        /*      */
    }

    /*      */
    /*      */
    public Integer getIsExamine() {
        /*  524 */
        return this.isExamine;
        /*      */
    }

    /*      */
    /*      */
    public void setIsExamine(Integer isExamine) {
        /*  528 */
        this.isExamine = isExamine;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Long getId()
    /*      */ {
        /*  540 */
        return this.id;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setId(Long id)
    /*      */ {
        /*  551 */
        this.id = id;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Long getCustomerId()
    /*      */ {
        /*  562 */
        return this.customerId;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setCustomerId(Long customerId)
    /*      */ {
        /*  573 */
        this.customerId = customerId;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Integer getCustomerType()
    /*      */ {
        /*  584 */
        return this.customerType;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setCustomerType(Integer customerType)
    /*      */ {
        /*  595 */
        this.customerType = customerType;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getMobilePhone()
    /*      */ {
        /*  606 */
        return this.mobilePhone;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setMobilePhone(String mobilePhone)
    /*      */ {
        /*  617 */
        this.mobilePhone = mobilePhone;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getEmail()
    /*      */ {
        /*  628 */
        return this.email;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setEmail(String email)
    /*      */ {
        /*  639 */
        this.email = email;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getTrueName()
    /*      */ {
        /*  650 */
        return this.trueName;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setTrueName(String trueName)
    /*      */ {
        /*  661 */
        this.trueName = trueName;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Integer getSex()
    /*      */ {
        /*  672 */
        return this.sex;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setSex(Integer sex)
    /*      */ {
        /*  683 */
        this.sex = sex;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getBirthday()
    /*      */ {
        /*  694 */
        return this.birthday;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setBirthday(String birthday)
    /*      */ {
        /*  705 */
        this.birthday = birthday;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getCountry()
    /*      */ {
        /*  716 */
        return this.country;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setCountry(String country)
    /*      */ {
        /*  727 */
        this.country = country;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Integer getCardType()
    /*      */ {
        /*  738 */
        return this.cardType;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setCardType(Integer cardType)
    /*      */ {
        /*  749 */
        this.cardType = cardType;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getCardId()
    /*      */ {
        /*  760 */
        return this.cardId;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setCardId(String cardId)
    /*      */ {
        /*  771 */
        this.cardId = cardId;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Integer getCustomerSource()
    /*      */ {
        /*  782 */
        return this.customerSource;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setCustomerSource(Integer customerSource)
    /*      */ {
        /*  793 */
        this.customerSource = customerSource;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Date getRealTime()
    /*      */ {
        /*  804 */
        return this.realTime;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setRealTime(Date realTime)
    /*      */ {
        /*  815 */
        this.realTime = realTime;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getEmailCode()
    /*      */ {
        /*  826 */
        return this.emailCode;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setEmailCode(String emailCode)
    /*      */ {
        /*  837 */
        this.emailCode = emailCode;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getCardIdUsd()
    /*      */ {
        /*  848 */
        return this.cardIdUsd;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setCardIdUsd(String cardIdUsd)
    /*      */ {
        /*  859 */
        this.cardIdUsd = cardIdUsd;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getCardIdValidPeriod()
    /*      */ {
        /*  870 */
        return this.cardIdValidPeriod;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setCardIdValidPeriod(String cardIdValidPeriod)
    /*      */ {
        /*  881 */
        this.cardIdValidPeriod = cardIdValidPeriod;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getPostalAddress()
    /*      */ {
        /*  892 */
        return this.postalAddress;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setPostalAddress(String postalAddress)
    /*      */ {
        /*  903 */
        this.postalAddress = postalAddress;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getContacts()
    /*      */ {
        /*  914 */
        return this.contacts;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setContacts(String contacts)
    /*      */ {
        /*  925 */
        this.contacts = contacts;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Integer getPostCode()
    /*      */ {
        /*  936 */
        return this.postCode;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setPostCode(Integer postCode)
    /*      */ {
        /*  947 */
        this.postCode = postCode;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public Integer getStage()
    /*      */ {
        /*  958 */
        return this.stage;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setStage(Integer stage)
    /*      */ {
        /*  969 */
        this.stage = stage;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getContactsTel()
    /*      */ {
        /*  980 */
        return this.contactsTel;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setContactsTel(String contactsTel)
    /*      */ {
        /*  991 */
        this.contactsTel = contactsTel;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getHandIdCardUrl()
    /*      */ {
        /* 1002 */
        return this.handIdCardUrl;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setHandIdCardUrl(String handIdCardUrl)
    /*      */ {
        /* 1013 */
        this.handIdCardUrl = handIdCardUrl;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getIdCardFrontUrl()
    /*      */ {
        /* 1024 */
        return this.idCardFrontUrl;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setIdCardFrontUrl(String idCardFrontUrl)
    /*      */ {
        /* 1035 */
        this.idCardFrontUrl = idCardFrontUrl;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getIdCardBackUrl()
    /*      */ {
        /* 1046 */
        return this.idCardBackUrl;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setIdCardBackUrl(String idCardBackUrl)
    /*      */ {
        /* 1057 */
        this.idCardBackUrl = idCardBackUrl;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public String getHandDealUrl()
    /*      */ {
        /* 1068 */
        return this.handDealUrl;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void setHandDealUrl(String handDealUrl)
    /*      */ {
        /* 1079 */
        this.handDealUrl = handDealUrl;
        /*      */
    }

    /*      */
    /*      */
    public BigDecimal getWithdrawCheckMoney() {
        /* 1083 */
        return this.withdrawCheckMoney;
        /*      */
    }

    /*      */
    /*      */
    public void setWithdrawCheckMoney(BigDecimal withdrawCheckMoney) {
        /* 1087 */
        this.withdrawCheckMoney = withdrawCheckMoney;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public Integer getJkAgentType()
    /*      */ {
        /* 1093 */
        return this.jkAgentType;
        /*      */
    }

    /*      */
    /*      */
    public void setJkAgentType(Integer jkAgentType) {
        /* 1097 */
        this.jkAgentType = jkAgentType;
        /*      */
    }

    /*      */
    /*      */
    public String getJkAgentProvince() {
        /* 1101 */
        return this.jkAgentProvince;
        /*      */
    }

    /*      */
    /*      */
    public void setJkAgentProvince(String jkAgentProvince) {
        /* 1105 */
        this.jkAgentProvince = jkAgentProvince;
        /*      */
    }

    /*      */
    /*      */
    public String getJkAgentCity() {
        /* 1109 */
        return this.jkAgentCity;
        /*      */
    }

    /*      */
    /*      */
    public void setJkAgentCity(String jkAgentCity) {
        /* 1113 */
        this.jkAgentCity = jkAgentCity;
        /*      */
    }

    /*      */
    /*      */
    public String getJkAgentCounty() {
        /* 1117 */
        return this.jkAgentCounty;
        /*      */
    }

    /*      */
    /*      */
    public void setJkAgentCounty(String jkAgentCounty) {
        /* 1121 */
        this.jkAgentCounty = jkAgentCounty;
        /*      */
    }

    /*      */
    /*      */
    public String getIsGivePerAgentRecommendCoin() {
        /* 1125 */
        return this.isGivePerAgentRecommendCoin;
        /*      */
    }

    /*      */
    /*      */
    public void setIsGivePerAgentRecommendCoin(String isGivePerAgentRecommendCoin) {
        /* 1129 */
        this.isGivePerAgentRecommendCoin = isGivePerAgentRecommendCoin;
        /*      */
    }

    /*      */
    /*      */
    public Integer getHasRecommendNum() {
        /* 1133 */
        return this.hasRecommendNum;
        /*      */
    }

    /*      */
    /*      */
    public void setHasRecommendNum(Integer hasRecommendNum) {
        /* 1137 */
        this.hasRecommendNum = hasRecommendNum;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public String getJkAgentName()
    /*      */ {
        /* 1143 */
        return this.jkAgentName;
        /*      */
    }

    /*      */
    /*      */
    public void setJkAgentName(String jkAgentName) {
        /* 1147 */
        this.jkAgentName = jkAgentName;
        /*      */
    }

    /*      */
    /*      */
    public Integer getJkApplyState() {
        /* 1151 */
        return this.jkApplyState;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyState(Integer jkApplyState) {
        /* 1155 */
        this.jkApplyState = jkApplyState;
        /*      */
    }

    /*      */
    /*      */
    public Integer getJkApplyType() {
        /* 1159 */
        return this.jkApplyType;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyType(Integer jkApplyType) {
        /* 1163 */
        this.jkApplyType = jkApplyType;
        /*      */
    }

    /*      */
    /*      */
    public String getJkApplyAuthorizationCode() {
        /* 1167 */
        return this.jkApplyAuthorizationCode;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyAuthorizationCode(String jkApplyAuthorizationCode) {
        /* 1171 */
        this.jkApplyAuthorizationCode = jkApplyAuthorizationCode;
        /*      */
    }

    /*      */
    /*      */
    public String getJkApplyAgentProvince() {
        /* 1175 */
        return this.jkApplyAgentProvince;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyAgentProvince(String jkApplyAgentProvince) {
        /* 1179 */
        this.jkApplyAgentProvince = jkApplyAgentProvince;
        /*      */
    }

    /*      */
    /*      */
    public String getJkApplyAgentProvinceCode() {
        /* 1183 */
        return this.jkApplyAgentProvinceCode;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyAgentProvinceCode(String jkApplyAgentProvinceCode) {
        /* 1187 */
        this.jkApplyAgentProvinceCode = jkApplyAgentProvinceCode;
        /*      */
    }

    /*      */
    /*      */
    public String getJkApplyAgentCity() {
        /* 1191 */
        return this.jkApplyAgentCity;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyAgentCity(String jkApplyAgentCity) {
        /* 1195 */
        this.jkApplyAgentCity = jkApplyAgentCity;
        /*      */
    }

    /*      */
    /*      */
    public String getJkApplyAgentCityCode() {
        /* 1199 */
        return this.jkApplyAgentCityCode;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyAgentCityCode(String jkApplyAgentCityCode) {
        /* 1203 */
        this.jkApplyAgentCityCode = jkApplyAgentCityCode;
        /*      */
    }

    /*      */
    /*      */
    public String getJkApplyAgentCounty() {
        /* 1207 */
        return this.jkApplyAgentCounty;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyAgentCounty(String jkApplyAgentCounty) {
        /* 1211 */
        this.jkApplyAgentCounty = jkApplyAgentCounty;
        /*      */
    }

    /*      */
    /*      */
    public String getJkApplyAgentCountyCode() {
        /* 1215 */
        return this.jkApplyAgentCountyCode;
        /*      */
    }

    /*      */
    /*      */
    public void setJkApplyAgentCountyCode(String jkApplyAgentCountyCode) {
        /* 1219 */
        this.jkApplyAgentCountyCode = jkApplyAgentCountyCode;
        /*      */
    }

    /*      */
    /*      */
    public static void main(String[] args) {
        /* 1223 */
        List<String> list = new ArrayList();
        /* 1224 */
        list.add(0, "1");
        /* 1225 */
        list.add(0, "2");
        /* 1226 */
        list.add(0, "3");
        /* 1227 */
        list.add(0, "4");
        /* 1228 */
        list.add(0, "5");
        /* 1229 */
        list.add(0, "6");
        /*      */
    }
    /*      */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\customer\person\model\AppPersonInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */