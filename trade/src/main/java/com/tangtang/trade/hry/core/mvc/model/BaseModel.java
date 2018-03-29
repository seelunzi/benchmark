/*    */
package com.tangtang.trade.hry.core.mvc.model;
/*    */
/*    */

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

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
@MappedSuperclass
/*    */ public class BaseModel
        /*    */ implements Serializable
        /*    */ {
    /*    */   private static final long serialVersionUID = -4825890686624512635L;
    /*    */
    @Column(name = "saasId")
    /*    */ private String saasId;
    /*    */
    @Column(name = "created")
    /*    */ private Date created;
    /*    */
    @Column(name = "modified")
    /*    */ private Date modified;

    /*    */
    /*    */
    public String getSaasId()
    /*    */ {
        /* 43 */
        return this.saasId;
        /*    */
    }

    /*    */
    /*    */
    public void setSaasId(String saasId) {
        /* 47 */
        this.saasId = saasId;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public Date getCreated()
    /*    */ {
        /* 55 */
        return this.created;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public void setCreated(Date created)
    /*    */ {
        /* 63 */
        this.created = created;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public Date getModified()
    /*    */ {
        /* 71 */
        return this.modified;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public void setModified(Date modified)
    /*    */ {
        /* 79 */
        this.modified = modified;
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\BaseModel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */