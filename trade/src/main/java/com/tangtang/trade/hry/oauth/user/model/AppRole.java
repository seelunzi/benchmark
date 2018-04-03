
package com.tangtang.trade.hry.oauth.user.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Table(name = "app_role")
public class AppRole
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Version

    @Column(name = "version", length = 11)
    private int version;

    @Column(name = "name")
    private String name;

    @Column(name = "remark")
    private String remark;

    @Column(name = "isDelete")
    /*  48 */ private String isDelete = "0";


    @Column(name = "type")
    /*  53 */ private String type = "normal";


    @Column(name = "money")
    /*  57 */ private BigDecimal money = new BigDecimal("0");


    @Transient
    private Set<AppResource> appResourceSet;


    public BigDecimal getMoney() {
        /*  65 */
        return this.money;

    }


    public void setMoney(BigDecimal money) {
        /*  73 */
        this.money = money;

    }


    public int getVersion() {
        /*  81 */
        return this.version;

    }


    public void setVersion(int version) {
        /*  89 */
        this.version = version;

    }


    public Long getId() {
        /* 103 */
        return this.id;

    }


    public void setId(Long id) {
        /* 111 */
        this.id = id;

    }


    public String getName() {
        /* 119 */
        return this.name;

    }


    public void setName(String name) {
        /* 127 */
        this.name = name;

    }


    public String getRemark() {
        /* 136 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 144 */
        this.remark = remark;

    }


    public Set<AppResource> getAppResourceSet() {
        /* 154 */
        return this.appResourceSet;

    }


    public void setAppResourceSet(Set<AppResource> appResourceSet) {
        /* 162 */
        this.appResourceSet = appResourceSet;

    }


    public String getIsDelete() {
        /* 170 */
        return this.isDelete;

    }


    public void setIsDelete(String isDelete) {
        /* 178 */
        this.isDelete = isDelete;

    }


    public String getType() {
        /* 186 */
        return this.type;

    }


    public void setType(String type) {
        /* 194 */
        this.type = type;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppRole.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */