/*     */
package com.tangtang.trade.hry.oauth.user.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@Entity
/*     */
@Table(name = "app_user_organization")
/*     */
@DynamicInsert(true)
/*     */
@DynamicUpdate(true)
/*     */ public class AppUserOrganization
        /*     */ extends BaseModel
        /*     */ {
    /*     */
    @Id
    /*     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*     */
    @Column(name = "id", unique = true, nullable = false)
    /*     */ private Long id;
    /*     */
    @Column(name = "userId", unique = false, nullable = false)
    /*     */ private Long userId;
    /*     */
    @Column(name = "organizationId", unique = false, nullable = false)
    /*     */ private Long organizationId;
    /*     */
    @Column(name = "type", unique = false, nullable = false)
    /*     */ private String type;

    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  56 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /*  64 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getUserId()
    /*     */ {
        /*  72 */
        return this.userId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setUserId(Long userId)
    /*     */ {
        /*  80 */
        this.userId = userId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Long getOrganizationId()
    /*     */ {
        /*  88 */
        return this.organizationId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setOrganizationId(Long organizationId)
    /*     */ {
        /*  96 */
        this.organizationId = organizationId;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getType()
    /*     */ {
        /* 104 */
        return this.type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setType(String type)
    /*     */ {
        /* 112 */
        this.type = type;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppUserOrganization.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */