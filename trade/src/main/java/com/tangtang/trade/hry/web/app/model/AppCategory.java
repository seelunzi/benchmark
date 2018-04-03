
package com.tangtang.trade.hry.web.app.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_artic_category")
public class AppCategory
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "preateId")
    private Long preateId;

    @Column(name = "preateName")
    private String preateName;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "seoFication")
    private String seoFication;

    @Column(name = "footerUrl")
    private String footerUrl;

    @Column(name = "state")
    private Integer state;

    @Column(name = "isShow")
    private Integer isShow;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "describes")
    private String describes;

    @Column(name = "website")
    private String website;


    public String getWebsite() {
        /*  57 */
        return this.website;

    }


    public void setWebsite(String website) {
        /*  61 */
        this.website = website;

    }


    public Long getId() {
        /*  65 */
        return this.id;

    }


    public void setId(Long id) {
        /*  69 */
        this.id = id;

    }


    public Long getPreateId() {
        /*  73 */
        return this.preateId;

    }


    public String getDescribes() {
        /*  77 */
        return this.describes;

    }


    public void setDescribes(String describes) {
        /*  81 */
        this.describes = describes;

    }


    public String getFooterUrl() {
        /*  85 */
        return this.footerUrl;

    }


    public void setFooterUrl(String footerUrl) {
        /*  89 */
        this.footerUrl = footerUrl;

    }


    public Integer getIsShow() {
        /*  93 */
        return this.isShow;

    }


    public void setIsShow(Integer isShow) {
        /*  97 */
        this.isShow = isShow;

    }


    public void setPreateId(Long preateId) {
        /* 101 */
        this.preateId = preateId;

    }


    public String getName() {
        /* 105 */
        return this.name;

    }


    public void setName(String name) {
        /* 109 */
        this.name = name;

    }


    public String getPreateName() {
        /* 113 */
        return this.preateName;

    }


    public void setPreateName(String preateName) {
        /* 117 */
        this.preateName = preateName;

    }


    public String getType() {
        /* 121 */
        return this.type;

    }


    public void setType(String type) {
        /* 125 */
        this.type = type;

    }


    public String getSeoFication() {
        /* 129 */
        return this.seoFication;

    }


    public void setSeoFication(String seoFication) {
        /* 133 */
        this.seoFication = seoFication;

    }


    public Integer getState() {
        /* 137 */
        return this.state;

    }


    public void setState(Integer state) {
        /* 141 */
        this.state = state;

    }


    public Integer getSort() {
        /* 145 */
        return this.sort;

    }


    public void setSort(Integer sort) {
        /* 149 */
        this.sort = sort;

    }


    public AppCategory(Long id, Long preateId, String name, String type, String seoFication, Integer state, Integer sort, String describes) {
        /* 155 */
        this.id = id;
        /* 156 */
        this.preateId = preateId;
        /* 157 */
        this.name = name;
        /* 158 */
        this.type = type;
        /* 159 */
        this.seoFication = seoFication;
        /* 160 */
        this.state = state;
        /* 161 */
        this.sort = sort;
        /* 162 */
        this.describes = describes;

    }


    public AppCategory() {
    }


    public String toString() {
        /* 171 */
        return "AppCategory [id=" + this.id + ", preateId=" + this.preateId + ", preateName=" + this.preateName + ", name=" + this.name + ", type=" + this.type + ", seoFication=" + this.seoFication + ", footerUrl=" + this.footerUrl + ", state=" + this.state + ", isShow=" + this.isShow + ", sort=" + this.sort + ", describes=" + this.describes + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppCategory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */