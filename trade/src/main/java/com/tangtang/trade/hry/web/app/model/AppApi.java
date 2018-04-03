
package com.tangtang.trade.hry.web.app.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.util.List;


@Table(name = "app_api")
public class AppApi
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "isShow")
    private Integer isShow;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "requestUrl")
    private String requestUrl;

    @Column(name = "version")
    private String version;

    @Column(name = "remark1")
    private String remark1;

    @Column(name = "remark2")
    private String remark2;

    @Column(name = "remark3")
    private String remark3;

    @Transient
    private List<AppApiParam> list;


    public List<AppApiParam> getList() {
        /*  78 */
        return this.list;

    }


    public void setList(List<AppApiParam> list) {
        /*  88 */
        this.list = list;

    }


    public Long getId() {
        /*  99 */
        return this.id;

    }


    public Integer getIsShow() {
        /* 109 */
        return this.isShow;

    }


    public void setId(Long id) {
        /* 123 */
        this.id = id;

    }


    public String getDescription() {
        /* 134 */
        return this.description;

    }


    public void setDescription(String description) {
        /* 144 */
        this.description = description;

    }


    public String getTitle() {
        /* 154 */
        return this.title;

    }


    public String getRemark1() {
        /* 173 */
        return this.remark1;

    }


    public String getRemark2() {
        /* 183 */
        return this.remark2;

    }


    public String getRemark3() {
        /* 193 */
        return this.remark3;

    }


    public void setTitle(String title) {
        /* 203 */
        this.title = title;

    }


    public String getRequestUrl() {
        /* 213 */
        return this.requestUrl;

    }


    public String getVersion() {
        /* 223 */
        return this.version;

    }


    public void setRequestUrl(String requestUrl) {
        /* 233 */
        this.requestUrl = requestUrl;

    }


    public void setVersion(String version) {
        /* 243 */
        this.version = version;

    }


    public void setRemark1(String remark1) {
        /* 253 */
        this.remark1 = remark1;

    }


    public void setRemark2(String remark2) {
        /* 263 */
        this.remark2 = remark2;

    }


    public void setRemark3(String remark3) {
        /* 273 */
        this.remark3 = remark3;

    }


    public void setIsShow(Integer isShow) {
        /* 283 */
        this.isShow = isShow;

    }


    public Integer getSort() {
        /* 292 */
        return this.sort;

    }


    public void setSort(Integer sort) {
        /* 300 */
        this.sort = sort;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */