/*     */
package com.tangtang.trade.hry.trade.entrust.model;
/*     */
/*     */

import hry.core.mvc.model.BaseExModel;

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
/*     */
/*     */
/*     */
/*     */
@Table(name = "ex_entrust_plan")
/*     */ public class ExEntrustPlan
        /*     */ extends BaseExModel
        /*     */ {
    /*     */
    @Id
    /*     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*     */
    @Column(name = "id", unique = true, nullable = false)
    /*     */ private Long id;
    /*     */
    @Column(name = "isValid")
    /*     */ private Integer isValid;
    /*     */
    @Column(name = "floatPrice")
    /*     */ private BigDecimal floatPrice;
    /*     */
    @Column(name = "entrustCount")
    /*     */ private BigDecimal entrustCount;
    /*     */
    @Column(name = "type")
    /*     */ private Integer type;
    /*     */
    @Column(name = "entrustNum")
    /*     */ private String entrustNum;
    /*     */
    @Column(name = "customerId")
    /*     */ private Long customerId;
    /*     */
    @Column(name = "trueName")
    /*     */ private String trueName;
    /*     */
    @Column(name = "userName")
    /*     */ private String userName;
    /*     */
    @Column(name = "userCode")
    /*     */ private String userCode;
    /*     */
    @Column(name = "customerType")
    /*     */ private Integer customerType;
    /*     */
    @Column(name = "coinCode")
    /*     */ private String coinCode;
    /*     */
    @Column(name = "ispriceType")
    /*     */ private Boolean ispriceType;
    /*     */
    @Column(name = "priceType")
    /*     */ private Integer priceType;
    /*     */
    @Column(name = "priceCompare")
    /*     */ private Integer priceCompare;
    /*     */
    @Column(name = "priceValue")
    /*     */ private BigDecimal priceValue;
    /*     */
    @Column(name = "iscommonCountType")
    /*     */ private Boolean iscommonCountType;
    /*     */
    @Column(name = "commonCountType")
    /*     */ private Integer commonCountType;
    /*     */
    @Column(name = "commonCountCompare")
    /*     */ private Integer commonCountCompare;
    /*     */
    @Column(name = "commonCountValue")
    /*     */ private BigDecimal commonCountValue;
    /*     */
    @Column(name = "ismakerCountType")
    /*     */ private Boolean ismakerCountType;
    /*     */
    @Column(name = "makerCountType")
    /*     */ private Integer makerCountType;
    /*     */
    @Column(name = "makerCountCompare")
    /*     */ private Integer makerCountCompare;
    /*     */
    @Column(name = "makerCountValue")
    /*     */ private BigDecimal makerCountValue;
    /*     */
    @Column(name = "iscommonProportionType")
    /*     */ private Boolean iscommonProportionType;
    /*     */
    @Column(name = "commonProportionType")
    /*     */ private Integer commonProportionType;
    /*     */
    @Column(name = "commonProportionCompare")
    /*     */ private Integer commonProportionCompare;
    /*     */
    @Column(name = "commonProportionValue")
    /*     */ private BigDecimal commonProportionValue;
    /*     */
    @Column(name = "ismakerProportionType")
    /*     */ private Boolean ismakerProportionType;
    /*     */
    @Column(name = "makerProportionType")
    /*     */ private Integer makerProportionType;
    /*     */
    @Column(name = "makerProportionCompare")
    /*     */ private Integer makerProportionCompare;
    /*     */
    @Column(name = "makerProportionValue")
    /*     */ private BigDecimal makerProportionValue;
    /*     */
    @Column(name = "istimeType")
    /*     */ private Boolean istimeType;
    /*     */
    @Column(name = "timeType")
    /*     */ private Integer timeType;
    /*     */
    @Column(name = "timeCompare")
    /*     */ private Integer timeCompare;
    /*     */
    @Column(name = "timeValue")
    /*     */ private String timeValue;
    /*     */
    @Column(name = "isPreEntrust")
    /*     */ private Integer isPreEntrust;
    /*     */
    @Column(name = "isEntrustNums")
    /*     */ private Boolean isEntrustNums;
    /*     */
    @Column(name = "entrustNums")
    /*     */ private String entrustNums;
    /*     */
    @Column(name = "allSellEntrust")
    /*     */ private Boolean allSellEntrust;
    /*     */
    @Column(name = "allBuyEntrust")
    /*     */ private Boolean allBuyEntrust;
    /*     */
    @Column(name = "isEntrustCount")
    /*     */ private Boolean isEntrustCount;
    /*     */
    @Column(name = "entrustCountl")
    /*     */ private BigDecimal entrustCountl;
    /*     */
    @Column(name = "entrustCountg")
    /*     */ private BigDecimal entrustCountg;
    /*     */
    @Column(name = "isEntrustPrice")
    /*     */ private Boolean isEntrustPrice;
    /*     */
    @Column(name = "entrustPriceg")
    /*     */ private BigDecimal entrustPriceg;
    /*     */
    @Column(name = "entrustPricel")
    /*     */ private BigDecimal entrustPricel;
    /*     */
    @Column(name = "pingCondition")
    /*     */ private String pingCondition;

    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /* 192 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /* 199 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getIsValid()
    /*     */ {
        /* 206 */
        return this.isValid;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsValid(Integer isValid)
    /*     */ {
        /* 213 */
        this.isValid = isValid;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getFloatPrice()
    /*     */ {
        /* 220 */
        return this.floatPrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setFloatPrice(BigDecimal floatPrice)
    /*     */ {
        /* 227 */
        this.floatPrice = floatPrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getEntrustCount()
    /*     */ {
        /* 234 */
        return this.entrustCount;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setEntrustCount(BigDecimal entrustCount)
    /*     */ {
        /* 241 */
        this.entrustCount = entrustCount;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getCustomerType()
    /*     */ {
        /* 249 */
        return this.customerType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCustomerType(Integer customerType)
    /*     */ {
        /* 256 */
        this.customerType = customerType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getType()
    /*     */ {
        /* 263 */
        return this.type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setType(Integer type)
    /*     */ {
        /* 270 */
        this.type = type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getEntrustNum()
    /*     */ {
        /* 277 */
        return this.entrustNum;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setEntrustNum(String entrustNum)
    /*     */ {
        /* 284 */
        this.entrustNum = entrustNum;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Long getCustomerId()
    /*     */ {
        /* 291 */
        return this.customerId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCustomerId(Long customerId)
    /*     */ {
        /* 298 */
        this.customerId = customerId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getUserCode()
    /*     */ {
        /* 305 */
        return this.userCode;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setUserCode(String userCode)
    /*     */ {
        /* 312 */
        this.userCode = userCode;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getCoinCode()
    /*     */ {
        /* 319 */
        return this.coinCode;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCoinCode(String coinCode)
    /*     */ {
        /* 326 */
        this.coinCode = coinCode;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIspriceType()
    /*     */ {
        /* 333 */
        return this.ispriceType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIspriceType(Boolean ispriceType)
    /*     */ {
        /* 340 */
        this.ispriceType = ispriceType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getPriceType()
    /*     */ {
        /* 347 */
        return this.priceType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setPriceType(Integer priceType)
    /*     */ {
        /* 354 */
        this.priceType = priceType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getPriceCompare()
    /*     */ {
        /* 361 */
        return this.priceCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setPriceCompare(Integer priceCompare)
    /*     */ {
        /* 368 */
        this.priceCompare = priceCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getPriceValue()
    /*     */ {
        /* 375 */
        return this.priceValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setPriceValue(BigDecimal priceValue)
    /*     */ {
        /* 382 */
        this.priceValue = priceValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIscommonCountType()
    /*     */ {
        /* 389 */
        return this.iscommonCountType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIscommonCountType(Boolean iscommonCountType)
    /*     */ {
        /* 396 */
        this.iscommonCountType = iscommonCountType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getCommonCountType()
    /*     */ {
        /* 403 */
        return this.commonCountType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCommonCountType(Integer commonCountType)
    /*     */ {
        /* 410 */
        this.commonCountType = commonCountType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getCommonCountCompare()
    /*     */ {
        /* 417 */
        return this.commonCountCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCommonCountCompare(Integer commonCountCompare)
    /*     */ {
        /* 424 */
        this.commonCountCompare = commonCountCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getCommonCountValue()
    /*     */ {
        /* 431 */
        return this.commonCountValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCommonCountValue(BigDecimal commonCountValue)
    /*     */ {
        /* 438 */
        this.commonCountValue = commonCountValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIsmakerCountType()
    /*     */ {
        /* 445 */
        return this.ismakerCountType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsmakerCountType(Boolean ismakerCountType)
    /*     */ {
        /* 452 */
        this.ismakerCountType = ismakerCountType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getMakerCountType()
    /*     */ {
        /* 459 */
        return this.makerCountType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setMakerCountType(Integer makerCountType)
    /*     */ {
        /* 466 */
        this.makerCountType = makerCountType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getMakerCountCompare()
    /*     */ {
        /* 473 */
        return this.makerCountCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setMakerCountCompare(Integer makerCountCompare)
    /*     */ {
        /* 480 */
        this.makerCountCompare = makerCountCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getMakerCountValue()
    /*     */ {
        /* 487 */
        return this.makerCountValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setMakerCountValue(BigDecimal makerCountValue)
    /*     */ {
        /* 494 */
        this.makerCountValue = makerCountValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIscommonProportionType()
    /*     */ {
        /* 501 */
        return this.iscommonProportionType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIscommonProportionType(Boolean iscommonProportionType)
    /*     */ {
        /* 508 */
        this.iscommonProportionType = iscommonProportionType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getCommonProportionType()
    /*     */ {
        /* 515 */
        return this.commonProportionType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCommonProportionType(Integer commonProportionType)
    /*     */ {
        /* 522 */
        this.commonProportionType = commonProportionType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getCommonProportionCompare()
    /*     */ {
        /* 529 */
        return this.commonProportionCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCommonProportionCompare(Integer commonProportionCompare)
    /*     */ {
        /* 536 */
        this.commonProportionCompare = commonProportionCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getCommonProportionValue()
    /*     */ {
        /* 543 */
        return this.commonProportionValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setCommonProportionValue(BigDecimal commonProportionValue)
    /*     */ {
        /* 550 */
        this.commonProportionValue = commonProportionValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIsmakerProportionType()
    /*     */ {
        /* 557 */
        return this.ismakerProportionType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsmakerProportionType(Boolean ismakerProportionType)
    /*     */ {
        /* 564 */
        this.ismakerProportionType = ismakerProportionType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getMakerProportionType()
    /*     */ {
        /* 571 */
        return this.makerProportionType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setMakerProportionType(Integer makerProportionType)
    /*     */ {
        /* 578 */
        this.makerProportionType = makerProportionType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getMakerProportionCompare()
    /*     */ {
        /* 585 */
        return this.makerProportionCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setMakerProportionCompare(Integer makerProportionCompare)
    /*     */ {
        /* 592 */
        this.makerProportionCompare = makerProportionCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getMakerProportionValue()
    /*     */ {
        /* 599 */
        return this.makerProportionValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setMakerProportionValue(BigDecimal makerProportionValue)
    /*     */ {
        /* 606 */
        this.makerProportionValue = makerProportionValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIstimeType()
    /*     */ {
        /* 613 */
        return this.istimeType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIstimeType(Boolean istimeType)
    /*     */ {
        /* 620 */
        this.istimeType = istimeType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getTimeType()
    /*     */ {
        /* 627 */
        return this.timeType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setTimeType(Integer timeType)
    /*     */ {
        /* 634 */
        this.timeType = timeType;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getTimeCompare()
    /*     */ {
        /* 641 */
        return this.timeCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setTimeCompare(Integer timeCompare)
    /*     */ {
        /* 648 */
        this.timeCompare = timeCompare;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getTimeValue()
    /*     */ {
        /* 655 */
        return this.timeValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setTimeValue(String timeValue)
    /*     */ {
        /* 662 */
        this.timeValue = timeValue;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getIsPreEntrust()
    /*     */ {
        /* 669 */
        return this.isPreEntrust;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsPreEntrust(Integer isPreEntrust)
    /*     */ {
        /* 676 */
        this.isPreEntrust = isPreEntrust;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIsEntrustNums()
    /*     */ {
        /* 683 */
        return this.isEntrustNums;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsEntrustNums(Boolean isEntrustNums)
    /*     */ {
        /* 690 */
        this.isEntrustNums = isEntrustNums;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getEntrustNums()
    /*     */ {
        /* 697 */
        return this.entrustNums;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setEntrustNums(String entrustNums)
    /*     */ {
        /* 704 */
        this.entrustNums = entrustNums;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getAllSellEntrust()
    /*     */ {
        /* 711 */
        return this.allSellEntrust;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setAllSellEntrust(Boolean allSellEntrust)
    /*     */ {
        /* 718 */
        this.allSellEntrust = allSellEntrust;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getAllBuyEntrust()
    /*     */ {
        /* 725 */
        return this.allBuyEntrust;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setAllBuyEntrust(Boolean allBuyEntrust)
    /*     */ {
        /* 732 */
        this.allBuyEntrust = allBuyEntrust;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIsEntrustCount()
    /*     */ {
        /* 739 */
        return this.isEntrustCount;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsEntrustCount(Boolean isEntrustCount)
    /*     */ {
        /* 746 */
        this.isEntrustCount = isEntrustCount;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getEntrustCountl()
    /*     */ {
        /* 753 */
        return this.entrustCountl;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setEntrustCountl(BigDecimal entrustCountl)
    /*     */ {
        /* 760 */
        this.entrustCountl = entrustCountl;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getEntrustCountg()
    /*     */ {
        /* 767 */
        return this.entrustCountg;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setEntrustCountg(BigDecimal entrustCountg)
    /*     */ {
        /* 774 */
        this.entrustCountg = entrustCountg;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Boolean getIsEntrustPrice()
    /*     */ {
        /* 781 */
        return this.isEntrustPrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsEntrustPrice(Boolean isEntrustPrice)
    /*     */ {
        /* 788 */
        this.isEntrustPrice = isEntrustPrice;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getEntrustPriceg()
    /*     */ {
        /* 795 */
        return this.entrustPriceg;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setEntrustPriceg(BigDecimal entrustPriceg)
    /*     */ {
        /* 802 */
        this.entrustPriceg = entrustPriceg;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getEntrustPricel()
    /*     */ {
        /* 809 */
        return this.entrustPricel;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setEntrustPricel(BigDecimal entrustPricel)
    /*     */ {
        /* 816 */
        this.entrustPricel = entrustPricel;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getPingCondition()
    /*     */ {
        /* 823 */
        return this.pingCondition;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setPingCondition(String pingCondition)
    /*     */ {
        /* 830 */
        this.pingCondition = pingCondition;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getTrueName()
    /*     */ {
        /* 837 */
        return this.trueName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setTrueName(String trueName)
    /*     */ {
        /* 844 */
        this.trueName = trueName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getUserName()
    /*     */ {
        /* 851 */
        return this.userName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setUserName(String userName)
    /*     */ {
        /* 858 */
        this.userName = userName;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\model\ExEntrustPlan.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */