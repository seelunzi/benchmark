/*    */
package com.tangtang.trade.hry.trade.entrust.service.impl;
/*    */
/*    */

import com.alibaba.fastjson.JSON;
import hry.core.thread.ThreadPool;
import hry.core.util.sys.ContextUtil;
import hry.redis.common.utils.RedisTradeService;
import hry.trade.entrust.service.ExEntrustService;
import hry.trade.entrust.service.ExOrderService;
import hry.trade.entrust.service.WebSocketScheduleService;
import hry.trade.model.ExEntrutKlineRunable;
import hry.trade.model.TradeRedis;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Service("webSocketScheduleService")
/*    */ public class WebSocketScheduleServiceImpl
        /*    */ implements WebSocketScheduleService
        /*    */ {
    /*    */
    @Resource
    /*    */ private ExOrderService exOrderService;
    /*    */
    @Resource
    /*    */ private ExEntrustService entrustService;

    /*    */
    /*    */
    public void pushMarket()
    /*    */ {
        /* 57 */
        Integer i = Integer.valueOf(0);
        /* 58 */
        Integer a = Integer.valueOf(0);
        /* 59 */
        String productListStr = TradeRedis.getStringData("cn:productFixList");
        /* 60 */
        if (!StringUtils.isEmpty(productListStr)) {
            /* 61 */
            List<String> productList = JSON.parseArray(productListStr, String.class);
            /* 62 */
            for (String coinCodetwo : productList)
                /*    */ {
                /*    */
                /* 65 */
                RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
                /* 66 */
                Integer localInteger1 = i;
                Integer localInteger2 = i = Integer.valueOf(i.intValue() + 1);
                /* 67 */
                String[] coinCodeArr = coinCodetwo.split("_");
                /* 68 */
                String coinCode = coinCodeArr[0];
                /* 69 */
                String fixPriceCoinCode = coinCodeArr[1];
                /* 70 */
                String flagstrkey = TradeRedis.getEntrustTimeFlag(coinCode, fixPriceCoinCode);
                /* 71 */
                String flag = redisTradeService.get(flagstrkey);
                /*    */
                /* 73 */
                if ((null != flag) && (flag.equals("1"))) {
                    /* 74 */
                    Integer localInteger3 = a;
                    Integer localInteger4 = a = Integer.valueOf(a.intValue() + 1);
                    /* 75 */
                    String header = TradeRedis.getHeader(coinCode, fixPriceCoinCode, null);
                    /* 76 */
                    ExEntrutKlineRunable exEntrutKlineRunable = new ExEntrutKlineRunable(coinCode, fixPriceCoinCode, header);
                    /* 77 */
                    ThreadPool.exe(exEntrutKlineRunable);
                    /*    */
                    /* 79 */
                    redisTradeService.save(TradeRedis.getEntrustTimeFlag(coinCode, fixPriceCoinCode), "0");
                    /*    */
                }
                /*    */
            }
            /*    */
        }
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
        /* 93 */
        long end = System.currentTimeMillis();
        /*    */
    }

    /*    */
    /*    */
    public void pushEntrusDephMarket() {
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\impl\WebSocketScheduleServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */