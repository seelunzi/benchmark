/*    */
package com.tangtang.trade.hry.trade.entrust.service.impl;
/*    */
/*    */

import hry.trade.redis.model.Accountadd;

import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class AccountAddToRedisRunable
        /*    */ implements Runnable
        /*    */ {
    /*    */   private List<Accountadd> aadds;

    /*    */
    /*    */
    public AccountAddToRedisRunable(List<Accountadd> aadds)
    /*    */ {
        /* 23 */
        this.aadds = aadds;
        /*    */
    }

    /*    */
    /*    */
    public void run() {
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\impl\AccountAddToRedisRunable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */