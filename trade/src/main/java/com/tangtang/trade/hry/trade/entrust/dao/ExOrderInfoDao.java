package com.tangtang.trade.hry.trade.entrust.dao;

import hry.core.mvc.dao.base.BaseDao;
import hry.trade.entrust.model.ExOrderInfo;

import java.util.List;
import java.util.Map;

public abstract interface ExOrderInfoDao
        extends BaseDao<ExOrderInfo, Long> {
    public abstract void insertExorderInfos(List<ExOrderInfo> paramList);

    public abstract List<ExOrderInfo> findNewList(Map<String, Object> paramMap);

    public abstract List<ExOrderInfo> findNewListDesc(Map<String, Object> paramMap);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\dao\ExOrderInfoDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */