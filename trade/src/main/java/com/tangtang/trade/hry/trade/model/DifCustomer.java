
package com.tangtang.trade.hry.trade.model;


import hry.core.util.properties.PropertiesUtils;


public class DifCustomer {
    /* 27 */   public static String differetCustomer = PropertiesUtils.APP.getProperty("app.differetCustomer");
    /* 28 */   public static String exEntrustIsUseMongo = PropertiesUtils.APP.getProperty("app.exEntrustIsUseMongo");

    /* 30 */   public static String isClosePlate = PropertiesUtils.APP.getProperty("app.isClosePlate");


    public static Boolean isexEntrustIsUseMongo() {
        /* 35 */
        return Boolean.valueOf(true);

    }


    /* 38 */
    public static Boolean isexEntrustIsUseMongomatch() {
        return Boolean.valueOf(true);
    }


    public static Boolean isexEntrustIsUseMongodeph() {
        /* 41 */
        return Boolean.valueOf(true);

    }


    /* 44 */
    public static Boolean isexOrderIsMemory() {
        return Boolean.valueOf(true);
    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\model\DifCustomer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */