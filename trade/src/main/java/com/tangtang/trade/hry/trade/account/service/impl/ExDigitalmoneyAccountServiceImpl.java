
package com.tangtang.trade.hry.trade.account.service.impl;


import com.alibaba.fastjson.JSON;
import hry.core.mvc.dao.base.BaseDao;
import hry.core.mvc.service.base.impl.BaseServiceImpl;
import hry.exchange.account.model.ExDigitalmoneyAccount;
import hry.exchange.account.model.ExDmColdAccountRecord;
import hry.exchange.account.model.ExDmHotAccountRecord;
import hry.trade.account.service.*;
import hry.trade.model.AccountRemarkEnum;
import hry.trade.model.TradeRedis;
import hry.trade.redis.model.ExDigitalmoneyAccountRedis;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


@Service("exDigitalmoneyAccountService")
public class ExDigitalmoneyAccountServiceImpl
        extends BaseServiceImpl<ExDigitalmoneyAccount, Long>
        implements ExDigitalmoneyAccountService {
    private ExDigitalmoneyAccountService exDigitalmoneyAccountService;

    @Resource
    private ExDmColdAccountRecordService exDmColdAccountRecordService;

    @Resource
    private ExDmHotAccountRecordService exDmHotAccountRecordService;

    @Resource
    private AppColdAccountRecordService appColdAccountRecordService;

    @Resource
    private AppHotAccountRecordService appHotAccountRecordService;



    @Resource(name = "exDigitalmoneyAccountDao")
    public void setDao(BaseDao<ExDigitalmoneyAccount, Long> dao) {
        /*  65 */
        this.dao = dao;

    }


    public ExDmColdAccountRecord createColdRecord(Integer recordType, ExDigitalmoneyAccount exDigitalmoneyAccount, BigDecimal freezeMoney, String transactionNum, Integer remark) {
        /*  83 */
        Integer status = Integer.valueOf(5);

        /*  85 */
        ExDmColdAccountRecord coldAccountRecord = new ExDmColdAccountRecord();
        /*  86 */
        coldAccountRecord.setAccountId(exDigitalmoneyAccount.getId());
        /*  87 */
        coldAccountRecord.setCurrencyType(exDigitalmoneyAccount.getCurrencyType());
        /*  88 */
        coldAccountRecord.setWebsite(exDigitalmoneyAccount.getWebsite());
        /*  89 */
        coldAccountRecord.setCoinCode(exDigitalmoneyAccount.getCoinCode());
        /*  90 */
        coldAccountRecord.setCustomerId(exDigitalmoneyAccount.getCustomerId());
        /*  91 */
        coldAccountRecord.setSaasId(exDigitalmoneyAccount.getSaasId());
        /*  92 */
        coldAccountRecord.setUserName(exDigitalmoneyAccount.getUserName());
        /*  93 */
        coldAccountRecord.setTrueName(exDigitalmoneyAccount.getTrueName());
        /*  94 */
        coldAccountRecord.setTransactionNum(transactionNum);
        /*  95 */
        coldAccountRecord.setRecordType(recordType);
        /*  96 */
        coldAccountRecord.setStatus(status);
        /*  97 */
        coldAccountRecord.setTransactionMoney(freezeMoney);
        /*  98 */
        coldAccountRecord.setRemark(AccountRemarkEnum.getName(remark.intValue()));
        /*  99 */
        return coldAccountRecord;

    }


    public ExDmHotAccountRecord createHotRecord(Integer recordType, ExDigitalmoneyAccount account, BigDecimal freezeMoney, String transactionNum, Integer remark) {
        /* 105 */
        Integer status = Integer.valueOf(5);
        /* 106 */
        ExDmHotAccountRecord hotAccountRecord = new ExDmHotAccountRecord();
        /* 107 */
        hotAccountRecord.setAccountId(account.getId());
        /* 108 */
        hotAccountRecord.setCurrencyType(account.getCurrencyType());
        /* 109 */
        hotAccountRecord.setWebsite(account.getWebsite());
        /* 110 */
        hotAccountRecord.setCoinCode(account.getCoinCode());

        /* 112 */
        hotAccountRecord.setCustomerId(account.getCustomerId());
        /* 113 */
        hotAccountRecord.setSaasId(account.getSaasId());
        /* 114 */
        hotAccountRecord.setUserName(account.getUserName());
        /* 115 */
        hotAccountRecord.setTrueName(account.getTrueName());
        /* 116 */
        hotAccountRecord.setTransactionNum(transactionNum);
        /* 117 */
        hotAccountRecord.setRecordType(recordType);
        /* 118 */
        hotAccountRecord.setStatus(status);
        /* 119 */
        hotAccountRecord.setTransactionMoney(freezeMoney);
        /* 120 */
        hotAccountRecord.setRemark(AccountRemarkEnum.getName(remark.intValue()));
        /* 121 */
        return hotAccountRecord;

    }


    public ExDigitalmoneyAccountRedis getExDigitalmoneyAccountByRedis(String id) {
        /* 129 */
        Object obj = TradeRedis.redisUtilExDigitalmoneyAccount.get(id);
        /* 130 */
        if (null == obj) {
            /* 132 */
            ExDigitalmoneyAccount account = (ExDigitalmoneyAccount) get(Long.valueOf(id));
            /* 133 */
            ExDigitalmoneyAccountRedis accountr = (ExDigitalmoneyAccountRedis) JSON.parseObject(JSON.toJSONString(account), ExDigitalmoneyAccountRedis.class);
            /* 134 */
            return accountr;

        }
        /* 136 */
        ExDigitalmoneyAccountRedis accountr = (ExDigitalmoneyAccountRedis) obj;
        /* 137 */
        return accountr;

    }


    public void setExDigitalmoneyAccounttoRedis(ExDigitalmoneyAccountRedis exDigitalmoneyAccount) {
        /* 146 */
        TradeRedis.redisUtilExDigitalmoneyAccount.put(exDigitalmoneyAccount, exDigitalmoneyAccount.getId().toString());

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\impl\ExDigitalmoneyAccountServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */