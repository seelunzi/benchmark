/*    */
package com.tangtang.trade.hry.core.mvc.model.constant;
/*    */
/*    */

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
@Entity
/*    */
@Table(name = "constantTip")
/*    */
@DynamicInsert(true)
/*    */
@DynamicUpdate(true)
/*    */ public class ConstantTip
        /*    */ {
    /*    */
    @Id
    /*    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*    */
    @Column(name = "id", unique = true, nullable = false)
    /*    */ private Long id;
    /*    */   private String tipkey;
    /*    */   private String tipvalue;

    /*    */
    /*    */
    public Long getId()
    /*    */ {
        /* 45 */
        return this.id;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public void setId(Long id)
    /*    */ {
        /* 53 */
        this.id = id;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public String getTipkey()
    /*    */ {
        /* 61 */
        return this.tipkey;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public void setTipkey(String tipkey)
    /*    */ {
        /* 69 */
        this.tipkey = tipkey;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public String getTipvalue()
    /*    */ {
        /* 77 */
        return this.tipvalue;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public void setTipvalue(String tipvalue)
    /*    */ {
        /* 85 */
        this.tipvalue = tipvalue;
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\constant\ConstantTip.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */