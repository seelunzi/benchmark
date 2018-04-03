
package com.tangtang.trade.hry.trade.entrust.model;


import hry.core.mvc.model.BaseExModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Table(name = "ex_order_info")
public class ExOrderInfo
        extends BaseExModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "orderNum")
    private String orderNum;

    @Column(name = "productName")
    private String productName;

    @Column(name = "coinCode")
    private String coinCode;

    @Column(name = "transactionPrice")
    private BigDecimal transactionPrice;

    @Column(name = "transactionCount")
    private BigDecimal transactionCount;

    @Column(name = "transactionSum")
    private BigDecimal transactionSum;

    @Column(name = "transactionTime")
    private Date transactionTime;

    @Column(name = "type")
    private Integer type;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "userCode")
    private String userCode;

    @Column(name = "userName")
    private String userName;

    @Column(name = "trueName")
    private String trueName;

    @Column(name = "transactionFee")
    private BigDecimal transactionFee;

    @Column(name = "transactionFeeRate")
    private BigDecimal transactionFeeRate;

    @Column(name = "entrustNum")
    private String entrustNum;

    @Column(name = "transactionBuyFeeRate")
    private BigDecimal transactionBuyFeeRate;

    @Column(name = "transactionBuyFee")
    private BigDecimal transactionBuyFee;

    @Column(name = "transactionSellFeeRate")
    private BigDecimal transactionSellFeeRate;

    @Column(name = "transactionSellFee")
    private BigDecimal transactionSellFee;

    @Column(name = "buyEntrustNum")
    private String buyEntrustNum;

    @Column(name = "sellEntrustNum")
    private String sellEntrustNum;

    @Column(name = "sellTrueName")
    private String sellTrueName;

    @Column(name = "buyCustomId")
    private Long buyCustomId;

    @Column(name = "buyUserCode")
    private String buyUserCode;

    @Column(name = "buyUserName")
    private String buyUserName;

    @Column(name = "buyTrueName")
    private String buyTrueName;

    @Column(name = "sellCustomId")
    private Long sellCustomId;

    @Column(name = "sellUserCode")
    private String sellUserCode;

    @Column(name = "sellUserName")
    private String sellUserName;

    @Column(name = "orderTimestapm")
    private Long orderTimestapm;

    @Column(name = "fixPriceCoinCode")
    private String fixPriceCoinCode;

    @Column(name = "fixPriceType")
    private Integer fixPriceType;

    @Transient
    private String recordTypeName;

    @Column(name = "inOrOutTransaction")
    private String inOrOutTransaction;

    @Column(name = "profitandlossMoney")
    private BigDecimal profitandlossMoney;

    @Column(name = "isCulAtferMoney")
    private Integer isCulAtferMoney;


    public Integer getIsCulAtferMoney() {
        /* 160 */
        return this.isCulAtferMoney;

    }


    public void setIsCulAtferMoney(Integer isCulAtferMoney) {
        /* 165 */
        this.isCulAtferMoney = isCulAtferMoney;

    }


    public String getFixPriceCoinCode() {
        /* 170 */
        return this.fixPriceCoinCode;

    }


    public void setFixPriceCoinCode(String fixPriceCoinCode) {
        /* 175 */
        this.fixPriceCoinCode = fixPriceCoinCode;

    }


    public Integer getFixPriceType() {
        /* 180 */
        return this.fixPriceType;

    }


    public void setFixPriceType(Integer fixPriceType) {
        /* 185 */
        this.fixPriceType = fixPriceType;

    }


    public BigDecimal getProfitandlossMoney() {
        /* 194 */
        return this.profitandlossMoney;

    }


    public void setProfitandlossMoney(BigDecimal profitandlossMoney) {
        /* 203 */
        this.profitandlossMoney = profitandlossMoney;

    }


    public String getEntrustNum() {
        /* 212 */
        return this.entrustNum;

    }


    public void setEntrustNum(String entrustNum) {
        /* 221 */
        this.entrustNum = entrustNum;

    }


    public Long getCustomerId() {
        /* 230 */
        return this.customerId;

    }


    public void setCustomerId(Long customerId) {
        /* 239 */
        this.customerId = customerId;

    }


    public String getUserCode() {
        /* 248 */
        return this.userCode;

    }


    public void setUserCode(String userCode) {
        /* 257 */
        this.userCode = userCode;

    }


    public String getUserName() {
        /* 266 */
        return this.userName;

    }


    public void setUserName(String userName) {
        /* 275 */
        this.userName = userName;

    }


    public BigDecimal getTransactionFee() {
        /* 284 */
        return this.transactionFee;

    }


    public void setTransactionFee(BigDecimal transactionFee) {
        /* 293 */
        this.transactionFee = transactionFee;

    }


    public BigDecimal getTransactionFeeRate() {
        /* 302 */
        return this.transactionFeeRate;

    }


    public void setTransactionFeeRate(BigDecimal transactionFeeRate) {
        /* 311 */
        this.transactionFeeRate = transactionFeeRate;

    }


    public Integer getType() {
        /* 320 */
        return this.type;

    }


    public void setType(Integer type) {
        /* 329 */
        this.type = type;

    }


    public String getBuyUserName() {
        /* 338 */
        return this.buyUserName;

    }


    public void setBuyUserName(String buyUserName) {
        /* 347 */
        this.buyUserName = buyUserName;

    }


    public String getSellUserName() {
        /* 356 */
        return this.sellUserName;

    }


    public void setSellUserName(String sellUserName) {
        /* 365 */
        this.sellUserName = sellUserName;

    }


    public String getInOrOutTransaction() {
        /* 374 */
        return this.inOrOutTransaction;

    }


    public void setInOrOutTransaction(String inOrOutTransaction) {
        /* 383 */
        this.inOrOutTransaction = inOrOutTransaction;

    }


    public Long getOrderTimestapm() {
        /* 392 */
        return this.orderTimestapm;

    }


    public void setOrderTimestapm(Long orderTimestapm) {
        /* 401 */
        this.orderTimestapm = orderTimestapm;

    }


    public String getProductName() {
        /* 406 */
        return this.productName;

    }


    public void setProductName(String productName) {
        /* 411 */
        this.productName = productName;

    }


    public String getRecordTypeName() {
        /* 420 */
        return this.recordTypeName;

    }


    public void setRecordTypeName(String recordTypeName) {
        /* 429 */
        this.recordTypeName = recordTypeName;

    }


    public ExOrderInfo(Long id, String orderNum, String coinCode, BigDecimal transactionPrice, BigDecimal transactionCount, Date transactionTime, BigDecimal transactionSum, BigDecimal transactionBuyFee, BigDecimal transactionSellFee, String buyEntrustNum, String sellEntrustNum, Long buyCustomId, Long sellCustomId, BigDecimal transactionBuyFeeRate, BigDecimal transactionSellFeeRate) {
        /* 438 */
        this.id = id;
        /* 439 */
        this.orderNum = orderNum;
        /* 440 */
        this.coinCode = coinCode;
        /* 441 */
        this.transactionPrice = transactionPrice;
        /* 442 */
        this.transactionCount = transactionCount;
        /* 443 */
        this.transactionTime = transactionTime;
        /* 444 */
        this.transactionSum = transactionSum;
        /* 445 */
        this.transactionBuyFee = transactionBuyFee;
        /* 446 */
        this.transactionSellFee = transactionSellFee;
        /* 447 */
        this.buyEntrustNum = buyEntrustNum;
        /* 448 */
        this.sellEntrustNum = sellEntrustNum;
        /* 449 */
        this.buyCustomId = buyCustomId;
        /* 450 */
        this.sellCustomId = sellCustomId;
        /* 451 */
        this.transactionBuyFeeRate = transactionBuyFeeRate;
        /* 452 */
        this.transactionSellFeeRate = transactionSellFeeRate;

    }


    public BigDecimal getTransactionBuyFeeRate() {
        /* 461 */
        return this.transactionBuyFeeRate;

    }


    public void setTransactionBuyFeeRate(BigDecimal transactionBuyFeeRate) {
        /* 470 */
        this.transactionBuyFeeRate = transactionBuyFeeRate;

    }


    public BigDecimal getTransactionSellFeeRate() {
        /* 479 */
        return this.transactionSellFeeRate;

    }


    public void setTransactionSellFeeRate(BigDecimal transactionSellFeeRate) {
        /* 488 */
        this.transactionSellFeeRate = transactionSellFeeRate;

    }


    public Long getId() {
        /* 493 */
        return this.id;

    }


    public void setId(Long id) {
        /* 498 */
        this.id = id;

    }


    public String getOrderNum() {
        /* 503 */
        return this.orderNum;

    }


    public void setOrderNum(String orderNum) {
        /* 508 */
        this.orderNum = orderNum;

    }


    public String getCoinCode() {
        /* 513 */
        return this.coinCode;

    }


    public void setCoinCode(String coinCode) {
        /* 517 */
        this.coinCode = coinCode;

    }


    public BigDecimal getTransactionPrice() {
        /* 522 */
        return this.transactionPrice;

    }


    public void setTransactionPrice(BigDecimal transactionPrice) {
        /* 527 */
        this.transactionPrice = transactionPrice;

    }


    public BigDecimal getTransactionCount() {
        /* 532 */
        return this.transactionCount;

    }


    public void setTransactionCount(BigDecimal transactionCount) {
        /* 537 */
        this.transactionCount = transactionCount;

    }


    public Date getTransactionTime() {
        /* 542 */
        return this.transactionTime;

    }


    public void setTransactionTime(Date transactionTime) {
        /* 546 */
        this.transactionTime = transactionTime;

    }


    public BigDecimal getTransactionSum() {
        /* 551 */
        return this.transactionSum;

    }


    public void setTransactionSum(BigDecimal transactionSum) {
        /* 555 */
        this.transactionSum = transactionSum;

    }


    public BigDecimal getTransactionBuyFee() {
        /* 560 */
        return this.transactionBuyFee;

    }


    public void setTransactionBuyFee(BigDecimal transactionBuyFee) {
        /* 565 */
        this.transactionBuyFee = transactionBuyFee;

    }


    public BigDecimal getTransactionSellFee() {
        /* 570 */
        return this.transactionSellFee;

    }


    public void setTransactionSellFee(BigDecimal transactionSellFee) {
        /* 575 */
        this.transactionSellFee = transactionSellFee;

    }


    public String getBuyEntrustNum() {
        /* 580 */
        return this.buyEntrustNum;

    }


    public void setBuyEntrustNum(String buyEntrustNum) {
        /* 585 */
        this.buyEntrustNum = buyEntrustNum;

    }


    public String getSellEntrustNum() {
        /* 590 */
        return this.sellEntrustNum;

    }


    public void setSellEntrustNum(String sellEntrustNum) {
        /* 595 */
        this.sellEntrustNum = sellEntrustNum;

    }


    public Long getBuyCustomId() {
        /* 599 */
        return this.buyCustomId;

    }


    public void setBuyCustomId(Long buyCustomId) {
        /* 604 */
        this.buyCustomId = buyCustomId;

    }


    public Long getSellCustomId() {
        /* 609 */
        return this.sellCustomId;

    }


    public void setSellCustomId(Long sellCustomId) {
        /* 614 */
        this.sellCustomId = sellCustomId;

    }


    public ExOrderInfo() {
    }


    public String getBuyUserCode() {
        /* 626 */
        return this.buyUserCode;

    }


    public void setBuyUserCode(String buyUserCode) {
        /* 635 */
        this.buyUserCode = buyUserCode;

    }


    public String getSellUserCode() {
        /* 644 */
        return this.sellUserCode;

    }


    public void setSellUserCode(String sellUserCode) {
        /* 653 */
        this.sellUserCode = sellUserCode;

    }


    public String getTrueName() {
        /* 662 */
        return this.trueName;

    }


    public void setTrueName(String trueName) {
        /* 671 */
        this.trueName = trueName;

    }


    public String getSellTrueName() {
        /* 680 */
        return this.sellTrueName;

    }


    public void setSellTrueName(String sellTrueName) {
        /* 689 */
        this.sellTrueName = sellTrueName;

    }


    public String getBuyTrueName() {
        /* 698 */
        return this.buyTrueName;

    }


    public void setBuyTrueName(String buyTrueName) {
        /* 707 */
        this.buyTrueName = buyTrueName;

    }


    public String toString() {
        /* 713 */
        return "ExOrderInfo [id=" + this.id + ", orderNum=" + this.orderNum + ", coinCode=" + this.coinCode + ", transactionPrice=" + this.transactionPrice + ", transactionCount=" + this.transactionCount + ", transactionTime=" + this.transactionTime + ", transactionSum=" + this.transactionSum + ", transactionBuyFee=" + this.transactionBuyFee + ", transactionBuyFeeRate=" + this.transactionBuyFeeRate + ", transactionSellFeeRate=" + this.transactionSellFeeRate + ", transactionSellFee=" + this.transactionSellFee + ", buyEntrustNum=" + this.buyEntrustNum + ", sellEntrustNum=" + this.sellEntrustNum + ", buyCustomId=" + this.buyCustomId + ", sellCustomId=" + this.sellCustomId + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\model\ExOrderInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */