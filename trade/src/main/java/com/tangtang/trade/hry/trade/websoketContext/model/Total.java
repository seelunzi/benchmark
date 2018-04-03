
package com.tangtang.trade.hry.trade.websoketContext.model;


import java.math.BigDecimal;
import java.util.List;


public class Total {
    public String currentExchangPrice;
    public String lastExchangPrice;
    public String RiseAndFall;
    public String transactionCount;
    public String transactionSum;
    public String maxPrice;
    public String minPrice;
    public List<BigDecimal[]> priceTrend;


    public String getCurrentExchangPrice() {
        /*  32 */
        return this.currentExchangPrice;

    }


    public void setCurrentExchangPrice(String currentExchangPrice) {
        /*  39 */
        this.currentExchangPrice = currentExchangPrice;

    }


    public String getTransactionSum() {
        /*  48 */
        return this.transactionSum;

    }


    public void setTransactionSum(String transactionSum) {
        /*  55 */
        this.transactionSum = transactionSum;

    }


    public String getLastExchangPrice() {
        /*  62 */
        return this.lastExchangPrice;

    }


    public void setLastExchangPrice(String lastExchangPrice) {
        /*  69 */
        this.lastExchangPrice = lastExchangPrice;

    }


    public String getRiseAndFall() {
        /*  76 */
        return this.RiseAndFall;

    }


    public void setRiseAndFall(String riseAndFall) {
        /*  83 */
        this.RiseAndFall = riseAndFall;

    }


    public String getTransactionCount() {
        /*  90 */
        return this.transactionCount;

    }


    public void setTransactionCount(String transactionCount) {
        /*  97 */
        this.transactionCount = transactionCount;

    }


    public String getMaxPrice() {
        /* 104 */
        return this.maxPrice;

    }


    public void setMaxPrice(String maxPrice) {
        /* 111 */
        this.maxPrice = maxPrice;

    }


    public String getMinPrice() {
        /* 118 */
        return this.minPrice;

    }


    public void setMinPrice(String minPrice) {
        /* 125 */
        this.minPrice = minPrice;

    }


    public List<BigDecimal[]> getPriceTrend() {
        /* 132 */
        return this.priceTrend;

    }


    public void setPriceTrend(List<BigDecimal[]> priceTrend) {
        /* 139 */
        this.priceTrend = priceTrend;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\websoketContext\model\Total.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */