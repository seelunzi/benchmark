/*    */
package com.tangtang.trade.hry.trade.model;
/*    */
/*    */

import hry.trade.entrust.model.ExOrderInfo;

import java.util.List;

/*    */
/*    */
/*    */ public class SetBuyOneRunable implements Runnable
        /*    */ {
    /*    */   private List<ExOrderInfo> exorderlist;

    /*    */
    /*    */
    public SetBuyOneRunable(List<ExOrderInfo> exorderlist)
    /*    */ {
        /* 12 */
        this.exorderlist = exorderlist;
        /*    */
    }

    /*    */
    /*    */
    public void run() {
        /* 16 */
        RedisLastKLine.savePeriodLastKLineList(this.exorderlist);
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\model\SetBuyOneRunable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */