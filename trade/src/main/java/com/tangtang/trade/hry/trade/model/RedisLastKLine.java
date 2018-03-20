/*     */
package com.tangtang.trade.hry.trade.model;
/*     */
/*     */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import hry.core.util.date.DateUtil;
import hry.core.util.sys.ContextUtil;
import hry.exchange.kline2.model.LastKLinePayload;
import hry.redis.common.utils.RedisService;
import hry.trade.entrust.model.ExOrderInfo;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
/*     */ public class RedisLastKLine
        /*     */ {
    /*     */
    public static void push24hours(List<ExOrderInfo> exOrderInfo)
    /*     */ {
        /*  33 */
        long splitTime = DateUtil.addDaysToDate(new Date(), -1).getTime();
        /*     */
        /*  35 */
        JedisPool jedisPool = (JedisPool) ContextUtil.getBean("jedisPool");
        /*  36 */
        Jedis jedis = jedisPool.getResource();
        /*     */
        /*     */
        /*  39 */
        ExOrderInfo order = (ExOrderInfo) exOrderInfo.get(exOrderInfo.size() - 1);
        /*     */
        /*  41 */
        String rediskey = order.getCoinCode() + "_" + order.getFixPriceCoinCode() + ":new24hours";
        /*  42 */
        String volkey = order.getCoinCode() + "_" + order.getFixPriceCoinCode() + ":new24hoursvol";
        /*  43 */
        String volstr = jedis.get(volkey);
        /*     */
        /*  45 */
        BigDecimal vol = new BigDecimal(0);
        /*  46 */
        if (!StringUtils.isEmpty(volstr)) {
            /*  47 */
            vol = new BigDecimal(volstr);
            /*     */
        }
        /*     */
        /*     */
        /*  51 */
        BigDecimal out = new BigDecimal(0);
        /*     */
        /*     */
        /*     */
        /*  55 */
        Long llen = jedis.llen(rediskey);
        /*     */
        /*     */
        /*  58 */
        long pageSize = 50L;
        /*     */
        /*  60 */
        if (llen.longValue() <= pageSize)
            /*     */ {
            /*  62 */
            List<String> list = jedis.lrange(rediskey, 0L, -1L);
            /*  63 */
            if ((list != null) && (list.size() > 0)) {
                /*  64 */
                int length = list.size() - 1;
                /*  65 */
                for (int i = length; i >= 0; i--) {
                    /*  66 */
                    String str = (String) list.get(i);
                    /*  67 */
                    JSONObject obj = JSON.parseObject(str);
                    /*  68 */
                    long longValue = obj.getLongValue("transactionTime");
                    /*  69 */
                    if (longValue >= splitTime) break;
                    /*  70 */
                    jedis.rpop(rediskey);
                    /*  71 */
                    out = out.add(new BigDecimal(obj.getLongValue("transactionSum")));
                    /*     */
                }
                /*     */
                /*     */
            }
            /*     */
            /*     */
        }
        /*     */
        else
            /*     */ {
            /*  79 */
            long page = 0L;
            /*  80 */
            if (llen.longValue() % pageSize == 0L) {
                /*  81 */
                page = llen.longValue() / pageSize;
                /*     */
            } else {
                /*  83 */
                page = llen.longValue() / pageSize + 1L;
                /*     */
            }
            /*  85 */
            for (int x = 1; x <= page; x++) {
                /*  86 */
                long start = x * pageSize * -1L;
                /*  87 */
                long end = -1L - (x - 1) * pageSize;
                /*     */
                /*     */
                /*  90 */
                List<String> list = jedis.lrange(rediskey, start, end);
                /*  91 */
                int length = list.size() - 1;
                /*  92 */
                for (int i = length; i >= 0; i--) {
                    /*  93 */
                    String str = (String) list.get(i);
                    /*  94 */
                    JSONObject obj = JSON.parseObject(str);
                    /*  95 */
                    long longValue = obj.getLongValue("transactionTime");
                    /*     */
                    /*  97 */
                    if (longValue >= splitTime) break label511;
                    /*  98 */
                    jedis.rpop(rediskey);
                    /*  99 */
                    out = out.add(new BigDecimal(obj.getLongValue("transactionSum")));
                    /*     */
                }
                /*     */
            }
            /*     */
        }
        /*     */
        /*     */
        /*     */
        /*     */
        /*     */
        label511:
        /*     */
        /*     */
        /*     */
        /* 111 */
        BigDecimal in = new BigDecimal(0);
        /*     */
        /*     */
        /* 114 */
        for (ExOrderInfo info : exOrderInfo) {
            /* 115 */
            JSONObject jsonObject = new JSONObject();
            /* 116 */
            jsonObject.put("transactionPrice", info.getTransactionPrice());
            /* 117 */
            jsonObject.put("transactionCount", info.getTransactionCount());
            /* 118 */
            jsonObject.put("transactionSum", info.getTransactionSum());
            /* 119 */
            jsonObject.put("transactionTime", Long.valueOf(info.getTransactionTime().getTime()));
            /* 120 */
            jsonObject.put("transactionTimeStr", DateUtil.dateToString(info.getTransactionTime()));
            /* 121 */
            jedis.lpush(rediskey, new String[]{jsonObject.toJSONString()});
            /* 122 */
            in = in.add(info.getTransactionSum());
            /*     */
        }
        /*     */
        /* 125 */
        vol = vol.add(in).subtract(out);
        /* 126 */
        jedis.set(volkey, vol.toString());
        /*     */
        /* 128 */
        jedis.close();
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
    public static void savePeriodLastKLineList(List<ExOrderInfo> exOrderInfo)
    /*     */ {
        /* 140 */
        if ((exOrderInfo == null) || (exOrderInfo.size() == 0)) {
            /* 141 */
            return;
            /*     */
        }
        /*     */
        /* 144 */
        push24hours(exOrderInfo);
        /*     */
        /*     */
        /* 147 */
        ExOrderInfo order = (ExOrderInfo) exOrderInfo.get(exOrderInfo.size() - 1);
        /*     */
        /* 149 */
        BigDecimal amout = new BigDecimal(0);
        /*     */
        /* 151 */
        BigDecimal totalMoney = new BigDecimal(0);
        /* 152 */
        if (exOrderInfo.size() > 1) {
            /* 153 */
            for (ExOrderInfo o : exOrderInfo) {
                /* 154 */
                amout = amout.add(o.getTransactionCount());
                /* 155 */
                totalMoney = totalMoney.add(o.getTransactionSum());
                /*     */
            }
            /*     */
        } else {
            /* 158 */
            amout = order.getTransactionCount();
            /* 159 */
            totalMoney = order.getTransactionSum();
            /*     */
        }
        /*     */
        /*     */
        /* 163 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /*     */
        /* 165 */
        String[] periods = {"1min", "5min", "15min", "30min", "60min", "1day", "1week", "1mon"};
        /*     */
        /*     */
        /* 168 */
        Map<String, Date> periodDate = DateUtil.getPeriodDate2(order.getTransactionTime());
        /*     */
        /*     */
        /* 171 */
        String redisList = redisService.get(order.getCoinCode() + "_" + order.getFixPriceCoinCode() + ":PeriodLastKLineList");
        /*     */
        /* 173 */
        List<LastKLinePayload> periodList = JSON.parseArray(redisList, LastKLinePayload.class);
        /*     */
        /*     */
        /* 176 */
        if (periodList == null) {
            /* 177 */
            periodList = new ArrayList();
            /* 178 */
            for (String p : periods) {
                /* 179 */
                LastKLinePayload lastKLinePayload = new LastKLinePayload();
                /* 180 */
                lastKLinePayload.setPeriod(p);
                /*     */
                /* 182 */
                lastKLinePayload.setPriceOpen(order.getTransactionPrice());
                /* 183 */
                lastKLinePayload.setPriceHigh(order.getTransactionPrice());
                /* 184 */
                lastKLinePayload.setPriceLow(order.getTransactionPrice());
                /* 185 */
                lastKLinePayload.setPriceLast(order.getTransactionPrice());
                /* 186 */
                lastKLinePayload.setAmount(amout);
                /* 187 */
                if ("1min".equals(p)) {
                    /* 188 */
                    lastKLinePayload.set_id(Long.valueOf(((Date) periodDate.get("1min")).getTime() / 1000L));
                    /*     */
                    /* 190 */
                    lastKLinePayload.setTime(Long.valueOf(((Date) periodDate.get("1min")).getTime() / 1000L));
                    /*     */
                    /* 192 */
                    lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("1min"), "yyyy-MM-dd HH:mm"));
                    /*     */
                    /* 194 */
                    lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("1min"), 1), "yyyy-MM-dd HH:mm"));
                    /*     */
                }
                /* 196 */
                if ("5min".equals(p)) {
                    /* 197 */
                    lastKLinePayload.set_id(Long.valueOf(((Date) periodDate.get("5min")).getTime() / 1000L));
                    /* 198 */
                    lastKLinePayload.setTime(Long.valueOf(((Date) periodDate.get("5min")).getTime() / 1000L));
                    /* 199 */
                    lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("5min"), "yyyy-MM-dd HH:mm"));
                    /* 200 */
                    lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("5min"), 5), "yyyy-MM-dd HH:mm"));
                    /*     */
                }
                /* 202 */
                if ("15min".equals(p)) {
                    /* 203 */
                    lastKLinePayload.set_id(Long.valueOf(((Date) periodDate.get("15min")).getTime() / 1000L));
                    /* 204 */
                    lastKLinePayload.setTime(Long.valueOf(((Date) periodDate.get("15min")).getTime() / 1000L));
                    /* 205 */
                    lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("15min"), "yyyy-MM-dd HH:mm"));
                    /* 206 */
                    lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("15min"), 15), "yyyy-MM-dd HH:mm"));
                    /*     */
                }
                /* 208 */
                if ("30min".equals(p)) {
                    /* 209 */
                    lastKLinePayload.set_id(Long.valueOf(((Date) periodDate.get("30min")).getTime() / 1000L));
                    /* 210 */
                    lastKLinePayload.setTime(Long.valueOf(((Date) periodDate.get("30min")).getTime() / 1000L));
                    /* 211 */
                    lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("30min"), "yyyy-MM-dd HH:mm"));
                    /* 212 */
                    lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("30min"), 30), "yyyy-MM-dd HH:mm"));
                    /*     */
                }
                /* 214 */
                if ("60min".equals(p)) {
                    /* 215 */
                    lastKLinePayload.set_id(Long.valueOf(((Date) periodDate.get("60min")).getTime() / 1000L));
                    /* 216 */
                    lastKLinePayload.setTime(Long.valueOf(((Date) periodDate.get("60min")).getTime() / 1000L));
                    /* 217 */
                    lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("60min"), "yyyy-MM-dd HH:mm"));
                    /* 218 */
                    lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("60min"), 60), "yyyy-MM-dd HH:mm"));
                    /*     */
                }
                /* 220 */
                if ("1day".equals(p)) {
                    /* 221 */
                    lastKLinePayload.set_id(Long.valueOf(((Date) periodDate.get("1day")).getTime() / 1000L));
                    /* 222 */
                    lastKLinePayload.setTime(Long.valueOf(((Date) periodDate.get("1day")).getTime() / 1000L));
                    /* 223 */
                    lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("1day"), "yyyy-MM-dd HH:mm"));
                    /* 224 */
                    lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addDaysToDate((Date) periodDate.get("1day"), 1), "yyyy-MM-dd HH:mm"));
                    /* 225 */
                    lastKLinePayload.setDayTotalDealAmount(new BigDecimal(0).add(order.getTransactionCount().multiply(order.getTransactionPrice())));
                    /*     */
                }
                /* 227 */
                if ("1week".equals(p)) {
                    /* 228 */
                    lastKLinePayload.set_id(Long.valueOf(((Date) periodDate.get("1week")).getTime() / 1000L));
                    /* 229 */
                    lastKLinePayload.setTime(Long.valueOf(((Date) periodDate.get("1week")).getTime() / 1000L));
                    /* 230 */
                    lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("1week"), "yyyy-MM-dd HH:mm"));
                    /* 231 */
                    lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addDaysToDate((Date) periodDate.get("1week"), 7), "yyyy-MM-dd HH:mm"));
                    /*     */
                }
                /* 233 */
                if ("1mon".equals(p)) {
                    /* 234 */
                    lastKLinePayload.set_id(Long.valueOf(((Date) periodDate.get("1mon")).getTime() / 1000L));
                    /* 235 */
                    lastKLinePayload.setTime(Long.valueOf(((Date) periodDate.get("1mon")).getTime() / 1000L));
                    /* 236 */
                    lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("1mon"), "yyyy-MM-dd HH:mm"));
                    /* 237 */
                    lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMonth((Date) periodDate.get("1mon"), 1), "yyyy-MM-dd HH:mm"));
                    /*     */
                }
                /* 239 */
                periodList.add(lastKLinePayload);
                /*     */
            }
            /* 241 */
            redisService.save(order.getCoinCode() + "_" + order.getFixPriceCoinCode() + ":PeriodLastKLineList", JSON.toJSONString(periodList));
            /*     */
        }
        /*     */
        else {
            /* 244 */
            for (LastKLinePayload lastKLinePayload : periodList) {
                /* 245 */
                String period = lastKLinePayload.getPeriod();
                /*     */
                /*     */
                /* 248 */
                LastKLinePayload lkp = new LastKLinePayload();
                /* 249 */
                lkp.setPriceOpen(lastKLinePayload.getPriceOpen());
                /* 250 */
                lkp.setPriceHigh(lastKLinePayload.getPriceHigh());
                /* 251 */
                lkp.setPriceLow(lastKLinePayload.getPriceLow());
                /* 252 */
                lkp.setPriceLast(lastKLinePayload.getPriceLast());
                /* 253 */
                lkp.setAmount(lastKLinePayload.getAmount());
                /* 254 */
                lkp.setStartTime(lastKLinePayload.getStartTime());
                /* 255 */
                lkp.setEndTime(lastKLinePayload.getEndTime());
                /* 256 */
                lkp.setPeriod(period);
                /*     */
                /*     */
                /* 259 */
                if ("1min".equals(period)) {
                    /* 260 */
                    boolean type = flushLastKlinePayLoad(periodDate, lastKLinePayload, order, amout, totalMoney, period);
                    /* 261 */
                    if (type) {
                        /* 262 */
                        backups(order, lkp, period);
                        /*     */
                    }
                    /*     */
                }
                /* 265 */
                if ("5min".equals(period)) {
                    /* 266 */
                    boolean type = flushLastKlinePayLoad(periodDate, lastKLinePayload, order, amout, totalMoney, period);
                    /* 267 */
                    if (type) {
                        /* 268 */
                        backups(order, lkp, period);
                        /*     */
                    }
                    /*     */
                }
                /* 271 */
                if ("15min".equals(period)) {
                    /* 272 */
                    boolean type = flushLastKlinePayLoad(periodDate, lastKLinePayload, order, amout, totalMoney, period);
                    /* 273 */
                    if (type) {
                        /* 274 */
                        backups(order, lkp, period);
                        /*     */
                    }
                    /*     */
                }
                /* 277 */
                if ("30min".equals(period)) {
                    /* 278 */
                    boolean type = flushLastKlinePayLoad(periodDate, lastKLinePayload, order, amout, totalMoney, period);
                    /* 279 */
                    if (type) {
                        /* 280 */
                        backups(order, lkp, period);
                        /*     */
                    }
                    /*     */
                }
                /* 283 */
                if ("60min".equals(period)) {
                    /* 284 */
                    boolean type = flushLastKlinePayLoad(periodDate, lastKLinePayload, order, amout, totalMoney, period);
                    /* 285 */
                    if (type) {
                        /* 286 */
                        backups(order, lkp, period);
                        /*     */
                    }
                    /*     */
                }
                /* 289 */
                if ("1day".equals(period)) {
                    /* 290 */
                    boolean type = flushLastKlinePayLoad(periodDate, lastKLinePayload, order, amout, totalMoney, period);
                    /* 291 */
                    if (type) {
                        /* 292 */
                        backups(order, lkp, period);
                        /*     */
                    }
                    /*     */
                }
                /* 295 */
                if ("1week".equals(period)) {
                    /* 296 */
                    boolean type = flushLastKlinePayLoad(periodDate, lastKLinePayload, order, amout, totalMoney, period);
                    /* 297 */
                    if (type) {
                        /* 298 */
                        backups(order, lkp, period);
                        /*     */
                    }
                    /*     */
                }
                /* 301 */
                if ("1mon".equals(period)) {
                    /* 302 */
                    boolean type = flushLastKlinePayLoad(periodDate, lastKLinePayload, order, amout, totalMoney, period);
                    /* 303 */
                    if (type) {
                        /* 304 */
                        backups(order, lkp, period);
                        /*     */
                    }
                    /*     */
                }
                /*     */
            }
            /*     */
            /*     */
            /* 310 */
            redisService.save(order.getCoinCode() + "_" + order.getFixPriceCoinCode() + ":PeriodLastKLineList", JSON.toJSONString(periodList));
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    public static void backups(ExOrderInfo order, LastKLinePayload lkp, String period)
    /*     */ {
        /* 316 */
        RedisService redisService = (RedisService) ContextUtil.getBean("redisService");
        /* 317 */
        String backup = redisService.get(order.getCoinCode() + "_" + order.getFixPriceCoinCode() + ":PeriodLastKLineList_backups");
        /* 318 */
        if (!StringUtils.isEmpty(backup)) {
            /* 319 */
            JSONObject obj = JSON.parseObject(backup);
            /* 320 */
            obj.put(period, lkp);
            /* 321 */
            redisService.save(order.getCoinCode() + "_" + order.getFixPriceCoinCode() + ":PeriodLastKLineList_backups", JSON.toJSONString(obj));
            /*     */
        } else {
            /* 323 */
            JSONObject obj = new JSONObject();
            /* 324 */
            obj.put(period, lkp);
            /* 325 */
            redisService.save(order.getCoinCode() + "_" + order.getFixPriceCoinCode() + ":PeriodLastKLineList_backups", JSON.toJSONString(obj));
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
    public static boolean flushLastKlinePayLoad(Map<String, Date> periodDate, LastKLinePayload lastKLinePayload, ExOrderInfo exOrderInfo, BigDecimal amout, BigDecimal totalMoney, String period)
    /*     */ {
        /* 342 */
        Date date = (Date) periodDate.get(period);
        /*     */
        /*     */
        /*     */
        /*     */
        /* 347 */
        if ("1day".equals(period)) {
            /* 348 */
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            /* 349 */
            String d1 = sdf.format(new Date(lastKLinePayload.getTime().longValue() * 1000L));
            /* 350 */
            String d2 = sdf.format(exOrderInfo.getTransactionTime());
            /* 351 */
            if (!d1.equals(d2)) {
                /* 352 */
                lastKLinePayload.setDayTotalDealAmount(totalMoney);
                /*     */
            }
            /*     */
            else {
                /* 355 */
                lastKLinePayload.setDayTotalDealAmount(lastKLinePayload.getDayTotalDealAmount().add(totalMoney));
                /*     */
            }
            /*     */
        }
        /*     */
        /*     */
        /*     */
        /* 361 */
        if (lastKLinePayload.getTime().compareTo(Long.valueOf(date.getTime() / 1000L)) == 0) {
            /* 362 */
            if (exOrderInfo.getTransactionPrice().compareTo(lastKLinePayload.getPriceHigh()) > 0) {
                /* 363 */
                lastKLinePayload.setPriceHigh(exOrderInfo.getTransactionPrice());
                /*     */
            }
            /* 365 */
            if (exOrderInfo.getTransactionPrice().compareTo(lastKLinePayload.getPriceLow()) < 0) {
                /* 366 */
                lastKLinePayload.setPriceLow(exOrderInfo.getTransactionPrice());
                /*     */
            }
            /* 368 */
            lastKLinePayload.setPriceLast(exOrderInfo.getTransactionPrice());
            /* 369 */
            lastKLinePayload.setAmount(lastKLinePayload.getAmount().add(amout));
            /*     */
            /*     */
            /* 372 */
            return false;
            /*     */
        }
        /*     */
        /* 375 */
        lastKLinePayload.setPriceOpen(exOrderInfo.getTransactionPrice());
        /* 376 */
        lastKLinePayload.setPriceHigh(exOrderInfo.getTransactionPrice());
        /* 377 */
        lastKLinePayload.setPriceLow(exOrderInfo.getTransactionPrice());
        /* 378 */
        lastKLinePayload.setPriceLast(exOrderInfo.getTransactionPrice());
        /* 379 */
        lastKLinePayload.setAmount(amout);
        /* 380 */
        lastKLinePayload.set_id(Long.valueOf(date.getTime() / 1000L));
        /* 381 */
        lastKLinePayload.setTime(Long.valueOf(date.getTime() / 1000L));
        /* 382 */
        if ("1min".equals(period)) {
            /* 383 */
            lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("1min"), "yyyy-MM-dd HH:mm"));
            /* 384 */
            lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("1min"), 1), "yyyy-MM-dd HH:mm"));
            /*     */
        }
        /* 386 */
        if ("5min".equals(period)) {
            /* 387 */
            lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("5min"), "yyyy-MM-dd HH:mm"));
            /* 388 */
            lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("5min"), 5), "yyyy-MM-dd HH:mm"));
            /*     */
        }
        /* 390 */
        if ("15min".equals(period)) {
            /* 391 */
            lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("15min"), "yyyy-MM-dd HH:mm"));
            /* 392 */
            lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("15min"), 15), "yyyy-MM-dd HH:mm"));
            /*     */
        }
        /* 394 */
        if ("30min".equals(period)) {
            /* 395 */
            lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("30min"), "yyyy-MM-dd HH:mm"));
            /* 396 */
            lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("30min"), 30), "yyyy-MM-dd HH:mm"));
            /*     */
        }
        /* 398 */
        if ("60min".equals(period)) {
            /* 399 */
            lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("60min"), "yyyy-MM-dd HH:mm"));
            /* 400 */
            lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMinToDate((Date) periodDate.get("60min"), 60), "yyyy-MM-dd HH:mm"));
            /*     */
        }
        /* 402 */
        if ("1day".equals(period)) {
            /* 403 */
            lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("1day"), "yyyy-MM-dd HH:mm"));
            /* 404 */
            lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addDaysToDate((Date) periodDate.get("1day"), 1), "yyyy-MM-dd HH:mm"));
            /*     */
        }
        /* 406 */
        if ("1week".equals(period)) {
            /* 407 */
            lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("1week"), "yyyy-MM-dd HH:mm"));
            /* 408 */
            lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addDaysToDate((Date) periodDate.get("1week"), 7), "yyyy-MM-dd HH:mm"));
            /*     */
        }
        /* 410 */
        if ("1mon".equals(period)) {
            /* 411 */
            lastKLinePayload.setStartTime(DateUtil.dateToString((Date) periodDate.get("1mon"), "yyyy-MM-dd HH:mm"));
            /* 412 */
            lastKLinePayload.setEndTime(DateUtil.dateToString(DateUtil.addMonth((Date) periodDate.get("1mon"), 1), "yyyy-MM-dd HH:mm"));
            /*     */
        }
        /*     */
        /*     */
        /*     */
        /* 417 */
        return true;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\model\RedisLastKLine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */