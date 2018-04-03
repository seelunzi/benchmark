
package com.tangtang.trade.hry.web.quartz.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_quartz_job")
public class AppQuartzJob
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "beanClass")
    private String beanClass;

    @Column(name = "methodName")
    private String methodName;

    @Column(name = "quarzTime")
    private String quarzTime;

    @Column(name = "remark")
    private String remark;

    @Column(name = "start")
    private Integer start;


    public Long getId() {
        /*  60 */
        return this.id;

    }


    public void setId(Long id) {
        /*  71 */
        this.id = id;

    }


    public String getName() {
        /*  82 */
        return this.name;

    }


    public void setName(String name) {
        /*  93 */
        this.name = name;

    }


    public String getBeanClass() {
        /* 104 */
        return this.beanClass;

    }


    public void setBeanClass(String beanClass) {
        /* 115 */
        this.beanClass = beanClass;

    }


    public String getMethodName() {
        /* 126 */
        return this.methodName;

    }


    public void setMethodName(String methodName) {
        /* 137 */
        this.methodName = methodName;

    }


    public String getQuarzTime() {
        /* 148 */
        return this.quarzTime;

    }


    public void setQuarzTime(String quarzTime) {
        /* 159 */
        this.quarzTime = quarzTime;

    }


    public String getRemark() {
        /* 170 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 181 */
        this.remark = remark;

    }


    public Integer getStart() {
        /* 192 */
        return this.start;

    }


    public void setStart(Integer start) {
        /* 203 */
        this.start = start;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\quartz\model\AppQuartzJob.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */