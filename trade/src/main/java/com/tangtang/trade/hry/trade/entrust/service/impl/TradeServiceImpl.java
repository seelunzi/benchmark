/*      */
package com.tangtang.trade.hry.trade.entrust.service.impl;
/*      */
/*      */

import com.alibaba.fastjson.JSON;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.github.pagehelper.StringUtil;
import hry.core.mvc.model.log.AppException;
import hry.core.mvc.service.log.AppExceptionService;
import hry.core.util.log.LogFactory;
import hry.core.util.sys.ContextUtil;
import hry.front.redis.model.UserRedis;
import hry.redis.common.dao.RedisUtil;
import hry.redis.common.utils.RedisService;
import hry.trade.account.service.AppAccountService;
import hry.trade.account.service.ExDigitalmoneyAccountService;
import hry.trade.comparator.AccountaddComparator;
import hry.trade.entrust.dao.ExEntrustDao;
import hry.trade.entrust.model.ExEntrust;
import hry.trade.entrust.model.ExOrderInfo;
import hry.trade.entrust.service.ExOrderInfoService;
import hry.trade.entrust.service.TradeService;
import hry.trade.model.TradeRedis;
import hry.trade.redis.model.Accountadd;
import hry.trade.redis.model.AppAccountRedis;
import hry.trade.redis.model.EntrustTrade;
import hry.trade.redis.model.ExDigitalmoneyAccountRedis;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
/*      */
@Service("tradeService")
/*      */ public class TradeServiceImpl
        /*      */ implements TradeService
        /*      */ {
    /*   80 */   private final Logger log = Logger.getLogger(TradeServiceImpl.class);
    /*      */
    /*      */
    @Resource
    /*      */ public ExDigitalmoneyAccountService exDigitalmoneyAccountService;
    /*      */
    /*      */
    @Resource
    /*      */ public AppAccountService appAccountService;
    /*      */
    @Resource
    /*      */ public ExOrderInfoService exOrderInfoService;
    /*      */
    @Resource
    /*      */ public RedisService redisService;
    /*      */
    @Resource
    /*      */ public ExEntrustDao exEntrustDao;

    /*      */
    /*      */
    public void canceltype(EntrustTrade entrustTrade1)
    /*      */ {
        /*   96 */
        if (null == entrustTrade1.getEntrustNum()) {
            /*   97 */
            long start = System.currentTimeMillis();
            /*   98 */
            Integer localInteger1;
            Integer localInteger2;
            if (null != entrustTrade1.getCoinCode()) {
                /*   99 */
                if (null != entrustTrade1.getCancelKeepN()) {
                    /*  100 */
                    Integer i = Integer.valueOf(0);
                    /*  101 */
                    Map<String, Object> map = new HashMap();
                    /*  102 */
                    map.put("customerId", entrustTrade1.getCustomerId().toString());
                    /*  103 */
                    map.put("fixPriceCoinCode", entrustTrade1.getFixPriceCoinCode());
                    /*  104 */
                    map.put("coinCode", entrustTrade1.getCoinCode());
                    /*  105 */
                    map.put("type", entrustTrade1.getType());
                    /*  106 */
                    List<ExEntrust> listex = this.exEntrustDao.getEntrustingByCustomerId(map);
                    /*  107 */
                    if ((null == listex) || (listex.size() == 0))
                        /*      */ {
                        /*  109 */
                        return;
                        /*      */
                    }
                    /*  111 */
                    for (Iterator i$ = listex.iterator(); i$.hasNext();
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*  123 */               localInteger2 = i = Integer.valueOf(i.intValue() + 1))
                        /*      */ {
                        /*  111 */
                        ExEntrust l = (ExEntrust) i$.next();
                        /*  112 */
                        if (i.intValue() + entrustTrade1.getCancelKeepN().intValue() >= listex.size()) {
                            /*      */
                            break;
                            /*      */
                        }
                        /*  115 */
                        EntrustTrade entrustTrade = new EntrustTrade();
                        /*  116 */
                        entrustTrade.setEntrustNum(l.getEntrustNum());
                        /*  117 */
                        entrustTrade.setCoinCode(l.getCoinCode());
                        /*  118 */
                        entrustTrade.setType(l.getType());
                        /*  119 */
                        entrustTrade.setFixPriceCoinCode(l.getFixPriceCoinCode());
                        /*  120 */
                        entrustTrade.setEntrustPrice(BigDecimal.valueOf(Double.parseDouble(l.getEntrustPrice().toString())).stripTrailingZeros());
                        /*  121 */
                        entrustTrade.setEntrustPrice(l.getEntrustPrice().setScale(10, 6));
                        /*  122 */
                        cancelExEntrust(entrustTrade);
                        /*  123 */
                        localInteger1 = i;
                        /*      */
                    }
                    /*      */
                    /*      */
                    /*  127 */
                    long end = System.currentTimeMillis();
                    /*  128 */
                    LogFactory.info("(" + i.toString() + ")全部单一币种mq撤销总耗时：" + (end - start) + "毫秒");
                    /*      */
                    /*      */
                }
                /*      */
                else
                    /*      */ {
                    /*  133 */
                    Integer i = Integer.valueOf(0);
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*  138 */
                    Map<String, Object> map = new HashMap();
                    /*  139 */
                    map.put("customerId", entrustTrade1.getCustomerId().toString());
                    /*  140 */
                    map.put("fixPriceCoinCode", entrustTrade1.getFixPriceCoinCode());
                    /*  141 */
                    map.put("coinCode", entrustTrade1.getCoinCode());
                    /*  142 */
                    List<ExEntrust> listex = this.exEntrustDao.getEntrustingByCustomerId(map);
                    /*  143 */
                    if ((null == listex) || (listex.size() == 0))
                        /*      */ {
                        /*  145 */
                        return;
                        /*      */
                    }
                    /*  147 */
                    for (Iterator i$ = listex.iterator(); i$.hasNext();
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*      */
                        /*  157 */               localInteger2 = i = Integer.valueOf(i.intValue() + 1))
                        /*      */ {
                        /*  147 */
                        ExEntrust l = (ExEntrust) i$.next();
                        /*      */
                        /*  149 */
                        EntrustTrade entrustTrade = new EntrustTrade();
                        /*  150 */
                        entrustTrade.setEntrustNum(l.getEntrustNum());
                        /*  151 */
                        entrustTrade.setCoinCode(l.getCoinCode());
                        /*  152 */
                        entrustTrade.setType(l.getType());
                        /*  153 */
                        entrustTrade.setFixPriceCoinCode(l.getFixPriceCoinCode());
                        /*  154 */
                        entrustTrade.setEntrustPrice(BigDecimal.valueOf(Double.parseDouble(l.getEntrustPrice().toString())).stripTrailingZeros());
                        /*  155 */
                        entrustTrade.setEntrustPrice(l.getEntrustPrice().setScale(10, 6));
                        /*  156 */
                        cancelExEntrust(entrustTrade);
                        /*  157 */
                        localInteger1 = i;
                        /*      */
                    }
                    /*      */
                    /*      */
                    /*  161 */
                    long end = System.currentTimeMillis();
                    /*  162 */
                    LogFactory.info("(" + i.toString() + ")全部单一币种mq撤销总耗时：" + (end - start) + "毫秒");
                    /*      */
                }
                /*      */
            } else {
                /*  165 */
                Integer i = Integer.valueOf(0);
                /*  166 */
                Map<String, Object> map = new HashMap();
                /*  167 */
                map.put("customerId", entrustTrade1.getCustomerId().toString());
                /*  168 */
                List<ExEntrust> listex = this.exEntrustDao.getEntrustingByCustomerId(map);
                /*  169 */
                if ((null == listex) || (listex.size() == 0)) {
                    /*  170 */
                    return;
                    /*      */
                }
                /*  172 */
                for (Iterator i$ = listex.iterator(); i$.hasNext();
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*  182 */             localInteger2 = i = Integer.valueOf(i.intValue() + 1))
                    /*      */ {
                    /*  172 */
                    ExEntrust l = (ExEntrust) i$.next();
                    /*      */
                    /*  174 */
                    EntrustTrade entrustTrade = new EntrustTrade();
                    /*  175 */
                    entrustTrade.setEntrustNum(l.getEntrustNum());
                    /*  176 */
                    entrustTrade.setCoinCode(l.getCoinCode());
                    /*  177 */
                    entrustTrade.setType(l.getType());
                    /*  178 */
                    entrustTrade.setFixPriceCoinCode(l.getFixPriceCoinCode());
                    /*  179 */
                    entrustTrade.setEntrustPrice(BigDecimal.valueOf(Double.parseDouble(l.getEntrustPrice().toString())).stripTrailingZeros());
                    /*  180 */
                    entrustTrade.setEntrustPrice(l.getEntrustPrice().setScale(10, 6));
                    /*  181 */
                    cancelExEntrust(entrustTrade);
                    /*  182 */
                    localInteger1 = i;
                    /*      */
                }
                /*      */
                /*  185 */
                long end = System.currentTimeMillis();
                /*  186 */
                LogFactory.info("(" + i.toString() + ")全部撤销总耗时：" + (end - start) + "毫秒");
                /*      */
            }
            /*      */
        }
        /*      */
        else
            /*      */ {
            /*  191 */
            long start = System.currentTimeMillis();
            /*  192 */
            entrustTrade1.setEntrustPrice(entrustTrade1.getEntrustPrice().setScale(10, 6));
            /*  193 */
            cancelExEntrust(entrustTrade1);
            /*  194 */
            long end = System.currentTimeMillis();
            /*  195 */
            LogFactory.info("单个mq撤销总耗时：" + (end - start) + "毫秒");
            /*      */
        }
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void matchExtrustToOrderQueue(String exentrust)
    /*      */ {
        /*  204 */
        EntrustTrade entrust = (EntrustTrade) JSON.parseObject(exentrust, EntrustTrade.class);
        /*      */
        /*  206 */
        if (null == entrust.getEntrustTime()) {
            /*  207 */
            canceltype(entrust);
            /*      */
        }
        /*      */
        else {
            /*  210 */
            RedisUtil<UserRedis> redisUtil = new RedisUtil(UserRedis.class);
            /*  211 */
            UserRedis userRedis = (UserRedis) redisUtil.get(entrust.getCustomerId().toString());
            /*      */
            /*  213 */
            String code = entrust.getCoinCode();
            /*  214 */
            String priceCode = entrust.getFixPriceCoinCode();
            /*      */
            /*  216 */
            if (entrust.getType().intValue() == 1) {
                /*  217 */
                if (entrust.getFixPriceType().compareTo(Integer.valueOf(0)) == 0) {
                    /*  218 */
                    AppAccountRedis accountRedis = this.appAccountService.getAppAccountByRedis(userRedis.getAccountId().toString());
                    /*      */
                    /*  220 */
                    if (accountRedis.getHotMoney().compareTo(entrust.getEntrustPrice().multiply(entrust.getEntrustCount())) < 0)
                        /*      */ {
                        /*      */
                        /*      */
                        /*      */
                        /*  225 */
                        LogFactory.info("钱余额不足");
                        /*  226 */
                        return;
                        /*      */
                    }
                    /*      */
                }
                /*      */
                else {
                    /*  230 */
                    ExDigitalmoneyAccountRedis ear = this.exDigitalmoneyAccountService.getExDigitalmoneyAccountByRedis(userRedis.getDmAccountId(priceCode).toString());
                    /*      */
                    /*  232 */
                    if (ear.getHotMoney().compareTo(entrust.getEntrustPrice().multiply(entrust.getEntrustCount())) < 0)
                        /*      */ {
                        /*      */
                        /*      */
                        /*      */
                        /*  237 */
                        LogFactory.info("币余额不足");
                        /*  238 */
                        return;
                        /*      */
                    }
                    /*      */
                }
                /*      */
            }
            /*      */
            /*  243 */
            if (entrust.getType().intValue() == 2) {
                /*  244 */
                ExDigitalmoneyAccountRedis ear = this.exDigitalmoneyAccountService.getExDigitalmoneyAccountByRedis(userRedis.getDmAccountId(code).toString());
                /*      */
                /*  246 */
                if (ear.getHotMoney().compareTo(entrust.getEntrustCount()) < 0)
                    /*      */ {
                    /*      */
                    /*      */
                    /*      */
                    /*  251 */
                    return;
                    /*      */
                }
                /*      */
            }
            /*  254 */
            if ((entrust.getEntrustWay().compareTo(Integer.valueOf(1)) == 0) && (
                    /*  255 */         (entrust.getEntrustPrice().compareTo(new BigDecimal(0)) <= 0) || (entrust.getEntrustCount().compareTo(new BigDecimal(0)) <= 0))) {
                /*  256 */
                return;
                /*      */
            }
            /*      */
            /*      */
            /*  260 */
            entrust.setEntrustTime(new Date());
            /*  261 */
            entrust.setEntrustNum(transactionNum(entrust.getEntrustTime()));
            /*  262 */
            if ((entrust.getEntrustPrice().compareTo(new BigDecimal("9999999999")) == 1) || (entrust.getEntrustCount().compareTo(new BigDecimal("9999999999")) == 1) || (entrust.getEntrustSum().compareTo(new BigDecimal("9999999999")) == 1))
                /*      */ {
                /*      */
                /*  265 */
                LogFactory.info("超过了数据库的长度，总价或者价格或者量");
                /*  266 */
                return;
                /*      */
            }
            /*  268 */
            matchExtrustToOrder(entrust);
            /*      */
        }
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public String transactionNum(Date date)
    /*      */ {
        /*  275 */
        String randomStr = RandomStringUtils.random(3, false, true);
        /*  276 */
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        /*  277 */
        String time = format.format(date);
        /*  278 */
        String v = this.redisService.get(time);
        /*  279 */
        if (!StringUtil.isEmpty(v)) {
            /*  280 */
            Integer aa = Integer.valueOf(Integer.valueOf(v).intValue() + 1);
            /*  281 */
            String bb = aa.toString();
            /*  282 */
            if (aa.compareTo(Integer.valueOf(10)) == -1) {
                /*  283 */
                bb = "00" + aa.toString();
                /*  284 */
            } else if (aa.compareTo(Integer.valueOf(100)) == -1) {
                /*  285 */
                bb = "0" + aa.toString();
                /*      */
            }
            /*  287 */
            this.redisService.save(time, aa.toString(), 1);
            /*  288 */
            return time + bb + randomStr;
            /*      */
        }
        /*  290 */
        this.redisService.save(time, "1", 1);
        /*  291 */
        return time + "001" + randomStr;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public EntrustTrade getById(List<EntrustTrade> list, Integer start, Integer end, Long id)
    /*      */ {
        /*  297 */
        Integer k = Integer.valueOf((start.intValue() + end.intValue()) / 2);
        /*  298 */
        EntrustTrade et = (EntrustTrade) list.get(k.intValue());
        /*  299 */
        if (et.getId().compareTo(id) == 0) {
            /*  300 */
            list.remove(k);
            /*  301 */
            return et;
        }
        /*  302 */
        if (et.getId().compareTo(id) == 1) {
            /*  303 */
            getById(list, start, k, id);
            /*  304 */
        } else if (et.getId().compareTo(id) == -1) {
            /*  305 */
            getById(list, k, end, id);
            /*      */
        }
        /*  307 */
        return null;
        /*      */
    }

    /*      */
    /*      */
    public void cancelExEntrust(EntrustTrade exEntrust) {
        /*  311 */
        String key = TradeRedis.getHeader(exEntrust.getCoinCode(), exEntrust.getFixPriceCoinCode(), exEntrust.getType()) + ":" + exEntrust.getEntrustPrice();
        /*  312 */
        String entrustredis = TradeRedis.getTradeStringData(key);
        /*  313 */
        if ((StringUtil.isEmpty(entrustredis)) || (entrustredis.equals("[]"))) {
            /*  314 */
            LogFactory.info("撤销失败，keylist为空" + key);
            /*  315 */
            return;
            /*      */
        }
        /*  317 */
        List<EntrustTrade> list = JSON.parseArray(entrustredis, EntrustTrade.class);
        /*  318 */
        int k = 0;
        /*  319 */
        for (EntrustTrade l : list) {
            /*  320 */
            if (exEntrust.getEntrustNum().equals(l.getEntrustNum())) {
                /*  321 */
                exEntrust = l;
                /*  322 */
                list.remove(l);
                /*  323 */
                k = 1;
                /*  324 */
                break;
                /*      */
            }
            /*      */
        }
        /*  327 */
        if (k == 0) {
            /*  328 */
            LogFactory.info("撤销失败，因为已经没找到这个委托");
            /*  329 */
            return;
            /*      */
        }
        /*  331 */
        if (null == exEntrust) {
            /*  332 */
            LogFactory.info("撤销失败，因为已经没找到这个委托");
            /*  333 */
            return;
            /*      */
        }
        /*  335 */
        if (exEntrust.getStatus().intValue() >= 2) {
            /*  336 */
            LogFactory.info("撤销失败，因为已经之前已经撤销过");
            /*  337 */
            return;
            /*      */
        }
        /*  339 */
        if (exEntrust.getStatus().equals(Integer.valueOf(1))) {
            /*  340 */
            exEntrust.setStatus(Integer.valueOf(3));
            /*  341 */
        } else if (exEntrust.getStatus().equals(Integer.valueOf(0))) {
            /*  342 */
            exEntrust.setStatus(Integer.valueOf(4));
            /*      */
        }
        /*  344 */
        List<Accountadd> aaddlists = new ArrayList();
        /*  345 */
        String transactionNum = exEntrust.getEntrustNum();
        /*  346 */
        if (exEntrust.getType().equals(Integer.valueOf(1)))
            /*      */ {
            /*  348 */
            if (exEntrust.getFixPriceType().equals(Integer.valueOf(0))) {
                /*  349 */
                BigDecimal unfreezeMoney = exEntrust.getEntrustSum().subtract(exEntrust.getTransactionSum());
                /*  350 */
                Accountadd accountadd1 = getAccountadd(Integer.valueOf(0), exEntrust.getAccountId(), unfreezeMoney, Integer.valueOf(1), Integer.valueOf(12), transactionNum);
                /*  351 */
                aaddlists.add(accountadd1);
                /*  352 */
                Accountadd accountadd2 = getAccountadd(Integer.valueOf(0), exEntrust.getAccountId(), fu(unfreezeMoney), Integer.valueOf(2), Integer.valueOf(12), transactionNum);
                /*  353 */
                aaddlists.add(accountadd2);
                /*      */
            }
            /*      */
            else {
                /*  356 */
                BigDecimal unfreezeMoney = exEntrust.getEntrustSum().subtract(exEntrust.getTransactionSum());
                /*  357 */
                Accountadd accountadd1 = getAccountadd(Integer.valueOf(1), exEntrust.getAccountId(), unfreezeMoney, Integer.valueOf(1), Integer.valueOf(12), transactionNum);
                /*  358 */
                aaddlists.add(accountadd1);
                /*  359 */
                Accountadd accountadd2 = getAccountadd(Integer.valueOf(1), exEntrust.getAccountId(), fu(unfreezeMoney), Integer.valueOf(2), Integer.valueOf(12), transactionNum);
                /*  360 */
                aaddlists.add(accountadd2);
                /*      */
            }
            /*      */
        }
        /*      */
        /*      */
        /*  365 */
        if (exEntrust.getType().equals(Integer.valueOf(2))) {
            /*  366 */
            BigDecimal unfreezeMoney = exEntrust.getSurplusEntrustCount();
            /*  367 */
            Accountadd accountadd1 = getAccountadd(Integer.valueOf(1), exEntrust.getCoinAccountId(), unfreezeMoney, Integer.valueOf(1), Integer.valueOf(12), transactionNum);
            /*  368 */
            aaddlists.add(accountadd1);
            /*  369 */
            Accountadd accountadd2 = getAccountadd(Integer.valueOf(1), exEntrust.getCoinAccountId(), fu(unfreezeMoney), Integer.valueOf(2), Integer.valueOf(12), transactionNum);
            /*  370 */
            aaddlists.add(accountadd2);
            /*      */
        }
        /*  372 */
        TradeRedis.cancelEntrust(exEntrust, list, key, aaddlists);
        /*      */
    }

    /*      */
    /*      */
    public void matchExtrustToOrder(EntrustTrade exEntrust)
    /*      */ {
        /*  377 */
        long start = System.currentTimeMillis();
        /*      */
        /*  379 */
        if (exEntrust.getType().equals(Integer.valueOf(1))) {
            /*  380 */
            buyExchange(exEntrust);
            /*  381 */
        } else if (exEntrust.getType().equals(Integer.valueOf(2))) {
            /*  382 */
            sellExchange(exEntrust);
            /*      */
        }
        /*      */
        /*  385 */
        long end = System.currentTimeMillis();
        /*  386 */
        long time = end - start;
        /*  387 */
        if (time > 20L) {
            /*  388 */
            LogFactory.info("匹配总耗时：" + time + "毫秒");
            /*      */
        }
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void buyExchange(EntrustTrade buyexEntrust)
    /*      */ {
        /*      */
        label410:
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        long end3;
        /*      */
        /*      */
        /*      */
        /*      */
        /*  409 */
        if (buyexEntrust.getEntrustWay().equals(Integer.valueOf(1)))
            /*      */ {
            /*  411 */
            long start = System.currentTimeMillis();
            /*      */
            /*      */
            /*      */
            /*      */
            /*      */
            /*      */
            /*      */
            /*  419 */
            List<BigDecimal> keyslist = TradeRedis.getMatchkeys(buyexEntrust);
            /*  420 */
            long end = System.currentTimeMillis();
            /*  421 */
            long time = end - start;
            /*  422 */
            if (time > 3L) {
                /*  423 */
                LogFactory.info("取key并排序：" + time + "毫秒");
                /*      */
            }
            /*      */
            /*      */
            /*  427 */
            BigDecimal sellonePrice = null;
            /*  428 */
            long start1 = System.currentTimeMillis();
            /*  429 */
            if ((null != keyslist) && (keyslist.size() > 0)) {
                /*      */
                try {
                    /*  431 */
                    List<EntrustTrade> listed = new ArrayList();
                    /*  432 */
                    Map<String, List<EntrustTrade>> maping = new HashMap();
                    /*      */
                    /*  434 */
                    for (BigDecimal keybig : keyslist) {
                        /*  435 */
                        String keyall = TradeRedis.getHeaderMatch(buyexEntrust) + ":" + keybig.toString();
                        /*  436 */
                        List<EntrustTrade> list = TradeRedis.getMatchEntrustTradeBykey(keyall);
                        /*  437 */
                        if ((null != list) && (list.size() > 0)) {
                            /*  438 */
                            maping.put(keyall, list);
                            /*  439 */
                            int size = list.size();
                            /*  440 */
                            int i = 0;
                            /*  441 */
                            while (i < size) {
                                /*  442 */
                                EntrustTrade sellentrust = (EntrustTrade) list.get(i);
                                /*  443 */
                                if (sellentrust.getEntrustPrice().compareTo(buyexEntrust.getEntrustPrice()) == 1) {
                                    /*  444 */
                                    sellonePrice = sellentrust.getEntrustPrice();
                                    /*      */
                                    break label410;
                                    /*      */
                                }
                                /*  447 */
                                matching(buyexEntrust, sellentrust, "buy");
                                /*  448 */
                                if (sellentrust.getStatus().equals(Integer.valueOf(2))) {
                                    /*  449 */
                                    list.remove(i);
                                    /*  450 */
                                    i--;
                                    /*  451 */
                                    size--;
                                    /*      */
                                }
                                /*  453 */
                                listed.add(sellentrust);
                                /*      */
                                /*  455 */
                                if (buyexEntrust.getStatus().equals(Integer.valueOf(2))) {
                                    /*  456 */
                                    if (!sellentrust.getStatus().equals(Integer.valueOf(2))) {
                                        /*  457 */
                                        sellonePrice = sellentrust.getEntrustPrice();
                                        /*      */
                                        break label410;
                                    }
                                    /*  459 */
                                    if (i + 1 < size) {
                                        /*  460 */
                                        EntrustTrade sellentrustsellone = (EntrustTrade) list.get(i + 1);
                                        /*  461 */
                                        sellonePrice = sellentrustsellone.getEntrustPrice();
                                        /*      */
                                        break label410;
                                    }
                                    /*  463 */
                                    sellonePrice = null;
                                    /*      */
                                    /*      */
                                    /*      */
                                    break label410;
                                    /*      */
                                }
                                /*      */
                                /*  469 */
                                i++;
                                /*      */
                            }
                            /*      */
                        }
                        /*      */
                    }
                    /*      */
                    /*  474 */
                    long end1 = System.currentTimeMillis();
                    /*      */
                    long end2;
                    /*  476 */
                    if (buyexEntrust.getStatus().equals(Integer.valueOf(0))) {
                        /*  477 */
                        long start2 = System.currentTimeMillis();
                        /*  478 */
                        dealFundNoMatch(buyexEntrust);
                        /*  479 */
                        end2 = System.currentTimeMillis();
                        /*      */
                    }
                    /*      */
                    else
                        /*      */ {
                        /*  483 */
                        long start2 = System.currentTimeMillis();
                        /*  484 */
                        TradeRedis.matchOneEnd(dealFundEntrust(buyexEntrust), buyexEntrust, maping, listed, sellonePrice);
                        /*  485 */
                        end2 = System.currentTimeMillis();
                        /*      */
                    }
                    /*      */
                }
                /*      */ catch (Exception e) {
                    /*      */
                    long end2;
                    /*  490 */
                    e.printStackTrace();
                    /*  491 */
                    throw e;
                    /*      */
                } finally {
                    /*  493 */
                    TradeRedis.eoinfolists = new ArrayList();
                    /*  494 */
                    TradeRedis.aaddlists = new ArrayList();
                    /*      */
                }
                /*      */
            }
            /*      */
            else
                /*      */ {
                /*  499 */
                long start3 = System.currentTimeMillis();
                /*  500 */
                dealFundNoMatch(buyexEntrust);
                /*  501 */
                end3 = System.currentTimeMillis();
                /*      */
            }
            /*      */
        }
        /*  504 */
        else if (!buyexEntrust.getEntrustWay().equals(Integer.valueOf(2))) {
        }
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void sellExchange(EntrustTrade sellentrust)
    /*      */ {
        /*  542 */
        if (sellentrust.getEntrustWay().equals(Integer.valueOf(1)))
            /*      */ {
            /*      */
            /*      */
            /*      */
            /*      */
            /*      */
            /*  549 */
            List<BigDecimal> keyslist = TradeRedis.getMatchkeys(sellentrust);
            /*  550 */
            if ((null != keyslist) && (keyslist.size() > 0)) {
                /*      */
                try {
                    /*  552 */
                    List<EntrustTrade> listed = new ArrayList();
                    /*  553 */
                    Map<String, List<EntrustTrade>> maping = new HashMap();
                    /*  554 */
                    BigDecimal buyonePrice = null;
                    /*  555 */
                    for (BigDecimal keybig : keyslist) {
                        /*  556 */
                        String keyall = TradeRedis.getHeaderMatch(sellentrust) + ":" + keybig.toString();
                        /*  557 */
                        List<EntrustTrade> list = TradeRedis.getMatchEntrustTradeBykey(keyall);
                        /*  558 */
                        if ((null != list) && (list.size() > 0)) {
                            /*  559 */
                            maping.put(keyall, list);
                            /*  560 */
                            int size = list.size();
                            /*  561 */
                            int i = 0;
                            /*  562 */
                            while (i < size) {
                                /*  563 */
                                EntrustTrade buyexEntrust = (EntrustTrade) list.get(i);
                                /*  564 */
                                if (buyexEntrust.getEntrustPrice().compareTo(sellentrust.getEntrustPrice()) == -1) {
                                    /*  565 */
                                    buyonePrice = buyexEntrust.getEntrustPrice();
                                    /*      */
                                    break label347;
                                    /*      */
                                }
                                /*  568 */
                                matching(buyexEntrust, sellentrust, "sell");
                                /*  569 */
                                if (buyexEntrust.getStatus().equals(Integer.valueOf(2))) {
                                    /*  570 */
                                    list.remove(i);
                                    /*  571 */
                                    i--;
                                    /*  572 */
                                    size--;
                                    /*      */
                                }
                                /*  574 */
                                listed.add(buyexEntrust);
                                /*      */
                                /*  576 */
                                if (sellentrust.getStatus().equals(Integer.valueOf(2))) {
                                    /*  577 */
                                    if (!buyexEntrust.getStatus().equals(Integer.valueOf(2))) {
                                        /*  578 */
                                        buyonePrice = buyexEntrust.getEntrustPrice();
                                        /*      */
                                        break label347;
                                    }
                                    /*  580 */
                                    if (i + 1 < size) {
                                        /*  581 */
                                        EntrustTrade buyexEntrustone = (EntrustTrade) list.get(i + 1);
                                        /*  582 */
                                        buyonePrice = buyexEntrustone.getEntrustPrice();
                                        /*      */
                                        break label347;
                                    }
                                    /*  584 */
                                    buyonePrice = null;
                                    /*      */
                                    /*      */
                                    break label347;
                                    /*      */
                                }
                                /*      */
                                /*  589 */
                                i++;
                                /*      */
                            }
                            /*      */
                        }
                    }
                    /*      */
                    label347:
                    /*  593 */
                    if (sellentrust.getStatus().equals(Integer.valueOf(0))) {
                        /*  594 */
                        dealFundNoMatch(sellentrust);
                        /*      */
                    } else {
                        /*  596 */
                        TradeRedis.matchOneEnd(dealFundEntrust(sellentrust), sellentrust, maping, listed, buyonePrice);
                        /*      */
                    }
                    /*      */
                } catch (Exception e) {
                    /*  599 */
                    e.printStackTrace();
                    /*  600 */
                    throw e;
                    /*      */
                } finally {
                    /*  602 */
                    TradeRedis.eoinfolists = new ArrayList();
                    /*  603 */
                    TradeRedis.aaddlists = new ArrayList();
                    /*      */
                }
                /*      */
                /*      */
            }
            /*      */
            else {
                /*  608 */
                dealFundNoMatch(sellentrust);
                /*      */
            }
            /*      */
        }
        /*  611 */
        else if (!sellentrust.getEntrustWay().equals(Integer.valueOf(2))) {
        }
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void matching(EntrustTrade buyexEntrust, EntrustTrade sellentrust, String initiative)
    /*      */ {
        /*  631 */
        if (buyexEntrust.getEntrustWay().equals(Integer.valueOf(1)))
            /*      */ {
            /*  633 */
            if (sellentrust.getEntrustWay().equals(Integer.valueOf(1))) {
                /*  634 */
                oneCase(buyexEntrust, sellentrust, initiative);
                /*      */
            }
            /*  636 */
            else if (sellentrust.getEntrustWay().equals(Integer.valueOf(2))) {
                /*  637 */
                twoCase(buyexEntrust, sellentrust, initiative);
                /*      */
            }
            /*      */
        }
        /*  640 */
        else if (buyexEntrust.getEntrustWay().equals(Integer.valueOf(2)))
            /*      */ {
            /*  642 */
            if (sellentrust.getEntrustWay().equals(Integer.valueOf(1))) {
                /*  643 */
                threeCase(buyexEntrust, sellentrust);
                /*      */
            }
            /*  645 */
            else if (sellentrust.getEntrustWay().equals(Integer.valueOf(2))) {
                /*  646 */
                fourCase(buyexEntrust, sellentrust);
                /*      */
            }
            /*      */
        }
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public void oneCase(EntrustTrade buyexEntrust, EntrustTrade sellentrust, String initiative)
    /*      */ {
        /*  654 */
        BigDecimal tradeCount = buyexEntrust.getSurplusEntrustCount().compareTo(sellentrust.getSurplusEntrustCount()) <= 0 ? buyexEntrust.getSurplusEntrustCount() : sellentrust.getSurplusEntrustCount();
        /*      */
        /*  656 */
        if (tradeCount.compareTo(BigDecimal.ZERO) == 0) {
            /*  657 */
            return;
            /*      */
        }
        /*      */
        /*  660 */
        BigDecimal tradePrice = buyexEntrust.getEntrustPrice();
        /*      */
        /*  662 */
        if (tradePrice.compareTo(BigDecimal.ZERO) == 0) {
            /*  663 */
            return;
            /*      */
        }
        /*  665 */
        if (sellentrust.getEntrustPrice().compareTo(BigDecimal.ZERO) == 0) {
            /*  666 */
            return;
            /*      */
        }
        /*      */
        /*      */
        /*  670 */
        if ((sellentrust.getEntrustWay().equals(Integer.valueOf(1))) && (buyexEntrust.getEntrustPrice().compareTo(sellentrust.getEntrustPrice()) != 0)) {
            /*  671 */
            BigDecimal[] array = new BigDecimal[4];
            /*      */
            /*  673 */
            array[0] = buyexEntrust.getEntrustPrice().add(buyexEntrust.getFloatUpPrice());
            /*      */
            /*  675 */
            array[1] = buyexEntrust.getEntrustPrice().subtract(buyexEntrust.getFloatDownPrice());
            /*      */
            /*  677 */
            array[2] = sellentrust.getEntrustPrice().add(sellentrust.getFloatUpPrice());
            /*      */
            /*  679 */
            array[3] = sellentrust.getEntrustPrice().subtract(sellentrust.getFloatDownPrice());
            /*  680 */
            Arrays.sort(array);
            /*  681 */
            if (initiative.equals("buy")) {
                /*  682 */
                tradePrice = array[1];
                /*  683 */
            } else if (initiative.equals("sell")) {
                /*  684 */
                tradePrice = array[2];
                /*      */
            }
            /*      */
        }
        /*      */
        /*      */
        /*  689 */
        dealmatchend(buyexEntrust, sellentrust, tradeCount, tradePrice, initiative);
        /*      */
    }

    /*      */
    /*      */
    public void twoCase(EntrustTrade buyexEntrust, EntrustTrade sellentrust, String initiative)
    /*      */ {
        /*  694 */
        oneCase(buyexEntrust, sellentrust, initiative);
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    public void threeCase(EntrustTrade buyexEntrust, EntrustTrade sellentrust)
    /*      */ {
        /*  701 */
        BigDecimal buysurplusEntrusMoney = buyexEntrust.getEntrustSum().subtract(buyexEntrust.getTransactionSum());
        /*      */
        /*  703 */
        BigDecimal sellsurplusEntrusMoney = sellentrust.getSurplusEntrustCount().multiply(sellentrust.getEntrustPrice());
        /*      */
        /*  705 */
        BigDecimal tradeCount = new BigDecimal("0");
        /*  706 */
        if (buysurplusEntrusMoney.compareTo(sellsurplusEntrusMoney) <= 0) {
            /*  707 */
            tradeCount = buysurplusEntrusMoney.divide(sellentrust.getEntrustPrice(), 4, 1);
            /*  708 */
            buyexEntrust.setStatus(Integer.valueOf(2));
            /*      */
        }
        /*  710 */
        if (buysurplusEntrusMoney.compareTo(sellsurplusEntrusMoney) == 1) {
            /*  711 */
            tradeCount = sellentrust.getSurplusEntrustCount();
            /*      */
        }
        /*  713 */
        if (tradeCount.compareTo(new BigDecimal(0)) == 0) {
            /*  714 */
            return;
            /*      */
        }
        /*  716 */
        BigDecimal tradePrice = sellentrust.getEntrustPrice();
        /*      */
        /*  718 */
        if (tradePrice.compareTo(new BigDecimal(0)) == 0) {
            /*  719 */
            return;
            /*      */
        }
        /*  721 */
        dealmatchend(buyexEntrust, sellentrust, tradeCount, tradePrice, "buy");
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void fourCase(EntrustTrade buyexEntrust, EntrustTrade sellentrust) {
    }

    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    /*      */
    public void dealmatchend(EntrustTrade buyexEntrust, EntrustTrade sellentrust, BigDecimal tradeCount, BigDecimal tradePrice, String initiative)
    /*      */ {
        /*  757 */
        ExOrderInfo exOrderInfo = this.exOrderInfoService.createExOrderInfo(Integer.valueOf(1), buyexEntrust, sellentrust, tradeCount, tradePrice);
        /*  758 */
        exOrderInfo.setInOrOutTransaction(initiative.equals("buy") ? "sell" : "buy");
        /*  759 */
        updatebuyExEntrust(buyexEntrust, sellentrust, exOrderInfo);
        /*  760 */
        updatesellExEntrust(buyexEntrust, sellentrust, exOrderInfo);
        /*  761 */
        deductMoney(exOrderInfo, buyexEntrust, sellentrust);
        /*      */
    }

    /*      */
    /*      */
    public void deductMoney(ExOrderInfo exOrderInfo, EntrustTrade buyexEntrust, EntrustTrade sellentrust) {
        /*  765 */
        if (buyexEntrust.getFixPriceType().intValue() == 0) {
            /*  766 */
            deductMoneyByaccount(exOrderInfo, buyexEntrust, sellentrust);
            /*      */
        } else {
            /*  768 */
            deductMoneyByExDigita(exOrderInfo, buyexEntrust, sellentrust);
            /*      */
        }
        /*      */
    }

    /*      */
    /*      */
    public Accountadd getAccountadd(Integer acccountType, Long accountId, BigDecimal money, Integer monteyType, Integer remarks, String transactionNum) {
        /*  773 */
        Accountadd accountadd = new Accountadd();
        /*  774 */
        accountadd.setAcccountType(acccountType);
        /*  775 */
        accountadd.setMoney(money);
        /*  776 */
        accountadd.setAccountId(accountId);
        /*  777 */
        accountadd.setMonteyType(monteyType);
        /*  778 */
        accountadd.setTransactionNum(transactionNum);
        /*  779 */
        accountadd.setRemarks(remarks);
        /*      */
        /*  781 */
        return accountadd;
        /*      */
    }

    /*      */
    /*      */
    public BigDecimal fu(BigDecimal money) {
        /*  785 */
        return new BigDecimal("0").subtract(money);
        /*      */
    }

    /*      */
    /*      */
    public void deductMoneyByaccount(ExOrderInfo exOrderInfo, EntrustTrade buyexEntrust, EntrustTrade sellentrust) {
        /*  789 */
        List<Accountadd> aaddlists = new ArrayList();
        /*  790 */
        BigDecimal buychangHotMoney = BigDecimal.ZERO;
        /*  791 */
        BigDecimal buychangColdMoney = BigDecimal.ZERO;
        /*      */
        /*  793 */
        String transactionNumbuy = buyexEntrust.getEntrustNum() + "," + exOrderInfo.getOrderNum();
        /*  794 */
        String transactionNumsell = sellentrust.getEntrustNum() + "," + exOrderInfo.getOrderNum();
        /*  795 */
        Accountadd accountadd5 = getAccountadd(Integer.valueOf(0), buyexEntrust.getAccountId(), fu(exOrderInfo.getTransactionSum()), Integer.valueOf(2), Integer.valueOf(2), transactionNumbuy);
        /*  796 */
        aaddlists.add(accountadd5);
        /*      */
        /*  798 */
        if ((buyexEntrust.getEntrustWay().equals(Integer.valueOf(2))) && (buyexEntrust.getStatus().equals(Integer.valueOf(2)))) {
            /*  799 */
            BigDecimal surpSum = buyexEntrust.getEntrustSum().subtract(buyexEntrust.getTransactionSum());
            /*      */
            /*  801 */
            if (surpSum.compareTo(BigDecimal.ZERO) > 0) {
                /*  802 */
                Accountadd accountadd2 = getAccountadd(Integer.valueOf(0), buyexEntrust.getAccountId(), fu(surpSum), Integer.valueOf(2), Integer.valueOf(3), transactionNumbuy);
                /*  803 */
                aaddlists.add(accountadd2);
                /*  804 */
                Accountadd accountadd1 = getAccountadd(Integer.valueOf(0), buyexEntrust.getAccountId(), surpSum, Integer.valueOf(1), Integer.valueOf(4), transactionNumbuy);
                /*  805 */
                aaddlists.add(accountadd1);
                /*      */
            }
            /*      */
        }
        /*  808 */
        else if ((buyexEntrust.getEntrustWay().equals(Integer.valueOf(1))) && (buyexEntrust.getStatus().equals(Integer.valueOf(2))) &&
                /*  809 */       (buyexEntrust.getEntrustSum().compareTo(buyexEntrust.getTransactionSum()) == 1)) {
            /*  810 */
            BigDecimal surpSum = buyexEntrust.getEntrustSum().subtract(buyexEntrust.getTransactionSum());
            /*  811 */
            Accountadd accountadd3 = getAccountadd(Integer.valueOf(0), buyexEntrust.getAccountId(), fu(surpSum), Integer.valueOf(2), Integer.valueOf(5), transactionNumbuy);
            /*  812 */
            aaddlists.add(accountadd3);
            /*  813 */
            Accountadd accountadd4 = getAccountadd(Integer.valueOf(0), buyexEntrust.getAccountId(), surpSum, Integer.valueOf(1), Integer.valueOf(6), transactionNumbuy);
            /*  814 */
            aaddlists.add(accountadd4);
            /*      */
        }
        /*      */
        /*      */
        /*  818 */
        BigDecimal sellchangHotMoney = BigDecimal.ZERO;
        /*      */
        /*  820 */
        BigDecimal incomeMoney = exOrderInfo.getTransactionSum();
        /*  821 */
        sellchangHotMoney = sellchangHotMoney.add(incomeMoney);
        /*  822 */
        Accountadd accountadd7 = getAccountadd(Integer.valueOf(0), sellentrust.getAccountId(), incomeMoney, Integer.valueOf(1), Integer.valueOf(7), transactionNumsell);
        /*  823 */
        aaddlists.add(accountadd7);
        /*      */
        /*  825 */
        if (exOrderInfo.getTransactionSellFee().compareTo(new BigDecimal("0")) == 1) {
            /*  826 */
            Accountadd accountadd8 = getAccountadd(Integer.valueOf(0), sellentrust.getAccountId(), fu(exOrderInfo.getTransactionSellFee()), Integer.valueOf(1), Integer.valueOf(8), transactionNumsell);
            /*  827 */
            aaddlists.add(accountadd8);
            /*      */
        }
        /*      */
        /*  830 */
        BigDecimal buycoinchangHotMoney = BigDecimal.ZERO;
        /*  831 */
        BigDecimal sellcoinchangColdMoney = BigDecimal.ZERO;
        /*      */
        /*      */
        /*  834 */
        BigDecimal incomecoin = exOrderInfo.getTransactionCount();
        /*  835 */
        Accountadd coinaccountadd1 = getAccountadd(Integer.valueOf(1), buyexEntrust.getCoinAccountId(), incomecoin, Integer.valueOf(1), Integer.valueOf(9), transactionNumbuy);
        /*  836 */
        aaddlists.add(coinaccountadd1);
        /*      */
        /*  838 */
        if (exOrderInfo.getTransactionBuyFee().compareTo(new BigDecimal("0")) == 1) {
            /*  839 */
            Accountadd accountadd6 = getAccountadd(Integer.valueOf(1), buyexEntrust.getCoinAccountId(), fu(exOrderInfo.getTransactionBuyFee()), Integer.valueOf(1), Integer.valueOf(10), transactionNumbuy);
            /*  840 */
            aaddlists.add(accountadd6);
            /*      */
        }
        /*      */
        /*  843 */
        Accountadd coinaccountadd2 = getAccountadd(Integer.valueOf(1), sellentrust.getCoinAccountId(), fu(incomecoin), Integer.valueOf(2), Integer.valueOf(11), transactionNumsell);
        /*  844 */
        aaddlists.add(coinaccountadd2);
        /*      */
        /*      */
        /*  847 */
        TradeRedis.matchOneAndOneEnd(exOrderInfo, aaddlists);
        /*      */
    }

    /*      */
    /*      */
    public void deductMoneyByExDigita(ExOrderInfo exOrderInfo, EntrustTrade buyexEntrust, EntrustTrade sellentrust)
    /*      */ {
        /*  852 */
        List<Accountadd> aaddlists = new ArrayList();
        /*  853 */
        BigDecimal buychangHotMoney = BigDecimal.ZERO;
        /*  854 */
        BigDecimal buychangColdMoney = BigDecimal.ZERO;
        /*      */
        /*  856 */
        String transactionNumbuy = buyexEntrust.getEntrustNum() + "," + exOrderInfo.getOrderNum();
        /*  857 */
        String transactionNumsell = sellentrust.getEntrustNum() + "," + exOrderInfo.getOrderNum();
        /*  858 */
        Accountadd accountadd5 = getAccountadd(Integer.valueOf(1), buyexEntrust.getAccountId(), fu(exOrderInfo.getTransactionSum()), Integer.valueOf(2), Integer.valueOf(2), transactionNumbuy);
        /*  859 */
        aaddlists.add(accountadd5);
        /*      */
        /*  861 */
        if ((buyexEntrust.getEntrustWay().equals(Integer.valueOf(2))) && (buyexEntrust.getStatus().equals(Integer.valueOf(2)))) {
            /*  862 */
            BigDecimal surpSum = buyexEntrust.getEntrustSum().subtract(buyexEntrust.getTransactionSum());
            /*      */
            /*  864 */
            if (surpSum.compareTo(BigDecimal.ZERO) > 0) {
                /*  865 */
                Accountadd accountadd2 = getAccountadd(Integer.valueOf(1), buyexEntrust.getAccountId(), fu(surpSum), Integer.valueOf(2), Integer.valueOf(3), transactionNumbuy);
                /*  866 */
                aaddlists.add(accountadd2);
                /*  867 */
                Accountadd accountadd1 = getAccountadd(Integer.valueOf(1), buyexEntrust.getAccountId(), surpSum, Integer.valueOf(1), Integer.valueOf(4), transactionNumbuy);
                /*  868 */
                aaddlists.add(accountadd1);
                /*      */
            }
            /*      */
        }
        /*  871 */
        else if ((buyexEntrust.getEntrustWay().equals(Integer.valueOf(1))) && (buyexEntrust.getStatus().equals(Integer.valueOf(2))) &&
                /*  872 */       (buyexEntrust.getEntrustSum().compareTo(buyexEntrust.getTransactionSum()) == 1)) {
            /*  873 */
            BigDecimal surpSum = buyexEntrust.getEntrustSum().subtract(buyexEntrust.getTransactionSum());
            /*  874 */
            Accountadd accountadd3 = getAccountadd(Integer.valueOf(1), buyexEntrust.getAccountId(), fu(surpSum), Integer.valueOf(2), Integer.valueOf(5), transactionNumbuy);
            /*  875 */
            aaddlists.add(accountadd3);
            /*  876 */
            Accountadd accountadd4 = getAccountadd(Integer.valueOf(1), buyexEntrust.getAccountId(), surpSum, Integer.valueOf(1), Integer.valueOf(6), transactionNumbuy);
            /*  877 */
            aaddlists.add(accountadd4);
            /*      */
        }
        /*      */
        /*      */
        /*  881 */
        BigDecimal sellchangHotMoney = BigDecimal.ZERO;
        /*      */
        /*  883 */
        BigDecimal incomeMoney = exOrderInfo.getTransactionSum();
        /*  884 */
        sellchangHotMoney = sellchangHotMoney.add(incomeMoney);
        /*  885 */
        Accountadd accountadd7 = getAccountadd(Integer.valueOf(1), sellentrust.getAccountId(), incomeMoney, Integer.valueOf(1), Integer.valueOf(7), transactionNumsell);
        /*  886 */
        aaddlists.add(accountadd7);
        /*      */
        /*  888 */
        if (exOrderInfo.getTransactionSellFee().compareTo(new BigDecimal("0")) == 1) {
            /*  889 */
            Accountadd accountadd8 = getAccountadd(Integer.valueOf(1), sellentrust.getAccountId(), fu(exOrderInfo.getTransactionSellFee()), Integer.valueOf(1), Integer.valueOf(8), transactionNumsell);
            /*  890 */
            aaddlists.add(accountadd8);
            /*      */
        }
        /*      */
        /*  893 */
        BigDecimal buycoinchangHotMoney = BigDecimal.ZERO;
        /*  894 */
        BigDecimal sellcoinchangColdMoney = BigDecimal.ZERO;
        /*      */
        /*  896 */
        BigDecimal incomecoin = exOrderInfo.getTransactionCount();
        /*  897 */
        Accountadd coinaccountadd1 = getAccountadd(Integer.valueOf(1), buyexEntrust.getCoinAccountId(), incomecoin, Integer.valueOf(1), Integer.valueOf(9), transactionNumbuy);
        /*  898 */
        aaddlists.add(coinaccountadd1);
        /*      */
        /*  900 */
        if (exOrderInfo.getTransactionBuyFee().compareTo(new BigDecimal("0")) == 1) {
            /*  901 */
            Accountadd accountadd6 = getAccountadd(Integer.valueOf(1), buyexEntrust.getCoinAccountId(), fu(exOrderInfo.getTransactionBuyFee()), Integer.valueOf(1), Integer.valueOf(10), transactionNumbuy);
            /*  902 */
            aaddlists.add(accountadd6);
            /*      */
        }
        /*      */
        /*  905 */
        Accountadd coinaccountadd2 = getAccountadd(Integer.valueOf(1), sellentrust.getCoinAccountId(), fu(incomecoin), Integer.valueOf(2), Integer.valueOf(11), transactionNumsell);
        /*  906 */
        aaddlists.add(coinaccountadd2);
        /*      */
        /*      */
        /*  909 */
        TradeRedis.matchOneAndOneEnd(exOrderInfo, aaddlists);
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public void updatebuyExEntrust(EntrustTrade buyExEntrust, EntrustTrade sellentrust, ExOrderInfo exOrderInfo)
    /*      */ {
        /*  915 */
        buyExEntrust.setSurplusEntrustCount(buyExEntrust.getSurplusEntrustCount().subtract(exOrderInfo.getTransactionCount()));
        /*  916 */
        buyExEntrust.setTransactionFee(buyExEntrust.getTransactionFee().add(exOrderInfo.getTransactionBuyFee()));
        /*  917 */
        buyExEntrust.setTransactionSum(buyExEntrust.getTransactionSum().add(exOrderInfo.getTransactionSum()));
        /*      */
        /*  919 */
        buyExEntrust.setProcessedPrice(buyExEntrust.getTransactionSum().divide(buyExEntrust.getEntrustCount().subtract(buyExEntrust.getSurplusEntrustCount()), 10, 4));
        /*      */
        /*      */
        /*  922 */
        if (buyExEntrust.getEntrustWay().equals(Integer.valueOf(2)))
            /*      */ {
            /*  924 */
            if (!buyExEntrust.getStatus().equals(Integer.valueOf(2))) {
                /*  925 */
                buyExEntrust.setStatus(Integer.valueOf(1));
                /*      */
                /*      */
            }
            /*      */
            /*      */
            /*      */
        }
        /*  931 */
        else if (buyExEntrust.getSurplusEntrustCount().compareTo(BigDecimal.ZERO) <= 0) {
            /*  932 */
            buyExEntrust.setStatus(Integer.valueOf(2));
            /*      */
        } else {
            /*  934 */
            buyExEntrust.setStatus(Integer.valueOf(1));
            /*      */
        }
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public void updatesellExEntrust(EntrustTrade buyExEntrust, EntrustTrade sellentrust, ExOrderInfo exOrderInfo)
    /*      */ {
        /*  941 */
        sellentrust.setSurplusEntrustCount(sellentrust.getSurplusEntrustCount().subtract(exOrderInfo.getTransactionCount()));
        /*  942 */
        sellentrust.setTransactionFee(sellentrust.getTransactionFee().add(exOrderInfo.getTransactionSellFee()));
        /*  943 */
        sellentrust.setTransactionSum(sellentrust.getTransactionSum().add(exOrderInfo.getTransactionSum()));
        /*      */
        /*      */
        /*  946 */
        sellentrust.setProcessedPrice(sellentrust.getTransactionSum().divide(sellentrust.getEntrustCount().subtract(sellentrust.getSurplusEntrustCount()), 8, 4));
        /*      */
        /*      */
        /*  949 */
        sellentrust.setStatus(Integer.valueOf(1));
        /*  950 */
        if (sellentrust.getSurplusEntrustCount().compareTo(new BigDecimal(0)) <= 0) {
            /*  951 */
            sellentrust.setStatus(Integer.valueOf(2));
            /*      */
        }
        /*      */
    }

    /*      */
    /*      */
    public void dealFundNoMatch(EntrustTrade exEntrust) {
        /*  956 */
        long start3 = System.currentTimeMillis();
        /*  957 */
        TradeRedis.NoMatchEnd(exEntrust, dealFundEntrust(exEntrust));
        /*  958 */
        long end3 = System.currentTimeMillis();
        /*      */
    }

    /*      */
    /*      */
    public List<Accountadd> dealFundEntrust(EntrustTrade exEntrust)
    /*      */ {
        /*  963 */
        List<Accountadd> aaddlists = new ArrayList();
        /*  964 */
        String transactionNum = exEntrust.getEntrustNum();
        /*  965 */
        if (exEntrust.getType().equals(Integer.valueOf(1))) {
            /*  966 */
            if (exEntrust.getFixPriceType().equals(Integer.valueOf(0))) {
                /*  967 */
                BigDecimal freezeMoney = exEntrust.getEntrustSum();
                /*      */
                /*  969 */
                Accountadd accountadd1 = getAccountadd(Integer.valueOf(0), exEntrust.getAccountId(), fu(freezeMoney), Integer.valueOf(1), Integer.valueOf(1), transactionNum);
                /*  970 */
                aaddlists.add(accountadd1);
                /*  971 */
                Accountadd accountadd2 = getAccountadd(Integer.valueOf(0), exEntrust.getAccountId(), freezeMoney, Integer.valueOf(2), Integer.valueOf(1), transactionNum);
                /*  972 */
                aaddlists.add(accountadd2);
                /*      */
            } else {
                /*  974 */
                BigDecimal freezeMoney = exEntrust.getEntrustSum();
                /*  975 */
                Accountadd accountadd1 = getAccountadd(Integer.valueOf(1), exEntrust.getAccountId(), fu(freezeMoney), Integer.valueOf(1), Integer.valueOf(1), transactionNum);
                /*  976 */
                aaddlists.add(accountadd1);
                /*  977 */
                Accountadd accountadd2 = getAccountadd(Integer.valueOf(1), exEntrust.getAccountId(), freezeMoney, Integer.valueOf(2), Integer.valueOf(1), transactionNum);
                /*  978 */
                aaddlists.add(accountadd2);
                /*      */
            }
            /*      */
        }
        /*  981 */
        else if (exEntrust.getType().equals(Integer.valueOf(2))) {
            /*  982 */
            BigDecimal freezeMoney = exEntrust.getEntrustCount();
            /*  983 */
            Accountadd accountadd1 = getAccountadd(Integer.valueOf(1), exEntrust.getCoinAccountId(), fu(freezeMoney), Integer.valueOf(1), Integer.valueOf(1), transactionNum);
            /*  984 */
            aaddlists.add(accountadd1);
            /*  985 */
            Accountadd accountadd2 = getAccountadd(Integer.valueOf(1), exEntrust.getCoinAccountId(), freezeMoney, Integer.valueOf(2), Integer.valueOf(1), transactionNum);
            /*  986 */
            aaddlists.add(accountadd2);
            /*      */
        }
        /*      */
        /*  989 */
        return aaddlists;
        /*      */
    }

    /*      */
    /*      */
    public Boolean accountaddQueue(String accoutadds)
    /*      */ {
        /*  994 */
        Boolean flag = Boolean.valueOf(true);
        /*  995 */
        JedisPool jedisPool = (JedisPool) ContextUtil.getBean("jedisPool");
        /*  996 */
        Jedis jedis = jedisPool.getResource();
        /*      */
        try
            /*      */ {
            /*  999 */
            Transaction transaction = jedis.multi();
            /* 1000 */
            List<Accountadd> accountaddlist = JSON.parseArray(accoutadds, Accountadd.class);
            /* 1001 */
            transaction.set(TradeRedis.getTradeDealAccountChangeNum(), JSON.toJSONString(accountaddlist));
            /*      */
            /*      */
            /* 1004 */
            AccountaddComparator accountaddComparator = new AccountaddComparator();
            /* 1005 */
            Collections.sort(accountaddlist, accountaddComparator);
            /* 1006 */
            Long coinaccountId = null;
            /* 1007 */
            ExDigitalmoneyAccountRedis coinaccount = null;
            /* 1008 */
            Long accountId = null;
            /* 1009 */
            AppAccountRedis appAccount = null;
            /* 1010 */
            for (Accountadd accountadd : accountaddlist) {
                /* 1011 */
                if (accountadd.getAcccountType().equals(Integer.valueOf(1))) {
                    /* 1012 */
                    if ((null == coinaccountId) || (accountadd.getAccountId().compareTo(coinaccountId) != 0)) {
                        /* 1013 */
                        if (null != coinaccount) {
                            /* 1014 */
                            RuntimeSchema<ExDigitalmoneyAccountRedis> schema = RuntimeSchema.createFrom(ExDigitalmoneyAccountRedis.class);
                            /* 1015 */
                            byte[] bytes = ProtostuffIOUtil.toByteArray(coinaccount, schema, LinkedBuffer.allocate(512));
                            /* 1016 */
                            String key = "RedisDB:" + ExDigitalmoneyAccountRedis.class.getName().replace(".", ":") + ":" + coinaccount.getId();
                            /* 1017 */
                            transaction.del(key.getBytes());
                            /* 1018 */
                            transaction.set(key.getBytes(), bytes);
                            /*      */
                        }
                        /*      */
                        /* 1021 */
                        coinaccount = this.exDigitalmoneyAccountService.getExDigitalmoneyAccountByRedis(accountadd.getAccountId().toString());
                        /* 1022 */
                        coinaccountId = accountadd.getAccountId();
                        /*      */
                    }
                    /* 1024 */
                    if (null != coinaccount) {
                        /* 1025 */
                        if (accountadd.getMonteyType().equals(Integer.valueOf(1))) {
                            /* 1026 */
                            coinaccount.setHotMoney(coinaccount.getHotMoney().add(accountadd.getMoney()));
                            /*      */
                        } else {
                            /* 1028 */
                            coinaccount.setColdMoney(coinaccount.getColdMoney().add(accountadd.getMoney()));
                            /*      */
                        }
                        /*      */
                        /*      */
                    }
                    /*      */
                    else {
                        /* 1033 */
                        LogFactory.info("mq:redis资金账户没有查到==" + accountadd.getAccountId());
                        /*      */
                    }
                    /*      */
                }
                /*      */
                else {
                    /* 1037 */
                    if ((null == accountId) || (accountadd.getAccountId().compareTo(accountId) != 0)) {
                        /* 1038 */
                        if (null != appAccount) {
                            /* 1039 */
                            RuntimeSchema<AppAccountRedis> schema = RuntimeSchema.createFrom(AppAccountRedis.class);
                            /* 1040 */
                            byte[] bytes = ProtostuffIOUtil.toByteArray(appAccount, schema, LinkedBuffer.allocate(512));
                            /* 1041 */
                            String key = "RedisDB:" + AppAccountRedis.class.getName().replace(".", ":") + ":" + appAccount.getId();
                            /* 1042 */
                            transaction.del(key.getBytes());
                            /* 1043 */
                            transaction.set(key.getBytes(), bytes);
                            /*      */
                        }
                        /*      */
                        /* 1046 */
                        appAccount = this.appAccountService.getAppAccountByRedis(accountadd.getAccountId().toString());
                        /*      */
                        /* 1048 */
                        accountId = accountadd.getAccountId();
                        /*      */
                    }
                    /*      */
                    /* 1051 */
                    if (null != appAccount) {
                        /* 1052 */
                        if (accountadd.getMonteyType().equals(Integer.valueOf(1))) {
                            /* 1053 */
                            appAccount.setHotMoney(appAccount.getHotMoney().add(accountadd.getMoney()));
                            /*      */
                        } else {
                            /* 1055 */
                            appAccount.setColdMoney(appAccount.getColdMoney().add(accountadd.getMoney()));
                            /*      */
                        }
                        /*      */
                    }
                    /*      */
                    else {
                        /* 1059 */
                        LogFactory.info("mq:redis虚拟账户没有查到==" + accountadd.getAccountId());
                        /*      */
                    }
                    /*      */
                }
                /*      */
            }
            /*      */
            /*      */
            /*      */
            /* 1066 */
            if (null != coinaccount) {
                /* 1067 */
                RuntimeSchema<ExDigitalmoneyAccountRedis> schema = RuntimeSchema.createFrom(ExDigitalmoneyAccountRedis.class);
                /* 1068 */
                byte[] bytes = ProtostuffIOUtil.toByteArray(coinaccount, schema, LinkedBuffer.allocate(512));
                /* 1069 */
                String key = "RedisDB:" + ExDigitalmoneyAccountRedis.class.getName().replace(".", ":") + ":" + coinaccount.getId();
                /* 1070 */
                transaction.del(key.getBytes());
                /* 1071 */
                transaction.set(key.getBytes(), bytes);
                /*      */
            }
            /*      */
            /* 1074 */
            if (null != appAccount) {
                /* 1075 */
                RuntimeSchema<AppAccountRedis> schema1 = RuntimeSchema.createFrom(AppAccountRedis.class);
                /* 1076 */
                byte[] bytes1 = ProtostuffIOUtil.toByteArray(appAccount, schema1, LinkedBuffer.allocate(512));
                /* 1077 */
                String key1 = "RedisDB:" + AppAccountRedis.class.getName().replace(".", ":") + ":" + appAccount.getId();
                /* 1078 */
                transaction.del(key1.getBytes());
                /* 1079 */
                transaction.set(key1.getBytes(), bytes1);
                /*      */
            }
            /*      */
            /*      */
            /*      */
            /*      */
            /* 1085 */
            List<Object> list = transaction.exec();
            /* 1086 */
            if ((null == list) || (list.size() == 0)) {
                /* 1087 */
                flag = Boolean.valueOf(false);
                /*      */
            }
            /*      */
        }
        /*      */ catch (Exception e) {
            /* 1091 */
            AppException exceptionLog = new AppException();
            /* 1092 */
            exceptionLog.setName("mq==accountaddQueue==");
            /* 1093 */
            AppExceptionService appExceptionService = (AppExceptionService) ContextUtil.getBean("appExceptionService");
            /* 1094 */
            appExceptionService.save(exceptionLog);
            /* 1095 */
            System.out.println("mq==accountaddQueue==" + accoutadds);
            /*      */
            /* 1097 */
            throw e;
            /*      */
        } finally {
            /* 1099 */
            jedis.close();
            /*      */
        }
        /*      */
        /* 1102 */
        return flag;
        /*      */
    }
    /*      */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\impl\TradeServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */