
package com.tangtang.trade.hry.trade.account.service.impl;


import hry.account.fund.model.AppAccount;
import hry.account.fund.model.AppHotAccountRecord;
import hry.core.mvc.dao.base.BaseDao;
import hry.core.mvc.service.base.impl.BaseServiceImpl;
import hry.trade.account.service.AppHotAccountRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


@Service("appHotAccountRecordService")
public class AppHotAccountRecordServiceImpl
        extends BaseServiceImpl<AppHotAccountRecord, Long>
        implements AppHotAccountRecordService {

    @Resource(name = "appHotAccountRecordDao")
    public void setDao(BaseDao<AppHotAccountRecord, Long> dao) {
        /* 32 */
        this.dao = dao;

    }


    public void addHotRecord(BigDecimal money, AppAccount appAccount, int type, int states) {
        /* 51 */
        AppHotAccountRecord appHotAccountRecord = new AppHotAccountRecord();
        /* 52 */
        appHotAccountRecord.setTrueName(appAccount.getTrueName());

        /* 54 */
        appHotAccountRecord.setAccountId(appAccount.getId());
        /* 55 */
        appHotAccountRecord.setCurrencyType(appAccount.getCurrencyType());
        /* 56 */
        appHotAccountRecord.setCustomerId(appAccount.getCustomerId());
        /* 57 */
        appHotAccountRecord.setRecordType(Integer.valueOf(type));
        /* 58 */
        appHotAccountRecord.setRemark("给  " + appAccount.getUserName() + " 转了一笔流水");
        /* 59 */
        appHotAccountRecord.setStatus(Integer.valueOf(states));
        /* 60 */
        appHotAccountRecord.setTransactionMoney(money);
        /* 61 */
        appHotAccountRecord.setUserName(appAccount.getUserName());
        /* 62 */
        appHotAccountRecord.setWebsite(appAccount.getWebsite());
        /* 63 */
        appHotAccountRecord.setTransactionNum("000000000");

        /* 65 */
        super.save(appHotAccountRecord);

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\impl\AppHotAccountRecordServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */