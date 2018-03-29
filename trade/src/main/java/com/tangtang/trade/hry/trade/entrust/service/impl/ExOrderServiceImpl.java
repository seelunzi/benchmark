/*     */
package com.tangtang.trade.hry.trade.entrust.service.impl;
/*     */
/*     */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import hry.core.mvc.dao.base.BaseDao;
import hry.core.mvc.service.base.impl.BaseServiceImpl;
import hry.core.util.SortList;
import hry.core.util.date.DateUtil;
import hry.redis.common.utils.RedisService;
import hry.trade.account.service.ExDigitalmoneyAccountService;
import hry.trade.entrust.dao.ExOrderDao;
import hry.trade.entrust.dao.ExOrderInfoDao;
import hry.trade.entrust.model.ExOrder;
import hry.trade.entrust.model.ExOrderInfo;
import hry.trade.entrust.service.ExEntrustService;
import hry.trade.entrust.service.ExOrderService;
import hry.trade.model.DifCustomer;
import hry.trade.model.TradeRedis;
import hry.trade.redis.model.ExchangeDataCacheRedis;
import hry.trade.websoketContext.PushData;
import hry.trade.websoketContext.model.MarketTrades;
import hry.trade.websoketContext.model.MarketTradesSelf;
import hry.trade.websoketContext.model.MarketTradesSub;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

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
@Service("exOrderService")
/*     */ public class ExOrderServiceImpl
        /*     */ extends BaseServiceImpl<ExOrder, Long>
        /*     */ implements ExOrderService
        /*     */ {
    /*     */
    @Resource
    /*     */ public RedisService redisService;
    /*     */
    @Resource
    /*     */ public ExDigitalmoneyAccountService exDigitalmoneyAccountService;
    /*     */
    @Resource
    /*     */ public ExEntrustService exEntrustService;
    /*     */
    @Resource
    /*     */ public ExOrderInfoDao exOrderInfoDao;

    /*     */
    /*     */
    @Resource(name = "exOrderDao")
    /*     */ public void setDao(BaseDao<ExOrder, Long> dao)
    /*     */ {
        /*  72 */
        this.dao = dao;
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
    public void setCurrentExchangPrice(String header)
    /*     */ {
        /*  86 */
        ExOrderDao exOrderDao = (ExOrderDao) this.dao;
        /*  87 */
        String[] headarry = header.split(":");
        /*  88 */
        Map<String, Object> map = new HashMap();
        /*  89 */
        map.put("website", headarry[0]);
        /*  90 */
        map.put("currencyType", headarry[1]);
        /*  91 */
        map.put("coinCode", headarry[2].split("_")[0]);
        /*  92 */
        map.put("fixPriceCoinCode", headarry[2].split("_")[1]);
        /*  93 */
        List<ExOrder> list = exOrderDao.getCurrentExchangPrice(map);
        /*  94 */
        if ((null != list) && (list.size() != 0)) {
            /*  95 */
            TradeRedis.setStringData(header + ":" + "currentExchangPrice", ((ExOrder) list.get(0)).getTransactionPrice().toString());
            /*  96 */
            TradeRedis.setStringData(header + ":" + "currentExchangDate", DateUtil.dateToString(((ExOrder) list.get(0)).getTransactionTime(), "yyyy-MM-dd").toString());
            /*  97 */
            TradeRedis.setStringData(header + ":" + "currentExchangTime", DateUtil.dateToString(((ExOrder) list.get(0)).getTransactionTime(), "yyyy-MM-dd HH:mm:ss").toString());
            /*     */
        } else {
            /*  99 */
            TradeRedis.setStringData(header + ":" + "currentExchangPrice", "0.00");
            /* 100 */
            TradeRedis.setStringData(header + ":" + "currentExchangDate", DateUtil.dateToString(new Date(), "yyyy-MM-dd").toString());
            /* 101 */
            TradeRedis.setStringData(header + ":" + "currentExchangTime", DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss").toString());
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    public void setLastExchangPrice(String header)
    /*     */ {
        /* 107 */
        ExOrderDao exOrderDao = (ExOrderDao) this.dao;
        /* 108 */
        String[] headarry = header.split(":");
        /* 109 */
        Map<String, Object> map = new HashMap();
        /* 110 */
        map.put("website", headarry[0]);
        /* 111 */
        map.put("currencyType", headarry[1]);
        /* 112 */
        map.put("coinCode", headarry[2].split("_")[0]);
        /* 113 */
        map.put("fixPriceCoinCode", headarry[2].split("_")[1]);
        /* 114 */
        List<ExOrder> list = exOrderDao.getLastExchangPrice(map);
        /*     */
        /* 116 */
        if ((null != list) && (list.size() != 0)) {
            /* 117 */
            if (list.size() == 2) {
                /* 118 */
                TradeRedis.setStringData(header + ":" + "lastExchangPrice", ((ExOrder) list.get(1)).getTransactionPrice().toString());
                /* 119 */
            } else if (list.size() == 1) {
                /* 120 */
                TradeRedis.setStringData(header + ":" + "lastExchangPrice", ((ExOrder) list.get(0)).getTransactionPrice().toString());
                /*     */
            }
            /*     */
        } else {
            /* 123 */
            TradeRedis.setStringData(header + ":" + "lastExchangPrice", "0.00");
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    public void setOpenedExchangPrice(String header, BigDecimal issuePrice)
    /*     */ {
        /* 129 */
        ExOrderDao exOrderDao = (ExOrderDao) this.dao;
        /* 130 */
        String[] headarry = header.split(":");
        /* 131 */
        Map<String, Object> map = new HashMap();
        /* 132 */
        map.put("website", headarry[0]);
        /* 133 */
        map.put("currencyType", headarry[1]);
        /* 134 */
        map.put("coinCode", headarry[2].split("_")[0]);
        /* 135 */
        map.put("fixPriceCoinCode", headarry[2].split("_")[1]);
        /* 136 */
        map.put("minDate", DateUtil.dateToString(new Date(), "yyyy-MM-dd 00:00:00"));
        /* 137 */
        List<ExOrder> list = exOrderDao.getOpenExchangPrice(map);
        /* 138 */
        if ((null != list) && (list.size() != 0)) {
            /* 139 */
            TradeRedis.setStringData(header + ":" + "openedExchangPrice", ((ExOrder) list.get(0)).getTransactionPrice().toString());
            /*     */
        }
        /*     */
        else {
            /* 142 */
            List<ExOrder> list1 = exOrderDao.getCurrentExchangPrice(map);
            /* 143 */
            if ((null != list1) && (list1.size() != 0)) {
                /* 144 */
                TradeRedis.setStringData(header + ":" + "openedExchangPrice", ((ExOrder) list1.get(0)).getTransactionPrice().toString());
                /*     */
            } else {
                /* 146 */
                TradeRedis.setStringData(header + ":" + "openedExchangPrice", issuePrice == null ? "0.00" : issuePrice.toString());
                /*     */
            }
            /*     */
        }
        /*     */
    }

    /*     */
    /*     */
    public void pushNewList(String header, Integer count)
    /*     */ {
        /* 153 */
        PushData.pushNewRecordList(getNewList(header, count), header);
        /* 154 */
        PushData.pushNewListRecordMarketAsc(getNewListMarket(header, "asc"), header);
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public String getNewList(String header, Integer count)
    /*     */ {
        /* 160 */
        if (null == count) {
            /* 161 */
            count = Integer.valueOf(10);
            /*     */
        }
        /* 163 */
        ExOrderDao exOrderDao = (ExOrderDao) this.dao;
        /* 164 */
        String[] headarry = header.split(":");
        /* 165 */
        Map<String, Object> seramap = new HashMap();
        /* 166 */
        seramap.put("website", headarry[0]);
        /* 167 */
        seramap.put("currencyType", headarry[1]);
        /* 168 */
        seramap.put("coinCode", headarry[2].split("_")[0]);
        /* 169 */
        seramap.put("fixPriceCoinCode", headarry[2].split("_")[1]);
        /* 170 */
        seramap.put("count", count);
        /* 171 */
        List<ExOrder> list = exOrderDao.findNewList(seramap);
        /* 172 */
        for (ExOrder l : list) {
            /* 173 */
            l.setTransactionPrice(l.getTransactionPrice().setScale(4, 4));
            /* 174 */
            l.setTransactionCount(l.getTransactionCount().setScale(4, 4));
            /*     */
        }
        /* 176 */
        MarketTradesSelf marketTrades = new MarketTradesSelf();
        /* 177 */
        marketTrades.setTrades(list);
        /* 178 */
        SimplePropertyPreFilter s = new SimplePropertyPreFilter(ExOrder.class, new String[]{"coinCode", "transactionTime", "transactionPrice", "transactionCount"});
        /* 179 */
        return JSON.toJSONString(marketTrades, s, new SerializerFeature[0]).toString();
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getNewListMarket(String header, String timeorder)
    /*     */ {
        /* 187 */
        String[] headarry = header.split("_");
        /* 188 */
        int keepDecimalForCoin = 8;
        /* 189 */
        int keepDecimalForCurrency = 8;
        /*     */
        /* 191 */
        String str = this.redisService.get("cn:coinInfoList");
        /* 192 */
        if (!StringUtils.isEmpty(str)) {
            /* 193 */
            JSONArray pa = JSON.parseArray(str);
            /* 194 */
            if (pa != null) {
                /* 195 */
                for (int i = 0; i < pa.size(); i++) {
                    /* 196 */
                    JSONObject obj = pa.getJSONObject(i);
                    /* 197 */
                    if (header.equals(obj.getString("coinCode") + "_" + obj.getString("fixPriceCoinCode"))) {
                        /* 198 */
                        keepDecimalForCoin = obj.getIntValue("keepDecimalForCoin");
                        /* 199 */
                        keepDecimalForCurrency = obj.getIntValue("keepDecimalForCurrency");
                        /* 200 */
                        break;
                        /*     */
                    }
                    /*     */
                }
                /*     */
            }
            /*     */
        }
        /*     */
        /* 206 */
        Map<String, Object> seramap = new HashMap();
        /* 207 */
        seramap.put("coinCode", headarry[0]);
        /* 208 */
        seramap.put("fixPriceCoinCode", headarry[1]);
        /* 209 */
        seramap.put("count", ExchangeDataCacheRedis.LastOrderRecordsLmit);
        /* 210 */
        List<ExOrderInfo> list = null;
        /* 211 */
        if (timeorder.equals("asc")) {
            /* 212 */
            String v = header + ":" + "LastOrderRecords";
            /* 213 */
            if (!StringUtil.isEmpty(v)) {
                /* 214 */
                list = this.exOrderInfoDao.findNewList(seramap);
                /* 215 */
                this.redisService.save(header + ":" + "LastOrderRecords", JSON.toJSONString(list));
                /*     */
            } else {
                /* 217 */
                list = JSON.parseArray(v, ExOrderInfo.class);
                /*     */
            }
            /*     */
        }
        /*     */
        else {
            /* 221 */
            String v = this.redisService.get(header + ":" + "LastOrderRecords");
            /* 222 */
            if (StringUtil.isEmpty(v)) {
                /* 223 */
                list = this.exOrderInfoDao.findNewListDesc(seramap);
                /* 224 */
                Collections.reverse(list);
                /* 225 */
                this.redisService.save(header + ":" + "LastOrderRecords", JSON.toJSONString(list));
                /*     */
            } else {
                /* 227 */
                list = JSON.parseArray(v, ExOrderInfo.class);
                /* 228 */
                Collections.reverse(list);
                /*     */
            }
            /*     */
        }
        /*     */
        /* 232 */
        List<MarketTradesSub> listsub = new ArrayList();
        /* 233 */
        for (ExOrderInfo l : list) {
            /* 234 */
            MarketTradesSub sub = new MarketTradesSub();
            /* 235 */
            sub.setAmount(l.getTransactionCount().setScale(keepDecimalForCoin, 4));
            /* 236 */
            sub.setPrice(l.getTransactionPrice().setScale(keepDecimalForCurrency, 4));
            /* 237 */
            sub.setTid(l.getOrderNum());
            /* 238 */
            sub.setType(l.getInOrOutTransaction());
            /* 239 */
            sub.setTime(l.getTransactionTime().getTime() / 1000L);
            /* 240 */
            listsub.add(sub);
            /*     */
        }
        /* 242 */
        SortList<MarketTradesSub> sort = new SortList();
        /* 243 */
        sort.Sort(listsub, "getTime", "desc");
        /* 244 */
        MarketTrades marketTrades = new MarketTrades();
        /* 245 */
        marketTrades.setTrades(listsub);
        /* 246 */
        return JSON.toJSONString(marketTrades).toString();
        /*     */
    }

    /*     */
    /*     */
    public String findNewListMarketnewAdd(String header, String minDate, String maxDate)
    /*     */ {
        /* 251 */
        ExOrderDao exOrderDao = (ExOrderDao) this.dao;
        /* 252 */
        String[] headarry = header.split(":");
        /* 253 */
        Map<String, Object> seramap = new HashMap();
        /* 254 */
        seramap.put("website", headarry[0]);
        /* 255 */
        seramap.put("currencyType", headarry[1]);
        /* 256 */
        seramap.put("coinCode", headarry[2].split("_")[0]);
        /* 257 */
        seramap.put("fixPriceCoinCode", headarry[2].split("_")[1]);
        /* 258 */
        seramap.put("minDate", minDate);
        /* 259 */
        seramap.put("maxDate", maxDate);
        /* 260 */
        List<ExOrder> list = new ArrayList();
        /* 261 */
        if (DifCustomer.isexOrderIsMemory().booleanValue()) {
            /* 262 */
            list = this.redisService.getList1(header + ":" + "LastOrderRecordAdds");
            /* 263 */
            if ((null == list) || (list.size() == 0)) {
                /* 264 */
                list = exOrderDao.findNewListnewAdd(seramap);
                /* 265 */
                this.redisService.setList(header + ":" + "LastOrderRecords", list);
                /*     */
            } else {
                /* 267 */
                Collections.reverse(list);
                /*     */
                /* 269 */
                this.redisService.setList(header + ":" + "LastOrderRecordAdds", new ArrayList());
                /*     */
            }
            /*     */
        }
        /*     */
        else {
            /* 273 */
            list = exOrderDao.findNewListnewAdd(seramap);
            /*     */
        }
        /* 275 */
        List<MarketTradesSub> listsub = new ArrayList();
        /* 276 */
        if ((null != list) && (list.size() > 0)) {
            /* 277 */
            for (ExOrder l : list) {
                /* 278 */
                MarketTradesSub sub = new MarketTradesSub();
                /* 279 */
                sub.setAmount(l.getTransactionCount().setScale(4, 4));
                /* 280 */
                sub.setPrice(l.getTransactionPrice().setScale(2, 4));
                /* 281 */
                sub.setTid(l.getOrderNum());
                /* 282 */
                sub.setType(l.getInOrOutTransaction());
                /* 283 */
                sub.setTime(l.getTransactionTime().getTime() / 1000L);
                /* 284 */
                listsub.add(sub);
                /*     */
            }
            /* 286 */
            MarketTrades marketTrades = new MarketTrades();
            /* 287 */
            marketTrades.setTrades(listsub);
            /* 288 */
            return JSON.toJSONString(marketTrades).toString();
            /*     */
        }
        /* 290 */
        return "";
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public List<ExOrder> exAveragePrice(String coinCode)
    /*     */ {
        /* 297 */
        ExOrderDao exOrderDao = (ExOrderDao) this.dao;
        /* 298 */
        return exOrderDao.exAveragePrice(coinCode);
        /*     */
    }

    /*     */
    /*     */
    public void setExchangeDataCache(ExOrderInfo exOrderInfo, ExOrder exOrder) {
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\impl\ExOrderServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */