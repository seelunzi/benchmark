
package com.tangtang.trade.hry.oauth.user.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Table(name = "app_user")
public class AppUser
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "appuserprefix")
    private String appuserprefix;

    @Column(name = "isDelete")
    /*  50 */ private String isDelete = "0";


    @Column(name = "isLock")
    /*  54 */ private String isLock = "0";


    @Column(name = "salt")
    private String salt;




    @Column(name = "picturePath")
    private String picturePath;




    @Column(name = "name")
    private String name;




    @Column(name = "number")
    private String number;




    @Column(name = "email")
    private String email;




    @Column(name = "workDate")
    private Date workDate;



    @Column(name = "homeAddress")
    private String homeAddress;



    @Column(name = "age")
    private Integer age;



    @Column(name = "sex")
    private String sex;



    @Column(name = "birthday")
    private Date birthday;



    @Column(name = "mobilePhone")
    private String mobilePhone;



    @Column(name = "secondPhone")
    private String secondPhone;



    @Column(name = "qqNumber")
    private String qqNumber;



    @Column(name = "weixinNumber")
    private String weixinNumber;



    @Column(name = "remark")
    private String remark;



    @Transient
    private Set<AppOrganization> companySet;



    @Transient
    private Set<AppOrganization> shopSet;



    @Transient
    private Set<AppOrganization> departmentSet;



    @Transient
    private Set<AppRole> appRoleSet;



    @Transient
    private String roleName;



    @Transient
    private String departmentName;


    public Long getId() {
        /* 150 */
        return this.id;

    }


    public void setId(Long id) {
        /* 158 */
        this.id = id;

    }


    public String getUsername() {
        /* 166 */
        return this.username;

    }


    public void setUsername(String username) {
        /* 174 */
        this.username = username;

    }


    public String getPassword() {
        /* 182 */
        return this.password;

    }


    public void setPassword(String password) {
        /* 190 */
        this.password = password;

    }


    public String getSalt() {
        /* 198 */
        return this.salt;

    }


    public void setSalt(String salt) {
        /* 206 */
        this.salt = salt;

    }


    public String getName() {
        /* 214 */
        return this.name;

    }


    public void setName(String name) {
        /* 222 */
        this.name = name;

    }


    public Integer getAge() {
        /* 230 */
        return this.age;

    }


    public void setAge(Integer age) {
        /* 238 */
        this.age = age;

    }


    public String getSex() {
        /* 246 */
        return this.sex;

    }


    public void setSex(String sex) {
        /* 254 */
        this.sex = sex;

    }


    public Date getBirthday() {
        /* 262 */
        return this.birthday;

    }


    public void setBirthday(Date birthday) {
        /* 270 */
        this.birthday = birthday;

    }


    public String getMobilePhone() {
        /* 278 */
        return this.mobilePhone;

    }


    public void setMobilePhone(String mobilePhone) {
        /* 286 */
        this.mobilePhone = mobilePhone;

    }


    public String getQqNumber() {
        /* 294 */
        return this.qqNumber;

    }


    public void setQqNumber(String qqNumber) {
        /* 302 */
        this.qqNumber = qqNumber;

    }


    public String getWeixinNumber() {
        /* 310 */
        return this.weixinNumber;

    }


    public void setWeixinNumber(String weixinNumber) {
        /* 318 */
        this.weixinNumber = weixinNumber;

    }


    public String getAppuserprefix() {
        /* 328 */
        return this.appuserprefix;

    }


    public void setAppuserprefix(String appuserprefix) {
        /* 336 */
        this.appuserprefix = appuserprefix;

    }


    public String getNumber() {
        /* 345 */
        return this.number;

    }


    public void setNumber(String number) {
        /* 353 */
        this.number = number;

    }


    public String getEmail() {
        /* 361 */
        return this.email;

    }


    public void setEmail(String email) {
        /* 369 */
        this.email = email;

    }


    public Date getWorkDate() {
        /* 377 */
        return this.workDate;

    }


    public void setWorkDate(Date workDate) {
        /* 385 */
        this.workDate = workDate;

    }


    public String getHomeAddress() {
        /* 393 */
        return this.homeAddress;

    }


    public void setHomeAddress(String homeAddress) {
        /* 401 */
        this.homeAddress = homeAddress;

    }


    public String getSecondPhone() {
        /* 409 */
        return this.secondPhone;

    }


    public void setSecondPhone(String secondPhone) {
        /* 417 */
        this.secondPhone = secondPhone;

    }


    public String getRemark() {
        /* 425 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 433 */
        this.remark = remark;

    }


    public String getPicturePath() {
        /* 441 */
        return this.picturePath;

    }


    public void setPicturePath(String picturePath) {
        /* 449 */
        this.picturePath = picturePath;

    }


    public String getIsDelete() {
        /* 457 */
        return this.isDelete;

    }


    public void setIsDelete(String isDelete) {
        /* 465 */
        this.isDelete = isDelete;

    }


    public String getIsLock() {
        /* 473 */
        return this.isLock;

    }


    public void setIsLock(String isLock) {
        /* 481 */
        this.isLock = isLock;

    }


    public Set<AppOrganization> getCompanySet() {
        /* 489 */
        return this.companySet;

    }


    public void setCompanySet(Set<AppOrganization> companySet) {
        /* 497 */
        this.companySet = companySet;

    }


    public Set<AppOrganization> getShopSet() {
        /* 505 */
        return this.shopSet;

    }


    public void setShopSet(Set<AppOrganization> shopSet) {
        /* 513 */
        this.shopSet = shopSet;

    }


    public Set<AppOrganization> getDepartmentSet() {
        /* 521 */
        return this.departmentSet;

    }


    public void setDepartmentSet(Set<AppOrganization> departmentSet) {
        /* 529 */
        this.departmentSet = departmentSet;

    }


    public Set<AppRole> getAppRoleSet() {
        /* 537 */
        return this.appRoleSet;

    }


    public void setAppRoleSet(Set<AppRole> appRoleSet) {
        /* 545 */
        this.appRoleSet = appRoleSet;

    }


    public String getRoleName() {
        /* 553 */
        return this.roleName;

    }


    public void setRoleName(String roleName) {
        /* 561 */
        this.roleName = roleName;

    }


    public String getDepartmentName() {
        /* 569 */
        return this.departmentName;

    }


    public void setDepartmentName(String departmentName) {
        /* 577 */
        this.departmentName = departmentName;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppUser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */