/*    */
package com.tangtang.trade.hry.trade.mq.service;
/*    */
/*    */

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*    */
/*    */
/*    */
/*    */
/*    */
@Service
/*    */ public class MessageProducer
        /*    */ {
    /* 11 */   private Logger logger = Logger.getLogger(MessageProducer.class);
    /*    */
    @Resource(name = "amqpTemplate")
    /*    */ private AmqpTemplate amqpTemplate;

    /*    */
    /*    */
    public void toTrade(Object message)
    /*    */ {
        /*    */
        try
            /*    */ {
            /* 19 */
            this.amqpTemplate.convertAndSend("toTradeKey", message);
            /*    */
        } catch (Exception e) {
            /* 21 */
            e.printStackTrace();
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    public void toAccount(Object message) {
        /*    */
        try {
            /* 27 */
            this.amqpTemplate.convertAndSend("toAccountKey", message);
            /*    */
        } catch (Exception e) {
            /* 29 */
            e.printStackTrace();
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    public void reidsToRedisLog(Object message) {
        /* 34 */
        try {
            this.amqpTemplate.convertAndSend("reidsToRedisLogKey", message);
            /*    */
        } catch (Exception e) {
            /* 36 */
            e.printStackTrace();
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    public void reidsToMysql(Object message) {
        /* 41 */
        try {
            this.amqpTemplate.convertAndSend("reidsToMysqlKey", message);
            /*    */
        } catch (Exception e) {
            /* 43 */
            e.printStackTrace();
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\mq\service\MessageProducer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */