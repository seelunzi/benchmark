
package com.tangtang.trade.hry.trade.entrust.model;


import hry.core.mvc.model.BaseExModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Table(name = "ex_order")
public class ExOrder
        extends BaseExModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "orderNum")
    private String orderNum;

    @Column(name = "coinCode")
    private String coinCode;

    @Column(name = "fixPriceCoinCode")
    private String fixPriceCoinCode;

    @Column(name = "fixPriceType")
    private Integer fixPriceType;

    @Column(name = "productName")
    private String productName;

    @Column(name = "transactionPrice")
    private BigDecimal transactionPrice;

    @Column(name = "transactionSum")
    private BigDecimal transactionSum;

    @Column(name = "transactionCount")
    private BigDecimal transactionCount;

    @Column(name = "transactionTime")
    private Date transactionTime;

    @Column(name = "orderTimestapm")
    private Long orderTimestapm;

    @Column(name = "inOrOutTransaction")
    private String inOrOutTransaction;

    @Transient
    private BigDecimal averagePrice;


    public Integer getFixPriceType() {
        /*  83 */
        return this.fixPriceType;

    }


    public void setFixPriceType(Integer fixPriceType) {
        /*  88 */
        this.fixPriceType = fixPriceType;

    }


    public String getFixPriceCoinCode() {
        /*  93 */
        return this.fixPriceCoinCode;

    }


    public void setFixPriceCoinCode(String fixPriceCoinCode) {
        /*  98 */
        this.fixPriceCoinCode = fixPriceCoinCode;

    }


    public BigDecimal getTransactionSum() {
        /* 107 */
        return this.transactionSum;

    }


    public void setTransactionSum(BigDecimal transactionSum) {
        /* 116 */
        this.transactionSum = transactionSum;

    }


    public Long getOrderTimestapm() {
        /* 125 */
        return this.orderTimestapm;

    }


    public void setOrderTimestapm(Long orderTimestapm) {
        /* 134 */
        this.orderTimestapm = orderTimestapm;

    }


    public String getInOrOutTransaction() {
        /* 143 */
        return this.inOrOutTransaction;

    }


    public void setInOrOutTransaction(String inOrOutTransaction) {
        /* 152 */
        this.inOrOutTransaction = inOrOutTransaction;

    }


    public String getProductName() {
        /* 157 */
        return this.productName;

    }


    public void setProductName(String productName) {
        /* 162 */
        this.productName = productName;

    }


    public Long getId() {
        /* 167 */
        return this.id;

    }


    public void setId(Long id) {
        /* 172 */
        this.id = id;

    }


    public String getOrderNum() {
        /* 177 */
        return this.orderNum;

    }


    public void setOrderNum(String orderNum) {
        /* 182 */
        this.orderNum = orderNum;

    }


    public String getCoinCode() {
        /* 187 */
        return this.coinCode;

    }


    public void setCoinCode(String coinCode) {
        /* 192 */
        this.coinCode = coinCode;

    }


    public BigDecimal getTransactionPrice() {
        /* 197 */
        return this.transactionPrice;

    }


    public void setTransactionPrice(BigDecimal transactionPrice) {
        /* 202 */
        this.transactionPrice = transactionPrice;

    }


    public BigDecimal getTransactionCount() {
        /* 207 */
        return this.transactionCount;

    }


    public void setTransactionCount(BigDecimal transactionCount) {
        /* 212 */
        this.transactionCount = transactionCount;

    }


    public Date getTransactionTime() {
        /* 217 */
        return this.transactionTime;

    }


    public void setTransactionTime(Date transactionTime) {
        /* 222 */
        this.transactionTime = transactionTime;

    }


    public BigDecimal getAveragePrice() {
        /* 227 */
        return this.averagePrice;

    }


    public void setAveragePrice(BigDecimal averagePrice) {
        /* 232 */
        this.averagePrice = averagePrice;

    }


    public ExOrder(Long id, String orderNum, String coinCode, BigDecimal transactionPrice, BigDecimal transactionCount, Date transactionTime, Long timestamps) {
        /* 239 */
        this.id = id;
        /* 240 */
        this.orderNum = orderNum;
        /* 241 */
        this.coinCode = coinCode;
        /* 242 */
        this.transactionPrice = transactionPrice;
        /* 243 */
        this.transactionCount = transactionCount;
        /* 244 */
        this.transactionTime = transactionTime;

    }


    public ExOrder() {
    }


    public String toString() {
        /* 253 */
        return "ExOrder [id=" + this.id + ", orderNum=" + this.orderNum + ", coinCode=" + this.coinCode + ", transactionPrice=" + this.transactionPrice + ", transactionCount=" + this.transactionCount + ", transactionTime=" + this.transactionTime + ", timestamps=" + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\model\ExOrder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */