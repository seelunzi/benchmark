/*    */
package com.tangtang.trade.hry.web.app.model;
/*    */
/*    */

import hry.core.mvc.model.BaseModel;

import javax.persistence.*;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
@Table(name = "app_message_category")
/*    */ public class AppMessageCategory
        /*    */ extends BaseModel
        /*    */ {
    /*    */
    @Id
    /*    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*    */
    @Column(name = "id", unique = true, nullable = false)
    /*    */ private Long id;
    /*    */
    @Column(name = "name")
    /*    */ private String name;
    /*    */
    @Column(name = "describes")
    /*    */ private String describes;
    /*    */
    @Column(name = "sort")
    /*    */ private Integer sort;
    /*    */
    @Column(name = "state")
    /*    */ private Integer state;

    /*    */
    /*    */
    public Long getId()
    /*    */ {
        /* 46 */
        return this.id;
        /*    */
    }

    /*    */
    /* 49 */
    public void setId(Long id) {
        this.id = id;
    }

    /*    */
    /*    */
    public String getName() {
        /* 52 */
        return this.name;
        /*    */
    }

    /*    */
    /* 55 */
    public void setName(String name) {
        this.name = name;
    }

    /*    */
    /*    */
    public String getDescribes() {
        /* 58 */
        return this.describes;
        /*    */
    }

    /*    */
    /* 61 */
    public void setDescribes(String describes) {
        this.describes = describes;
    }

    /*    */
    /*    */
    public Integer getSort() {
        /* 64 */
        return this.sort;
        /*    */
    }

    /*    */
    /* 67 */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /*    */
    /*    */
    public Integer getState() {
        /* 70 */
        return this.state;
        /*    */
    }

    /*    */
    /* 73 */
    public void setState(Integer state) {
        this.state = state;
    }

    /*    */
    /*    */
    /*    */
    public AppMessageCategory(Long id, String name, String describes, Integer sort, Integer state)
    /*    */ {
        /* 78 */
        this.id = id;
        /* 79 */
        this.name = name;
        /* 80 */
        this.describes = describes;
        /* 81 */
        this.sort = sort;
        /* 82 */
        this.state = state;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public AppMessageCategory() {
    }

    /*    */
    /*    */
    /*    */
    public String toString()
    /*    */ {
        /* 91 */
        return "AppMessageCategory [id=" + this.id + ", name=" + this.name + ", describes=" + this.describes + ", sort=" + this.sort + ", state=" + this.state + "]";
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppMessageCategory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */