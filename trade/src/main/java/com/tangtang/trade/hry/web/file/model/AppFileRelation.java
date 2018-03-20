/*     */
package com.tangtang.trade.hry.web.file.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

import javax.persistence.*;

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
@Table(name = "app_file_relation")
/*     */ public class AppFileRelation
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
    @Column(name = "fileId")
    /*     */ protected Long fileId;
    /*     */
    @Column(name = "mkey")
    /*     */ protected String mkey;
    /*     */
    @Column(name = "pkey")
    /*     */ protected String pkey;
    /*     */
    @Column(name = "orgId")
    /*     */ protected Long orgId;
    /*     */
    @Column(name = "userId")
    /*     */ protected Long userId;
    /*     */
    @Column(name = "type")
    /*     */ protected String type;
    /*     */
    @Transient
    /*     */ private String name;
    /*     */
    @Transient
    /*     */ private String orgpId;

    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  75 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /*  84 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getFileId()
    /*     */ {
        /*  93 */
        return this.fileId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setFileId(Long fileId)
    /*     */ {
        /* 102 */
        this.fileId = fileId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getMkey()
    /*     */ {
        /* 111 */
        return this.mkey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setMkey(String mkey)
    /*     */ {
        /* 120 */
        this.mkey = mkey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getPkey()
    /*     */ {
        /* 129 */
        return this.pkey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setPkey(String pkey)
    /*     */ {
        /* 138 */
        this.pkey = pkey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getOrgId()
    /*     */ {
        /* 147 */
        return this.orgId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setOrgId(Long orgId)
    /*     */ {
        /* 156 */
        this.orgId = orgId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getUserId()
    /*     */ {
        /* 168 */
        return this.userId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setUserId(Long userId)
    /*     */ {
        /* 177 */
        this.userId = userId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getType()
    /*     */ {
        /* 186 */
        return this.type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setType(String type)
    /*     */ {
        /* 195 */
        this.type = type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getName()
    /*     */ {
        /* 204 */
        return this.name;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setName(String name)
    /*     */ {
        /* 213 */
        this.name = name;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getOrgpId()
    /*     */ {
        /* 222 */
        return this.orgpId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setOrgpId(String orgpId)
    /*     */ {
        /* 231 */
        this.orgpId = orgpId;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\file\model\AppFileRelation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */