package com.tangtang.trade.hry.trade.account.dao;

import hry.core.mvc.dao.base.BaseDao;
import hry.exchange.account.model.ExDigitalmoneyAccount;
import hry.trade.redis.model.ExDigitalmoneyAccountRedis;

import java.util.List;

public abstract interface ExDigitalmoneyAccountDao
        extends BaseDao<ExDigitalmoneyAccount, Long> {
    public abstract void updateExDigitalmoneyAccount(List<ExDigitalmoneyAccountRedis> paramList);
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\dao\ExDigitalmoneyAccountDao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */