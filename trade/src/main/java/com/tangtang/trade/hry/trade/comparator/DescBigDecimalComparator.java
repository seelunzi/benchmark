/*    */
package com.tangtang.trade.hry.trade.comparator;
/*    */
/*    */

import java.math.BigDecimal;

/*    */
/*    */ public class DescBigDecimalComparator implements java.util.Comparator<BigDecimal>
        /*    */ {
    /*    */
    public int compare(BigDecimal price1, BigDecimal price2) {
        /*  8 */
        if (price1.compareTo(price2) == -1)
            /*  9 */ return 1;
        /* 10 */
        if (price1.compareTo(price2) == 1) {
            /* 11 */
            return -1;
            /*    */
        }
        /* 13 */
        return 0;
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\comparator\DescBigDecimalComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */