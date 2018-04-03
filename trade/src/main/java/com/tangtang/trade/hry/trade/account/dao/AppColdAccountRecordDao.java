package com.tangtang.trade.hry.trade.account.dao;

import hry.account.fund.model.AppColdAccountRecord;
import hry.core.mvc.dao.base.BaseDao;

import java.util.List;

public interface AppColdAccountRecordDao
        extends BaseDao<AppColdAccountRecord, Long> {
    void insertRecord(List<AppColdAccountRecord> paramList);
}
