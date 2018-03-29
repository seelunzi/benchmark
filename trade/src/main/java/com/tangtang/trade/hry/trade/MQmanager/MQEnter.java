
package com.tangtang.trade.hry.trade.MQmanager;

import com.tangtang.trade.hry.trade.mq.service.MessageProducer;
import hry.core.util.serialize.Mapper;
import hry.core.util.sys.ContextUtil;
import hry.trade.redis.model.Accountadd;
import hry.trade.redis.model.EntrustTrade;

import java.util.List;

public class MQEnter {

    public static void pushExEntrustMQ(EntrustTrade exEntrust) {
        MessageProducer messageProducer = (MessageProducer) ContextUtil.getBean("messageProducer");
        String exentrust = Mapper.objectToJson(exEntrust);
        messageProducer.toTrade(exentrust);
    }

    public static void pushDealFundMQ(List<Accountadd> aadds) {
        MessageProducer messageProducer = (MessageProducer) ContextUtil.getBean("messageProducer");
        String accountadds = Mapper.objectToJson(aadds);
        messageProducer.toAccount(accountadds);
    }
}
