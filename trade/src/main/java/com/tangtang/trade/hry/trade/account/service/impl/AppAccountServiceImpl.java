
package com.tangtang.trade.hry.trade.account.service.impl;


import com.alibaba.fastjson.JSON;
import hry.account.fund.model.AppAccount;
import hry.account.fund.model.AppColdAccountRecord;
import hry.account.fund.model.AppHotAccountRecord;
import hry.core.mvc.dao.base.BaseDao;
import hry.core.mvc.service.base.impl.BaseServiceImpl;
import hry.trade.account.service.AppAccountService;
import hry.trade.account.service.AppColdAccountRecordService;
import hry.trade.account.service.AppHotAccountRecordService;
import hry.trade.model.AccountRemarkEnum;
import hry.trade.model.TradeRedis;
import hry.trade.redis.model.AppAccountRedis;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


@Service("appAccountService")
public class AppAccountServiceImpl
        extends BaseServiceImpl<AppAccount, Long>
        implements AppAccountService {

    @Resource
    private AppColdAccountRecordService appColdAccountRecordService;

    @Resource
    private AppHotAccountRecordService appHotAccountRecordService;



    @Resource(name = "appAccountDao")
    public void setDao(BaseDao<AppAccount, Long> dao) {
        /*  62 */
        this.dao = dao;

    }


    public AppColdAccountRecord createColdRecord(Integer recordType, AppAccount account, BigDecimal freezeMoney, String transactionNum, Integer remark) {
        /*  74 */
        Integer status = Integer.valueOf(5);

        /*  76 */
        AppColdAccountRecord coldAccountRecord = new AppColdAccountRecord();
        /*  77 */
        coldAccountRecord.setAccountId(account.getId());
        /*  78 */
        coldAccountRecord.setWebsite(account.getWebsite());
        /*  79 */
        coldAccountRecord.setCurrencyType(account.getCurrencyType());
        /*  80 */
        coldAccountRecord.setCustomerId(account.getCustomerId());
        /*  81 */
        coldAccountRecord.setSaasId(account.getSaasId());
        /*  82 */
        coldAccountRecord.setUserName(account.getUserName());
        /*  83 */
        coldAccountRecord.setTrueName(account.getTrueName());
        /*  84 */
        coldAccountRecord.setTransactionNum(transactionNum);
        /*  85 */
        coldAccountRecord.setRecordType(recordType);
        /*  86 */
        coldAccountRecord.setStatus(status);
        /*  87 */
        coldAccountRecord.setTransactionMoney(freezeMoney);
        /*  88 */
        coldAccountRecord.setRemark(AccountRemarkEnum.getName(remark.intValue()));
        /*  89 */
        return coldAccountRecord;

    }


    public AppHotAccountRecord createHotRecord(Integer recordType, AppAccount account, BigDecimal freezeMoney, String transactionNum, Integer remark) {
        /*  96 */
        Integer status = Integer.valueOf(5);
        /*  97 */
        AppHotAccountRecord hotAccountRecord = new AppHotAccountRecord();
        /*  98 */
        hotAccountRecord.setAccountId(account.getId());
        /*  99 */
        hotAccountRecord.setWebsite(account.getWebsite());
        /* 100 */
        hotAccountRecord.setCurrencyType(account.getCurrencyType());
        /* 101 */
        hotAccountRecord.setCustomerId(account.getCustomerId());
        /* 102 */
        hotAccountRecord.setSaasId(account.getSaasId());
        /* 103 */
        hotAccountRecord.setUserName(account.getUserName());
        /* 104 */
        hotAccountRecord.setTrueName(account.getTrueName());
        /* 105 */
        hotAccountRecord.setTransactionNum(transactionNum);
        /* 106 */
        hotAccountRecord.setRecordType(recordType);
        /* 107 */
        hotAccountRecord.setStatus(status);
        /* 108 */
        hotAccountRecord.setTransactionMoney(freezeMoney);
        /* 109 */
        hotAccountRecord.setRemark(AccountRemarkEnum.getName(remark.intValue()));
        /* 110 */
        return hotAccountRecord;

    }


    public AppAccountRedis getAppAccountByRedis(String id) {
        /* 118 */
        Object obj = TradeRedis.redisUtilAppAccount.get(id);
        /* 119 */
        if (null == obj) {
            /* 121 */
            AppAccount account = (AppAccount) get(Long.valueOf(id));
            /* 122 */
            AppAccountRedis accountr = (AppAccountRedis) JSON.parseObject(JSON.toJSONString(account), AppAccountRedis.class);
            /* 123 */
            return accountr;

        }
        /* 125 */
        AppAccountRedis accountr = (AppAccountRedis) obj;
        /* 126 */
        return accountr;

    }


    public void setAppAccounttoRedis(AppAccountRedis appAccount) {
        /* 133 */
        TradeRedis.redisUtilAppAccount.put(appAccount, appAccount.getId().toString());

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\impl\AppAccountServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */