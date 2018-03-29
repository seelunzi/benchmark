/*     */
package com.tangtang.trade.hry.web.app.model.vo;
/*     */
/*     */

import hry.web.app.model.MessageAsCustomer;

import java.util.Date;
import java.util.List;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ public class MessageListVo
        /*     */ {
    /*     */   private Long id;
    /*     */   private String categoryName;
    /*     */   private String messageTitle;
    /*     */   private Integer isSend;
    /*     */   private String sendUserName;
    /*     */   private Date sendDate;
    /*     */   private Date created;
    /*     */   private List<MessageAsCustomer> list;
    /*     */   private String operator;

    /*     */
    /*     */
    public Integer getIsSend()
    /*     */ {
        /*  38 */
        return this.isSend;
        /*     */
    }

    /*     */
    /*  41 */
    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    /*     */
    /*     */
    public Date getCreated() {
        /*  44 */
        return this.created;
        /*     */
    }

    /*     */
    /*  47 */
    public void setCreated(Date created) {
        this.created = created;
    }

    /*     */
    /*     */
    public List<MessageAsCustomer> getList() {
        /*  50 */
        return this.list;
        /*     */
    }

    /*     */
    /*  53 */
    public void setList(List<MessageAsCustomer> list) {
        this.list = list;
    }

    /*     */
    /*     */
    public String getSendUserName()
    /*     */ {
        /*  57 */
        return this.sendUserName;
        /*     */
    }

    /*     */
    /*  60 */
    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  68 */
        return this.id;
        /*     */
    }

    /*     */
    /*  71 */
    public void setId(Long id) {
        this.id = id;
    }

    /*     */
    /*     */
    public String getCategoryName() {
        /*  74 */
        return this.categoryName;
        /*     */
    }

    /*     */
    /*  77 */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /*     */
    /*     */
    public String getMessageTitle() {
        /*  80 */
        return this.messageTitle;
        /*     */
    }

    /*     */
    /*  83 */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    /*     */
    /*     */
    public Date getSendDate() {
        /*  86 */
        return this.sendDate;
        /*     */
    }

    /*     */
    /*  89 */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /*     */
    /*     */
    public String getOperator()
    /*     */ {
        /*  93 */
        return this.operator;
        /*     */
    }

    /*     */
    /*  96 */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public MessageListVo(Long id, String categoryName, String messageTitle, Date sendDate, String receiveUserName, String sendUserName, String operator)
    /*     */ {
        /* 102 */
        this.id = id;
        /* 103 */
        this.categoryName = categoryName;
        /* 104 */
        this.messageTitle = messageTitle;
        /* 105 */
        this.sendDate = sendDate;
        /*     */
        /* 107 */
        this.operator = operator;
        /*     */
    }

    /*     */
    /*     */
    public MessageListVo() {
    }

    /*     */
    /*     */
    public String toString()
    /*     */ {
        /* 114 */
        return "MessageListVo [id=" + this.id + ", categoryName=" + this.categoryName + ", messageTitle=" + this.messageTitle + ", sendDate=" + this.sendDate + ", receiveUserName=" + ", sendUserName=" + ", operator=" + this.operator + "]";
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\vo\MessageListVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */