package com.tangtang.trade.hry.trade.account.service;

import hry.core.mvc.service.base.BaseService;
import hry.exchange.account.model.ExDmHotAccountRecord;

import java.util.List;

public abstract interface ExDmHotAccountRecordService
        extends BaseService<ExDmHotAccountRecord, Long> {
    public abstract ExDmHotAccountRecord findByAccountId(Long paramLong);

    public abstract List<ExDmHotAccountRecord> findHotAccountRecordBytransactionNum(String paramString);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\ExDmHotAccountRecordService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */