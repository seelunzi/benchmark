
package com.tangtang.trade.hry.trade.listener;


import com.tangtang.trade.hry.trade.entrust.service.ExEntrustService;
import hry.core.quartz.QuartzJob;
import hry.core.quartz.QuartzManager;
import hry.core.quartz.ScheduleJob;
import hry.core.util.StringUtil;
import hry.core.util.log.LogFactory;
import hry.core.util.properties.PropertiesUtils;
import hry.core.util.sys.AppUtils;
import hry.core.util.sys.ContextUtil;

import javax.servlet.ServletContextEvent;


public class StartupListener
        extends ContextLoaderListener {

    public void contextInitialized(ServletContextEvent event) {
        /* 34 */
        super.contextInitialized(event);

        /* 36 */
        AppUtils.init(event.getServletContext());
        /* 37 */
        LogFactory.info("--------------------------------------------------------------------------------");
        /* 38 */
        LogFactory.info("---------------------------------加载应用app----------------------------------------");
        /* 39 */
        LogFactory.info("------------------" + PropertiesUtils.APP.getProperty("app.loadApp") + "-----------------");

        /* 41 */
        String isStartRobot = PropertiesUtils.APP.getProperty("app.isStartRobot");
        /* 42 */
        if ((!StringUtil.isEmpty(isStartRobot)) && (isStartRobot.equals("true"))) {
            /* 44 */
            ScheduleJob autoAddExEntrust = new ScheduleJob();
            /* 45 */
            autoAddExEntrust.setSpringId("exEntrustService");
            /* 46 */
            autoAddExEntrust.setMethodName("autoAddExEntrust");
            /* 47 */
            QuartzManager.addJob("autoAddExEntrust", autoAddExEntrust, QuartzJob.class, "0/4 * * * * ?");

            /* 49 */
            ScheduleJob cancelAutoAddExEntrust = new ScheduleJob();
            /* 50 */
            cancelAutoAddExEntrust.setSpringId("exEntrustService");
            /* 51 */
            cancelAutoAddExEntrust.setMethodName("cancelAutoAddExEntrust");
            /* 52 */
            QuartzManager.addJob("cancelAutoAddExEntrust", cancelAutoAddExEntrust, QuartzJob.class, "0/30 * * * * ?");

        }



        /* 57 */
        ScheduleJob reidsToMysql = new ScheduleJob();
        /* 58 */
        reidsToMysql.setSpringId("exOrderInfoService");
        /* 59 */
        reidsToMysql.setMethodName("reidsToMysqlmq");
        /* 60 */
        QuartzManager.addJob("reidsToMysql", reidsToMysql, QuartzJob.class, "0/2 * * * * ?");

        try {
            /* 62 */
            Thread.sleep(300L);

        } catch (InterruptedException e) {
            /* 65 */
            e.printStackTrace();

        }

        /* 68 */
        ScheduleJob reidsToredisLog = new ScheduleJob();
        /* 69 */
        reidsToredisLog.setSpringId("exOrderInfoService");
        /* 70 */
        reidsToredisLog.setMethodName("reidsToredisLogmq");
        /* 71 */
        QuartzManager.addJob("reidsToredisLog", reidsToredisLog, QuartzJob.class, "0/2 * * * * ?");


        /* 74 */
        ScheduleJob jobRunTimepushMarket = new ScheduleJob();
        jobRunTimepushMarket.setSpringId("webSocketScheduleService");
        jobRunTimepushMarket.setMethodName("pushMarket");
        ExEntrustService exEntrustService = (ExEntrustService) ContextUtil.getBean("exEntrustService");
        long start1 = System.currentTimeMillis();
        /* 89 */
        exEntrustService.tradeInit();
        /* 90 */
        long end = System.currentTimeMillis();
        /* 91 */
        System.out.println("初始化交易数据：");
        /* 92 */
        System.out.println(end - start1);

    }

}
