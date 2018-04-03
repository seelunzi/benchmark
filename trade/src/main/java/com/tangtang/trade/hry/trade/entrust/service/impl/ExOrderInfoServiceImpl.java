
package com.tangtang.trade.hry.trade.entrust.service.impl;


import com.alibaba.fastjson.JSON;
import hry.account.fund.model.AppAccount;
import hry.account.fund.model.AppColdAccountRecord;
import hry.account.fund.model.AppHotAccountRecord;
import hry.core.mvc.dao.base.BaseDao;
import hry.core.util.idgenerate.IdGenerate;
import hry.core.util.log.LogFactory;
import hry.core.util.sys.ContextUtil;
import hry.exchange.account.model.ExDigitalmoneyAccount;
import hry.exchange.account.model.ExDmColdAccountRecord;
import hry.exchange.account.model.ExDmHotAccountRecord;
import hry.redis.common.utils.RedisService;
import hry.trade.account.dao.*;
import hry.trade.account.service.AppAccountService;
import hry.trade.account.service.AppHotAccountRecordService;
import hry.trade.account.service.ExDigitalmoneyAccountService;
import hry.trade.entrust.dao.ExEntrustDao;
import hry.trade.entrust.dao.ExOrderInfoDao;
import hry.trade.entrust.model.ExEntrust;
import hry.trade.entrust.model.ExOrder;
import hry.trade.entrust.model.ExOrderInfo;
import hry.trade.entrust.service.ExEntrustService;
import hry.trade.entrust.service.ExOrderInfoService;
import hry.trade.mq.service.MessageProducer;
import hry.trade.redis.model.Accountadd;
import hry.trade.redis.model.AppAccountRedis;
import hry.trade.redis.model.EntrustTrade;
import hry.trade.redis.model.ExDigitalmoneyAccountRedis;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;


@org.springframework.stereotype.Service("exOrderInfoService")
public class ExOrderInfoServiceImpl extends hry.core.mvc.service.base.impl.BaseServiceImpl<ExOrderInfo, Long> implements ExOrderInfoService {

    @Resource(name = "exOrderService")
    public hry.trade.entrust.service.ExOrderService exOrderService;

    @Resource
    public ExEntrustService exEntrustService;

    @Resource
    private RedisService redisService;

    @Resource
    private ExOrderInfoService exOrderInfoService;

    @Resource
    public ExDigitalmoneyAccountService exDigitalmoneyAccountService;

    @Resource
    public AppAccountService appAccountService;

    @Resource
    public ExDigitalmoneyAccountDao exDigitalmoneyAccountDao;

    @Resource
    public AppAccountDao appAccountDao;

    @Resource
    private ExEntrustDao exEntrustDao;

    @Resource
    private ExOrderInfoDao exOrderInfoDao;

    @Resource
    private hry.trade.account.service.ExDmColdAccountRecordService exDmColdAccountRecordService;

    @Resource
    private hry.trade.account.service.ExDmHotAccountRecordService exDmHotAccountRecordService;

    @Resource
    private hry.trade.account.service.AppColdAccountRecordService appColdAccountRecordService;

    @Resource
    private AppHotAccountRecordService appHotAccountRecordService;

    @Resource
    private ExDmColdAccountRecordDao exDmColdAccountRecordDao;

    @Resource
    private ExDmHotAccountRecordDao exDmHotAccountRecordDao;

    @Resource
    private AppColdAccountRecordDao appColdAccountRecordDao;

    @Resource
    private AppHotAccountRecordDao appHotAccountRecordDao;



    @Resource(name = "exOrderInfoDao")
    public void setDao(BaseDao<ExOrderInfo, Long> dao) {
        /*  89 */
        this.dao = dao;

    }


    public ExOrderInfo createExOrderInfo(Integer type, EntrustTrade buyExEntrust, EntrustTrade sellentrust, BigDecimal tradeCount, BigDecimal tradePrice) {
        /* 132 */
        ExOrderInfo exOrderInfo = new ExOrderInfo();
        /* 133 */
        exOrderInfo.setType(type);
        /* 134 */
        String transactionNum = IdGenerate.transactionNum("11");
        /* 135 */
        exOrderInfo.setOrderNum("T" + transactionNum.substring(2, transactionNum.length()));
        /* 136 */
        exOrderInfo.setTransactionCount(tradeCount);
        /* 137 */
        exOrderInfo.setTransactionPrice(tradePrice);
        /* 138 */
        exOrderInfo.setTransactionSum(tradePrice.multiply(tradeCount));
        /* 139 */
        exOrderInfo.setTransactionTime(new Date());
        /* 140 */
        exOrderInfo.setOrderTimestapm(Long.valueOf(exOrderInfo.getTransactionTime().getTime()));
        /* 141 */
        exOrderInfo.setTransactionBuyFeeRate(buyExEntrust.getTransactionFeeRate());
        /* 142 */
        exOrderInfo.setTransactionSellFeeRate(sellentrust.getTransactionFeeRate());
        /* 143 */
        exOrderInfo.setTransactionBuyFee(exOrderInfo.getTransactionCount().multiply(exOrderInfo.getTransactionBuyFeeRate()).divide(new BigDecimal("100")));
        /* 144 */
        exOrderInfo.setTransactionSellFee(exOrderInfo.getTransactionSum().multiply(exOrderInfo.getTransactionSellFeeRate()).divide(new BigDecimal("100")));
        /* 145 */
        exOrderInfo.setBuyCustomId(buyExEntrust.getCustomerId());
        /* 146 */
        exOrderInfo.setSellCustomId(sellentrust.getCustomerId());
        /* 147 */
        exOrderInfo.setWebsite("cn");
        /* 148 */
        exOrderInfo.setCurrencyType("cny");
        /* 149 */
        exOrderInfo.setFixPriceCoinCode(buyExEntrust.getFixPriceCoinCode());
        /* 150 */
        exOrderInfo.setFixPriceType(buyExEntrust.getFixPriceType());
        /* 151 */
        exOrderInfo.setCoinCode(buyExEntrust.getCoinCode());


        /* 154 */
        exOrderInfo.setBuyEntrustNum(buyExEntrust.getEntrustNum());
        /* 155 */
        exOrderInfo.setSellEntrustNum(sellentrust.getEntrustNum());

        /* 157 */
        exOrderInfo.setBuyUserName(buyExEntrust.getUserName());
        /* 158 */
        exOrderInfo.setSellUserName(sellentrust.getUserName());
        /* 159 */
        exOrderInfo.setTransactionTime(new Date());
        /* 160 */
        exOrderInfo.setOrderTimestapm(Long.valueOf(exOrderInfo.getTransactionTime().getTime()));



        /* 164 */
        return exOrderInfo;

    }


    public ExOrder createExOrder(ExOrderInfo exOrderInfo) {
        /* 171 */
        ExOrder exOrder = new ExOrder();
        /* 172 */
        exOrder.setOrderNum(exOrderInfo.getOrderNum());
        /* 173 */
        exOrder.setTransactionTime(exOrderInfo.getTransactionTime());
        /* 174 */
        exOrder.setOrderTimestapm(exOrderInfo.getOrderTimestapm());
        /* 175 */
        exOrder.setSaasId(exOrderInfo.getSaasId());
        /* 176 */
        exOrder.setCurrencyType(exOrderInfo.getCurrencyType());
        /* 177 */
        exOrder.setWebsite(exOrderInfo.getWebsite());
        /* 178 */
        exOrder.setTransactionCount(exOrderInfo.getTransactionCount());
        /* 179 */
        exOrder.setTransactionPrice(exOrderInfo.getTransactionPrice());
        /* 180 */
        exOrder.setTransactionSum(exOrderInfo.getTransactionSum());
        /* 181 */
        exOrder.setCoinCode(exOrderInfo.getCoinCode());
        /* 182 */
        exOrder.setWebsite(exOrderInfo.getWebsite());
        /* 183 */
        exOrder.setCurrencyType(exOrderInfo.getCurrencyType());
        /* 184 */
        exOrder.setProductName(exOrderInfo.getProductName());
        /* 185 */
        exOrder.setInOrOutTransaction(exOrderInfo.getInOrOutTransaction());
        /* 186 */
        exOrder.setFixPriceCoinCode(exOrderInfo.getFixPriceCoinCode());
        /* 187 */
        exOrder.setFixPriceType(exOrderInfo.getFixPriceType());


        /* 190 */
        return exOrder;

    }


    public void reidsToMysql() {
        /* 196 */
        long start = System.currentTimeMillis();

        /* 198 */
        Map<String, EntrustTrade> map = new java.util.HashMap();
        /* 199 */
        long start4 = System.currentTimeMillis();
        /* 200 */
        Set<String> keysTradeDealEntrustChange = this.redisService.noPerkeys("deal:tradeDealEntrustChange:");
        /* 201 */
        long end4 = System.currentTimeMillis();

        /* 203 */
        List<BigDecimal> list2 = new ArrayList();
        /* 204 */
        Iterator<String> iterator1 = keysTradeDealEntrustChange.iterator();
        /* 205 */
        while (iterator1.hasNext()) {
            /* 206 */
            String keystr = (String) iterator1.next();
            /* 207 */
            BigDecimal ks = new BigDecimal(keystr.split(":")[2]);
            /* 208 */
            list2.add(ks);

        }
        /* 210 */
        java.util.Collections.sort(list2, new hry.trade.comparator.AscBigDecimalComparator());
        /* 211 */
        long start5 = System.currentTimeMillis();
        /* 212 */
        for (BigDecimal l : list2) {
            /* 213 */
            String keystr = "deal:tradeDealEntrustChange:" + l;

            /* 215 */
            List<EntrustTrade> entrustTradeSlist = JSON.parseArray(this.redisService.get(keystr), EntrustTrade.class);
            /* 216 */
            if (null != entrustTradeSlist) {
                /* 217 */
                for (EntrustTrade es : entrustTradeSlist) {
                    /* 218 */
                    map.put(es.getEntrustNum(), es);

                }

            }

        }

        /* 223 */
        long end5 = System.currentTimeMillis();

        /* 225 */
        List<EntrustTrade> entrustlisted = new ArrayList(map.values());
        /* 226 */
        long end2;
        if ((null != entrustlisted) && (entrustlisted.size() > 0)) {
            /* 227 */
            List<ExEntrust> entrustupdatelist = this.exEntrustDao.getExEntrustListByNumstoMysql(entrustlisted);
            /* 228 */
            List<EntrustTrade> entrustnewlist = new ArrayList();
            /* 229 */
            if ((null != entrustupdatelist) && (entrustupdatelist.size() > 0)) {
                /* 230 */
                int k = 0;
                /* 231 */
                int size = entrustlisted.size();
                /* 232 */
                while (k < size) {
                    /* 233 */
                    int i = 0;
                    /* 234 */
                    EntrustTrade entrusted = (EntrustTrade) entrustlisted.get(k);
                    /* 235 */
                    for (ExEntrust entrustUpdate : entrustupdatelist) {
                        /* 236 */
                        if (entrusted.getEntrustNum().equals(entrustUpdate.getEntrustNum())) {
                            /* 237 */
                            entrustUpdate.setStatusint(entrusted.getStatus().intValue());
                            /* 238 */
                            entrustUpdate.setSurplusEntrustCountDouble(entrusted.getSurplusEntrustCount().doubleValue());
                            /* 239 */
                            entrustUpdate.setTransactionSumDouble(entrusted.getTransactionSum().doubleValue());
                            /* 240 */
                            entrustUpdate.setTransactionFeeDouble(entrusted.getTransactionFee().doubleValue());
                            /* 241 */
                            if (null == entrusted.getProcessedPrice()) {
                                /* 242 */
                                entrustUpdate.setProcessedPriceDouble(Double.valueOf("0").doubleValue());

                            } else {
                                /* 244 */
                                entrustUpdate.setProcessedPriceDouble(entrusted.getProcessedPrice().doubleValue());

                            }

                            /* 247 */
                            entrustUpdate.setModified(new Date());
                            /* 248 */
                            i++;
                            /* 249 */
                            break;

                        }

                    }
                    /* 252 */
                    if (i == 0) {
                        /* 253 */
                        if (null == entrusted.getProcessedPrice()) {
                            /* 254 */
                            entrusted.setProcessedPrice(new BigDecimal("0"));

                        }
                        /* 256 */
                        entrustnewlist.add(entrusted);

                    }
                    /* 258 */
                    k++;

                }

            } else {
                /* 261 */
                entrustnewlist = entrustlisted;

            }

            long end1;
            /* 264 */
            if ((null != entrustupdatelist) && (entrustupdatelist.size() > 0)) {
                /* 265 */
                long start1 = System.currentTimeMillis();

                /* 267 */
                this.exEntrustDao.updateExEntrust(entrustupdatelist);
                /* 268 */
                end1 = System.currentTimeMillis();

            }


            /* 272 */
            if ((null != entrustnewlist) && (entrustnewlist.size() > 0)) {
                /* 273 */
                long start2 = System.currentTimeMillis();

                /* 275 */
                this.exEntrustDao.insertExEntrust(entrustnewlist);
                /* 276 */
                end2 = System.currentTimeMillis();

            }

        }



























        /* 306 */
        List<ExOrderInfo> eExOrderInfolistss = new ArrayList();
        /* 307 */
        Set<String> keysTradeDealOrderInfoChange = this.redisService.noPerkeys("deal:tradeDealOrderInfoChange:");
        /* 308 */
        Iterator<String> iteratorTradeDealOrderInfoChange = keysTradeDealOrderInfoChange.iterator();
        /* 309 */
        while (iteratorTradeDealOrderInfoChange.hasNext()) {
            /* 310 */
            String keystr = (String) iteratorTradeDealOrderInfoChange.next();
            /* 311 */
            List<ExOrderInfo> accountaddSlist = JSON.parseArray(this.redisService.get(keystr), ExOrderInfo.class);
            /* 312 */
            if (null != accountaddSlist) {
                /* 313 */
                eExOrderInfolistss.addAll(accountaddSlist);

            }

        }

        long end3;
        /* 317 */
        if ((null != eExOrderInfolistss) && (eExOrderInfolistss.size() > 0)) {
            /* 318 */
            long start3 = System.currentTimeMillis();
            /* 319 */
            this.exOrderInfoDao.insertExorderInfos(eExOrderInfolistss);
            /* 320 */
            end3 = System.currentTimeMillis();

        }






        /* 328 */
        Iterator<String> keysTradeDealEntrustChangedelete = keysTradeDealEntrustChange.iterator();
        /* 329 */
        while (keysTradeDealEntrustChangedelete.hasNext()) {
            /* 330 */
            String keystr = (String) keysTradeDealEntrustChangedelete.next();
            /* 331 */
            this.redisService.delete(keystr);

        }

        /* 334 */
        Iterator<String> keysTradeDealOrderInfoChangedelete = keysTradeDealOrderInfoChange.iterator();
        /* 335 */
        while (keysTradeDealOrderInfoChangedelete.hasNext()) {
            /* 336 */
            String keystr = (String) keysTradeDealOrderInfoChangedelete.next();
            /* 337 */
            this.redisService.delete(keystr);

        }

        /* 340 */
        long end = System.currentTimeMillis();
        /* 341 */
        long time = end - start;
        /* 342 */
        if (time > 800L) {
            /* 343 */
            LogFactory.info("redis(委托单和成交单)入库总耗时：" + time + "ms");

        }

    }


    public void reidsToredisLog() {
        /* 349 */
        long start = System.currentTimeMillis();
        /* 350 */
        Set<Long> setaccount = new HashSet();
        /* 351 */
        Set<Long> setaccountcoin = new HashSet();
        /* 352 */
        List<Accountadd> accountaddSlistss = new ArrayList();
        /* 353 */
        Set<String> keysTradeDealAccountChange = this.redisService.noPerkeys("deal:TradeDealAccountChange:");
        /* 354 */
        Iterator<String> iteratorTradeDealAccountChange = keysTradeDealAccountChange.iterator();
        /* 355 */
        while (iteratorTradeDealAccountChange.hasNext()) {
            /* 356 */
            String keystr = (String) iteratorTradeDealAccountChange.next();
            /* 357 */
            List<Accountadd> accountaddSlist = JSON.parseArray(this.redisService.get(keystr), Accountadd.class);
            /* 358 */
            if (null != accountaddSlist) {
                /* 359 */
                accountaddSlistss.addAll(accountaddSlist);

            }

        }

        /* 363 */
        List<AppHotAccountRecord> listahar = new ArrayList();
        /* 364 */
        List<AppColdAccountRecord> listacar = new ArrayList();
        /* 365 */
        List<ExDmHotAccountRecord> listehar = new ArrayList();
        /* 366 */
        List<ExDmColdAccountRecord> listedcar = new ArrayList();
        /* 367 */
        if (null != accountaddSlistss) {
            /* 368 */
            for (Accountadd accountadd : accountaddSlistss) {
                /* 369 */
                if (accountadd.getAcccountType().equals(Integer.valueOf(0))) {
                    /* 370 */
                    AppAccount appAccount = (AppAccount) this.appAccountService.get(accountadd.getAccountId());
                    /* 371 */
                    if (null != appAccount) {
                        /* 372 */
                        if (accountadd.getMonteyType().equals(Integer.valueOf(1))) {
                            /* 373 */
                            if (accountadd.getMoney().compareTo(BigDecimal.ZERO) == -1) {
                                /* 374 */
                                AppHotAccountRecord appHotAccountRecord = this.appAccountService.createHotRecord(Integer.valueOf(2), appAccount, BigDecimal.ZERO.subtract(accountadd.getMoney()), accountadd.getTransactionNum(), accountadd.getRemarks());
                                /* 375 */
                                listahar.add(appHotAccountRecord);
                                /* 376 */
                            } else if (accountadd.getMoney().compareTo(BigDecimal.ZERO) == 1) {
                                /* 377 */
                                AppHotAccountRecord appHotAccountRecord = this.appAccountService.createHotRecord(Integer.valueOf(1), appAccount, accountadd.getMoney(), accountadd.getTransactionNum(), accountadd.getRemarks());
                                /* 378 */
                                listahar.add(appHotAccountRecord);

                            }


                        }
                        /* 382 */
                        else if (accountadd.getMoney().compareTo(BigDecimal.ZERO) == -1) {
                            /* 383 */
                            AppColdAccountRecord AppColdAccountRecord = this.appAccountService.createColdRecord(Integer.valueOf(2), appAccount, BigDecimal.ZERO.subtract(accountadd.getMoney()), accountadd.getTransactionNum(), accountadd.getRemarks());
                            /* 384 */
                            listacar.add(AppColdAccountRecord);
                            /* 385 */
                        } else if (accountadd.getMoney().compareTo(BigDecimal.ZERO) == 1) {
                            /* 386 */
                            AppColdAccountRecord AppColdAccountRecord = this.appAccountService.createColdRecord(Integer.valueOf(1), appAccount, accountadd.getMoney(), accountadd.getTransactionNum(), accountadd.getRemarks());
                            /* 387 */
                            listacar.add(AppColdAccountRecord);

                        }

                        /* 390 */
                        setaccount.add(appAccount.getId());

                    }

                } else {
                    /* 394 */
                    ExDigitalmoneyAccount exDigitalmoneyAccount = (ExDigitalmoneyAccount) this.exDigitalmoneyAccountService.get(accountadd.getAccountId());
                    /* 395 */
                    if (null != exDigitalmoneyAccount) {
                        /* 396 */
                        if (accountadd.getMonteyType().equals(Integer.valueOf(1))) {
                            /* 397 */
                            if (accountadd.getMoney().compareTo(BigDecimal.ZERO) == -1) {
                                /* 398 */
                                ExDmHotAccountRecord exDmHotAccountRecord = this.exDigitalmoneyAccountService.createHotRecord(Integer.valueOf(2), exDigitalmoneyAccount, BigDecimal.ZERO.subtract(accountadd.getMoney()), accountadd.getTransactionNum(), accountadd.getRemarks());
                                /* 399 */
                                listehar.add(exDmHotAccountRecord);
                                /* 400 */
                            } else if (accountadd.getMoney().compareTo(BigDecimal.ZERO) == 1) {
                                /* 401 */
                                ExDmHotAccountRecord exDmHotAccountRecord = this.exDigitalmoneyAccountService.createHotRecord(Integer.valueOf(1), exDigitalmoneyAccount, accountadd.getMoney(), accountadd.getTransactionNum(), accountadd.getRemarks());
                                /* 402 */
                                listehar.add(exDmHotAccountRecord);

                            }

                        }
                        /* 405 */
                        else if (accountadd.getMoney().compareTo(BigDecimal.ZERO) == -1) {
                            /* 406 */
                            ExDmColdAccountRecord exDmColdAccountRecord = this.exDigitalmoneyAccountService.createColdRecord(Integer.valueOf(2), exDigitalmoneyAccount, BigDecimal.ZERO.subtract(accountadd.getMoney()), accountadd.getTransactionNum(), accountadd.getRemarks());
                            /* 407 */
                            listedcar.add(exDmColdAccountRecord);
                            /* 408 */
                        } else if (accountadd.getMoney().compareTo(BigDecimal.ZERO) == 1) {
                            /* 409 */
                            ExDmColdAccountRecord exDmColdAccountRecord = this.exDigitalmoneyAccountService.createColdRecord(Integer.valueOf(1), exDigitalmoneyAccount, accountadd.getMoney(), accountadd.getTransactionNum(), accountadd.getRemarks());
                            /* 410 */
                            listedcar.add(exDmColdAccountRecord);

                        }


                        /* 414 */
                        setaccountcoin.add(exDigitalmoneyAccount.getId());

                    }

                }

            }

        }


        /* 421 */
        if ((null != listahar) && (listahar.size() > 0)) {
            /* 422 */
            this.appHotAccountRecordDao.insertRecord(listahar);

        }
        /* 424 */
        if ((null != listacar) && (listacar.size() > 0)) {
            /* 425 */
            this.appColdAccountRecordDao.insertRecord(listacar);

        }
        /* 427 */
        if ((null != listehar) && (listehar.size() > 0)) {
            /* 428 */
            this.exDmHotAccountRecordDao.insertRecord(listehar);

        }
        /* 430 */
        if ((null != listedcar) && (listedcar.size() > 0)) {
            /* 431 */
            this.exDmColdAccountRecordDao.insertRecord(listedcar);

        }




        /* 437 */
        Iterator<Long> iteratora = setaccount.iterator();
        /* 438 */
        List<AppAccountRedis> lista = new ArrayList();
        /* 439 */
        while (iteratora.hasNext()) {
            /* 440 */
            Long id = (Long) iteratora.next();
            /* 441 */
            AppAccountRedis appAccountredis = this.appAccountService.getAppAccountByRedis(id.toString());
            /* 442 */
            appAccountredis.setHotMoneyDouble(Double.valueOf(appAccountredis.getHotMoney().doubleValue()));
            /* 443 */
            appAccountredis.setColdMoneyDouble(Double.valueOf(appAccountredis.getColdMoney().doubleValue()));
            /* 444 */
            lista.add(appAccountredis);

        }
        /* 446 */
        if ((null != lista) && (lista.size() > 0)) {
            /* 447 */
            this.appAccountDao.updateAppAccount(lista);

        }
        /* 449 */
        Iterator<Long> iteratorc = setaccountcoin.iterator();
        /* 450 */
        List<ExDigitalmoneyAccountRedis> listd = new ArrayList();
        /* 451 */
        while (iteratorc.hasNext()) {
            /* 452 */
            Long id = (Long) iteratorc.next();
            /* 453 */
            ExDigitalmoneyAccountRedis exDigitalmoneyAccountredis = this.exDigitalmoneyAccountService.getExDigitalmoneyAccountByRedis(id.toString());
            /* 454 */
            exDigitalmoneyAccountredis.setHotMoneyDouble(Double.valueOf(exDigitalmoneyAccountredis.getHotMoney().doubleValue()));
            /* 455 */
            exDigitalmoneyAccountredis.setColdMoneyDouble(Double.valueOf(exDigitalmoneyAccountredis.getColdMoney().doubleValue()));
            /* 456 */
            listd.add(exDigitalmoneyAccountredis);

        }
        /* 458 */
        if ((null != listd) && (listd.size() > 0)) {
            /* 459 */
            this.exDigitalmoneyAccountDao.updateExDigitalmoneyAccount(listd);

        }




        /* 465 */
        Iterator<String> iteratorTradeDealAccountChangedelete = keysTradeDealAccountChange.iterator();
        /* 466 */
        while (iteratorTradeDealAccountChangedelete.hasNext()) {
            /* 467 */
            String keystr = (String) iteratorTradeDealAccountChangedelete.next();
            /* 468 */
            this.redisService.delete(keystr);

        }
        /* 470 */
        long end = System.currentTimeMillis();
        /* 471 */
        long time = end - start;
        /* 472 */
        if (time > 800L) {
            /* 473 */
            LogFactory.info("accountredis（账户和资金流水）入库总耗时：" + time + "ms");

        }

    }


    public void reidsToMysqlmq() {
        /* 480 */
        MessageProducer messageProducer = (MessageProducer) ContextUtil.getBean("messageProducer");
        /* 481 */
        messageProducer.reidsToMysql("111");

    }


    public void reidsToredisLogmq() {
        /* 487 */
        MessageProducer messageProducer = (MessageProducer) ContextUtil.getBean("messageProducer");
        /* 488 */
        messageProducer.reidsToRedisLog("333");

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\impl\ExOrderInfoServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */