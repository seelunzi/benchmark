
package com.tangtang.trade.hry.core.mvc.model;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity

@Table(name = "app_config")

@DynamicInsert(true)

@DynamicUpdate(true)
public class AppConfig
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long configid;
    protected String configkey;
    protected String value;
    protected String configdescription;
    protected String typename;
    protected String typekey;
    protected String configname;
    protected String datatype;
    protected int ishidden;


    public int getIshidden() {
        /*  48 */
        return this.ishidden;

    }


    public void setIshidden(int ishidden) {
        /*  52 */
        this.ishidden = ishidden;

    }


    public String getTypename() {
        /*  60 */
        return this.typename;

    }


    public void setTypename(String typename) {
        /*  68 */
        this.typename = typename;

    }


    public String getTypekey() {
        /*  76 */
        return this.typekey;

    }


    public void setTypekey(String typekey) {
        /*  84 */
        this.typekey = typekey;

    }


    public String getConfigname() {
        /*  92 */
        return this.configname;

    }


    public void setConfigname(String configname) {
        /* 100 */
        this.configname = configname;

    }


    public String getDatatype() {
        /* 108 */
        return this.datatype;

    }


    public void setDatatype(String datatype) {
        /* 116 */
        this.datatype = datatype;

    }


    public Long getConfigid() {
        /* 126 */
        return this.configid;

    }


    public void setConfigid(Long aValue) {
        /* 133 */
        this.configid = aValue;

    }


    public String getValue() {
        /* 149 */
        return this.value;

    }


    public String getConfigkey() {
        /* 157 */
        return this.configkey;

    }


    public void setConfigkey(String configkey) {
        /* 165 */
        this.configkey = configkey;

    }


    public String getConfigdescription() {
        /* 173 */
        return this.configdescription;

    }


    public void setConfigdescription(String configdescription) {
        /* 181 */
        this.configdescription = configdescription;

    }


    public void setValue(String aValue) {
        /* 188 */
        this.value = aValue;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\AppConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */