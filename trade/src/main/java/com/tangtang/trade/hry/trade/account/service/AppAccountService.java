package com.tangtang.trade.hry.trade.account.service;

import hry.account.fund.model.AppAccount;
import hry.account.fund.model.AppColdAccountRecord;
import hry.account.fund.model.AppHotAccountRecord;
import hry.core.mvc.service.base.BaseService;
import hry.trade.redis.model.AppAccountRedis;

import java.math.BigDecimal;

public abstract interface AppAccountService
        extends BaseService<AppAccount, Long> {
    public abstract AppColdAccountRecord createColdRecord(Integer paramInteger1, AppAccount paramAppAccount, BigDecimal paramBigDecimal, String paramString, Integer paramInteger2);

    public abstract AppHotAccountRecord createHotRecord(Integer paramInteger1, AppAccount paramAppAccount, BigDecimal paramBigDecimal, String paramString, Integer paramInteger2);

    public abstract AppAccountRedis getAppAccountByRedis(String paramString);

    public abstract void setAppAccounttoRedis(AppAccountRedis paramAppAccountRedis);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\AppAccountService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */