package com.tangtang.trade.hry.trade.account.dao;

import hry.account.fund.model.AppColdAccountRecord;
import hry.core.mvc.dao.base.BaseDao;

import java.util.List;

public abstract interface AppColdAccountRecordDao
        extends BaseDao<AppColdAccountRecord, Long> {
    public abstract void insertRecord(List<AppColdAccountRecord> paramList);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\dao\AppColdAccountRecordDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */