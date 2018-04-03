
package com.tangtang.trade.hry.web.app.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_dictionary")
public class AppDictionary
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "pid")
    protected Long pid;

    @Column(name = "pDicKey")
    protected String pDicKey;

    @Column(name = "path")
    protected String path;

    @Column(name = "dicKey")
    protected String dicKey;

    @Column(name = "itemName")
    protected String itemName;

    @Column(name = "itemValue")
    protected String itemValue;

    @Column(name = "orderNo")
    protected Integer orderNo;

    @Column(name = "leaf")
    protected Integer leaf;

    @Column(name = "isOld")
    protected Integer isOld;

    @Column(name = "dicDescrption")
    protected String dicDescrption;

    @Column(name = "dicType")
    protected Integer dicType;


    public String getpDicKey() {
        /*  74 */
        return this.pDicKey;

    }


    public void setpDicKey(String pDicKey) {
        /*  82 */
        this.pDicKey = pDicKey;

    }


    public Long getId() {
        /*  97 */
        return this.id;

    }


    public void setId(Long aValue) {
        /* 104 */
        this.id = aValue;

    }


    public String getPath() {
        /* 122 */
        return this.path;

    }


    public Long getPid() {
        /* 133 */
        return this.pid;

    }


    public void setPid(Long pid) {
        /* 144 */
        this.pid = pid;

    }


    public void setPath(String aValue) {
        /* 151 */
        this.path = aValue;

    }


    public String getDicKey() {
        /* 173 */
        return this.dicKey;

    }


    public void setDicKey(String dicKey) {
        /* 181 */
        this.dicKey = dicKey;

    }


    public String getItemName() {
        /* 192 */
        return this.itemName;

    }


    public void setItemName(String itemName) {
        /* 203 */
        this.itemName = itemName;

    }


    public String getItemValue() {
        /* 211 */
        return this.itemValue;

    }


    public void setItemValue(String itemValue) {
        /* 219 */
        this.itemValue = itemValue;

    }


    public Integer getOrderNo() {
        /* 230 */
        return this.orderNo;

    }


    public void setOrderNo(Integer aValue) {
        /* 237 */
        this.orderNo = aValue;

    }


    public Integer getLeaf() {
        /* 248 */
        return this.leaf;

    }


    public void setLeaf(Integer aValue) {
        /* 255 */
        this.leaf = aValue;

    }


    public Integer getIsOld() {
        /* 266 */
        return this.isOld;

    }


    public void setIsOld(Integer aValue) {
        /* 273 */
        this.isOld = aValue;

    }


    public String getDicDescrption() {
        /* 284 */
        return this.dicDescrption;

    }


    public void setDicDescrption(String aValue) {
        /* 291 */
        this.dicDescrption = aValue;

    }


    public Integer getDicType() {
        /* 302 */
        return this.dicType;

    }


    public void setDicType(Integer aValue) {
        /* 309 */
        this.dicType = aValue;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppDictionary.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */