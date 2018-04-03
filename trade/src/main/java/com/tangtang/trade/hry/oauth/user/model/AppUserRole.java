
package com.tangtang.trade.hry.oauth.user.model;


import hry.core.mvc.model.BaseModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity

@Table(name = "app_user_role")

@DynamicInsert(true)

@DynamicUpdate(true)
public class AppUserRole
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "userId", unique = false, nullable = false)
    private Long userId;

    @Column(name = "roleId", unique = false, nullable = false)
    private Long roleId;


    public Long getId() {
        /* 47 */
        return this.id;

    }


    public void setId(Long id) {
        /* 55 */
        this.id = id;

    }


    public Long getUserId() {
        /* 63 */
        return this.userId;

    }


    public void setUserId(Long userId) {
        /* 71 */
        this.userId = userId;

    }


    public Long getRoleId() {
        /* 79 */
        return this.roleId;

    }


    public void setRoleId(Long roleId) {
        /* 87 */
        this.roleId = roleId;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppUserRole.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */