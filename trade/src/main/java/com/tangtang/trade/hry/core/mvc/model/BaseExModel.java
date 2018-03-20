/*     */
package com.tangtang.trade.hry.core.mvc.model;
/*     */
/*     */

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

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
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
@MappedSuperclass
/*     */ public class BaseExModel
        /*     */ implements Serializable
        /*     */ {
    /*     */   private static final long serialVersionUID = -4825890686624512635L;
    /*     */
    @Column(name = "saasId")
    /*     */ private String saasId;
    /*     */
    @Column(name = "created")
    /*     */ private Date created;
    /*     */
    @Column(name = "modified")
    /*     */ private Date modified;
    /*     */
    @Column(name = "currencyType")
    /*     */ private String currencyType;
    /*     */
    @Column(name = "website")
    /*     */ private String website;
    /*     */
    @Transient
    /*     */
    @Column(name = "keepDecimalForCoin")
    /*     */ private Integer keepDecimalForCoin;
    /*     */
    @Transient
    /*     */
    @Column(name = "keepDecimalForCurrency")
    /*     */ private Integer keepDecimalForCurrency;

    /*     */
    /*     */
    public Integer getKeepDecimalForCoin()
    /*     */ {
        /*  62 */
        return this.keepDecimalForCoin;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setKeepDecimalForCoin(Integer keepDecimalForCoin)
    /*     */ {
        /*  71 */
        this.keepDecimalForCoin = keepDecimalForCoin;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getKeepDecimalForCurrency()
    /*     */ {
        /*  80 */
        return this.keepDecimalForCurrency;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setKeepDecimalForCurrency(Integer keepDecimalForCurrency)
    /*     */ {
        /*  89 */
        this.keepDecimalForCurrency = keepDecimalForCurrency;
        /*     */
    }

    /*     */
    /*  92 */
    public String getSaasId() {
        return this.saasId;
    }

    /*     */
    /*     */
    public void setSaasId(String saasId)
    /*     */ {
        /*  96 */
        this.saasId = saasId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Date getCreated()
    /*     */ {
        /* 104 */
        return this.created;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setCreated(Date created)
    /*     */ {
        /* 112 */
        this.created = created;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Date getModified()
    /*     */ {
        /* 120 */
        return this.modified;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setModified(Date modified)
    /*     */ {
        /* 128 */
        this.modified = modified;
        /*     */
    }

    /*     */
    /*     */
    public String getCurrencyType() {
        /* 132 */
        return this.currencyType;
        /*     */
    }

    /*     */
    /*     */
    public void setCurrencyType(String currencyType) {
        /* 136 */
        this.currencyType = currencyType;
        /*     */
    }

    /*     */
    /*     */
    public String getWebsite() {
        /* 140 */
        return this.website;
        /*     */
    }

    /*     */
    /*     */
    public void setWebsite(String website) {
        /* 144 */
        this.website = website;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\BaseExModel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */