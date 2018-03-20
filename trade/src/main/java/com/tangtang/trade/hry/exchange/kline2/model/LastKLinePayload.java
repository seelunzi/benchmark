/*     */
package com.tangtang.trade.hry.exchange.kline2.model;
/*     */
/*     */

import java.math.BigDecimal;

/*     */
/*     */
/*     */
/*     */ public class LastKLinePayload
        /*     */ {
    /*     */   private Long _id;
    /*  10 */   private String symbolId = "btccny";
    /*     */
    /*     */   private Long time;
    /*     */
    /*  14 */   private String period = "1min";
    /*     */
    /*  16 */   private BigDecimal priceOpen = new BigDecimal(0);
    /*     */
    /*  18 */   private BigDecimal priceHigh = new BigDecimal(0);
    /*     */
    /*  20 */   private BigDecimal priceLow = new BigDecimal(0);
    /*     */
    /*  22 */   private BigDecimal priceLast = new BigDecimal(0);
    /*     */
    /*  24 */   private BigDecimal amount = new BigDecimal(0);
    /*     */
    /*  26 */   private BigDecimal dayTotalDealAmount = new BigDecimal(0);
    /*     */
    /*  28 */   private BigDecimal volume = new BigDecimal(0);
    /*     */
    /*  30 */   private BigDecimal count = new BigDecimal(0);
    /*     */
    /*     */   private String startTime;
    /*     */
    /*     */   private String endTime;

    /*     */
    /*     */
    public String getStartTime()
    /*     */ {
        /*  38 */
        return this.startTime;
        /*     */
    }

    /*     */
    /*  41 */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /*     */
    /*     */
    public String getEndTime() {
        /*  44 */
        return this.endTime;
        /*     */
    }

    /*     */
    /*  47 */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public BigDecimal getDayTotalDealAmount()
    /*     */ {
        /*  54 */
        return this.dayTotalDealAmount;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setDayTotalDealAmount(BigDecimal dayTotalDealAmount)
    /*     */ {
        /*  61 */
        this.dayTotalDealAmount = dayTotalDealAmount;
        /*     */
    }

    /*     */
    /*  64 */
    public Long get_id() {
        return this._id;
    }

    /*     */
    /*     */
    public void set_id(Long _id) {
        /*  67 */
        this._id = _id;
        /*     */
    }

    /*     */
    /*  70 */
    public String getSymbolId() {
        return this.symbolId;
    }

    /*     */
    /*     */
    public void setSymbolId(String symbolId) {
        /*  73 */
        this.symbolId = symbolId;
        /*     */
    }

    /*     */
    /*     */
    public String getPeriod() {
        /*  77 */
        return this.period;
        /*     */
    }

    /*     */
    /*  80 */
    public void setPeriod(String period) {
        this.period = period;
    }

    /*     */
    /*     */
    public BigDecimal getPriceOpen() {
        /*  83 */
        return this.priceOpen;
        /*     */
    }

    /*     */
    /*  86 */
    public void setPriceOpen(BigDecimal priceOpen) {
        this.priceOpen = priceOpen;
    }

    /*     */
    /*     */
    public BigDecimal getPriceHigh() {
        /*  89 */
        return this.priceHigh;
        /*     */
    }

    /*     */
    /*  92 */
    public void setPriceHigh(BigDecimal priceHigh) {
        this.priceHigh = priceHigh;
    }

    /*     */
    /*     */
    public BigDecimal getPriceLow() {
        /*  95 */
        return this.priceLow;
        /*     */
    }

    /*     */
    /*  98 */
    public void setPriceLow(BigDecimal priceLow) {
        this.priceLow = priceLow;
    }

    /*     */
    /*     */
    public BigDecimal getPriceLast() {
        /* 101 */
        return this.priceLast;
        /*     */
    }

    /*     */
    /* 104 */
    public void setPriceLast(BigDecimal priceLast) {
        this.priceLast = priceLast;
    }

    /*     */
    /*     */
    public BigDecimal getAmount() {
        /* 107 */
        return this.amount;
        /*     */
    }

    /*     */
    /* 110 */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /*     */
    /*     */
    public BigDecimal getVolume() {
        /* 113 */
        return this.volume;
        /*     */
    }

    /*     */
    /* 116 */
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    /*     */
    /*     */
    public BigDecimal getCount() {
        /* 119 */
        return this.count;
        /*     */
    }

    /*     */
    /* 122 */
    public void setCount(BigDecimal count) {
        this.count = count;
    }

    /*     */
    /*     */
    public Long getTime() {
        /* 125 */
        return this.time;
        /*     */
    }

    /*     */
    /* 128 */
    public void setTime(Long time) {
        this.time = time;
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\exchange\kline2\model\LastKLinePayload.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */