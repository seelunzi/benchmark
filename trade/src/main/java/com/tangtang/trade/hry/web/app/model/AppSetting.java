
package com.tangtang.trade.hry.web.app.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_setting")
public class AppSetting
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "propertiesName")
    protected String propertiesName;

    @Column(name = "isOpen")
    protected Integer isOpen;

    @Column(name = "propertiesUrl")
    protected String propertiesUrl;

    @Column(name = "remark")
    protected String remark;


    public Long getId() {
        /*  45 */
        return this.id;

    }


    public String getPropertiesUrl() {
        /*  53 */
        return this.propertiesUrl;

    }


    public void setPropertiesUrl(String propertiesUrl) {
        /*  61 */
        this.propertiesUrl = propertiesUrl;

    }


    public void setId(Long id) {
        /*  69 */
        this.id = id;

    }


    public String getPropertiesName() {
        /*  77 */
        return this.propertiesName;

    }


    public void setPropertiesName(String propertiesName) {
        /*  85 */
        this.propertiesName = propertiesName;

    }


    public Integer getIsOpen() {
        /*  93 */
        return this.isOpen;

    }


    public void setIsOpen(Integer isOpen) {
        /* 101 */
        this.isOpen = isOpen;

    }


    public String getRemark() {
        /* 109 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 117 */
        this.remark = remark;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppSetting.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */