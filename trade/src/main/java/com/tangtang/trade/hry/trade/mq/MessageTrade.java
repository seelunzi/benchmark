/*    */
package com.tangtang.trade.hry.trade.mq;
/*    */
/*    */

import hry.core.util.sys.ContextUtil;
import hry.trade.entrust.service.TradeService;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class MessageTrade
        /*    */ implements MessageListener
        /*    */ {
    /* 13 */   private Logger logger = Logger.getLogger(MessageTrade.class);

    /*    */
    /*    */
    public void onMessage(Message message)
    /*    */ {
        /* 17 */
        TradeService tradeService = (TradeService) ContextUtil.getBean("tradeService");
        /*    */
        try {
            /* 19 */
            tradeService.matchExtrustToOrderQueue(new String(message.getBody(), "utf-8"));
            /*    */
        }
        /*    */ catch (UnsupportedEncodingException e) {
            /* 22 */
            e.printStackTrace();
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\mq\MessageTrade.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */