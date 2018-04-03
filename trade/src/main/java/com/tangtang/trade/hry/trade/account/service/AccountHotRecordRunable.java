
package com.tangtang.trade.hry.trade.account.service;


import hry.account.fund.model.AppHotAccountRecord;
import hry.core.util.sys.ContextUtil;
import org.apache.log4j.Logger;


public class AccountHotRecordRunable
        implements Runnable {
    /* 23 */   private static final Logger log = Logger.getLogger(AccountHotRecordRunable.class);

    private AppHotAccountRecord hotAccountRecord;


    public AccountHotRecordRunable(AppHotAccountRecord hotAccountRecord) {
        /* 30 */
        this.hotAccountRecord = hotAccountRecord;

    }


    public void run() {
        /* 36 */
        long start = System.currentTimeMillis();

        /* 38 */
        AppHotAccountRecordService appHotAccountRecordService = (AppHotAccountRecordService) ContextUtil.getBean("appHotAccountRecordService");
        /* 39 */
        this.hotAccountRecord.setRemark(this.hotAccountRecord.getRemark() + "(thread)");
        /* 40 */
        appHotAccountRecordService.save(this.hotAccountRecord);
        /* 41 */
        long end = System.currentTimeMillis();

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\AccountHotRecordRunable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */