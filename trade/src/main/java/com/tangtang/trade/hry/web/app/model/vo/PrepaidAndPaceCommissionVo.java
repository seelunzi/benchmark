
package com.tangtang.trade.hry.web.app.model.vo;


import java.io.Serializable;


public class PrepaidAndPaceCommissionVo
        implements Serializable {
    public String prepaidCommission;
    public String paceCommission;


    public String getPrepaidCommission() {
        /* 24 */
        return this.prepaidCommission;

    }


    /* 27 */
    public void setPrepaidCommission(String prepaidCommission) {
        this.prepaidCommission = prepaidCommission;
    }


    public String getPaceCommission() {
        /* 30 */
        return this.paceCommission;

    }


    /* 33 */
    public void setPaceCommission(String paceCommission) {
        this.paceCommission = paceCommission;
    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\vo\PrepaidAndPaceCommissionVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */