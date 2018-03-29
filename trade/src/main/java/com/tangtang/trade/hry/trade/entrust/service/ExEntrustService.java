package com.tangtang.trade.hry.trade.entrust.service;

import hry.core.mvc.service.base.BaseService;
import hry.trade.entrust.model.ExEntrust;
import hry.trade.entrust.model.ExOrderInfo;
import hry.trade.redis.model.EntrustTrade;

import java.math.BigDecimal;

public abstract interface ExEntrustService
        extends BaseService<ExEntrust, Long> {
    public abstract String getHeader(String paramString1, String paramString2);

    public abstract String getHeader(ExOrderInfo paramExOrderInfo);

    public abstract String getHeader(EntrustTrade paramEntrustTrade);

    public abstract ExEntrust getExEntrustByentrustNum(String paramString);

    public abstract void autoAddExEntrust();

    public abstract void cancelAutoAddExEntrust();

    public abstract String addExEntrust(Integer paramInteger1, Integer paramInteger2, Long paramLong, BigDecimal paramBigDecimal1, String paramString1, String paramString2, BigDecimal paramBigDecimal2, String paramString3, String paramString4);

    public abstract String getExEntrustChangeMarket(String paramString1, String paramString2, Integer paramInteger);

    public abstract void tradeInit();

    public abstract void initTradeRedis();

    public abstract String getExEntrustChangeDephMarket(String paramString1, String paramString2, Integer paramInteger, BigDecimal paramBigDecimal);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\ExEntrustService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */