
package com.tangtang.trade.hry.trade.websoketContext;


import hry.core.util.sys.ContextUtil;
import hry.redis.common.utils.RedisService;


public class PushData {

    public static void pushEntrust(String pustdata, String currencyType) {
        /*  19 */
        String key = currencyType + ":pushEntrust";
        /*  20 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  21 */
        String preData = redisService.get(key);
        /*  22 */
        if ((null == preData) || (!preData.equals(pustdata))) {
            /*  23 */
            redisService.save(key, pustdata);

        }

    }


    public static void pushNewRecordList(String pustdata, String currencyType) {
        /*  28 */
        String key = currencyType + ":pushNewRecordList";
        /*  29 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  30 */
        String preData = redisService.get(key);
        /*  31 */
        if ((null == preData) || (!preData.equals(pustdata))) {
            /*  32 */
            redisService.save(key, pustdata);

        }

    }


    public static void pushIndex(String pustdata, String currencyType) {
        /*  38 */
        String key = currencyType + ":pushIndex";
        /*  39 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  40 */
        String preData = redisService.get(key);
        /*  41 */
        if ((null == preData) || (!preData.equals(pustdata))) {
            /*  42 */
            redisService.save(key, pustdata);

        }

    }


    public static void pushEntrusMarket(String pustdata, String header) {
        /*  50 */
        String key = header + ":pushEntrusMarket";
        /*  51 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  52 */
        String preData = redisService.get(key);
        /*  53 */
        if ((null == preData) || (!preData.equals(pustdata))) {
            /*  54 */
            redisService.save(key, pustdata);

        }

    }


    public static void pushtheSeatEntrustCenter(String pustdata, String currencyType) {
        /*  59 */
        String key = currencyType + ":pushtheSeatEntrustCenter";
        /*  60 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  61 */
        String preData = redisService.get(key);
        /*  62 */
        if ((null == preData) || (!preData.equals(pustdata))) {
            /*  63 */
            redisService.save(key, pustdata);

        }

    }


    public static void pushtheSeatEntrustDephCenter(String pustdata, String currencyType, String key1) {
        /*  69 */
        String key = currencyType + ":pushtheSeatEntrustCenter" + key1;
        /*  70 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  71 */
        String preData = redisService.get(key);
        /*  72 */
        if ((null == preData) || (!preData.equals(pustdata))) {
            /*  73 */
            redisService.save(key, pustdata);

        }

    }


    public static void pushEntrusDephMarket(String pustdata, String currencyType, String key1) {
        /*  79 */
        String key = currencyType + ":pushEntrusMarket" + key1;
        /*  80 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  81 */
        String preData = redisService.get(key);
        /*  82 */
        if ((null == preData) || (!preData.equals(pustdata))) {
            /*  83 */
            redisService.save(key, pustdata);

        }

    }


    public static void pushNewListRecordMarketAsc(String pustdata, String currencyType) {
        /*  88 */
        String key = currencyType + ":pushNewListRecordMarket";
        /*  89 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  90 */
        redisService.save(key, pustdata);

    }


    public static void pushNewListRecordMarketDesc(String pustdata, String header) {
        /*  94 */
        String key = header + ":pushNewListRecordMarketDesc";
        /*  95 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  96 */
        redisService.save(key, pustdata);

    }


    public static void pushNewListRecordMarketnewAdd(String pustdata, String currencyType) {
        /* 100 */
        String key = currencyType + ":pushNewListRecordMarketnewAdd";
        /* 101 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 102 */
        if (!"".equals(pustdata)) {
            /* 103 */
            redisService.save(key, pustdata);

        }

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\websoketContext\PushData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */