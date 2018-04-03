
package com.tangtang.trade.hry.exchange.account.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;


@Table(name = "ex_dm_hot_account_record")
public class ExDmHotAccountRecord
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "accountId")
    private Long accountId;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "trueName")
    private String trueName;

    @Column(name = "recordType")
    private Integer recordType;

    @Column(name = "transactionMoney")
    private BigDecimal transactionMoney;

    @Column(name = "transactionNum")
    private String transactionNum;

    @Column(name = "status")
    private Integer status;

    @Column(name = "remark")
    private String remark;

    @Column(name = "currencyType")
    private String currencyType;

    @Column(name = "coinCode")
    private String coinCode;

    @Column(name = "website")
    private String website;


    public String getTrueName() {
        /*  77 */
        return this.trueName;

    }


    public void setTrueName(String trueName) {
        /*  81 */
        this.trueName = trueName;

    }


    public Long getId() {
        /*  85 */
        return this.id;

    }


    public void setId(Long id) {
        /*  89 */
        this.id = id;

    }


    public Long getAccountId() {
        /*  93 */
        return this.accountId;

    }


    public void setAccountId(Long accountId) {
        /*  97 */
        this.accountId = accountId;

    }


    public Long getCustomerId() {
        /* 101 */
        return this.customerId;

    }


    public void setCustomerId(Long customerId) {
        /* 105 */
        this.customerId = customerId;

    }


    public String getUserName() {
        /* 109 */
        return this.userName;

    }


    public void setUserName(String userName) {
        /* 113 */
        this.userName = userName;

    }


    public Integer getRecordType() {
        /* 117 */
        return this.recordType;

    }


    public void setRecordType(Integer recordType) {
        /* 121 */
        this.recordType = recordType;

    }


    public BigDecimal getTransactionMoney() {
        /* 125 */
        return this.transactionMoney;

    }


    public void setTransactionMoney(BigDecimal transactionMoney) {
        /* 129 */
        this.transactionMoney = transactionMoney;

    }


    public String getTransactionNum() {
        /* 133 */
        return this.transactionNum;

    }


    public void setTransactionNum(String transactionNum) {
        /* 137 */
        this.transactionNum = transactionNum;

    }


    public Integer getStatus() {
        /* 141 */
        return this.status;

    }


    public void setStatus(Integer status) {
        /* 145 */
        this.status = status;

    }


    public String getRemark() {
        /* 149 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 153 */
        this.remark = remark;

    }


    public String getCurrencyType() {
        /* 157 */
        return this.currencyType;

    }


    public void setCurrencyType(String currencyType) {
        /* 161 */
        this.currencyType = currencyType;

    }


    public ExDmHotAccountRecord(Long id, Long accountId, Long customerId, String userName, Integer recordType, BigDecimal transactionMoney, String transactionNum, Integer status, String remark, String currencyType) {
        /* 169 */
        this.id = id;
        /* 170 */
        this.accountId = accountId;
        /* 171 */
        this.customerId = customerId;
        /* 172 */
        this.userName = userName;
        /* 173 */
        this.recordType = recordType;
        /* 174 */
        this.transactionMoney = transactionMoney;
        /* 175 */
        this.transactionNum = transactionNum;
        /* 176 */
        this.status = status;
        /* 177 */
        this.remark = remark;
        /* 178 */
        this.currencyType = currencyType;

    }


    public ExDmHotAccountRecord() {
    }


    public String getCoinCode() {
        /* 186 */
        return this.coinCode;

    }


    public void setCoinCode(String coinCode) {
        /* 190 */
        this.coinCode = coinCode;

    }


    public String getWebsite() {
        /* 194 */
        return this.website;

    }


    public void setWebsite(String website) {
        /* 198 */
        this.website = website;

    }


    public String toString() {
        /* 203 */
        return "ExDmHotAccountRecord [id=" + this.id + ", accountId=" + this.accountId + ", customerId=" + this.customerId + ", userName=" + this.userName + ", recordType=" + this.recordType + ", transactionMoney=" + this.transactionMoney + ", transactionNum=" + this.transactionNum + ", status=" + this.status + ", remark=" + this.remark + ", vurrencyType=" + this.currencyType + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\exchange\account\model\ExDmHotAccountRecord.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */