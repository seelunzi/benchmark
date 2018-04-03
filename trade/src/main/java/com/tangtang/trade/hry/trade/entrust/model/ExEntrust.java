
package com.tangtang.trade.hry.trade.entrust.model;


import hry.core.mvc.model.BaseExModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Table(name = "ex_entrust")
public class ExEntrust
        extends BaseExModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "entrustNum")
    private String entrustNum;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "userCode")
    private String userCode;

    @Column(name = "userName")
    private String userName;

    @Column(name = "trueName")
    private String trueName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "accountId")
    private Long accountId;

    @Column(name = "coinAccountId")
    private Long coinAccountId;

    @Column(name = "coinCode")
    private String coinCode;

    @Column(name = "type")
    private Integer type;

    @Column(name = "status")
    private Integer status;

    @Column(name = "entrustPrice")
    private BigDecimal entrustPrice;

    @Column(name = "entrustCount")
    private BigDecimal entrustCount;

    @Column(name = "entrustSum")
    private BigDecimal entrustSum;

    @Column(name = "entrustTime")
    private Date entrustTime;

    @Column(name = "entrustWay")
    private Integer entrustWay;

    @Column(name = "surplusEntrustCount")
    private BigDecimal surplusEntrustCount;

    @Column(name = "fixPriceType")
    private Integer fixPriceType;

    @Column(name = "fixPriceCoinCode")
    private String fixPriceCoinCode;

    @Column(name = "transactionFeeRate")
    private BigDecimal transactionFeeRate;

    @Column(name = "transactionFee")
    private BigDecimal transactionFee;

    @Column(name = "transactionSum")
    private BigDecimal transactionSum;

    @Column(name = "processedPrice")
    private BigDecimal processedPrice;

    @Column(name = "customerType")
    private Integer customerType;

    @Column(name = "floatUpPrice")
    private BigDecimal floatUpPrice;

    @Column(name = "floatDownPrice")
    private BigDecimal floatDownPrice;

    @Column(name = "source")
    private Integer source;

    @Transient
    private String onlyMatchExEntrusts;

    @Column(name = "matchPriority")
    private Integer matchPriority;

    @Column(name = "transactionTime")
    private Date transactionTime;

    @Column(name = "projectType")
    private Integer projectType;

    @Column(name = "customerIp")
    private String customerIp;

    @Transient
    private double transactionSumDouble;

    @Transient
    private double transactionFeeDouble;

    @Transient
    private double surplusEntrustCountDouble;

    @Transient
    private double processedPriceDouble;

    @Transient
    private int statusint;


    public int getStatusint() {
        /* 167 */
        return this.statusint;

    }


    public void setStatusint(int statusint) {
        /* 171 */
        this.statusint = statusint;

    }


    public double getProcessedPriceDouble() {
        /* 175 */
        return this.processedPriceDouble;

    }


    public void setProcessedPriceDouble(double processedPriceDouble) {
        /* 179 */
        this.processedPriceDouble = processedPriceDouble;

    }


    public String getFixPriceCoinCode() {
        /* 183 */
        return this.fixPriceCoinCode;

    }


    public double getTransactionFeeDouble() {
        /* 187 */
        return this.transactionFeeDouble;

    }


    public void setTransactionFeeDouble(double transactionFeeDouble) {
        /* 191 */
        this.transactionFeeDouble = transactionFeeDouble;

    }


    public double getSurplusEntrustCountDouble() {
        /* 195 */
        return this.surplusEntrustCountDouble;

    }


    public void setSurplusEntrustCountDouble(double surplusEntrustCountDouble) {
        /* 199 */
        this.surplusEntrustCountDouble = surplusEntrustCountDouble;

    }


    public double getTransactionSumDouble() {
        /* 203 */
        return this.transactionSumDouble;

    }


    public void setTransactionSumDouble(double transactionSumDouble) {
        /* 207 */
        this.transactionSumDouble = transactionSumDouble;

    }


    public void setFixPriceCoinCode(String fixPriceCoinCode) {
        /* 211 */
        this.fixPriceCoinCode = fixPriceCoinCode;

    }


    public String getCustomerIp() {
        /* 222 */
        return this.customerIp;

    }


    public void setCustomerIp(String customerIp) {
        /* 233 */
        this.customerIp = customerIp;

    }


    public Long getId() {
        /* 244 */
        return this.id;

    }


    public void setId(Long id) {
        /* 255 */
        this.id = id;

    }


    public String getEntrustNum() {
        /* 266 */
        return this.entrustNum;

    }


    public void setEntrustNum(String entrustNum) {
        /* 277 */
        this.entrustNum = entrustNum;

    }


    public Long getCustomerId() {
        /* 288 */
        return this.customerId;

    }


    public void setCustomerId(Long customerId) {
        /* 299 */
        this.customerId = customerId;

    }


    public String getUserCode() {
        /* 310 */
        return this.userCode;

    }


    public void setUserCode(String userCode) {
        /* 321 */
        this.userCode = userCode;

    }


    public String getUserName() {
        /* 332 */
        return this.userName;

    }


    public void setUserName(String userName) {
        /* 343 */
        this.userName = userName;

    }


    public String getTrueName() {
        /* 354 */
        return this.trueName;

    }


    public void setTrueName(String trueName) {
        /* 365 */
        this.trueName = trueName;

    }


    public Long getAccountId() {
        /* 376 */
        return this.accountId;

    }


    public void setAccountId(Long accountId) {
        /* 387 */
        this.accountId = accountId;

    }


    public String getCoinCode() {
        /* 398 */
        return this.coinCode;

    }


    public void setCoinCode(String coinCode) {
        /* 409 */
        this.coinCode = coinCode;

    }


    public Integer getType() {
        /* 420 */
        return this.type;

    }


    public void setType(Integer type) {
        /* 431 */
        this.type = type;

    }


    public Integer getStatus() {
        /* 442 */
        return this.status;

    }


    public void setStatus(Integer status) {
        /* 453 */
        this.status = status;

    }


    public BigDecimal getEntrustPrice() {
        /* 464 */
        return this.entrustPrice;

    }


    public void setEntrustPrice(BigDecimal entrustPrice) {
        /* 475 */
        this.entrustPrice = entrustPrice;

    }


    public BigDecimal getEntrustCount() {
        /* 486 */
        return this.entrustCount;

    }


    public void setEntrustCount(BigDecimal entrustCount) {
        /* 497 */
        this.entrustCount = entrustCount;

    }


    public BigDecimal getEntrustSum() {
        /* 508 */
        return this.entrustSum;

    }


    public void setEntrustSum(BigDecimal entrustSum) {
        /* 519 */
        this.entrustSum = entrustSum;

    }


    public Date getEntrustTime() {
        /* 530 */
        return this.entrustTime;

    }


    public void setEntrustTime(Date entrustTime) {
        /* 541 */
        this.entrustTime = entrustTime;

    }


    public Integer getEntrustWay() {
        /* 552 */
        return this.entrustWay;

    }


    public void setEntrustWay(Integer entrustWay) {
        /* 563 */
        this.entrustWay = entrustWay;

    }


    public BigDecimal getSurplusEntrustCount() {
        /* 574 */
        return this.surplusEntrustCount;

    }


    public void setSurplusEntrustCount(BigDecimal surplusEntrustCount) {
        /* 585 */
        this.surplusEntrustCount = surplusEntrustCount;

    }


    public BigDecimal getTransactionFeeRate() {
        /* 596 */
        return this.transactionFeeRate;

    }


    public void setTransactionFeeRate(BigDecimal transactionFeeRate) {
        /* 607 */
        this.transactionFeeRate = transactionFeeRate;

    }


    public BigDecimal getTransactionFee() {
        /* 618 */
        return this.transactionFee;

    }


    public void setTransactionFee(BigDecimal transactionFee) {
        /* 629 */
        this.transactionFee = transactionFee;

    }


    public BigDecimal getTransactionSum() {
        /* 640 */
        return this.transactionSum;

    }


    public void setTransactionSum(BigDecimal transactionSum) {
        /* 651 */
        this.transactionSum = transactionSum;

    }


    public BigDecimal getProcessedPrice() {
        /* 662 */
        return this.processedPrice;

    }


    public void setProcessedPrice(BigDecimal processedPrice) {
        /* 673 */
        this.processedPrice = processedPrice;

    }


    public Integer getCustomerType() {
        /* 684 */
        return this.customerType;

    }


    public void setCustomerType(Integer customerType) {
        /* 695 */
        this.customerType = customerType;

    }


    public BigDecimal getFloatUpPrice() {
        /* 706 */
        return this.floatUpPrice;

    }


    public void setFloatUpPrice(BigDecimal floatUpPrice) {
        /* 717 */
        this.floatUpPrice = floatUpPrice;

    }


    public BigDecimal getFloatDownPrice() {
        /* 728 */
        return this.floatDownPrice;

    }


    public void setFloatDownPrice(BigDecimal floatDownPrice) {
        /* 739 */
        this.floatDownPrice = floatDownPrice;

    }


    public Integer getSource() {
        /* 750 */
        return this.source;

    }


    public void setSource(Integer source) {
        /* 761 */
        this.source = source;

    }


    public String getOnlyMatchExEntrusts() {
        /* 772 */
        return this.onlyMatchExEntrusts;

    }


    public void setOnlyMatchExEntrusts(String onlyMatchExEntrusts) {
        /* 783 */
        this.onlyMatchExEntrusts = onlyMatchExEntrusts;

    }


    public Integer getMatchPriority() {
        /* 794 */
        return this.matchPriority;

    }


    public void setMatchPriority(Integer matchPriority) {
        /* 805 */
        this.matchPriority = matchPriority;

    }


    public Integer getProjectType() {
        /* 816 */
        return this.projectType;

    }


    public void setProjectType(Integer projectType) {
        /* 827 */
        this.projectType = projectType;

    }


    public Date getTransactionTime() {
        /* 838 */
        return this.transactionTime;

    }


    public void setTransactionTime(Date transactionTime) {
        /* 849 */
        this.transactionTime = transactionTime;

    }


    public Integer getFixPriceType() {
        /* 853 */
        return this.fixPriceType;

    }


    public void setFixPriceType(Integer fixPriceType) {
        /* 857 */
        this.fixPriceType = fixPriceType;

    }


    public Long getCoinAccountId() {
        /* 861 */
        return this.coinAccountId;

    }


    public void setCoinAccountId(Long coinAccountId) {
        /* 865 */
        this.coinAccountId = coinAccountId;

    }


    public String getSurname() {
        /* 874 */
        return this.surname;

    }


    public void setSurname(String surname) {
        /* 878 */
        this.surname = surname;

    }


    public String toString() {
        /* 883 */
        return "EcEntrust [id=" + this.id + ", entrustNum=" + this.entrustNum + ", customerId=" + this.customerId + ", accountId=" + this.accountId + ", coinCode=" + this.coinCode + ", type=" + this.type + ", status=" + this.status + ", entrustPrice=" + this.entrustPrice + ", entrustNum=" + this.entrustCount + ", entrustTime=" + this.entrustTime + ", entrustWay=" + this.entrustWay + ", surplusEntrustNum=" + this.surplusEntrustCount + ", source=" + this.source + ", transactionFee=" + this.transactionFee + ", transactionSum=" + this.transactionSum + ", processedPrice=" + this.processedPrice + ", entrustSum=" + this.entrustSum + ", transactionFeeRate=" + this.transactionFeeRate + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\model\ExEntrust.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */