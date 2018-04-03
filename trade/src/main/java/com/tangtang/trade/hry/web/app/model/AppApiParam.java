
package com.tangtang.trade.hry.web.app.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_api_param")
public class AppApiParam
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "param")
    private String param;

    @Column(name = "paramName")
    private String paramName;

    @Column(name = "paramType")
    private String paramType;

    @Column(name = "paramDesc")
    private String paramDesc;

    @Column(name = "isRequired")
    private Integer isRequired;

    @Column(name = "example")
    private String example;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "apiId")
    private Long apiId;

    @Column(name = "remark1")
    private String remark1;

    @Column(name = "remark2")
    private String remark2;

    @Column(name = "remark3")
    private String remark3;


    public Long getId() {
        /*  86 */
        return this.id;

    }


    public Integer getIsRequired() {
        /*  97 */
        return this.isRequired;

    }


    public Integer getSort() {
        /* 106 */
        return this.sort;

    }


    public String getRemark1() {
        /* 116 */
        return this.remark1;

    }


    public String getRemark2() {
        /* 124 */
        return this.remark2;

    }


    public String getRemark3() {
        /* 132 */
        return this.remark3;

    }


    public void setId(Long id) {
        /* 140 */
        this.id = id;

    }


    public String getParam() {
        /* 151 */
        return this.param;

    }


    public String getParamName() {
        /* 159 */
        return this.paramName;

    }


    public String getParamType() {
        /* 167 */
        return this.paramType;

    }


    public String getParamDesc() {
        /* 175 */
        return this.paramDesc;

    }


    public String getExample() {
        /* 183 */
        return this.example;

    }


    public void setParam(String param) {
        /* 191 */
        this.param = param;

    }


    public void setParamName(String paramName) {
        /* 199 */
        this.paramName = paramName;

    }


    public void setParamType(String paramType) {
        /* 207 */
        this.paramType = paramType;

    }


    public void setParamDesc(String paramDesc) {
        /* 215 */
        this.paramDesc = paramDesc;

    }


    public void setExample(String example) {
        /* 223 */
        this.example = example;

    }


    public void setIsRequired(Integer isRequired) {
        /* 231 */
        this.isRequired = isRequired;

    }


    public void setSort(Integer sort) {
        /* 240 */
        this.sort = sort;

    }


    public void setRemark1(String remark1) {
        /* 249 */
        this.remark1 = remark1;

    }


    public Long getApiId() {
        /* 257 */
        return this.apiId;

    }


    public void setApiId(Long apiId) {
        /* 265 */
        this.apiId = apiId;

    }


    public void setRemark2(String remark2) {
        /* 273 */
        this.remark2 = remark2;

    }


    public void setRemark3(String remark3) {
        /* 281 */
        this.remark3 = remark3;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppApiParam.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */