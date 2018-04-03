
package com.tangtang.trade.hry.trade.entrust.service.impl;


import com.alibaba.fastjson.JSON;
import hry.core.mvc.dao.base.BaseDao;
import hry.core.mvc.service.base.impl.BaseServiceImpl;
import hry.core.util.QueryFilter;
import hry.core.util.idgenerate.IdGenerate;
import hry.core.util.properties.PropertiesUtils;
import hry.core.util.sys.ContextUtil;
import hry.customer.user.model.AppCustomer;
import hry.exchange.product.model.ExCointoCoin;
import hry.front.redis.model.UserRedis;
import hry.redis.common.dao.RedisUtil;
import hry.redis.common.utils.RedisService;
import hry.redis.common.utils.RedisTradeService;
import hry.trade.MQmanager.MQEnter;
import hry.trade.entrust.dao.CommonDao;
import hry.trade.entrust.dao.ExEntrustDao;
import hry.trade.entrust.model.ExEntrust;
import hry.trade.entrust.model.ExOrderInfo;
import hry.trade.entrust.service.ExEntrustService;
import hry.trade.entrust.service.ExOrderInfoService;
import hry.trade.entrust.service.ExOrderService;
import hry.trade.model.CoinKeepDecimal;
import hry.trade.model.TradeRedis;
import hry.trade.mq.service.MessageProducer;
import hry.trade.redis.model.EntrustTrade;
import hry.trade.websoketContext.model.MarketDepths;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;


@Service("exEntrustService")
public class ExEntrustServiceImpl
        extends BaseServiceImpl<ExEntrust, Long>
        implements ExEntrustService {

    @Resource
    private ExOrderInfoService exOrderInfoService;

    @Resource
    private ExOrderService exOrderService;

    @Resource
    public RedisService redisService;

    @Resource
    public CommonDao commonDao;

    @Resource
    public ExEntrustDao exEntrustDao;



    @Resource(name = "exEntrustDao")
    public void setDao(BaseDao<ExEntrust, Long> dao) {
        /*  71 */
        this.dao = dao;

    }


    public void initTradeRedis() {
        /*  87 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*  88 */
        ExEntrustService exEntrustService = (ExEntrustService) ContextUtil.getBean("exEntrustService");



        /*  92 */
        List<ExCointoCoin> listExCointoCoin = this.commonDao.getExointocoinValid();
        /*  93 */
        for (ExCointoCoin exCointoCoin : listExCointoCoin) {
            /*  94 */
            String header = getHeader(exCointoCoin.getCoinCode(), exCointoCoin.getFixPriceCoinCode());
            /*  95 */
            this.exOrderService.setLastExchangPrice(header);
            /*  96 */
            this.exOrderService.setCurrentExchangPrice(header);

        }

    }


    public void tradeInit() {
        /* 104 */
        RedisTradeService redisTradeService = (RedisTradeService) ContextUtil.getBean("redisTradeService");

        /* 106 */
        redisTradeService.delkeys(":buy:");
        /* 107 */
        redisTradeService.delkeys(":sell:");


        /* 110 */
        List<ExCointoCoin> listExCointoCoin = this.commonDao.getExointocoinValid();
        /* 111 */
        for (ExCointoCoin exCointoCoin : listExCointoCoin) {
            /* 112 */
            String header = getHeader(exCointoCoin.getCoinCode(), exCointoCoin.getFixPriceCoinCode());

            /* 114 */
            QueryFilter filterbuy = new QueryFilter(ExEntrust.class);
            /* 115 */
            filterbuy.addFilter("status<", Integer.valueOf(2));
            /* 116 */
            filterbuy.addFilter("type=", Integer.valueOf(1));
            /* 117 */
            filterbuy.addFilter("coinCode=", exCointoCoin.getCoinCode());
            /* 118 */
            filterbuy.addFilter("fixPriceCoinCode=", exCointoCoin.getFixPriceCoinCode());
            /* 119 */
            filterbuy.setOrderby("entrustPrice desc");
            /* 120 */
            List<ExEntrust> listbuy = find(filterbuy);
            /* 121 */
            List<EntrustTrade> listbuypricesame = new ArrayList();
            /* 122 */
            String buyonePricekey = header + ":" + "buyonePrice";
            /* 123 */
            if ((null != listbuy) && (listbuy.size() > 0)) {
                /* 124 */
                BigDecimal sameprice = ((ExEntrust) listbuy.get(0)).getEntrustPrice();
                /* 125 */
                EntrustTrade entrustTrade = null;
                /* 126 */
                for (ExEntrust l : listbuy) {
                    /* 127 */
                    String exentrust = JSON.toJSONString(l);
                    /* 128 */
                    entrustTrade = (EntrustTrade) JSON.parseObject(exentrust, EntrustTrade.class);
                    /* 129 */
                    if (l.getEntrustPrice().compareTo(sameprice) == 0) {
                        /* 130 */
                        listbuypricesame.add(entrustTrade);

                    } else {
                        /* 132 */
                        String key = getHeader(entrustTrade) + ":buy:" + sameprice.setScale(10, 6).toString();
                        /* 133 */
                        redisTradeService.save(key, JSON.toJSONString(listbuypricesame));
                        /* 134 */
                        listbuypricesame = new ArrayList();
                        /* 135 */
                        listbuypricesame.add(entrustTrade);
                        /* 136 */
                        sameprice = l.getEntrustPrice();

                    }

                }
                /* 139 */
                String key = header + ":buy:" + sameprice.setScale(10, 6).toString();
                /* 140 */
                redisTradeService.save(key, JSON.toJSONString(listbuypricesame));


                /* 143 */
                this.redisService.save(buyonePricekey, JSON.toJSONString(((ExEntrust) listbuy.get(0)).getEntrustPrice()));

            } else {
                /* 145 */
                this.redisService.delete(buyonePricekey);

            }



            /* 150 */
            QueryFilter filtersell = new QueryFilter(ExEntrust.class);
            /* 151 */
            filtersell.addFilter("status<", Integer.valueOf(2));
            /* 152 */
            filtersell.addFilter("type=", Integer.valueOf(2));
            /* 153 */
            filtersell.addFilter("coinCode=", exCointoCoin.getCoinCode());
            /* 154 */
            filtersell.addFilter("fixPriceCoinCode=", exCointoCoin.getFixPriceCoinCode());
            /* 155 */
            filtersell.setOrderby("entrustPrice asc");
            /* 156 */
            List<ExEntrust> listsell = find(filtersell);
            /* 157 */
            List<EntrustTrade> listsellpricesame = new ArrayList();
            /* 158 */
            String sellonePricekey = header + ":" + "sellonePrice";
            /* 159 */
            if ((null != listsell) && (listsell.size() > 0)) {
                /* 160 */
                BigDecimal sameprice = ((ExEntrust) listsell.get(0)).getEntrustPrice();
                /* 161 */
                EntrustTrade entrustTrade = null;
                /* 162 */
                for (ExEntrust l : listsell) {
                    /* 163 */
                    String exentrust = JSON.toJSONString(l);
                    /* 164 */
                    entrustTrade = (EntrustTrade) JSON.parseObject(exentrust, EntrustTrade.class);
                    /* 165 */
                    if (l.getEntrustPrice().compareTo(sameprice) == 0) {
                        /* 166 */
                        listsellpricesame.add(entrustTrade);

                    } else {
                        /* 168 */
                        String key = getHeader(entrustTrade) + ":sell:" + sameprice.setScale(10, 6).toString();
                        /* 169 */
                        redisTradeService.save(key, JSON.toJSONString(listsellpricesame));
                        /* 170 */
                        listsellpricesame = new ArrayList();
                        /* 171 */
                        listsellpricesame.add(entrustTrade);
                        /* 172 */
                        sameprice = l.getEntrustPrice();

                    }

                }


                /* 177 */
                String key = header + ":sell:" + sameprice.setScale(10, 6).toString();
                /* 178 */
                redisTradeService.save(key, JSON.toJSONString(listsellpricesame));

                /* 180 */
                this.redisService.save(sellonePricekey, JSON.toJSONString(((ExEntrust) listsell.get(0)).getEntrustPrice()));

            } else {
                /* 182 */
                this.redisService.delete(sellonePricekey);

            }

        }

    }


    public void cancelAutoAddExEntrust() {
        /* 192 */
        Map<String, String> mapLoadWeb = PropertiesUtils.getLoadWeb();
        /* 193 */
        for (String Website : mapLoadWeb.keySet()) {
            /* 194 */
            List<ExCointoCoin> listExCointoCoin = this.commonDao.getExointocoinValid();
            /* 195 */
            for (ExCointoCoin exCointoCoin : listExCointoCoin) {
                /* 196 */
                String autoUsernames = exCointoCoin.getAutoUsername();
                /* 197 */
                Long customerId = exCointoCoin.getCustomerId();
                /* 198 */
                Integer isSratAuto = exCointoCoin.getIsSratAuto();
                /* 199 */
                Integer isFromChbtc = exCointoCoin.getIsFromChbtc();


                /* 202 */
                if (isSratAuto.equals(Integer.valueOf(1))) {
                    /* 203 */
                    String[] autoUsernameArr = null;
                    /* 204 */
                    if (null == customerId) {
                        /* 205 */
                        autoUsernameArr = autoUsernames.split(",");

                    }
                    /* 207 */
                    if (null == autoUsernameArr) break;
                    /* 208 */
                    for (String autoUsername : autoUsernameArr) {
                        /* 209 */
                        if (null == customerId) {
                            /* 210 */
                            AppCustomer customer = this.commonDao.getAppUserByuserName(autoUsername);
                            /* 211 */
                            if (null == autoUsername) {
                                /* 212 */
                                System.out.println("填写的手机号有误，请检查重试！");
                                /* 213 */
                                break;

                            }
                            /* 215 */
                            customerId = customer.getId();
                            /* 216 */
                            exCointoCoin.setCustomerId(customerId);

                        }

                        /* 219 */
                        if (isFromChbtc.equals(Integer.valueOf(0))) {
                            /* 221 */
                            EntrustTrade entrustTrade = new EntrustTrade();
                            /* 222 */
                            entrustTrade.setCustomerId(customerId);
                            /* 223 */
                            entrustTrade.setCoinCode(exCointoCoin.getCoinCode());
                            /* 224 */
                            entrustTrade.setFixPriceCoinCode(exCointoCoin.getFixPriceCoinCode());
                            /* 225 */
                            entrustTrade.setCancelKeepN(Integer.valueOf(10));

                            /* 227 */
                            String str = JSON.toJSONString(entrustTrade);
                            /* 228 */
                            MessageProducer messageProducer = (MessageProducer) ContextUtil.getBean("messageProducer");

                            /* 230 */
                            messageProducer.toTrade(str);

                        }

                    }

                }

            }

        }

    }


    /* 244 */   public static int entrustType = 1;


    public void autoAddExEntrust() {
        /* 250 */
        Map<String, String> mapLoadWeb = PropertiesUtils.getLoadWeb();
        /* 251 */
        for (String Website : mapLoadWeb.keySet()) {
            /* 252 */
            String currencyType = (String) mapLoadWeb.get(Website);
            /* 253 */
            List<ExCointoCoin> listExCointoCoin = this.commonDao.getExointocoinValid();
            /* 254 */
            max = 10;
            /* 255 */
            maxjs = 1;
            /* 256 */
            for (ExCointoCoin exCointoCoin : listExCointoCoin) {
                /* 257 */
                if (maxjs > max) {
                    /* 258 */
                    if (entrustType == 1) {
                        /* 260 */
                        entrustType = 2;

                    } else {
                        /* 262 */
                        entrustType = 1;

                    }
                    /* 264 */
                    return;

                }
                /* 266 */
                String autoUsernames = exCointoCoin.getAutoUsername();
                /* 267 */
                Long customerId = exCointoCoin.getCustomerId();
                /* 268 */
                BigDecimal autoCount = exCointoCoin.getAutoCount();
                /* 269 */
                BigDecimal autoCountFloat = exCointoCoin.getAutoCountFloat();
                /* 270 */
                BigDecimal autoPrice = exCointoCoin.getAutoPrice();
                /* 271 */
                BigDecimal autoPriceFloat = exCointoCoin.getAutoPriceFloat();
                /* 272 */
                Integer isSratAuto = exCointoCoin.getIsSratAuto();
                /* 273 */
                Integer isFromChbtc = exCointoCoin.getIsFromChbtc();
                /* 274 */
                Integer fixPriceType = exCointoCoin.getFixPriceType();
                /* 275 */
                if (isSratAuto.equals(Integer.valueOf(1))) {
                    /* 276 */
                    String[] autoUsernameArr = null;
                    /* 277 */
                    if (null == customerId) {
                        /* 278 */
                        autoUsernameArr = autoUsernames.split(",");

                    }
                    /* 280 */
                    if (null == autoUsernameArr) break;
                    /* 281 */
                    for (String autoUsername : autoUsernameArr) {
                        /* 283 */
                        AppCustomer customer = this.commonDao.getAppUserByuserName(autoUsername);
                        /* 284 */
                        if (null == autoUsername) {
                            /* 285 */
                            System.out.println("填写的手机号有误，请检查重试！");
                            /* 286 */
                            break;

                        }
                        /* 288 */
                        customerId = customer.getId();
                        /* 289 */
                        exCointoCoin.setCustomerId(customerId);

                        /* 291 */
                        maxjs++;
                        /* 292 */
                        if (isFromChbtc.equals(Integer.valueOf(0))) {



                            /* 297 */
                            for (int i = 0; i < 1; i++) {
                                /* 298 */
                                if (entrustType == 1) {
                                    /* 300 */
                                    BigDecimal buyautoPrice = getPrcie(exCointoCoin.getAtuoPriceType(), exCointoCoin.getUpFloatPer(), exCointoCoin.getCoinCode(), exCointoCoin.getFixPriceCoinCode(), autoPrice, autoPriceFloat);

                                    /* 302 */
                                    buyautoPrice = buyautoPrice.setScale(8, 5);

                                    /* 304 */
                                    BigDecimal buytrueNum = getPrcie(exCointoCoin.getAtuoPriceType(), exCointoCoin.getUpFloatPer(), exCointoCoin.getCoinCode(), exCointoCoin.getFixPriceCoinCode(), autoCount, autoCountFloat);

                                    /* 306 */
                                    buytrueNum = buytrueNum.setScale(8, 5);
                                    /* 307 */
                                    String coinCodebuy = exCointoCoin.getCoinCode() + "_" + exCointoCoin.getFixPriceCoinCode();
                                    /* 308 */
                                    addExEntrust(fixPriceType, Integer.valueOf(1), customerId, buyautoPrice, autoUsername, coinCodebuy, buytrueNum, "cny", "cn");

                                } else {
                                    /* 311 */
                                    BigDecimal sellautoPrice = getPrcie(exCointoCoin.getAtuoPriceType(), exCointoCoin.getUpFloatPer(), exCointoCoin.getCoinCode(), exCointoCoin.getFixPriceCoinCode(), autoPrice, autoPriceFloat);

                                    /* 313 */
                                    sellautoPrice = sellautoPrice.setScale(8, 5);

                                    /* 315 */
                                    BigDecimal selltrueNum = getPrcie(exCointoCoin.getAtuoPriceType(), exCointoCoin.getUpFloatPer(), exCointoCoin.getCoinCode(), exCointoCoin.getFixPriceCoinCode(), autoCount, autoCountFloat);

                                    /* 317 */
                                    selltrueNum = selltrueNum.setScale(8, 5);
                                    /* 318 */
                                    String coinCodesell = exCointoCoin.getCoinCode() + "_" + exCointoCoin.getFixPriceCoinCode();
                                    /* 319 */
                                    addExEntrust(fixPriceType, Integer.valueOf(2), customerId, sellautoPrice, autoUsername, coinCodesell, selltrueNum, "cny", "cn");

                                }

                            }

                        }

                    }

                }

            }

        }


        int max;


        int maxjs;


        /* 337 */
        if (entrustType == 1) {
            /* 339 */
            entrustType = 2;

        } else {
            /* 341 */
            entrustType = 1;

        }

    }


    public String addExEntrust(Integer fixPriceType, Integer type, Long customerId, BigDecimal price, String autoUsername, String coinCode, BigDecimal entrustCount, String currencyType, String website) {
        /* 377 */
        long start1 = System.currentTimeMillis();
        /* 378 */
        EntrustTrade exEntrust = new EntrustTrade();
        /* 379 */
        String[] rtd = coinCode.split("_");
        /* 380 */
        if (rtd.length == 1) {
            /* 381 */
            return "";

        }
        /* 383 */
        exEntrust.setFixPriceCoinCode(rtd[1]);
        /* 384 */
        exEntrust.setCoinCode(rtd[0]);

        /* 386 */
        exEntrust.setFixPriceType(fixPriceType);
        /* 387 */
        exEntrust.setType(type);
        /* 388 */
        exEntrust.setEntrustPrice(price);
        /* 389 */
        exEntrust.setEntrustCount(entrustCount);
        /* 390 */
        if ((price.compareTo(new BigDecimal(0)) == 0) || (entrustCount.compareTo(new BigDecimal(0)) == 0)) {
            /* 391 */
            return "";

        }
        /* 393 */
        exEntrust.setEntrustSum(new BigDecimal("0"));
        /* 394 */
        exEntrust.setEntrustWay(Integer.valueOf(1));
        /* 395 */
        exEntrust.setCustomerId(customerId);





        /* 401 */
        exEntrust.setSource(Integer.valueOf(2));
        /* 402 */
        exEntrust.setUserName(autoUsername);
        /* 403 */
        exEntrust.setTrueName("机器人");
        /* 404 */
        ExEntrustService exEntrustService = (ExEntrustService) ContextUtil.getBean("exEntrustService");
        /* 405 */
        initExEntrust(exEntrust);
        /* 406 */
        MQEnter.pushExEntrustMQ(exEntrust);
        /* 407 */
        return "";

    }


    public void initExEntrust(EntrustTrade exEntrust) {
        /* 411 */
        String saasId = PropertiesUtils.APP.getProperty("app.saasId");
        /* 412 */
        if (null == exEntrust.getEntrustTime()) {
            /* 413 */
            exEntrust.setEntrustTime(new Date());

        }

        /* 416 */
        exEntrust.setEntrustNum(IdGenerate.transactionNum("10"));


        /* 419 */
        if (exEntrust.getType().intValue() == 1) {
            /* 420 */
            exEntrust.setEntrustNum("WB" + UUID.randomUUID());

        } else {
            /* 422 */
            exEntrust.setEntrustNum("WS" + UUID.randomUUID());

        }
        /* 424 */
        exEntrust.setCustomerId(exEntrust.getCustomerId());

        /* 426 */
        RedisUtil<UserRedis> redisUtil = new RedisUtil(UserRedis.class);
        /* 427 */
        UserRedis userRedis = (UserRedis) redisUtil.get(exEntrust.getCustomerId().toString());

        /* 429 */
        if (exEntrust.getFixPriceType().equals(Integer.valueOf(0))) {
            /* 430 */
            exEntrust.setAccountId(userRedis.getAccountId());

        } else {
            /* 432 */
            exEntrust.setAccountId(userRedis.getDmAccountId(exEntrust.getFixPriceCoinCode()));

        }
        /* 434 */
        exEntrust.setCoinAccountId(userRedis.getDmAccountId(exEntrust.getCoinCode()));




        /* 439 */
        exEntrust.setStatus(Integer.valueOf(0));
        /* 440 */
        exEntrust.setTransactionSum(null == exEntrust.getTransactionSum() ? new BigDecimal("0") : exEntrust.getTransactionSum());
        /* 441 */
        exEntrust.setEntrustSum((null != exEntrust.getEntrustPrice()) && (null != exEntrust.getEntrustCount()) && (!new BigDecimal("0").equals(exEntrust.getEntrustPrice())) && (!new BigDecimal("0").equals(exEntrust.getEntrustCount())) ? exEntrust.getEntrustPrice().multiply(exEntrust.getEntrustCount()) : exEntrust.getEntrustSum());
        /* 442 */
        exEntrust.setEntrustCount(null == exEntrust.getEntrustCount() ? new BigDecimal("0") : exEntrust.getEntrustCount());
        /* 443 */
        exEntrust.setSurplusEntrustCount(exEntrust.getEntrustCount());
        /* 444 */
        if (null == exEntrust.getEntrustCount()) {
            /* 445 */
            exEntrust.setEntrustCount(new BigDecimal("0"));

        }
        /* 447 */
        if (null == exEntrust.getEntrustPrice()) {
            /* 448 */
            exEntrust.setEntrustPrice(new BigDecimal("0"));

        }
        /* 450 */
        exEntrust.setTransactionFeeRate(new BigDecimal("0"));
        /* 451 */
        exEntrust.setTransactionFee(new BigDecimal("0"));

        /* 453 */
        if (null == exEntrust.getEntrustWay()) {
            /* 455 */
            exEntrust.setEntrustWay(Integer.valueOf(1));

        }
        /* 457 */
        if (null == exEntrust.getFloatDownPrice()) {
            /* 458 */
            exEntrust.setFloatDownPrice(new BigDecimal("0"));
            /* 459 */
            if ((exEntrust.getEntrustWay().intValue() == 1) && (exEntrust.getType().intValue() == 1)) {
                /* 460 */
                exEntrust.setFloatDownPrice(exEntrust.getEntrustPrice());

            }
            /* 462 */
            if ((exEntrust.getEntrustWay().intValue() == 1) && (exEntrust.getType().intValue() == 2)) {
                /* 463 */
                exEntrust.setFloatUpPrice(new BigDecimal("999999"));

            }

        }
        /* 466 */
        if (null == exEntrust.getFloatUpPrice()) {
            /* 468 */
            exEntrust.setFloatUpPrice(new BigDecimal("0"));

        }

    }


    public BigDecimal getPrcie(Integer atuoPriceType, BigDecimal upFloatPer, String coinCode, String fixPriceCoinCode, BigDecimal number, BigDecimal floatNum) {
        /* 491 */
        if (atuoPriceType.intValue() == 1) {
            /* 492 */
            return getFloatNum1(number, floatNum)[1];

        }

        /* 495 */
        String currentPrice = TradeRedis.getStringData(coinCode + "_" + fixPriceCoinCode + ":" + "currentExchangPrice");
        /* 496 */
        if (!StringUtil.isEmpty(currentPrice)) {
            /* 497 */
            BigDecimal[] price = getFloatNum1(new BigDecimal(currentPrice), floatNum);
            /* 498 */
            if (price[0].compareTo(new BigDecimal(1)) == 0) {
                /* 499 */
                return price[1].multiply(upFloatPer);

            }
            /* 501 */
            return price[1];

        }


        /* 505 */
        return null;

    }


    public BigDecimal[] getFloatNum1(BigDecimal number, BigDecimal floatNum) {
        /* 512 */
        BigDecimal[] price = new BigDecimal[2];
        /* 513 */
        BigDecimal truePrice = number;

        /* 515 */
        double num = Math.random();
        /* 516 */
        BigDecimal fudongNum = number.multiply(floatNum).divide(new BigDecimal("100")).multiply(new BigDecimal(num));

        /* 518 */
        int number1 = (int) (Math.random() * 2.0D);
        /* 519 */
        if (number1 == 0) {
            /* 520 */
            truePrice = number.subtract(fudongNum);
            /* 521 */
            price[0] = new BigDecimal(-1);

        } else {
            /* 523 */
            truePrice = number.add(fudongNum);
            /* 524 */
            price[0] = new BigDecimal(1);

        }
        /* 526 */
        price[1] = truePrice;
        /* 527 */
        return price;

    }


    public String getHeader(String coinCode, String fixPriceCoinCode) {
        /* 532 */
        String header = coinCode + "_" + fixPriceCoinCode;
        /* 533 */
        return header;

    }


    public String getHeader(EntrustTrade exEntrust) {
        /* 538 */
        String header = exEntrust.getCoinCode() + "_" + exEntrust.getFixPriceCoinCode();
        /* 539 */
        return header;

    }


    public String getHeader(ExOrderInfo exEntrust) {
        /* 544 */
        String header = exEntrust.getCoinCode() + "_" + exEntrust.getFixPriceCoinCode();
        /* 545 */
        return header;

    }


    public ExEntrust getExEntrustByentrustNum(String entrustNum) {
        /* 550 */
        QueryFilter filter = new QueryFilter(ExEntrust.class);
        /* 551 */
        filter.addFilter("entrustNum=", entrustNum);
        /* 552 */
        filter.setSaasId("hurong_system");
        /* 553 */
        return (ExEntrust) get(filter);

    }


    public String getExEntrustChangeMarket(String coinCode, String fixPriceCoinCode, Integer n) {
        /* 559 */
        MarketDepths marketDepths = new MarketDepths();
        /* 560 */
        Map<String, List<BigDecimal[]>> map = new HashMap();
        /* 561 */
        int keepDecimalForCoin = 4;
        /* 562 */
        int keepDecimalForCurrency = 4;

        /* 564 */
        CoinKeepDecimal coinKeepDecimal = null;
        /* 565 */
        String str = this.redisService.get("cn:coinInfoList");
        /* 566 */
        if (!StringUtils.isEmpty(str)) {
            /* 567 */
            List<CoinKeepDecimal> coins = JSON.parseArray(str, CoinKeepDecimal.class);
            /* 568 */
            if ((coins != null) && (coins.size() > 0)) {
                /* 569 */
                for (CoinKeepDecimal coin : coins) {
                    /* 570 */
                    if ((coinCode.equals(coin.getCoinCode())) && (fixPriceCoinCode.equals(coin.getFixPriceCoinCode()))) {
                        /* 571 */
                        coinKeepDecimal = coin;

                    }

                }

            }

        }
        /* 576 */
        if (null != coinKeepDecimal) {
            /* 577 */
            keepDecimalForCoin = coinKeepDecimal.getKeepDecimalForCoin().intValue();
            /* 578 */
            keepDecimalForCurrency = coinKeepDecimal.getKeepDecimalForCurrency().intValue();

        }

        /* 581 */
        List<BigDecimal[]> bids = new ArrayList();
        /* 582 */
        EntrustTrade sellexEntrust = new EntrustTrade();
        /* 583 */
        sellexEntrust.setCoinCode(coinCode);
        /* 584 */
        sellexEntrust.setFixPriceCoinCode(fixPriceCoinCode);
        /* 585 */
        sellexEntrust.setType(Integer.valueOf(2));
        /* 586 */
        List<BigDecimal> keyslistbuy = TradeRedis.getMatchkeys(sellexEntrust);
        /* 587 */
        int i = 0;
        /* 588 */
        while (i < keyslistbuy.size()) {
            /* 589 */
            BigDecimal keybig = (BigDecimal) keyslistbuy.get(i);
            /* 590 */
            String keyall = TradeRedis.getHeaderMatch(sellexEntrust) + ":" + keybig.toString();
            /* 591 */
            List<EntrustTrade> list = TradeRedis.getMatchEntrustTradeBykey(keyall);
            /* 592 */
            BigDecimal entrustPrice = new BigDecimal("0");
            /* 593 */
            BigDecimal surplusEntrustCount = new BigDecimal("0");
            /* 594 */
            if (null != list) {
                /* 595 */
                for (EntrustTrade entrustTrade : list) {
                    /* 596 */
                    entrustPrice = entrustTrade.getEntrustPrice();
                    /* 597 */
                    surplusEntrustCount = surplusEntrustCount.add(entrustTrade.getSurplusEntrustCount());

                }
                /* 599 */
                BigDecimal[] array = new BigDecimal[2];
                /* 600 */
                array[0] = entrustPrice.setScale(keepDecimalForCurrency, 6);
                /* 601 */
                array[1] = surplusEntrustCount.setScale(keepDecimalForCoin, 6);
                /* 602 */
                bids.add(array);

            }

            /* 605 */
            if (i == n.intValue())
                break;
            /* 607 */
            i++;

        }

        /* 610 */
        map.put("bids", bids);
        /* 611 */
        if (keyslistbuy.size() > 0) {
            /* 612 */
            String keybuy = TradeRedis.getHeaderFront(sellexEntrust) + ":" + "buyonePrice";
            /* 613 */
            String v = this.redisService.get(keybuy);
            /* 614 */
            if (StringUtil.isEmpty(v)) {
                /* 615 */
                this.redisService.save(keybuy, JSON.toJSONString(((BigDecimal[]) bids.get(0))[0]));

            }

        }

        /* 619 */
        List<BigDecimal[]> asks = new ArrayList();
        /* 620 */
        EntrustTrade byllexEntrust = new EntrustTrade();
        /* 621 */
        byllexEntrust.setCoinCode(coinCode);
        /* 622 */
        byllexEntrust.setFixPriceCoinCode(fixPriceCoinCode);
        /* 623 */
        byllexEntrust.setType(Integer.valueOf(1));
        /* 624 */
        List<BigDecimal> keyslistsell = TradeRedis.getMatchkeys(byllexEntrust);
        /* 625 */
        int k = 0;
        /* 626 */
        while (k < keyslistsell.size()) {
            /* 627 */
            BigDecimal keybig = (BigDecimal) keyslistsell.get(k);
            /* 628 */
            String keyall = TradeRedis.getHeaderMatch(byllexEntrust) + ":" + keybig.toString();
            /* 629 */
            List<EntrustTrade> list = TradeRedis.getMatchEntrustTradeBykey(keyall);
            /* 630 */
            BigDecimal entrustPrice = new BigDecimal("0");
            /* 631 */
            BigDecimal surplusEntrustCount = new BigDecimal("0");
            /* 632 */
            if (null != list) {
                /* 633 */
                for (EntrustTrade entrustTrade : list) {
                    /* 634 */
                    entrustPrice = entrustTrade.getEntrustPrice();
                    /* 635 */
                    surplusEntrustCount = surplusEntrustCount.add(entrustTrade.getSurplusEntrustCount());

                }
                /* 637 */
                BigDecimal[] array = new BigDecimal[2];
                /* 638 */
                array[0] = entrustPrice.setScale(keepDecimalForCurrency, 6);
                /* 639 */
                array[1] = surplusEntrustCount.setScale(keepDecimalForCoin, 6);
                /* 640 */
                asks.add(array);

            }
            /* 642 */
            if (k == n.intValue())
                break;
            /* 644 */
            k++;

        }
        /* 646 */
        map.put("asks", asks);
        /* 647 */
        if (keyslistsell.size() > 0) {
            /* 648 */
            String keysell = TradeRedis.getHeaderFront(byllexEntrust) + ":" + "sellonePrice";
            /* 649 */
            String v = this.redisService.get(keysell);
            /* 650 */
            if (StringUtil.isEmpty(v)) {
                /* 651 */
                this.redisService.save(keysell, JSON.toJSONString(((BigDecimal[]) asks.get(0))[0]));

            }

        }

        /* 655 */
        marketDepths.setDepths(map);
        /* 656 */
        return JSON.toJSONString(marketDepths).toString();

    }


    public BigDecimal getByn(int n) {
        /* 660 */
        BigDecimal bd = new BigDecimal(1);
        /* 661 */
        for (int i = 0; i < n; i++) {
            /* 662 */
            bd = bd.multiply(new BigDecimal(10));

        }
        /* 664 */
        return bd;

    }


    public String getExEntrustChangeDephMarket(String coinCode, String fixPriceCoinCode, Integer n, BigDecimal jj) {
        /* 669 */
        MarketDepths marketDepths = new MarketDepths();
        /* 670 */
        Map<String, List<BigDecimal[]>> map = new HashMap();
        /* 671 */
        int keepDecimalForCoin = 4;
        /* 672 */
        int keepDecimalForCurrency = 4;

        /* 674 */
        CoinKeepDecimal coinKeepDecimal = null;
        /* 675 */
        String str = this.redisService.get("cn:coinInfoList");
        /* 676 */
        if (!StringUtils.isEmpty(str)) {
            /* 677 */
            List<CoinKeepDecimal> coins = JSON.parseArray(str, CoinKeepDecimal.class);
            /* 678 */
            if ((coins != null) && (coins.size() > 0)) {
                /* 679 */
                for (CoinKeepDecimal coin : coins) {
                    /* 680 */
                    if ((coinCode.equals(coin.getCoinCode())) && (fixPriceCoinCode.equals(coin.getFixPriceCoinCode()))) {
                        /* 681 */
                        coinKeepDecimal = coin;

                    }

                }

            }

        }

        /* 687 */
        if (null != coinKeepDecimal) {
            /* 688 */
            keepDecimalForCoin = coinKeepDecimal.getKeepDecimalForCoin().intValue();
            /* 689 */
            keepDecimalForCurrency = coinKeepDecimal.getKeepDecimalForCurrency().intValue();

        }
        /* 691 */
        int keepDecimalForCurrencysubone = keepDecimalForCurrency - 1;
        /* 692 */
        if (keepDecimalForCurrencysubone < 0) {
            /* 693 */
            keepDecimalForCurrencysubone = 0;

        }
        /* 695 */
        BigDecimal depth = new BigDecimal(1).divide(getByn(keepDecimalForCurrencysubone), keepDecimalForCurrencysubone, 1);
        /* 696 */
        depth = depth.multiply(jj);
        /* 697 */
        List<BigDecimal[]> bids = new ArrayList();
        /* 698 */
        EntrustTrade sellexEntrust = new EntrustTrade();
        /* 699 */
        sellexEntrust.setCoinCode(coinCode);
        /* 700 */
        sellexEntrust.setFixPriceCoinCode(fixPriceCoinCode);
        /* 701 */
        sellexEntrust.setType(Integer.valueOf(2));
        /* 702 */
        List<BigDecimal> keyslistbuy = TradeRedis.getMatchkeys(sellexEntrust);
        /* 703 */
        if ((null != keyslistbuy) && (keyslistbuy.size() > 0)) {
            /* 704 */
            BigDecimal maxPrice = new BigDecimal(((BigDecimal) keyslistbuy.get(0)).toString());
            /* 705 */
            if (maxPrice.compareTo(BigDecimal.ZERO) > 0) {
                /* 706 */
                BigDecimal startPrice = maxPrice.setScale(depth.scale(), 1);
                /* 707 */
                startPrice = startPrice.subtract(depth);
                /* 708 */
                int i = 0;
                /* 709 */
                int flag = 0;
                /* 710 */
                for (int j = 0; j < 5; j++) {
                    /* 711 */
                    if (j > 0) {
                        /* 712 */
                        startPrice = startPrice.subtract(depth);

                    }
                    /* 714 */
                    if (flag == 1) {

                        break;

                    }
                    /* 717 */
                    if (startPrice.compareTo(new BigDecimal(0)) <= 0) {
                        /* 718 */
                        flag = 1;
                        /* 719 */
                        startPrice = new BigDecimal(0);

                    }
                    /* 721 */
                    BigDecimal surplusEntrustCount = new BigDecimal("0");
                    /* 722 */
                    while (i < keyslistbuy.size()) {
                        /* 723 */
                        BigDecimal keybig = (BigDecimal) keyslistbuy.get(i);
                        /* 724 */
                        if (keybig.compareTo(startPrice) < 0) break;
                        /* 725 */
                        String keyall = TradeRedis.getHeaderMatch(sellexEntrust) + ":" + keybig.toString();
                        /* 726 */
                        List<EntrustTrade> list = TradeRedis.getMatchEntrustTradeBykey(keyall);
                        /* 727 */
                        if (null != list) {
                            /* 728 */
                            for (EntrustTrade entrustTrade : list) {
                                /* 729 */
                                surplusEntrustCount = surplusEntrustCount.add(entrustTrade.getSurplusEntrustCount());

                            }

                        }
                        /* 732 */
                        i++;

                    }





                    /* 739 */
                    BigDecimal[] array = new BigDecimal[2];
                    /* 740 */
                    array[0] = startPrice.setScale(keepDecimalForCurrency, 6);
                    /* 741 */
                    array[1] = surplusEntrustCount.setScale(keepDecimalForCoin, 6);
                    /* 742 */
                    bids.add(array);

                }

            }

        }
        /* 746 */
        map.put("bids", bids);


        /* 749 */
        List<BigDecimal[]> asks = new ArrayList();
        /* 750 */
        EntrustTrade byllexEntrust = new EntrustTrade();
        /* 751 */
        byllexEntrust.setCoinCode(coinCode);
        /* 752 */
        byllexEntrust.setFixPriceCoinCode(fixPriceCoinCode);
        /* 753 */
        byllexEntrust.setType(Integer.valueOf(1));
        /* 754 */
        List<BigDecimal> keyslistsell = TradeRedis.getMatchkeys(byllexEntrust);
        /* 755 */
        if ((null != keyslistsell) && (keyslistsell.size() > 0)) {
            /* 756 */
            BigDecimal minPrice = new BigDecimal(((BigDecimal) keyslistsell.get(0)).toString());
            /* 757 */
            if (minPrice.compareTo(BigDecimal.ZERO) > 0) {
                /* 758 */
                BigDecimal startPrice = minPrice.setScale(depth.scale(), 1);
                /* 759 */
                startPrice = startPrice.add(depth);
                /* 760 */
                int k = 0;
                /* 761 */
                for (int j = 0; j < 5; j++) {
                    /* 762 */
                    if (j > 0) {
                        /* 763 */
                        startPrice = startPrice.add(depth);

                    }
                    /* 765 */
                    BigDecimal surplusEntrustCount = new BigDecimal("0");
                    /* 766 */
                    while (k < keyslistsell.size()) {
                        /* 767 */
                        BigDecimal keybig = (BigDecimal) keyslistsell.get(k);
                        /* 768 */
                        if (keybig.compareTo(startPrice) >= 1) break;
                        /* 769 */
                        String keyall = TradeRedis.getHeaderMatch(byllexEntrust) + ":" + keybig.toString();
                        /* 770 */
                        List<EntrustTrade> list = TradeRedis.getMatchEntrustTradeBykey(keyall);
                        /* 771 */
                        if (null != list) {
                            /* 772 */
                            for (EntrustTrade entrustTrade : list) {
                                /* 773 */
                                surplusEntrustCount = surplusEntrustCount.add(entrustTrade.getSurplusEntrustCount());

                            }

                        }
                        /* 776 */
                        k++;

                    }





                    /* 783 */
                    BigDecimal[] array = new BigDecimal[2];
                    /* 784 */
                    array[0] = startPrice.setScale(keepDecimalForCurrency, 6);
                    /* 785 */
                    array[1] = surplusEntrustCount.setScale(keepDecimalForCoin, 6);
                    /* 786 */
                    asks.add(array);

                }

            }

        }

        /* 791 */
        map.put("asks", asks);
        /* 792 */
        marketDepths.setDepths(map);
        /* 793 */
        return JSON.toJSONString(marketDepths).toString();

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\impl\ExEntrustServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */