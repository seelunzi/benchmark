package com.tangtang.trade.hry.trade.account.dao;

import hry.account.fund.model.AppHotAccountRecord;
import hry.core.mvc.dao.base.BaseDao;

import java.util.List;

public abstract interface AppHotAccountRecordDao
        extends BaseDao<AppHotAccountRecord, Long> {
    public abstract void insertRecord(List<AppHotAccountRecord> paramList);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\dao\AppHotAccountRecordDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */