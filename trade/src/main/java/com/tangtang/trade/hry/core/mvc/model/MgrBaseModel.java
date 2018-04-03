
package com.tangtang.trade.hry.core.mvc.model;


import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;


@MappedSuperclass
public class MgrBaseModel
        implements Serializable {
    public Timestamp created;
    public Timestamp modified;


    public Timestamp getCreated() {
        /* 35 */
        return this.created;

    }


    public void setCreated(Timestamp created) {
        /* 39 */
        this.created = created;

    }


    public Timestamp getModified() {
        /* 43 */
        return this.modified;

    }


    public void setModified(Timestamp modified) {
        /* 47 */
        this.modified = modified;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\MgrBaseModel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */