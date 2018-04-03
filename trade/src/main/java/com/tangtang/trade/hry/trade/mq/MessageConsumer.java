
package com.tangtang.trade.hry.trade.mq;


import hry.trade.mq.service.MessageProducer;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import javax.annotation.Resource;


public class MessageConsumer
        implements MessageListener {
    /* 12 */   private Logger logger = Logger.getLogger(MessageConsumer.class);


    @Resource
    private MessageProducer messageProducer;


    public void onMessage(Message message) {
        /* 19 */
        this.logger.info("consumer receive message------->" + new String(message.getBody()));
        /* 20 */
        int i = 10 / 0;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\mq\MessageConsumer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */