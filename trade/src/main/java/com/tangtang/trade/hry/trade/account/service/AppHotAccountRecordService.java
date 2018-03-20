package com.tangtang.trade.hry.trade.account.service;

import hry.account.fund.model.AppAccount;
import hry.account.fund.model.AppHotAccountRecord;
import hry.core.mvc.service.base.BaseService;

import java.math.BigDecimal;

public abstract interface AppHotAccountRecordService
        extends BaseService<AppHotAccountRecord, Long> {
    public abstract void addHotRecord(BigDecimal paramBigDecimal, AppAccount paramAppAccount, int paramInt1, int paramInt2);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\AppHotAccountRecordService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */