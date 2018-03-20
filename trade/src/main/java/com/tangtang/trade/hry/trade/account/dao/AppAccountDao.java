package com.tangtang.trade.hry.trade.account.dao;

import hry.account.fund.model.AppAccount;
import hry.core.mvc.dao.base.BaseDao;
import hry.trade.redis.model.AppAccountRedis;

import java.util.List;

public abstract interface AppAccountDao
        extends BaseDao<AppAccount, Long> {
    public abstract void updateAppAccount(List<AppAccountRedis> paramList);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\dao\AppAccountDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */