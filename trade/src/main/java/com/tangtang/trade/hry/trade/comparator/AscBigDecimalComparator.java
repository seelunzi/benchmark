
package com.tangtang.trade.hry.trade.comparator;


import java.math.BigDecimal;


public class AscBigDecimalComparator implements java.util.Comparator<BigDecimal> {

    public int compare(BigDecimal price1, BigDecimal price2) {
        /*  9 */
        if (price1.compareTo(price2) == 1)
            /* 10 */ return 1;
        /* 11 */
        if (price1.compareTo(price2) == -1) {
            /* 12 */
            return -1;

        }
        /* 14 */
        return 0;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\comparator\AscBigDecimalComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */