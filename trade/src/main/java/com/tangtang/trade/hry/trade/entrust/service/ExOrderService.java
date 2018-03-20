package com.tangtang.trade.hry.trade.entrust.service;

import hry.core.mvc.service.base.BaseService;
import hry.trade.entrust.model.ExOrder;
import hry.trade.entrust.model.ExOrderInfo;

import java.math.BigDecimal;
import java.util.List;

public abstract interface ExOrderService
        extends BaseService<ExOrder, Long> {
    public abstract void setCurrentExchangPrice(String paramString);

    public abstract void setOpenedExchangPrice(String paramString, BigDecimal paramBigDecimal);

    public abstract void setLastExchangPrice(String paramString);

    public abstract void pushNewList(String paramString, Integer paramInteger);

    public abstract String getNewList(String paramString, Integer paramInteger);

    public abstract String getNewListMarket(String paramString1, String paramString2);

    public abstract String findNewListMarketnewAdd(String paramString1, String paramString2, String paramString3);

    public abstract List<ExOrder> exAveragePrice(String paramString);

    public abstract void setExchangeDataCache(ExOrderInfo paramExOrderInfo, ExOrder paramExOrder);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\ExOrderService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */