
package com.tangtang.trade.hry.trade.comparator;


import hry.trade.redis.model.Accountadd;

import java.util.Comparator;

public class AccountaddComparator
        implements Comparator<Accountadd> {

    public int compare(Accountadd o1, Accountadd o2) {
        /* 13 */
        if (o1.getAccountId().compareTo(o2.getAccountId()) == 1)
            /* 14 */ return -1;
        /* 15 */
        if (o1.getAccountId().compareTo(o2.getAccountId()) == -1) {
            /* 16 */
            return 1;

        }
        /* 18 */
        return 0;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\comparator\AccountaddComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */