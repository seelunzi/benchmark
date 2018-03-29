/*    */
package com.tangtang.trade.hry.web.app.model.vo;
/*    */
/*    */

import java.io.Serializable;
import java.util.Date;

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
/*    */ public class MessageAndCustromerVo
        /*    */ implements Serializable
        /*    */ {
    /*    */   private Long id;
    /*    */   private String content;
    /*    */   private String title;
    /*    */   private String sortTitle;
    /*    */   private Date sendDate;
    /*    */   private Long cid;
    /*    */   private Integer state;

    /*    */
    /*    */
    public Long getId()
    /*    */ {
        /* 27 */
        return this.id;
        /*    */
    }

    /*    */
    /* 30 */
    public void setId(Long id) {
        this.id = id;
    }

    /*    */
    /*    */
    public String getContent() {
        /* 33 */
        return this.content;
        /*    */
    }

    /*    */
    /* 36 */
    public void setContent(String content) {
        this.content = content;
    }

    /*    */
    /*    */
    public String getTitle() {
        /* 39 */
        return this.title;
        /*    */
    }

    /*    */
    /* 42 */
    public void setTitle(String title) {
        this.title = title;
    }

    /*    */
    /*    */
    public String getSortTitle() {
        /* 45 */
        return this.sortTitle;
        /*    */
    }

    /*    */
    /* 48 */
    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    /*    */
    /*    */
    public Date getSendDate() {
        /* 51 */
        return this.sendDate;
        /*    */
    }

    /*    */
    /* 54 */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /*    */
    /*    */
    public Long getCid() {
        /* 57 */
        return this.cid;
        /*    */
    }

    /*    */
    /* 60 */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /*    */
    /*    */
    public Integer getState() {
        /* 63 */
        return this.state;
        /*    */
    }

    /*    */
    /* 66 */
    public void setState(Integer state) {
        this.state = state;
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\vo\MessageAndCustromerVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */