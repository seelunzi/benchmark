
package com.tangtang.trade.hry.trade.account.service.impl;


import hry.core.mvc.dao.base.BaseDao;
import hry.core.mvc.service.base.impl.BaseServiceImpl;
import hry.core.util.QueryFilter;
import hry.exchange.account.model.ExDigitalmoneyAccount;
import hry.exchange.account.model.ExDmHotAccountRecord;
import hry.trade.account.service.ExDigitalmoneyAccountService;
import hry.trade.account.service.ExDmHotAccountRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("exDmHotAccountRecordService")
public class ExDmHotAccountRecordServiceImpl
        extends BaseServiceImpl<ExDmHotAccountRecord, Long>
        implements ExDmHotAccountRecordService {

    @Resource(name = "exDigitalmoneyAccountService")
    public ExDigitalmoneyAccountService exDigitalmoneyAccountService;



    @Resource(name = "exDmHotAccountRecordDao")
    public void setDao(BaseDao<ExDmHotAccountRecord, Long> dao) {
        /* 42 */
        this.dao = dao;

    }


    public ExDmHotAccountRecord findByAccountId(Long id) {
        /* 47 */
        ExDigitalmoneyAccount exDigitalmoneyAccount = (ExDigitalmoneyAccount) this.exDigitalmoneyAccountService.get(id);

        /* 49 */
        String accountNum = exDigitalmoneyAccount.getAccountNum();

        /* 51 */
        return null;

    }


    public List<ExDmHotAccountRecord> findHotAccountRecordBytransactionNum(String transactionNum) {
        /* 57 */
        QueryFilter filter = new QueryFilter(ExDmHotAccountRecord.class);
        /* 58 */
        filter.addFilter("transactionNum=", transactionNum);
        /* 59 */
        List<ExDmHotAccountRecord> list = super.find(filter);

        /* 61 */
        return list;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\impl\ExDmHotAccountRecordServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */