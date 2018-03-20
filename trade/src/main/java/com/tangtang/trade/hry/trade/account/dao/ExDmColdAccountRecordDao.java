package com.tangtang.trade.hry.trade.account.dao;

import hry.core.mvc.dao.base.BaseDao;
import hry.exchange.account.model.ExDmColdAccountRecord;

import java.util.List;

public abstract interface ExDmColdAccountRecordDao
        extends BaseDao<ExDmColdAccountRecord, Long> {
    public abstract void insertRecord(List<ExDmColdAccountRecord> paramList);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\dao\ExDmColdAccountRecordDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */