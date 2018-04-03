
package com.tangtang.trade.hry.trade.model;


import java.io.Serializable;


public class CoinKeepDecimal
        implements Serializable {
    private static final long serialVersionUID = 352272460201788717L;
    private Long id;
    private String name;
    private String coinCode;
    private String fixPriceCoinCode;
    private Integer fixPriceType;
    private Integer keepDecimalForCoin;
    private Integer keepDecimalForCurrency;


    public Long getId() {
        /* 25 */
        return this.id;

    }


    /* 28 */
    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        /* 31 */
        return this.name;

    }


    /* 34 */
    public void setName(String name) {
        this.name = name;
    }


    public String getCoinCode() {
        /* 37 */
        return this.coinCode;

    }


    /* 40 */
    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }


    public String getFixPriceCoinCode() {
        /* 43 */
        return this.fixPriceCoinCode;

    }


    /* 46 */
    public void setFixPriceCoinCode(String fixPriceCoinCode) {
        this.fixPriceCoinCode = fixPriceCoinCode;
    }


    public Integer getFixPriceType() {
        /* 49 */
        return this.fixPriceType;

    }


    /* 52 */
    public void setFixPriceType(Integer fixPriceType) {
        this.fixPriceType = fixPriceType;
    }


    public Integer getKeepDecimalForCoin() {
        /* 55 */
        return this.keepDecimalForCoin;

    }


    /* 58 */
    public void setKeepDecimalForCoin(Integer keepDecimalForCoin) {
        this.keepDecimalForCoin = keepDecimalForCoin;
    }


    public Integer getKeepDecimalForCurrency() {
        /* 61 */
        return this.keepDecimalForCurrency;

    }


    /* 64 */
    public void setKeepDecimalForCurrency(Integer keepDecimalForCurrency) {
        this.keepDecimalForCurrency = keepDecimalForCurrency;
    }


    public static long getSerialversionuid() {
        /* 67 */
        return 352272460201788717L;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\model\CoinKeepDecimal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */