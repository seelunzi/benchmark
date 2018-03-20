/*    */
package com.tangtang.trade.hry.core.mvc.model.page;
/*    */
/*    */

import java.io.Serializable;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class JsonResult
        /*    */ implements Serializable
        /*    */ {
    /* 21 */   private Boolean success = Boolean.valueOf(false);
    /* 22 */   private String msg = "";
    /* 23 */   private Object obj = null;
    /* 24 */   private String code = "";

    /*    */
    /*    */
    public Boolean getSuccess() {
        /* 27 */
        return this.success;
        /*    */
    }

    /*    */
    /*    */
    public void setSuccess(Boolean success) {
        /* 31 */
        this.success = success;
        /*    */
    }

    /*    */
    /*    */
    public String getMsg() {
        /* 35 */
        return this.msg;
        /*    */
    }

    /*    */
    /*    */
    public void setMsg(String msg) {
        /* 39 */
        this.msg = msg;
        /*    */
    }

    /*    */
    /*    */
    public Object getObj() {
        /* 43 */
        return this.obj;
        /*    */
    }

    /*    */
    /*    */
    public void setObj(Object obj) {
        /* 47 */
        this.obj = obj;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public String getCode()
    /*    */ {
        /* 55 */
        return this.code;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public void setCode(String code)
    /*    */ {
        /* 63 */
        this.code = code;
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\page\JsonResult.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */