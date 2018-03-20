
package com.tangtang.trade.hry.exchange.product.model;

import com.tangtang.trade.hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
@Table(name = "ex_cointo_coin")
/*     */ public class ExCointoCoin
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
    @Column(name = "coinCode")
    /*     */ private String coinCode;
    /*     */
    @Column(name = "fixPriceCoinCode")
    /*     */ private String fixPriceCoinCode;
    /*     */
    @Column(name = "fixPriceType")
    /*     */ private Integer fixPriceType;
    /*     */
    @Column(name = "keepDecimalFixPrice")
    /*     */ private Integer keepDecimalFixPrice;
    /*     */
    @Column(name = "state")
    /*     */ private Integer state;
    /*     */
    @Column(name = "buyFeeRate")
    /*     */ private BigDecimal buyFeeRate;
    /*     */
    @Column(name = "sellFeeRate")
    /*     */ private BigDecimal sellFeeRate;
    /*     */
    @Column(name = "buyMinMoney")
    /*     */ private BigDecimal buyMinMoney;
    /*     */
    @Column(name = "sellMinCoin")
    /*     */ private BigDecimal sellMinCoin;
    /*     */
    @Column(name = "priceLimits")
    /*     */ private BigDecimal priceLimits;
    /*     */
    @Column(name = "rose")
    /*     */ private BigDecimal rose;
    /*     */
    @Column(name = "decline")
    /*     */ private BigDecimal decline;
    /*     */
    @Column(name = "averagePrice")
    /*     */ private BigDecimal averagePrice;
    /*     */
    @Column(name = "oneTimeOrderNum")
    /*     */ private BigDecimal oneTimeOrderNum;
    /*     */
    @Column(name = "isSratAuto")
    /*     */ private Integer isSratAuto;
    /*     */
    @Column(name = "isFromChbtc")
    /*     */ private Integer isFromChbtc;
    /*     */
    @Column(name = "autoPrice")
    /*     */ private BigDecimal autoPrice;
    /*     */
    @Column(name = "autoPriceFloat")
    /*     */ private BigDecimal autoPriceFloat;
    /*     */
    @Column(name = "autoCount")
    /*     */ private BigDecimal autoCount;
    /*     */
    @Column(name = "autoCountFloat")
    /*     */ private BigDecimal autoCountFloat;
    /*     */
    @Column(name = "autoUsername")
    /*     */ private String autoUsername;
    /*     */
    @Column(name = "atuoPriceType")
    /*     */ private Integer atuoPriceType;
    /*     */
    @Column(name = "upFloatPer")
    /*     */ private BigDecimal upFloatPer;
    /*     */
    @Column(name = "customerId")
    /*     */ private Long customerId;
    /*     */
    @Transient
    /*     */ private String yesterdayPrice;

    /*     */
    /*     */
    public Integer getAtuoPriceType()
    /*     */ {
        /* 126 */
        return this.atuoPriceType;
        /*     */
    }

    /*     */
    /*     */
    public void setAtuoPriceType(Integer atuoPriceType) {
        /* 130 */
        this.atuoPriceType = atuoPriceType;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getUpFloatPer() {
        /* 134 */
        return this.upFloatPer;
        /*     */
    }

    /*     */
    /*     */
    public void setUpFloatPer(BigDecimal upFloatPer) {
        /* 138 */
        this.upFloatPer = upFloatPer;
        /*     */
    }

    /*     */
    /*     */
    public String getYesterdayPrice()
    /*     */ {
        /* 143 */
        return this.yesterdayPrice;
        /*     */
    }

    /*     */
    /*     */
    public void setYesterdayPrice(String yesterdayPrice) {
        /* 147 */
        this.yesterdayPrice = yesterdayPrice;
        /*     */
    }

    /*     */
    /*     */
    public Long getCustomerId() {
        /* 151 */
        return this.customerId;
        /*     */
    }

    /*     */
    /*     */
    public void setCustomerId(Long customerId) {
        /* 155 */
        this.customerId = customerId;
        /*     */
    }

    /*     */
    /*     */
    public String getAutoUsername() {
        /* 159 */
        return this.autoUsername;
        /*     */
    }

    /*     */
    /*     */
    public void setAutoUsername(String autoUsername) {
        /* 163 */
        this.autoUsername = autoUsername;
        /*     */
    }

    /*     */
    /*     */
    public Integer getIsSratAuto() {
        /* 167 */
        return this.isSratAuto;
        /*     */
    }

    /*     */
    /*     */
    public void setIsSratAuto(Integer isSratAuto) {
        /* 171 */
        this.isSratAuto = isSratAuto;
        /*     */
    }

    /*     */
    /*     */
    public Integer getIsFromChbtc() {
        /* 175 */
        return this.isFromChbtc;
        /*     */
    }

    /*     */
    /*     */
    public void setIsFromChbtc(Integer isFromChbtc) {
        /* 179 */
        this.isFromChbtc = isFromChbtc;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getAutoPrice() {
        /* 183 */
        return this.autoPrice;
        /*     */
    }

    /*     */
    /*     */
    public void setAutoPrice(BigDecimal autoPrice) {
        /* 187 */
        this.autoPrice = autoPrice;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getAutoPriceFloat() {
        /* 191 */
        return this.autoPriceFloat;
        /*     */
    }

    /*     */
    /*     */
    public void setAutoPriceFloat(BigDecimal autoPriceFloat) {
        /* 195 */
        this.autoPriceFloat = autoPriceFloat;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getAutoCount() {
        /* 199 */
        return this.autoCount;
        /*     */
    }

    /*     */
    /*     */
    public void setAutoCount(BigDecimal autoCount) {
        /* 203 */
        this.autoCount = autoCount;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getAutoCountFloat() {
        /* 207 */
        return this.autoCountFloat;
        /*     */
    }

    /*     */
    /*     */
    public void setAutoCountFloat(BigDecimal autoCountFloat) {
        /* 211 */
        this.autoCountFloat = autoCountFloat;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getBuyFeeRate() {
        /* 215 */
        return this.buyFeeRate;
        /*     */
    }

    /*     */
    /*     */
    public void setBuyFeeRate(BigDecimal buyFeeRate) {
        /* 219 */
        this.buyFeeRate = buyFeeRate;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getSellFeeRate() {
        /* 223 */
        return this.sellFeeRate;
        /*     */
    }

    /*     */
    /*     */
    public void setSellFeeRate(BigDecimal sellFeeRate) {
        /* 227 */
        this.sellFeeRate = sellFeeRate;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getBuyMinMoney() {
        /* 231 */
        return this.buyMinMoney;
        /*     */
    }

    /*     */
    /*     */
    public void setBuyMinMoney(BigDecimal buyMinMoney) {
        /* 235 */
        this.buyMinMoney = buyMinMoney;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getSellMinCoin() {
        /* 239 */
        return this.sellMinCoin;
        /*     */
    }

    /*     */
    /*     */
    public void setSellMinCoin(BigDecimal sellMinCoin) {
        /* 243 */
        this.sellMinCoin = sellMinCoin;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getPriceLimits() {
        /* 247 */
        return this.priceLimits;
        /*     */
    }

    /*     */
    /*     */
    public void setPriceLimits(BigDecimal priceLimits) {
        /* 251 */
        this.priceLimits = priceLimits;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getRose() {
        /* 255 */
        return this.rose;
        /*     */
    }

    /*     */
    /*     */
    public void setRose(BigDecimal rose) {
        /* 259 */
        this.rose = rose;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getDecline() {
        /* 263 */
        return this.decline;
        /*     */
    }

    /*     */
    /*     */
    public void setDecline(BigDecimal decline) {
        /* 267 */
        this.decline = decline;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getAveragePrice() {
        /* 271 */
        return this.averagePrice;
        /*     */
    }

    /*     */
    /*     */
    public void setAveragePrice(BigDecimal averagePrice) {
        /* 275 */
        this.averagePrice = averagePrice;
        /*     */
    }

    /*     */
    /*     */
    public BigDecimal getOneTimeOrderNum() {
        /* 279 */
        return this.oneTimeOrderNum;
        /*     */
    }

    /*     */
    /*     */
    public void setOneTimeOrderNum(BigDecimal oneTimeOrderNum) {
        /* 283 */
        this.oneTimeOrderNum = oneTimeOrderNum;
        /*     */
    }

    /*     */
    /*     */
    public Integer getState() {
        /* 287 */
        return this.state;
        /*     */
    }

    /*     */
    /*     */
    public void setState(Integer state) {
        /* 291 */
        this.state = state;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /* 301 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /* 312 */
        this.id = id;
        /*     */
    }

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
    public String getCoinCode()
    /*     */ {
        /* 325 */
        return this.coinCode;
        /*     */
    }

    /*     */
    /*     */
    public void setCoinCode(String coinCode) {
        /* 329 */
        this.coinCode = coinCode;
        /*     */
    }

    /*     */
    /*     */
    public String getFixPriceCoinCode() {
        return this.fixPriceCoinCode;
    }

    public void setFixPriceCoinCode(String fixPriceCoinCode) {
        this.fixPriceCoinCode = fixPriceCoinCode;
    }

    public Integer getKeepDecimalFixPrice() {
        return this.keepDecimalFixPrice;
    }

    public void setKeepDecimalFixPrice(Integer keepDecimalFixPrice) {
        this.keepDecimalFixPrice = keepDecimalFixPrice;
    }

    public Integer getFixPriceType() {
        return this.fixPriceType;
    }

    public void setFixPriceType(Integer fixPriceType) {
        this.fixPriceType = fixPriceType;
    }
}
