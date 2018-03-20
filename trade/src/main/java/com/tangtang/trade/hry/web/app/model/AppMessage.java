/*     */
package com.tangtang.trade.hry.web.app.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;
import org.springframework.web.util.HtmlUtils;

import javax.persistence.*;
import java.util.Date;

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
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
@Table(name = "app_message")
/*     */ public class AppMessage
        /*     */ extends BaseModel
        /*     */ {
    /*     */
    @Id
    /*     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*     */
    @Column(name = "id", unique = true, nullable = false)
    /*     */ private Long id;
    /*     */
    @Column(name = "content")
    /*     */ private String content;
    /*     */
    @Column(name = "sendUserName")
    /*     */ private String sendUserName;
    /*     */
    @Column(name = "categoryName")
    /*     */ private String categoryName;
    /*     */
    @Column(name = "categoryId")
    /*     */ private String categoryId;
    /*     */
    @Column(name = "title")
    /*     */ private String title;
    /*     */
    @Column(name = "titleImage")
    /*     */ private String titleImage;
    /*     */
    @Column(name = "sortTitle")
    /*     */ private String sortTitle;
    /*     */
    @Column(name = "operator")
    /*     */ private String operator;
    /*     */
    @Column(name = "isAll")
    /*     */ private Integer isAll;
    /*     */
    @Column(name = "isSend")
    /*     */ private Integer isSend;
    /*     */
    @Column(name = "sendDate")
    /*     */ private Date sendDate;
    /*     */
    @Transient
    /*     */ private MessageAsCustomer messageAsCustomer;

    /*     */
    /*     */
    public String getTitleImage()
    /*     */ {
        /*  87 */
        return this.titleImage;
        /*     */
    }

    /*     */
    /*     */
    public void setTitleImage(String titleImage) {
        /*  91 */
        this.titleImage = titleImage;
        /*     */
    }

    /*     */
    /*     */
    public MessageAsCustomer getMessageAsCustomer() {
        /*  95 */
        return this.messageAsCustomer;
        /*     */
    }

    /*     */
    /*     */
    public void setMessageAsCustomer(MessageAsCustomer messageAsCustomer) {
        /*  99 */
        this.messageAsCustomer = messageAsCustomer;
        /*     */
    }

    /*     */
    /*     */
    public Integer getIsAll() {
        /* 103 */
        return this.isAll;
        /*     */
    }

    /*     */
    /*     */
    public void setIsAll(Integer isAll) {
        /* 107 */
        this.isAll = isAll;
        /*     */
    }

    /*     */
    /*     */
    public Integer getIsSend() {
        /* 111 */
        return this.isSend;
        /*     */
    }

    /*     */
    /*     */
    public void setIsSend(Integer isSend) {
        /* 115 */
        this.isSend = isSend;
        /*     */
    }

    /*     */
    /*     */
    public Date getSendDate() {
        /* 119 */
        return this.sendDate;
        /*     */
    }

    /*     */
    /*     */
    public void setSendDate(Date sendDate) {
        /* 123 */
        this.sendDate = sendDate;
        /*     */
    }

    /*     */
    /*     */
    public String getOperator() {
        /* 127 */
        return this.operator;
        /*     */
    }

    /*     */
    /*     */
    public void setOperator(String operator) {
        /* 131 */
        this.operator = operator;
        /*     */
    }

    /*     */
    /*     */
    public Long getId() {
        /* 135 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    public void setId(Long id) {
        /* 139 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    public String getContent() {
        /* 143 */
        return HtmlUtils.htmlUnescape(this.content);
        /*     */
    }

    /*     */
    /*     */
    public void setContent(String content) {
        /* 147 */
        this.content = content;
        /*     */
    }

    /*     */
    /*     */
    public String getCategoryName() {
        /* 151 */
        return this.categoryName;
        /*     */
    }

    /*     */
    /*     */
    public String getSendUserName() {
        /* 155 */
        return this.sendUserName;
        /*     */
    }

    /*     */
    /*     */
    public void setSendUserName(String sendUserName) {
        /* 159 */
        this.sendUserName = sendUserName;
        /*     */
    }

    /*     */
    /*     */
    public void setCategoryName(String categoryName) {
        /* 163 */
        this.categoryName = categoryName;
        /*     */
    }

    /*     */
    /*     */
    public String getCategoryId() {
        /* 167 */
        return this.categoryId;
        /*     */
    }

    /*     */
    /*     */
    public void setCategoryId(String categoryId) {
        /* 171 */
        this.categoryId = categoryId;
        /*     */
    }

    /*     */
    /*     */
    public String getTitle() {
        /* 175 */
        return HtmlUtils.htmlUnescape(this.title);
        /*     */
    }

    /*     */
    /*     */
    public void setTitle(String title) {
        /* 179 */
        this.title = title;
        /*     */
    }

    /*     */
    /*     */
    public String getSortTitle() {
        /* 183 */
        return HtmlUtils.htmlUnescape(this.sortTitle);
        /*     */
    }

    /*     */
    /*     */
    public void setSortTitle(String sortTitle) {
        /* 187 */
        this.sortTitle = sortTitle;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public AppMessage(Long id, String content, String categoryName, String categoryId, String title, String sortTitle)
    /*     */ {
        /* 194 */
        this.id = id;
        /* 195 */
        this.content = content;
        /* 196 */
        this.categoryName = categoryName;
        /* 197 */
        this.categoryId = categoryId;
        /* 198 */
        this.title = title;
        /* 199 */
        this.sortTitle = sortTitle;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public AppMessage() {
    }

    /*     */
    /*     */
    /*     */
    public String toString()
    /*     */ {
        /* 208 */
        return "AppMessage [id=" + this.id + ", content=" + this.content + ", sendUserName=" + this.sendUserName + ", categoryName=" + this.categoryName + ", categoryId=" + this.categoryId + ", title=" + this.title + ", titleImage=" + this.titleImage + ", sortTitle=" + this.sortTitle + ", operator=" + this.operator + ", isAll=" + this.isAll + ", isSend=" + this.isSend + ", sendDate=" + this.sendDate + ", messageAsCustomer=" + this.messageAsCustomer + "]";
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppMessage.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */