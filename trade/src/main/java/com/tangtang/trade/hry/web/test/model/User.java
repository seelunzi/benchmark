/*    */
package com.tangtang.trade.hry.web.test.model;
/*    */
/*    */

import hry.core.mvc.model.BaseModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@Entity
/*    */
@Table(name = "t_user")
/*    */
@DynamicInsert(true)
/*    */
@DynamicUpdate(true)
/*    */ public class User
        /*    */ extends BaseModel
        /*    */ {
    /*    */
    @Id
    /*    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*    */
    @Column(name = "id", unique = true, nullable = false)
    /*    */ private Integer id;
    /*    */   private String name;
    /*    */   private int fundnum;

    /*    */
    /*    */
    public int getId()
    /*    */ {
        /* 31 */
        return this.id.intValue();
        /*    */
    }

    /*    */
    /*    */
    public void setId(int id) {
        /* 35 */
        this.id = Integer.valueOf(id);
        /*    */
    }

    /*    */
    /*    */
    public String getName() {
        /* 39 */
        return this.name;
        /*    */
    }

    /*    */
    /*    */
    public void setName(String name) {
        /* 43 */
        this.name = name;
        /*    */
    }

    /*    */
    /*    */
    public int getFundnum() {
        /* 47 */
        return this.fundnum;
        /*    */
    }

    /*    */
    /*    */
    public void setFundnum(int fundnum) {
        /* 51 */
        this.fundnum = fundnum;
        /*    */
    }

    /*    */
    /*    */
    public User(int id, String name, Integer i)
    /*    */ {
        /* 56 */
        this.id = Integer.valueOf(id);
        /* 57 */
        this.name = name;
        /* 58 */
        this.fundnum = i.intValue();
        /*    */
    }

    /*    */
    /*    */
    public User() {
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\test\model\User.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */