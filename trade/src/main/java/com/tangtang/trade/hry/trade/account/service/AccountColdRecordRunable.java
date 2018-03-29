/*    */
package com.tangtang.trade.hry.trade.account.service;
/*    */
/*    */

import hry.account.fund.model.AppColdAccountRecord;
import hry.core.util.sys.ContextUtil;
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
/*    */ public class AccountColdRecordRunable
        /*    */ implements Runnable
        /*    */ {
    /* 23 */   private static final Logger log = Logger.getLogger(AccountColdRecordRunable.class);
    /*    */
    /*    */   public AppColdAccountRecord coldAccountRecord;

    /*    */
    /*    */
    /*    */
    public AccountColdRecordRunable(AppColdAccountRecord coldAccountRecord)
    /*    */ {
        /* 30 */
        this.coldAccountRecord = coldAccountRecord;
        /*    */
    }

    /*    */
    /*    */
    public void run()
    /*    */ {
        /* 35 */
        long end = System.currentTimeMillis();
        /* 36 */
        AppColdAccountRecordService appColdAccountRecordService = (AppColdAccountRecordService) ContextUtil.getBean("appColdAccountRecordService");
        /* 37 */
        this.coldAccountRecord.setRemark(this.coldAccountRecord.getRemark() + "(thread)");
        /* 38 */
        appColdAccountRecordService.save(this.coldAccountRecord);
        /* 39 */
        long start = System.currentTimeMillis();
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\AccountColdRecordRunable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */