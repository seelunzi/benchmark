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
@Entity
/*    */
@Table(name = "t_biao")
/*    */
@DynamicInsert(true)
/*    */
@DynamicUpdate(true)
/*    */ public class Biao
        /*    */ extends BaseModel
        /*    */ {
    /*    */
    @Id
    /*    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*    */
    @Column(name = "id", unique = true, nullable = false)
    /*    */ private Integer id;
    /*    */   private int sumMoney;
    /*    */   private int nowMoney;
    /*    */   private String biaoName;
    /*    */
    @Version
    /*    */ private Integer version;

    /*    */
    /*    */
    public int getId()
    /*    */ {
        /* 33 */
        return this.id.intValue();
        /*    */
    }

    /*    */
    /*    */
    public void setId(int id) {
        /* 37 */
        this.id = Integer.valueOf(id);
        /*    */
    }

    /*    */
    /*    */
    public int getSumMoney() {
        /* 41 */
        return this.sumMoney;
        /*    */
    }

    /*    */
    /*    */
    public void setSumMoney(int sumMoney) {
        /* 45 */
        this.sumMoney = sumMoney;
        /*    */
    }

    /*    */
    /*    */
    public int getNowMoney() {
        /* 49 */
        return this.nowMoney;
        /*    */
    }

    /*    */
    /*    */
    public void setNowMoney(int nowMoney) {
        /* 53 */
        this.nowMoney = nowMoney;
        /*    */
    }

    /*    */
    /*    */
    public String getBiaoName() {
        /* 57 */
        return this.biaoName;
        /*    */
    }

    /*    */
    /*    */
    public void setBiaoName(String biaoName) {
        /* 61 */
        this.biaoName = biaoName;
        /*    */
    }

    /*    */
    /*    */
    public Integer getVersion() {
        /* 65 */
        return this.version;
        /*    */
    }

    /*    */
    /*    */
    public void setVersion(Integer version) {
        /* 69 */
        this.version = version;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Biao(int id, int sumMoney, int nowMoney, String biaoName, Integer version)
    /*    */ {
        /* 75 */
        this.id = Integer.valueOf(id);
        /* 76 */
        this.sumMoney = sumMoney;
        /* 77 */
        this.nowMoney = nowMoney;
        /* 78 */
        this.biaoName = biaoName;
        /* 79 */
        this.version = version;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    public Biao() {
    }

    /*    */
    /*    */
    /*    */
    public String toString()
    /*    */ {
        /* 88 */
        return "Biao [id=" + this.id + ", sumMoney=" + this.sumMoney + ", nowMoney=" + this.nowMoney + ", biaoName=" + this.biaoName + ", version=" + this.version + "]";
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\test\model\Biao.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */