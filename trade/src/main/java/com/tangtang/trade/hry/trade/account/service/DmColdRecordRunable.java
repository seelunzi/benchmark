/*    */
package com.tangtang.trade.hry.trade.account.service;
/*    */
/*    */

import hry.core.util.sys.ContextUtil;
import hry.exchange.account.model.ExDmColdAccountRecord;
import org.apache.log4j.Logger;

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
/*    */
/*    */
/*    */
/*    */
/*    */ public class DmColdRecordRunable
        /*    */ implements Runnable
        /*    */ {
    /* 23 */   private static final Logger log = Logger.getLogger(AccountHotRecordRunable.class);
    /*    */
    /*    */   private ExDmColdAccountRecord exDmColdAccountRecord;

    /*    */
    /*    */
    /*    */
    public DmColdRecordRunable(ExDmColdAccountRecord exDmColdAccountRecord)
    /*    */ {
        /* 30 */
        this.exDmColdAccountRecord = exDmColdAccountRecord;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public void run()
    /*    */ {
        /* 36 */
        long start = System.currentTimeMillis();
        /*    */
        /* 38 */
        ExDmColdAccountRecordService exDmColdAccountRecordService = (ExDmColdAccountRecordService) ContextUtil.getBean("exDmColdAccountRecordService");
        /* 39 */
        this.exDmColdAccountRecord.setRemark(this.exDmColdAccountRecord.getRemark() + "(thread)");
        /* 40 */
        exDmColdAccountRecordService.save(this.exDmColdAccountRecord);
        /* 41 */
        long end = System.currentTimeMillis();
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\DmColdRecordRunable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */