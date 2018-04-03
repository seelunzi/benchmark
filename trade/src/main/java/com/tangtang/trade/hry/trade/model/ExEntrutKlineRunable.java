
package com.tangtang.trade.hry.trade.model;


import hry.core.util.sys.ContextUtil;
import hry.trade.entrust.service.ExEntrustService;
import hry.trade.entrust.service.ExOrderService;
import hry.trade.websoketContext.PushData;


public class ExEntrutKlineRunable
        implements Runnable {
    private String coinCode;
    private String fixPriceCoinCode;
    private String header;


    public ExEntrutKlineRunable(String coinCode, String fixPriceCoinCode, String header) {
        /* 20 */
        this.coinCode = coinCode;
        /* 21 */
        this.fixPriceCoinCode = fixPriceCoinCode;
        /* 22 */
        this.header = header;

    }


    public void run() {
        /* 26 */
        long start = System.currentTimeMillis();
        /* 27 */
        ExEntrustService entrustService = (ExEntrustService) ContextUtil.getBean("exEntrustService");
        /* 28 */
        ExOrderService exOrderService = (ExOrderService) ContextUtil.getBean("exOrderService");


        /* 31 */
        PushData.pushEntrusMarket(entrustService.getExEntrustChangeMarket(this.coinCode, this.fixPriceCoinCode, Integer.valueOf(18)), this.header);
        /* 32 */
        long end1 = System.currentTimeMillis();


        /* 35 */
        PushData.pushNewListRecordMarketDesc(exOrderService.getNewListMarket(this.header, "desc"), this.header);
        /* 36 */
        long end2 = System.currentTimeMillis();

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\model\ExEntrutKlineRunable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */