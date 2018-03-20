/*    */
package com.tangtang.trade.hry.oauth.user.model;
/*    */
/*    */

import hry.core.mvc.model.BaseModel;

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
@Table(name = "app_role_resource")
/*    */ public class AppRoleResource
        /*    */ extends BaseModel
        /*    */ {
    /*    */
    @Id
    /*    */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*    */
    @Column(name = "id", unique = true, nullable = false)
    /*    */ private Long id;
    /*    */
    @Column(name = "roleId", unique = false, nullable = false)
    /*    */ private Long roleId;
    /*    */
    @Column(name = "resourceId", unique = false, nullable = false)
    /*    */ private Long resourceId;

    /*    */
    /*    */
    public Long getId()
    /*    */ {
        /* 40 */
        return this.id;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void setId(Long id)
    /*    */ {
        /* 47 */
        this.id = id;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public Long getRoleId()
    /*    */ {
        /* 54 */
        return this.roleId;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void setRoleId(Long roleId)
    /*    */ {
        /* 61 */
        this.roleId = roleId;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public Long getResourceId()
    /*    */ {
        /* 68 */
        return this.resourceId;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    public void setResourceId(Long resourceId)
    /*    */ {
        /* 75 */
        this.resourceId = resourceId;
        /*    */
    }
    /*    */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppRoleResource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */