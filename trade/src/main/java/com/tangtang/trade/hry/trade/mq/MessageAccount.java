
package com.tangtang.trade.hry.trade.mq;


import com.rabbitmq.client.Channel;
import hry.core.mvc.model.log.AppException;
import hry.core.mvc.service.log.AppExceptionService;
import hry.core.util.sys.ContextUtil;
import hry.trade.entrust.service.TradeService;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import java.io.IOException;


public class MessageAccount
        implements ChannelAwareMessageListener {
    /* 18 */   private Logger logger = Logger.getLogger(MessageAccount.class);


    public void onMessage(Message message, Channel channel) {
        /* 22 */
        TradeService tradeService = (TradeService) ContextUtil.getBean("tradeService");

        try {
            /* 24 */
            Boolean flag = tradeService.accountaddQueue(new String(message.getBody()));
            /* 25 */
            if (!flag.booleanValue()) {
                /* 26 */
                AppException exceptionLog = new AppException();
                /* 27 */
                exceptionLog.setName("mq==消息报错体==");
                /* 28 */
                AppExceptionService appExceptionService = (AppExceptionService) ContextUtil.getBean("appExceptionService");
                /* 29 */
                appExceptionService.save(exceptionLog);
                /* 30 */
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

            }

        } catch (Exception e) {

            try {
                /* 37 */
                AppException exceptionLog = new AppException();
                /* 38 */
                exceptionLog.setName("mq==消息报错体2==");
                /* 39 */
                AppExceptionService appExceptionService = (AppExceptionService) ContextUtil.getBean("appExceptionService");
                /* 40 */
                appExceptionService.save(exceptionLog);
                /* 41 */
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

            } catch (IOException a) {
                /* 44 */
                a.printStackTrace();

            }

        }


        try {
            /* 50 */
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        } catch (IOException e1) {
            /* 52 */
            this.logger.info("mq==channel.basicAck==确认失败");
            /* 53 */
            e1.printStackTrace();

        }

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\mq\MessageAccount.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */