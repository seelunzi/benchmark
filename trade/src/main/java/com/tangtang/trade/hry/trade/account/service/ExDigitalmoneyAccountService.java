package com.tangtang.trade.hry.trade.account.service;

import hry.core.mvc.service.base.BaseService;
import hry.exchange.account.model.ExDigitalmoneyAccount;
import hry.exchange.account.model.ExDmColdAccountRecord;
import hry.exchange.account.model.ExDmHotAccountRecord;
import hry.trade.redis.model.ExDigitalmoneyAccountRedis;

import java.math.BigDecimal;

public abstract interface ExDigitalmoneyAccountService
        extends BaseService<ExDigitalmoneyAccount, Long> {
    public abstract ExDigitalmoneyAccountRedis getExDigitalmoneyAccountByRedis(String paramString);

    public abstract void setExDigitalmoneyAccounttoRedis(ExDigitalmoneyAccountRedis paramExDigitalmoneyAccountRedis);

    public abstract ExDmColdAccountRecord createColdRecord(Integer paramInteger1, ExDigitalmoneyAccount paramExDigitalmoneyAccount, BigDecimal paramBigDecimal, String paramString, Integer paramInteger2);

    public abstract ExDmHotAccountRecord createHotRecord(Integer paramInteger1, ExDigitalmoneyAccount paramExDigitalmoneyAccount, BigDecimal paramBigDecimal, String paramString, Integer paramInteger2);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\ExDigitalmoneyAccountService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */