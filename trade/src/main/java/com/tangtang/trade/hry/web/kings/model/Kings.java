
package com.tangtang.trade.hry.web.kings.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "s_kings")
public class Kings
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "work")
    private String work;


    public Integer getId() {
        /*  47 */
        return this.id;

    }


    public void setId(Integer id) {
        /*  58 */
        this.id = id;

    }


    public String getName() {
        /*  70 */
        return this.name;

    }


    public void setName(String name) {
        /*  81 */
        this.name = name;

    }


    public String getWork() {
        /*  92 */
        return this.work;

    }


    public void setWork(String work) {
        /* 103 */
        this.work = work;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\kings\model\Kings.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */