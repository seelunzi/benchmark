/*     */
package com.tangtang.trade.hry.web.app.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

import javax.persistence.*;

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
@Table(name = "message_as_customer")
/*     */ public class MessageAsCustomer
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
    @Column(name = "messageId")
    /*     */ private Long messageId;
    /*     */
    @Column(name = "customerId")
    /*     */ private Long customerId;
    /*     */
    @Column(name = "state")
    /*     */ private Integer state;
    /*     */
    @Column(name = "customerName")
    /*     */ private String customerName;
    /*     */
    @Column(name = "trueName")
    /*     */ private String trueName;

    /*     */
    /*     */
    public String getTrueName()
    /*     */ {
        /*  52 */
        return this.trueName;
        /*     */
    }

    /*     */
    /*  55 */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /*     */
    /*     */
    public String getCustomerName() {
        /*  58 */
        return this.customerName;
        /*     */
    }

    /*     */
    /*  61 */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  65 */
        return this.id;
        /*     */
    }

    /*     */
    /*  68 */
    public void setId(Long id) {
        this.id = id;
    }

    /*     */
    /*     */
    public Long getMessageId() {
        /*  71 */
        return this.messageId;
        /*     */
    }

    /*     */
    /*  74 */
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    /*     */
    /*     */
    public Long getCustomerId() {
        /*  77 */
        return this.customerId;
        /*     */
    }

    /*     */
    /*  80 */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /*     */
    /*     */
    public Integer getState() {
        /*  83 */
        return this.state;
        /*     */
    }

    /*     */
    /*  86 */
    public void setState(Integer state) {
        this.state = state;
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public MessageAsCustomer(Long id, Long mseeageId, Long customerId, Long sendUserId, Integer state, String customerName, String userName)
    /*     */ {
        /*  94 */
        this.id = id;
        /*  95 */
        this.messageId = mseeageId;
        /*  96 */
        this.customerId = customerId;
        /*  97 */
        this.state = state;
        /*  98 */
        this.customerName = customerName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    public MessageAsCustomer() {
    }

    /*     */
    /*     */
    public String toString()
    /*     */ {
        /* 106 */
        return "MessageAsCustomer [id=" + this.id + ", mseeageId=" + this.messageId + ", customerId=" + this.customerId + ", sendUserId=" + ", state=" + this.state + ", customerName=" + this.customerName + ", userName=" + "]";
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\MessageAsCustomer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */