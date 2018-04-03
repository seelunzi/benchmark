
package com.tangtang.trade.hry.oauth.user.model;


import hry.core.mvc.model.BaseModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity

@Table(name = "app_user_level")

@DynamicInsert(true)

@DynamicUpdate(true)
public class AppUserLevel
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "superiorId")
    private Long superiorId;

    @Column(name = "name")
    private String name;


    public Long getId() {
        /*  55 */
        return this.id;

    }


    public void setId(Long id) {
        /*  63 */
        this.id = id;

    }


    public Long getUserId() {
        /*  71 */
        return this.userId;

    }


    public void setUserId(Long userId) {
        /*  79 */
        this.userId = userId;

    }


    public Long getSuperiorId() {
        /*  87 */
        return this.superiorId;

    }


    public void setSuperiorId(Long superiorId) {
        /*  95 */
        this.superiorId = superiorId;

    }


    public String getName() {
        /* 103 */
        return this.name;

    }


    public void setName(String name) {
        /* 111 */
        this.name = name;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppUserLevel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */