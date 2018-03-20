package com.tangtang.trade.hry.trade.entrust.dao;

import hry.core.mvc.dao.base.BaseDao;
import hry.customer.user.model.AppCustomer;
import hry.exchange.product.model.ExCointoCoin;
import hry.trade.redis.model.EntrustTrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public abstract interface CommonDao
        extends BaseDao<EntrustTrade, Long> {
    public abstract AppCustomer getAppUserByuserName(@Param("userName") String paramString);

    public abstract List<ExCointoCoin> getExointocoinValid();

    public abstract List<AppCustomer> getAppUserAll();
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\entrust\dao\CommonDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */