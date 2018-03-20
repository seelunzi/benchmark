package com.tangtang.trade.hry.trade.entrust.dao;

import hry.core.mvc.dao.base.BaseDao;
import hry.trade.entrust.model.ExOrder;

import java.util.List;
import java.util.Map;

public abstract interface ExOrderDao
        extends BaseDao<ExOrder, Long> {
    public abstract List<ExOrder> getCurrentExchangPrice(Map<String, Object> paramMap);

    public abstract List<ExOrder> getOpenExchangPrice(Map<String, Object> paramMap);

    public abstract List<ExOrder> getLastExchangPrice(Map<String, Object> paramMap);

    public abstract List<ExOrder> findNewList(Map<String, Object> paramMap);

    public abstract List<ExOrder> findNewListDesc(Map<String, Object> paramMap);

    public abstract List<ExOrder> findNewListnewAdd(Map<String, Object> paramMap);

    public abstract List<ExOrder> exAveragePrice(String paramString);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\dao\ExOrderDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */