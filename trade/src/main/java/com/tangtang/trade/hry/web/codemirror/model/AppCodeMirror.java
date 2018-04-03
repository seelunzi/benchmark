
package com.tangtang.trade.hry.web.codemirror.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_codemirror")
public class AppCodeMirror
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "isDelete")
    private String isDelete;

    @Column(name = "name")
    private String name;

    @Column(name = "furl")
    private String furl;

    @Column(name = "remark")
    private String remark;

    @Column(name = "type")
    private String type;

    @Column(name = "orderNo")
    private String orderNo;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "content")
    private String content;


    public Long getId() {
        /*  66 */
        return this.id;

    }


    public void setId(Long id) {
        /*  77 */
        this.id = id;

    }


    public String getIsDelete() {
        /*  88 */
        return this.isDelete;

    }


    public void setIsDelete(String isDelete) {
        /*  99 */
        this.isDelete = isDelete;

    }


    public String getName() {
        /* 110 */
        return this.name;

    }


    public void setName(String name) {
        /* 121 */
        this.name = name;

    }


    public String getFurl() {
        /* 132 */
        return this.furl;

    }


    public void setFurl(String furl) {
        /* 143 */
        this.furl = furl;

    }


    public String getRemark() {
        /* 154 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 165 */
        this.remark = remark;

    }


    public String getType() {
        /* 176 */
        return this.type;

    }


    public void setType(String type) {
        /* 187 */
        this.type = type;

    }


    public String getOrderNo() {
        /* 198 */
        return this.orderNo;

    }


    public void setOrderNo(String orderNo) {
        /* 209 */
        this.orderNo = orderNo;

    }


    public Long getPid() {
        /* 220 */
        return this.pid;

    }


    public void setPid(Long pid) {
        /* 231 */
        this.pid = pid;

    }


    public String getContent() {
        /* 242 */
        return this.content;

    }


    public void setContent(String content) {
        /* 253 */
        this.content = content;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\codemirror\model\AppCodeMirror.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */