
package com.tangtang.trade.hry.account.fund.model;

import com.tangtang.trade.hry.core.mvc.model.BaseModel;

import java.math.BigDecimal;

@Table(name = "app_cold_account_record")
/*     */ public class AppColdAccountRecord
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
    @Column(name = "website")
    /*     */ private String website;
    /*     */
    @Column(name = "trueName")
    /*     */ private String trueName;

    /*     */
    /*     */
    public String getTrueName()
    /*     */ {
        /*  71 */
        return this.trueName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setTrueName(String trueName)
    /*     */ {
        /*  79 */
        this.trueName = trueName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  87 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /*  95 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getAccountId()
    /*     */ {
        /* 103 */
        return this.accountId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setAccountId(Long accountId)
    /*     */ {
        /* 111 */
        this.accountId = accountId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getCustomerId()
    /*     */ {
        /* 119 */
        return this.customerId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setCustomerId(Long customerId)
    /*     */ {
        /* 127 */
        this.customerId = customerId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getUserName()
    /*     */ {
        /* 135 */
        return this.userName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setUserName(String userName)
    /*     */ {
        /* 143 */
        this.userName = userName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getRecordType()
    /*     */ {
        /* 151 */
        return this.recordType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setRecordType(Integer recordType)
    /*     */ {
        /* 159 */
        this.recordType = recordType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getTransactionMoney()
    /*     */ {
        /* 167 */
        return this.transactionMoney;
        /*     */
    }

    public void setTransactionMoney(BigDecimal transactionMoney)
    /*     */ {
        /* 175 */
        this.transactionMoney = transactionMoney;
        /*     */
    }

    public String getTransactionNum() {
        return this.transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getStatus()
    /*     */ {
        /* 199 */
        return this.status;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setStatus(Integer status)
    /*     */ {
        /* 207 */
        this.status = status;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getRemark()
    /*     */ {
        /* 215 */
        return this.remark;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setRemark(String remark)
    /*     */ {
        /* 223 */
        this.remark = remark;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getCurrencyType()
    /*     */ {
        /* 231 */
        return this.currencyType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setCurrencyType(String currencyType)
    /*     */ {
        /* 239 */
        this.currencyType = currencyType;
        /*     */
    }

    /*     */
    /*     */
    public String getWebsite() {
        /* 243 */
        return this.website;
        /*     */
    }

    /*     */
    /*     */
    public void setWebsite(String website) {
        /* 247 */
        this.website = website;
        /*     */
    }
    /*     */
}
