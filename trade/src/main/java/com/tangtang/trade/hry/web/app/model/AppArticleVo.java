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
/*    */ public class AppArticleVo
        /*    */ implements Serializable
        /*    */ {
    /*    */   private Long id;
    /*    */   private String name;
    /*    */   private List<AppArticle> list;

    /*    */
    /*    */
    public Long getId()
    /*    */ {
        /* 35 */
        return this.id;
        /*    */
    }

    /*    */
    /*    */
    public void setId(Long id) {
        /* 39 */
        this.id = id;
        /*    */
    }

    /*    */
    /*    */
    public String getName() {
        /* 43 */
        return this.name;
        /*    */
    }

    /*    */
    /*    */
    public void setName(String name) {
        /* 47 */
        this.name = name;
        /*    */
    }

    /*    */
    /*    */
    public List<AppArticle> getList() {
        /* 51 */
        return this.list;
        /*    */
    }

    /*    */
    /*    */
    public void setList(List<AppArticle> list) {
        /* 55 */
        this.list = list;
        /*    */
    }

    /*    */
    /*    */
    public String toString()
    /*    */ {
        /* 60 */
        return "AppArticleVo [id=" + this.id + ", name=" + this.name + ", list=" + this.list + "]";
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppArticleVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */