/*     */
package com.tangtang.trade.hry.trade.model;
/*     */
/*     */

import com.alibaba.fastjson.JSON;
import hry.core.thread.ThreadPool;
import hry.core.util.properties.PropertiesUtils;
import hry.core.util.sys.ContextUtil;
import hry.redis.common.dao.RedisUtil;
import hry.redis.common.utils.RedisService;
import hry.redis.common.utils.RedisTradeService;
import hry.trade.MQmanager.MQEnter;
import hry.trade.comparator.AscBigDecimalComparator;
import hry.trade.comparator.DescBigDecimalComparator;
import hry.trade.entrust.model.ExOrderInfo;
import hry.trade.redis.model.*;
import tk.mybatis.mapper.util.StringUtil;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ public class TradeRedis
        /*     */ {
    /*  37 */   public static RedisUtil redisUtilAppAccount = new RedisUtil(AppAccountRedis.class);
    /*  38 */   public static RedisUtil redisUtilExDigitalmoneyAccount = new RedisUtil(ExDigitalmoneyAccountRedis.class);
    /*  39 */   public static RedisUtil redisUtilExEntrust = new RedisUtil(EntrustTrade.class);
    /*  40 */   public static RedisUtil redisUtilEntrustByUser = new RedisUtil(EntrustByUser.class);
    /*  41 */   public static List<Accountadd> aaddlists = new ArrayList();
    /*  42 */   public static List<ExOrderInfo> eoinfolists = new ArrayList();
    /*  43 */   public static String noSaveEntrustByUser = null;
    /*  44 */   public static Integer isNoSaveEntrustByUser = null;

    /*     */
    /*     */
    /*     */
    public static String getHeader(EntrustTrade exEntrust)
    /*     */ {
        /*  49 */
        if (exEntrust.getType().equals(Integer.valueOf(2))) {
            /*  50 */
            String header = exEntrust.getCoinCode() + "_" + exEntrust.getFixPriceCoinCode() + ":sell";
            /*  51 */
            return header;
            /*     */
        }
        /*  53 */
        String header = exEntrust.getCoinCode() + "_" + exEntrust.getFixPriceCoinCode() + ":buy";
        /*  54 */
        return header;
        /*     */
    }

    /*     */
    /*     */
    public static String getHeader(String coinCode, String fixPriceCoinCode, Integer type)
    /*     */ {
        /*  59 */
        if (null == type) {
            /*  60 */
            String header = coinCode + "_" + fixPriceCoinCode;
            /*  61 */
            return header;
        }
        /*  62 */
        if (type.equals(Integer.valueOf(2))) {
            /*  63 */
            String header = coinCode + "_" + fixPriceCoinCode + ":sell";
            /*  64 */
            return header;
            /*     */
        }
        /*  66 */
        String header = coinCode + "_" + fixPriceCoinCode + ":buy";
        /*  67 */
        return header;
        /*     */
    }

    /*     */
    /*     */
    public static String getHeaderMatch(String coinCode, String fixPriceCoinCode, Integer type)
    /*     */ {
        /*  72 */
        if (null == type) {
            /*  73 */
            String header = coinCode + "_" + fixPriceCoinCode;
            /*  74 */
            return header;
        }
        /*  75 */
        if (type.equals(Integer.valueOf(1))) {
            /*  76 */
            String header = coinCode + "_" + fixPriceCoinCode + ":sell";
            /*  77 */
            return header;
            /*     */
        }
        /*  79 */
        String header = coinCode + "_" + fixPriceCoinCode + ":buy";
        /*  80 */
        return header;
        /*     */
    }

    /*     */
    /*     */
    public static String getEntrustTimeFlag(String coinCode, String fixPriceCoinCode) {
        /*  84 */
        String header = coinCode + "_" + fixPriceCoinCode + ":isTimgEntrsutFlag";
        /*  85 */
        return header;
        /*     */
    }

    /*     */
    /*     */
    public static String getHeaderMatch(EntrustTrade exEntrust) {
        /*  89 */
        if (exEntrust.getType().equals(Integer.valueOf(1))) {
            /*  90 */
            String header = exEntrust.getCoinCode() + "_" + exEntrust.getFixPriceCoinCode() + ":sell";
            /*  91 */
            return header;
            /*     */
        }
        /*  93 */
        String header = exEntrust.getCoinCode() + "_" + exEntrust.getFixPriceCoinCode() + ":buy";
        /*  94 */
        return header;
        /*     */
    }

    /*     */
    /*     */
    public static String getHeaderFront(EntrustTrade exEntrust)
    /*     */ {
        /*  99 */
        String header = exEntrust.getCoinCode() + "_" + exEntrust.getFixPriceCoinCode();
        /* 100 */
        return header;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public static void setSelfonePrice(EntrustTrade entrust)
    /*     */ {
        /* 116 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 117 */
        String key = getHeaderFront(entrust);
        /* 118 */
        if (entrust.getType().equals(Integer.valueOf(1))) {
            /* 119 */
            String buyonePricekey = key + ":" + "buyonePrice";
            /* 120 */
            String buyonePrices = redisService.get(buyonePricekey);
            /* 121 */
            if (StringUtil.isEmpty(buyonePrices)) {
                /* 122 */
                redisService.save(buyonePricekey, JSON.toJSONString(entrust.getEntrustPrice()));
                /*     */
            }
            /* 124 */
            else if (new BigDecimal(buyonePrices).compareTo(entrust.getEntrustPrice()) == -1) {
                /* 125 */
                redisService.save(buyonePricekey, JSON.toJSONString(entrust.getEntrustPrice()));
                /*     */
            }
            /*     */
        }
        /*     */
        else
            /*     */ {
            /* 130 */
            String sellonePricekey = key + ":" + "sellonePrice";
            /* 131 */
            String sellonePrices = redisService.get(sellonePricekey);
            /* 132 */
            if (StringUtil.isEmpty(sellonePrices)) {
                /* 133 */
                redisService.save(sellonePricekey, JSON.toJSONString(entrust.getEntrustPrice()));
                /*     */
            }
            /* 135 */
            else if (new BigDecimal(sellonePrices).compareTo(entrust.getEntrustPrice()) == 1) {
                /* 136 */
                redisService.save(sellonePricekey, JSON.toJSONString(entrust.getEntrustPrice()));
                /*     */
            }
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    public static String getTradeDealEntrustChangeNum() {
        /* 142 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 143 */
        String v = redisService.get("deal:tradeDealEntrustChangeNum");
        /* 144 */
        if ((!StringUtil.isEmpty(v)) && (!"null".equals(v))) {
            /* 145 */
            String num = String.valueOf(Integer.valueOf(v).intValue() + 1);
            /* 146 */
            redisService.save("deal:tradeDealEntrustChangeNum", num);
            /* 147 */
            return "deal:tradeDealEntrustChange:" + num;
            /*     */
        }
        /* 149 */
        redisService.save("deal:tradeDealEntrustChangeNum", "0");
        /* 150 */
        return "deal:tradeDealEntrustChange:0";
        /*     */
    }

    /*     */
    /*     */
    public static String getTradeDealAccountChangeNum() {
        /* 154 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 155 */
        String v = redisService.get("deal:tradeDealAccountChangeNum");
        /* 156 */
        if ((!StringUtil.isEmpty(v)) && (!"null".equals(v))) {
            /* 157 */
            String num = String.valueOf(Integer.valueOf(v).intValue() + 1);
            /* 158 */
            redisService.save("deal:tradeDealAccountChangeNum", num);
            /* 159 */
            return "deal:TradeDealAccountChange:" + num;
            /*     */
        }
        /* 161 */
        redisService.save("deal:tradeDealAccountChangeNum", "0");
        /* 162 */
        return "deal:TradeDealAccountChange:0";
        /*     */
    }

    /*     */
    /*     */
    public static String getTradeDealOrderInfoChangeNum() {
        /* 166 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 167 */
        String v = redisService.get("deal:tradeDealOrderInfoChangeNum");
        /* 168 */
        if ((!StringUtil.isEmpty(v)) && (!"null".equals(v))) {
            /* 169 */
            String num = String.valueOf(Integer.valueOf(v).intValue() + 1);
            /* 170 */
            redisService.save("deal:tradeDealOrderInfoChangeNum", num);
            /* 171 */
            return "deal:tradeDealOrderInfoChange:" + num;
            /*     */
        }
        /* 173 */
        redisService.save("deal:tradeDealOrderInfoChangeNum", "0");
        /* 174 */
        return "deal:tradeDealOrderInfoChange:0";
        /*     */
    }

    /*     */
    /*     */
    public static void NoMatchEnd(EntrustTrade entrust, List<Accountadd> aadds)
    /*     */ {
        /* 179 */
        setSelfonePrice(entrust);
        /* 180 */
        putSelfEntrustTradelist(entrust);
        /*     */
        /* 182 */
        MQEnter.pushDealFundMQ(aadds);
        /* 183 */
        putEntrustByUser(entrust);
        /*     */
        /*     */
        /* 186 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 187 */
        List<EntrustTrade> listchange = new ArrayList();
        /* 188 */
        listchange.add(entrust);
        /* 189 */
        redisService.save(getTradeDealEntrustChangeNum(), JSON.toJSONString(listchange));
        /*     */
        /*     */
        /* 192 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /* 193 */
        redisTradeService.save(getEntrustTimeFlag(entrust.getCoinCode(), entrust.getFixPriceCoinCode()), "1");
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static void matchOneEnd(List<Accountadd> exEntrustAccountadd, EntrustTrade exEntrust, Map<String, List<EntrustTrade>> maping, List<EntrustTrade> listed, BigDecimal matchonePrice)
    /*     */ {
        /* 199 */
        aaddlists.addAll(0, exEntrustAccountadd);
        /* 200 */
        listed.add(exEntrust);
        /* 201 */
        if (!exEntrust.getStatus().equals(Integer.valueOf(2))) {
            /* 202 */
            putSelfEntrustTradelist(exEntrust);
            /* 203 */
            setSelfonePrice(exEntrust);
            /*     */
        }
        /*     */
        /* 206 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /* 207 */
        for (Entry<String, List<EntrustTrade>> entry : maping.entrySet()) {
            /* 208 */
            List<EntrustTrade> listing = (List) entry.getValue();
            /* 209 */
            if ((null == listing) || (listing.size() == 0)) {
                /* 210 */
                redisTradeService.delete((String) entry.getKey());
                /*     */
            } else {
                /* 212 */
                redisTradeService.save((String) entry.getKey(), JSON.toJSONString(listing));
                /*     */
            }
            /*     */
        }
        /*     */
        /*     */
        /* 217 */
        MQEnter.pushDealFundMQ(aaddlists);
        /*     */
        /*     */
        /* 220 */
        for (EntrustTrade entrust : listed) {
            /* 221 */
            putEntrustByUser(entrust);
            /*     */
        }
        /* 223 */
        setMatchOnePrice(matchonePrice, exEntrust);
        /* 224 */
        String keyFront = getHeaderFront(exEntrust);
        /* 225 */
        setExchangeDataCache(eoinfolists, keyFront);
        /*     */
        /* 227 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 228 */
        redisService.save(getTradeDealEntrustChangeNum(), JSON.toJSONString(listed));
        /* 229 */
        redisService.save(getTradeDealOrderInfoChangeNum(), JSON.toJSONString(eoinfolists));
        /*     */
        /*     */
        /*     */
        /* 233 */
        List<ExOrderInfo> arr = new ArrayList();
        /* 234 */
        arr.addAll(eoinfolists);
        /* 235 */
        PeriodLastKLineListRunable periodLastKLineListRunable = new PeriodLastKLineListRunable(arr);
        /* 236 */
        ThreadPool.exe(periodLastKLineListRunable);
        /* 237 */
        aaddlists.clear();
        /* 238 */
        eoinfolists.clear();
        /*     */
        /* 240 */
        redisTradeService.save(getEntrustTimeFlag(exEntrust.getCoinCode(), exEntrust.getFixPriceCoinCode()), "1");
        /*     */
    }

    /*     */
    /*     */
    public static void cancelEntrust(EntrustTrade exEntrust, List<EntrustTrade> entrustlist, String key, List<Accountadd> aadds)
    /*     */ {
        /* 245 */
        putIngExEntrust(entrustlist, key);
        /*     */
        /* 247 */
        MQEnter.pushDealFundMQ(aadds);
        /*     */
        /* 249 */
        putEntrustByUser(exEntrust);
        /* 250 */
        setcancelSelfOnePrice(exEntrust);
        /*     */
        /*     */
        /* 253 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 254 */
        List<EntrustTrade> listchange = new ArrayList();
        /* 255 */
        listchange.add(exEntrust);
        /* 256 */
        redisService.save(getTradeDealEntrustChangeNum(), JSON.toJSONString(listchange));
        /*     */
        /* 258 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /* 259 */
        redisTradeService.save(getEntrustTimeFlag(exEntrust.getCoinCode(), exEntrust.getFixPriceCoinCode()), "1");
        /*     */
    }

    /*     */
    /*     */
    public static void setcancelSelfOnePrice(EntrustTrade exEntrust)
    /*     */ {
        /* 264 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 265 */
        List<BigDecimal> keyslist = getSelfkeys(exEntrust);
        /* 266 */
        String keyFront = getHeaderFront(exEntrust);
        /* 267 */
        if ((null != keyslist) && (keyslist.size() > 0)) {
            /* 268 */
            BigDecimal onePrice = (BigDecimal) keyslist.get(0);
            /* 269 */
            if (null != onePrice) {
                /* 270 */
                if (exEntrust.getType().equals(Integer.valueOf(1))) {
                    /* 271 */
                    String buyonePricekey = keyFront + ":" + "buyonePrice";
                    /* 272 */
                    redisService.save(buyonePricekey, JSON.toJSONString(onePrice));
                    /*     */
                } else {
                    /* 274 */
                    String sellonePricekey = keyFront + ":" + "sellonePrice";
                    /* 275 */
                    redisService.save(sellonePricekey, JSON.toJSONString(onePrice));
                    /*     */
                }
                /*     */
                /*     */
            }
            /*     */
        }
        /* 280 */
        else if (exEntrust.getType().equals(Integer.valueOf(1))) {
            /* 281 */
            String buyonePricekey = keyFront + ":" + "buyonePrice";
            /* 282 */
            redisService.delete(buyonePricekey);
            /*     */
        } else {
            /* 284 */
            String sellonePricekey = keyFront + ":" + "sellonePrice";
            /* 285 */
            redisService.delete(sellonePricekey);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static void setMatchOnePrice(BigDecimal matchonePrice, EntrustTrade exEntrust)
    /*     */ {
        /* 292 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 293 */
        String keyFront = getHeaderFront(exEntrust);
        /* 294 */
        if (null != matchonePrice) {
            /* 295 */
            if (exEntrust.getType().equals(Integer.valueOf(2))) {
                /* 296 */
                String buyonePricekey = keyFront + ":" + "buyonePrice";
                /* 297 */
                redisService.save(buyonePricekey, JSON.toJSONString(matchonePrice));
                /*     */
            } else {
                /* 299 */
                String sellonePricekey = keyFront + ":" + "sellonePrice";
                /* 300 */
                redisService.save(sellonePricekey, JSON.toJSONString(matchonePrice));
                /*     */
            }
            /*     */
            /*     */
        }
        /* 304 */
        else if (exEntrust.getType().equals(Integer.valueOf(2))) {
            /* 305 */
            String buyonePricekey = keyFront + ":" + "buyonePrice";
            /* 306 */
            redisService.delete(buyonePricekey);
            /*     */
        } else {
            /* 308 */
            String sellonePricekey = keyFront + ":" + "sellonePrice";
            /* 309 */
            redisService.save(sellonePricekey, JSON.toJSONString(matchonePrice));
            /* 310 */
            redisService.delete(sellonePricekey);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static void setExchangeDataCache(List<ExOrderInfo> listExOrderInfo, String header)
    /*     */ {
        /* 317 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 318 */
        ExOrderInfo exOrderInfo = (ExOrderInfo) listExOrderInfo.get(listExOrderInfo.size() - 1);
        /*     */
        /* 320 */
        setStringData(header + ":" + "currentExchangPrice", exOrderInfo.getTransactionPrice().setScale(10, 4).toString());
        /*     */
        /* 322 */
        String v = redisService.get(header + ":" + "LastOrderRecords");
        /* 323 */
        List<ExOrderInfo> list = null;
        /* 324 */
        if (!StringUtil.isEmpty(v)) {
            /* 325 */
            list = JSON.parseArray(v, ExOrderInfo.class);
            /*     */
        } else {
            /* 327 */
            list = new ArrayList();
            /*     */
        }
        /* 329 */
        list.addAll(listExOrderInfo);
        /* 330 */
        if (list.size() > ExchangeDataCacheRedis.LastOrderRecordsLmit.intValue()) {
            /* 331 */
            List<ExOrderInfo> sublist = list.subList(list.size() - ExchangeDataCacheRedis.LastOrderRecordsLmit.intValue(), list.size());
            /* 332 */
            redisService.save(header + ":" + "LastOrderRecords", JSON.toJSONString(sublist));
            /*     */
        } else {
            /* 334 */
            redisService.save(header + ":" + "LastOrderRecords", JSON.toJSONString(list));
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static void putEntrustByUser(EntrustTrade entrust)
    /*     */ {
        /* 341 */
        Boolean flag = isSaveEntrustByUser(entrust.getUserName());
        /* 342 */
        if (!flag.booleanValue()) {
            /* 343 */
            EntrustByUser ebu = (EntrustByUser) redisUtilEntrustByUser.get(entrust.getCustomerId().toString());
            /* 344 */
            if (null == ebu) {
                /* 345 */
                ebu = new EntrustByUser();
                /* 346 */
                ebu.addEntrust(entrust);
                /* 347 */
                ebu.setCustomerId(entrust.getCustomerId());
                /*     */
            } else {
                /* 349 */
                ebu.addEntrust(entrust);
                /*     */
            }
            /* 351 */
            if ((ebu.getEntrustedmap().size() == 0) && (ebu.getEntrustingmap().size() == 0)) {
                /* 352 */
                redisUtilEntrustByUser.delete(ebu.getCustomerId().toString());
                /*     */
            } else {
                /* 354 */
                redisUtilEntrustByUser.put(ebu, ebu.getCustomerId().toString());
                /*     */
            }
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static Boolean isSaveEntrustByUser(String userName)
    /*     */ {
        /* 362 */
        if (null != isNoSaveEntrustByUser) {
            /* 363 */
            if (null != noSaveEntrustByUser) {
                /* 364 */
                int i = 0;
                /* 365 */
                String[] rt = noSaveEntrustByUser.split(",");
                /* 366 */
                while (i < rt.length) {
                    /* 367 */
                    if (rt[i].equals(userName)) {
                        /* 368 */
                        return Boolean.valueOf(true);
                        /*     */
                    }
                    /* 370 */
                    i++;
                    /*     */
                }
                /*     */
            }
            /*     */
            /* 374 */
            return Boolean.valueOf(false);
            /*     */
        }
        /* 376 */
        isNoSaveEntrustByUser = new Integer("1");
        /* 377 */
        String appisNoSaveEntrustByUser = PropertiesUtils.APP.getProperty("app.noSaveEntrustByUser");
        /* 378 */
        if (!StringUtil.isEmpty(appisNoSaveEntrustByUser)) {
            /* 379 */
            noSaveEntrustByUser = appisNoSaveEntrustByUser;
            /* 380 */
            int i = 0;
            /* 381 */
            String[] rt = appisNoSaveEntrustByUser.split(",");
            /* 382 */
            while (i < rt.length) {
                /* 383 */
                if (rt[i].equals(userName))
                    /*     */ {
                    /* 385 */
                    return Boolean.valueOf(true);
                    /*     */
                }
                /* 387 */
                i++;
                /*     */
            }
            /*     */
        }
        /*     */
        /* 391 */
        return Boolean.valueOf(false);
        /*     */
    }

    /*     */
    /*     */
    public static void putchange(EntrustTrade entrust)
    /*     */ {
        /* 396 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 397 */
        String v = redisService.get("changeEntrust");
        /* 398 */
        List<EntrustTrade> list = JSON.parseArray(v, EntrustTrade.class);
        /* 399 */
        if (null == list) {
            /* 400 */
            list = new ArrayList();
            /*     */
        }
        /*     */
        /* 403 */
        list.add(entrust);
        /*     */
        /*     */
        /* 406 */
        redisService.save("changeEntrust", JSON.toJSONString(list));
        /*     */
    }

    /*     */
    /*     */
    public static void matchOneAndOneEnd(ExOrderInfo exOrderInfo, List<Accountadd> aadds) {
        /* 410 */
        eoinfolists.add(exOrderInfo);
        /* 411 */
        for (Accountadd aadd : aadds) {
            /* 412 */
            aaddlists.add(aadd);
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public static void putExOrderInfolist(List<ExOrderInfo> oinfolist)
    /*     */ {
        /* 433 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 434 */
        String v = redisService.get("exorderinfos");
        /* 435 */
        List<ExOrderInfo> list = JSON.parseArray(v, ExOrderInfo.class);
        /* 436 */
        if (null == list) {
            /* 437 */
            list = new ArrayList();
            /*     */
        }
        /* 439 */
        for (ExOrderInfo info : oinfolist) {
            /* 440 */
            list.add(info);
            /*     */
        }
        /* 442 */
        redisService.save("exorderinfos", JSON.toJSONString(list));
        /*     */
    }

    /*     */
    /*     */
    public static void putSelfEntrustTradelist(EntrustTrade exEntrust) {
        /* 446 */
        String key = getHeader(exEntrust) + ":" + exEntrust.getEntrustPrice().setScale(10, 6).toString();
        /* 447 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /* 448 */
        String v = redisTradeService.get(key);
        /* 449 */
        List<EntrustTrade> list = JSON.parseArray(v, EntrustTrade.class);
        /* 450 */
        if (null == list) {
            /* 451 */
            list = new ArrayList();
            /*     */
        }
        /* 453 */
        list.add(exEntrust);
        /* 454 */
        redisTradeService.save(key, JSON.toJSONString(list));
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static BigDecimal getMatchOnePrice(EntrustTrade exEntrust)
    /*     */ {
        /* 460 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 461 */
        String key = "";
        /* 462 */
        if (exEntrust.getType().equals(Integer.valueOf(1))) {
            /* 463 */
            key = getHeaderFront(exEntrust) + ":" + "sellonePrice";
            /*     */
        } else {
            /* 465 */
            key = getHeaderFront(exEntrust) + ":" + "buyonePrice";
            /*     */
        }
        /* 467 */
        String onePrice = redisService.get(key);
        /* 468 */
        if (StringUtil.isEmpty(onePrice)) {
            /* 469 */
            return null;
            /*     */
        }
        /* 471 */
        return new BigDecimal(onePrice);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public static void putIngExEntrust(List<EntrustTrade> exEntrustlist, String key)
    /*     */ {
        /* 490 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /*     */
        /*     */
        /*     */
        /*     */
        /*     */
        /* 496 */
        if ((null == exEntrustlist) || (exEntrustlist.size() == 0)) {
            /* 497 */
            redisTradeService.delete(key);
            /*     */
        } else {
            /* 499 */
            redisTradeService.save(key, JSON.toJSONString(exEntrustlist));
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static void put(List<EntrustTrade> exEntrustlist, String type)
    /*     */ {
        /* 506 */
        if ((null == exEntrustlist) || (exEntrustlist.size() == 0)) {
            /* 507 */
            return;
            /*     */
        }
        /* 509 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 510 */
        if (type.equals("change")) {
            /* 511 */
            String v = redisService.get("changeEntrust");
            /* 512 */
            List<EntrustTrade> list = JSON.parseArray(v, EntrustTrade.class);
            /* 513 */
            if (null == list) {
                /* 514 */
                redisService.save("changeEntrust", JSON.toJSONString(exEntrustlist));
                /*     */
            } else {
                /* 516 */
                for (EntrustTrade entrust : exEntrustlist) {
                    /* 517 */
                    list.add(entrust);
                    /* 518 */
                    putEntrustByUser(entrust);
                    /*     */
                }
                /* 520 */
                redisService.save("changeEntrust", JSON.toJSONString(list));
                /*     */
            }
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public static void put(ExOrderInfo exOrderInfo)
    /*     */ {
        /* 528 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 529 */
        String v = redisService.get("exorderinfos");
        /* 530 */
        List<ExOrderInfo> list = JSON.parseArray(v, ExOrderInfo.class);
        /* 531 */
        list.add(exOrderInfo);
        /* 532 */
        redisService.save("exorderinfos", JSON.toJSONString(list));
        /*     */
    }

    /*     */
    /*     */
    public static void put(Accountadd accountadd) {
        /* 536 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 537 */
        String v = redisService.get("Accountadds");
        /* 538 */
        List<Accountadd> list = JSON.parseArray(v, Accountadd.class);
        /* 539 */
        list.add(accountadd);
        /* 540 */
        redisService.save("Accountadds", JSON.toJSONString(list));
        /*     */
    }

    /*     */
    /*     */
    public static String getStringData(String key) {
        /* 544 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 545 */
        String v = redisService.get(key);
        /* 546 */
        return v;
        /*     */
    }

    /*     */
    /*     */
    public static String getTradeStringData(String key) {
        /* 550 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /*     */
        /* 552 */
        String v = redisTradeService.get(key);
        /* 553 */
        return v;
        /*     */
    }

    /*     */
    /*     */
    public static void setStringData(String key, String val) {
        /* 557 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 558 */
        String preData = redisService.save(key, val);
        /*     */
    }

    /*     */
    /*     */
    public static List<BigDecimal> getSelfkeys(EntrustTrade exEntrust) {
        /* 562 */
        String key = getHeader(exEntrust);
        /* 563 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /* 564 */
        Set<String> keys = redisTradeService.noPerkeys(key + ":");
        /* 565 */
        if (null == keys) {
            /* 566 */
            return null;
            /*     */
        }
        /* 568 */
        List<BigDecimal> list2 = new ArrayList();
        /* 569 */
        Iterator<String> iterator = keys.iterator();
        /* 570 */
        while (iterator.hasNext()) {
            /* 571 */
            String keystr = (String) iterator.next();
            /* 572 */
            BigDecimal ks = new BigDecimal(keystr.split(":")[2]);
            /* 573 */
            list2.add(ks);
            /*     */
        }
        /* 575 */
        if (exEntrust.getType().equals(Integer.valueOf(2))) {
            /* 576 */
            Collections.sort(list2, new AscBigDecimalComparator());
            /*     */
        } else {
            /* 578 */
            Collections.sort(list2, new DescBigDecimalComparator());
            /*     */
        }
        /* 580 */
        return list2;
        /*     */
    }

    /*     */
    /*     */
    public static List<BigDecimal> getMatchkeys(EntrustTrade exEntrust) {
        /* 584 */
        String key = getHeaderMatch(exEntrust);
        /* 585 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /* 586 */
        Set<String> keys = redisTradeService.noPerkeys(key + ":");
        /* 587 */
        if (null == keys) {
            /* 588 */
            return null;
            /*     */
        }
        /* 590 */
        List<BigDecimal> list2 = new ArrayList();
        /* 591 */
        Iterator<String> iterator = keys.iterator();
        /* 592 */
        while (iterator.hasNext()) {
            /* 593 */
            String keystr = (String) iterator.next();
            /* 594 */
            BigDecimal ks = new BigDecimal(keystr.split(":")[2]);
            /* 595 */
            list2.add(ks);
            /*     */
        }
        /* 597 */
        if (exEntrust.getType().equals(Integer.valueOf(1))) {
            /* 598 */
            Collections.sort(list2, new AscBigDecimalComparator());
            /*     */
        } else {
            /* 600 */
            Collections.sort(list2, new DescBigDecimalComparator());
            /*     */
        }
        /* 602 */
        return list2;
        /*     */
    }

    /*     */
    /*     */
    public static List<EntrustTrade> getMatchEntrustTradeBykey(String keys)
    /*     */ {
        /* 607 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");
        /* 608 */
        String v = redisTradeService.get(keys);
        /* 609 */
        List<EntrustTrade> list = JSON.parseArray(v, EntrustTrade.class);
        /* 610 */
        return list;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\model\TradeRedis.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */