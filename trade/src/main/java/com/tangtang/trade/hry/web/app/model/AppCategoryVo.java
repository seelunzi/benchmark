/*    */
package com.tangtang.trade.hry.web.app.model;
/*    */
/*    */

import java.io.Serializable;
import java.util.List;

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
/*    */ public class AppCategoryVo
        /*    */ implements Serializable
        /*    */ {
    /*    */   private Long id;
    /*    */   private String preateName;
    /*    */   private List<AppCategory> list;

    /*    */
    /*    */
    public Long getId()
    /*    */ {
        /* 24 */
        return this.id;
        /*    */
    }

    /*    */
    /* 27 */
    public void setId(Long id) {
        this.id = id;
    }

    /*    */
    /*    */
    public String getPreateName() {
        /* 30 */
        return this.preateName;
        /*    */
    }

    /*    */
    /* 33 */
    public void setPreateName(String preateName) {
        this.preateName = preateName;
    }

    /*    */
    /*    */
    public List<AppCategory> getList() {
        /* 36 */
        return this.list;
        /*    */
    }

    /*    */
    /* 39 */
    public void setList(List<AppCategory> list) {
        this.list = list;
    }

    /*    */
    /*    */
    public String toString()
    /*    */ {
        /* 43 */
        return "AppCategoryVo [id=" + this.id + ", preateName=" + this.preateName + ", list=" + this.list + "]";
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppCategoryVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */