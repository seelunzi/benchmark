package com.tangtang.trade.hry.trade.account.dao;

import hry.core.mvc.dao.base.BaseDao;
import hry.exchange.account.model.ExDigitalmoneyAccount;
import hry.trade.redis.model.ExDigitalmoneyAccountRedis;

import java.util.List;

public interface ExDigitalmoneyAccountDao
        extends BaseDao<ExDigitalmoneyAccount, Long> {
    void updateExDigitalmoneyAccount(List<ExDigitalmoneyAccountRedis> paramList);
}
