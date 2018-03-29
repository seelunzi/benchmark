package com.tangtang.trade.hry.trade.account.dao;

import hry.core.mvc.dao.base.BaseDao;
import hry.exchange.account.model.ExDmHotAccountRecord;

import java.util.List;

public abstract interface ExDmHotAccountRecordDao
        extends BaseDao<ExDmHotAccountRecord, Long> {
    public abstract void insertRecord(List<ExDmHotAccountRecord> paramList);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\dao\ExDmHotAccountRecordDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */