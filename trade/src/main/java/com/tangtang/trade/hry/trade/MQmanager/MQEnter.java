/*    */
package com.tangtang.trade.hry.trade.MQmanager;
/*    */
/*    */

import hry.core.util.serialize.Mapper;
import hry.core.util.sys.ContextUtil;
import hry.trade.mq.service.MessageProducer;
import hry.trade.redis.model.Accountadd;
import hry.trade.redis.model.EntrustTrade;

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
/*    */
/*    */
/*    */ public class MQEnter
        /*    */ {
    /*    */
    public static void pushExEntrustMQ(EntrustTrade exEntrust)
    /*    */ {
        /* 38 */
        MessageProducer messageProducer = (MessageProducer) ContextUtil.getBean("messageProducer");
        /* 39 */
        String exentrust = Mapper.objectToJson(exEntrust);
        /* 40 */
        messageProducer.toTrade(exentrust);
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public static void pushDealFundMQ(List<Accountadd> aadds)
    /*    */ {
        /* 48 */
        MessageProducer messageProducer = (MessageProducer) ContextUtil.getBean("messageProducer");
        /*    */
        /*    */
        /*    */
        /* 52 */
        String accountadds = Mapper.objectToJson(aadds);
        /* 53 */
        messageProducer.toAccount(accountadds);
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\MQmanager\MQEnter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */