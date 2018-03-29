/*    */
package com.tangtang.trade.hry.trade.mq;
/*    */
/*    */

import hry.core.util.sys.ContextUtil;
import hry.trade.entrust.service.ExOrderInfoService;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class MessageReidsToMysql
        /*    */ implements MessageListener
        /*    */ {
    /* 12 */   private Logger logger = Logger.getLogger(MessageReidsToMysql.class);

    /*    */
    /*    */
    public void onMessage(Message message)
    /*    */ {
        /* 16 */
        ExOrderInfoService exOrderInfoService = (ExOrderInfoService) ContextUtil.getBean("exOrderInfoService");
        /* 17 */
        exOrderInfoService.reidsToMysql();
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\mq\MessageReidsToMysql.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */