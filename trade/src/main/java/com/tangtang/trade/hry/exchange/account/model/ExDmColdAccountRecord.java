/*     */
package com.tangtang.trade.hry.exchange.account.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

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
@Table(name = "ex_dm_cold_account_record")
/*     */ public class ExDmColdAccountRecord
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
    @Column(name = "accountId")
    /*     */ private Long accountId;
    /*     */
    @Column(name = "customerId")
    /*     */ private Long customerId;
    /*     */
    @Column(name = "userName")
    /*     */ private String userName;
    /*     */
    @Column(name = "trueName")
    /*     */ private String trueName;
    /*     */
    @Column(name = "recordType")
    /*     */ private Integer recordType;
    /*     */
    @Column(name = "transactionMoney")
    /*     */ private BigDecimal transactionMoney;
    /*     */
    @Column(name = "transactionNum")
    /*     */ private String transactionNum;
    /*     */
    @Column(name = "status")
    /*     */ private Integer status;
    /*     */
    @Column(name = "remark")
    /*     */ private String remark;
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
    /*     */
    public String getTrueName()
    /*     */ {
        /*  78 */
        return this.trueName;
        /*     */
    }

    /*     */
    /*     */
    public void setTrueName(String trueName) {
        /*  82 */
        this.trueName = trueName;
        /*     */
    }

    /*     */
    /*     */
    public Long getId() {
        /*  86 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    public void setId(Long id) {
        /*  90 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    public Long getAccountId() {
        /*  94 */
        return this.accountId;
        /*     */
    }

    /*     */
    /*     */
    public void setAccountId(Long accountId) {
        /*  98 */
        this.accountId = accountId;
        /*     */
    }

    /*     */
    /*     */
    public Long getCustomerId() {
        /* 102 */
        return this.customerId;
        /*     */
    }

    /*     */
    /*     */
    public void setCustomerId(Long customerId) {
        /* 106 */
        this.customerId = customerId;
        /*     */
    }

    /*     */
    /*     */
    public String getUserName() {
        /* 110 */
        return this.userName;
        /*     */
    }

    /*     */
    /*     */
    public void setUserName(String userName) {
        /* 114 */
        this.userName = userName;
        /*     */
    }

    /*     */
    /*     */
    public Integer getRecordType() {
        /* 118 */
        return this.recordType;
        /*     */
    }

    /*     */
    /*     */
    public void setRecordType(Integer recordType) {
        /* 122 */
        this.recordType = recordType;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getTransactionMoney() {
        /* 126 */
        return this.transactionMoney;
        /*     */
    }

    /*     */
    /*     */
    public void setTransactionMoney(BigDecimal transactionMoney) {
        /* 130 */
        this.transactionMoney = transactionMoney;
        /*     */
    }

    /*     */
    /*     */
    public String getTransactionNum() {
        /* 134 */
        return this.transactionNum;
        /*     */
    }

    /*     */
    /*     */
    public void setTransactionNum(String transactionNum) {
        /* 138 */
        this.transactionNum = transactionNum;
        /*     */
    }

    /*     */
    /*     */
    public Integer getStatus() {
        /* 142 */
        return this.status;
        /*     */
    }

    /*     */
    /*     */
    public void setStatus(Integer status) {
        /* 146 */
        this.status = status;
        /*     */
    }

    /*     */
    /*     */
    public String getRemark() {
        /* 150 */
        return this.remark;
        /*     */
    }

    /*     */
    /*     */
    public void setRemark(String remark) {
        /* 154 */
        this.remark = remark;
        /*     */
    }

    /*     */
    /*     */
    public String getCurrencyType() {
        /* 158 */
        return this.currencyType;
        /*     */
    }

    /*     */
    /*     */
    public void setCurrencyType(String currencyType) {
        /* 162 */
        this.currencyType = currencyType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public ExDmColdAccountRecord(Long id, Long accountId, Long customerId, String userName, Integer recordType, BigDecimal transactionMoney, String transactionNum, Integer status, String remark, String currencyType)
    /*     */ {
        /* 170 */
        this.id = id;
        /* 171 */
        this.accountId = accountId;
        /* 172 */
        this.customerId = customerId;
        /* 173 */
        this.userName = userName;
        /* 174 */
        this.recordType = recordType;
        /* 175 */
        this.transactionMoney = transactionMoney;
        /* 176 */
        this.transactionNum = transactionNum;
        /* 177 */
        this.status = status;
        /* 178 */
        this.remark = remark;
        /* 179 */
        this.currencyType = currencyType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public ExDmColdAccountRecord() {
    }

    /*     */
    /*     */
    /*     */
    public String toString()
    /*     */ {
        /* 188 */
        return "ExDmColdAccountRecord [id=" + this.id + ", accountId=" + this.accountId + ", customerId=" + this.customerId + ", userName=" + this.userName + ", recordType=" + this.recordType + ", transactionMoney=" + this.transactionMoney + ", transactionNum=" + this.transactionNum + ", status=" + this.status + ", remark=" + this.remark + ", currencyType=" + this.currencyType + "]";
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getCoinCode()
    /*     */ {
        /* 197 */
        return this.coinCode;
        /*     */
    }

    /*     */
    /*     */
    public void setCoinCode(String coinCode) {
        /* 201 */
        this.coinCode = coinCode;
        /*     */
    }

    /*     */
    /*     */
    public String getWebsite() {
        /* 205 */
        return this.website;
        /*     */
    }

    /*     */
    /*     */
    public void setWebsite(String website) {
        /* 209 */
        this.website = website;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\exchange\account\model\ExDmColdAccountRecord.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */