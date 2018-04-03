
package com.tangtang.trade.hry.trade.account.service;


import hry.core.util.sys.ContextUtil;
import hry.exchange.account.model.ExDmHotAccountRecord;
import org.apache.log4j.Logger;


public class DmHotRecordRunable
        implements Runnable {
    /* 22 */   private static final Logger log = Logger.getLogger(AccountHotRecordRunable.class);

    private ExDmHotAccountRecord exDmHotAccountRecord;


    public DmHotRecordRunable(ExDmHotAccountRecord exDmHotAccountRecord) {
        /* 29 */
        this.exDmHotAccountRecord = exDmHotAccountRecord;

    }


    public void run() {
        /* 35 */
        long start = System.currentTimeMillis();
        /* 36 */
        ExDmHotAccountRecordService exDmHotAccountRecordService = (ExDmHotAccountRecordService) ContextUtil.getBean("exDmHotAccountRecordService");
        /* 37 */
        this.exDmHotAccountRecord.setRemark(this.exDmHotAccountRecord.getRemark() + "(thread)");
        /* 38 */
        exDmHotAccountRecordService.save(this.exDmHotAccountRecord);
        /* 39 */
        long end = System.currentTimeMillis();

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\DmHotRecordRunable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */