package com.tangtang.trade.hry.trade.account.service;

import hry.core.mvc.service.base.BaseService;
import hry.exchange.account.model.ExDmColdAccountRecord;

import java.util.List;

public abstract interface ExDmColdAccountRecordService
        extends BaseService<ExDmColdAccountRecord, Long> {
    public abstract List<ExDmColdAccountRecord> findColdAccountRecordBytransactionNum(String paramString);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\ExDmColdAccountRecordService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */