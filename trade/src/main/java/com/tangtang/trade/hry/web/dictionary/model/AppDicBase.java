/*     */
package com.tangtang.trade.hry.web.dictionary.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ public class AppDicBase
        /*     */ extends BaseModel
        /*     */ {
    /*     */
    @Id
    /*     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*     */
    @Column(name = "id", unique = true, nullable = false)
    /*     */ protected Long id;
    /*     */
    @Column(name = "itemName")
    /*     */ protected String itemName;
    /*     */
    @Column(name = "orderNo")
    /*     */ protected Integer orderNo;
    /*     */
    @Column(name = "leaf")
    /*     */ protected Integer leaf;
    /*     */
    @Column(name = "isOld")
    /*     */ protected Integer isOld;
    /*     */
    @Column(name = "dicDescrption")
    /*     */ protected String dicDescrption;
    /*     */
    @Column(name = "pDicKey")
    /*     */ protected String pDicKey;
    /*     */
    @Column(name = "dicKey")
    /*     */ protected String dicKey;

    /*     */
    /*     */
    public String getpDicKey()
    /*     */ {
        /*  56 */
        return this.pDicKey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setpDicKey(String pDicKey)
    /*     */ {
        /*  63 */
        this.pDicKey = pDicKey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getDicKey()
    /*     */ {
        /*  70 */
        return this.dicKey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setDicKey(String dicKey)
    /*     */ {
        /*  77 */
        this.dicKey = dicKey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  84 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /*  91 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getItemName()
    /*     */ {
        /*  98 */
        return this.itemName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setItemName(String itemName)
    /*     */ {
        /* 105 */
        this.itemName = itemName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getOrderNo()
    /*     */ {
        /* 112 */
        return this.orderNo;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setOrderNo(Integer orderNo)
    /*     */ {
        /* 119 */
        this.orderNo = orderNo;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getLeaf()
    /*     */ {
        /* 126 */
        return this.leaf;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setLeaf(Integer leaf)
    /*     */ {
        /* 133 */
        this.leaf = leaf;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getIsOld()
    /*     */ {
        /* 140 */
        return this.isOld;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsOld(Integer isOld)
    /*     */ {
        /* 147 */
        this.isOld = isOld;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getDicDescrption()
    /*     */ {
        /* 154 */
        return this.dicDescrption;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setDicDescrption(String dicDescrption)
    /*     */ {
        /* 161 */
        this.dicDescrption = dicDescrption;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\dictionary\model\AppDicBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */