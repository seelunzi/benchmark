package com.tangtang.trade.hry.trade.entrust.dao;

import hry.core.mvc.dao.base.BaseDao;
import hry.trade.entrust.model.ExEntrust;
import hry.trade.redis.model.EntrustTrade;

import java.util.List;
import java.util.Map;

public abstract interface ExEntrustDao
        extends BaseDao<ExEntrust, Long> {
    public abstract ExEntrust getExEntrustByentrustNum(String paramString);

    public abstract void insertExEntrust(List<EntrustTrade> paramList);

    public abstract void updateExEntrust(List<ExEntrust> paramList);

    public abstract List<ExEntrust> getExEntrustListByNums(List<EntrustTrade> paramList);

    public abstract List<ExEntrust> getExEdBycustomerId(Map<String, Object> paramMap);

    public abstract List<ExEntrust> getExEntrustListByNumstoMysql(List<EntrustTrade> paramList);

    public abstract List<ExEntrust> getEntrustingByCustomerId(Map<String, Object> paramMap);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\dao\ExEntrustDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */