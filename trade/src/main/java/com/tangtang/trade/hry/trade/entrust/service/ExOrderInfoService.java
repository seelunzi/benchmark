package com.tangtang.trade.hry.trade.entrust.service;

import hry.core.mvc.service.base.BaseService;
import hry.trade.entrust.model.ExOrder;
import hry.trade.entrust.model.ExOrderInfo;
import hry.trade.redis.model.EntrustTrade;

import java.math.BigDecimal;

public abstract interface ExOrderInfoService
        extends BaseService<ExOrderInfo, Long> {
    public abstract ExOrderInfo createExOrderInfo(Integer paramInteger, EntrustTrade paramEntrustTrade1, EntrustTrade paramEntrustTrade2, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2);

    public abstract ExOrder createExOrder(ExOrderInfo paramExOrderInfo);

    public abstract void reidsToMysql();

    public abstract void reidsToredisLog();

    public abstract void reidsToMysqlmq();

    public abstract void reidsToredisLogmq();
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\service\ExOrderInfoService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */