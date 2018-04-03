
package com.tangtang.trade.hry.trade.account.service.impl;


import hry.core.mvc.dao.base.BaseDao;
import hry.core.mvc.service.base.impl.BaseServiceImpl;
import hry.core.util.QueryFilter;
import hry.exchange.account.model.ExDmColdAccountRecord;
import hry.exchange.account.model.ExDmHotAccountRecord;
import hry.trade.account.service.ExDmColdAccountRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("exDmColdAccountRecordService")
public class ExDmColdAccountRecordServiceImpl
        extends BaseServiceImpl<ExDmColdAccountRecord, Long>
        implements ExDmColdAccountRecordService {

    @Resource(name = "exDmColdAccountRecordDao")
    public void setDao(BaseDao<ExDmColdAccountRecord, Long> dao) {
        /* 38 */
        this.dao = dao;

    }


    public List<ExDmColdAccountRecord> findColdAccountRecordBytransactionNum(String transactionNum) {
        /* 44 */
        QueryFilter filter = new QueryFilter(ExDmHotAccountRecord.class);
        /* 45 */
        filter.addFilter("transactionNum=", transactionNum);
        /* 46 */
        List<ExDmColdAccountRecord> list = super.find(filter);
        /* 47 */
        return list;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\impl\ExDmColdAccountRecordServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */