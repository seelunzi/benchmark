
package com.tangtang.trade.hry.web.app.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.util.Date;


@Entity

@Table(name = "app_holiday_config")
public class AppHolidayConfig
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "beginDate")
    private Date beginDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "states")
    private Integer states;


    public Long getId() {
        /* 44 */
        return this.id;

    }


    /* 47 */
    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        /* 50 */
        return this.name;

    }


    /* 53 */
    public void setName(String name) {
        this.name = name;
    }


    public Date getBeginDate() {
        /* 56 */
        return this.beginDate;

    }


    /* 59 */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }


    public Date getEndDate() {
        /* 62 */
        return this.endDate;

    }


    /* 65 */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public Integer getStates() {
        /* 68 */
        return this.states;

    }


    /* 71 */
    public void setStates(Integer states) {
        this.states = states;
    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppHolidayConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */