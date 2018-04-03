
package com.tangtang.trade.hry.trade.account.service.impl;


import hry.account.fund.model.AppColdAccountRecord;
import hry.core.mvc.dao.base.BaseDao;
import hry.core.mvc.service.base.impl.BaseServiceImpl;
import hry.trade.account.service.AppColdAccountRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("appColdAccountRecordService")
public class AppColdAccountRecordServiceImpl
        extends BaseServiceImpl<AppColdAccountRecord, Long>
        implements AppColdAccountRecordService {

    @Resource(name = "appColdAccountRecordDao")
    public void setDao(BaseDao<AppColdAccountRecord, Long> dao) {
        /* 29 */
        this.dao = dao;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\account\service\impl\AppColdAccountRecordServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */