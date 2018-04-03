
package com.tangtang.trade.hry.trade.model;


import java.io.Serializable;
import java.math.BigDecimal;


public class ExEntrustSimple
        implements Serializable {
    private static final long serialVersionUID = -4825890686624512635L;
    private BigDecimal entrustPrice;
    private BigDecimal surplusEntrustCount;


    public BigDecimal getEntrustPrice() {
        /* 23 */
        return this.entrustPrice;

    }


    /* 26 */
    public void setEntrustPrice(BigDecimal entrustPrice) {
        this.entrustPrice = entrustPrice;
    }


    public BigDecimal getSurplusEntrustCount() {
        /* 33 */
        return this.surplusEntrustCount;

    }


    public void setSurplusEntrustCount(BigDecimal surplusEntrustCount) {
        /* 40 */
        this.surplusEntrustCount = surplusEntrustCount;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\model\ExEntrustSimple.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */