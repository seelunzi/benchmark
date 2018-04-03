
package com.tangtang.trade.hry.oauth.user.model;


import hry.core.mvc.model.BaseModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;


@Entity

@Table(name = "app_user_info")

@DynamicInsert(true)

@DynamicUpdate(true)
public class AppUserInfo
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "userId", unique = false, nullable = false)
    private Long userId;

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


    public Long getId() {
        /* 103 */
        return this.id;

    }


    public void setId(Long id) {
        /* 111 */
        this.id = id;

    }


    public String getPicturePath() {
        /* 119 */
        return this.picturePath;

    }


    public void setPicturePath(String picturePath) {
        /* 127 */
        this.picturePath = picturePath;

    }


    public String getName() {
        /* 135 */
        return this.name;

    }


    public void setName(String name) {
        /* 143 */
        this.name = name;

    }


    public String getNumber() {
        /* 151 */
        return this.number;

    }


    public void setNumber(String number) {
        /* 159 */
        this.number = number;

    }


    public String getEmail() {
        /* 167 */
        return this.email;

    }


    public void setEmail(String email) {
        /* 175 */
        this.email = email;

    }


    public Date getWorkDate() {
        /* 183 */
        return this.workDate;

    }


    public void setWorkDate(Date workDate) {
        /* 191 */
        this.workDate = workDate;

    }


    public String getHomeAddress() {
        /* 199 */
        return this.homeAddress;

    }


    public void setHomeAddress(String homeAddress) {
        /* 207 */
        this.homeAddress = homeAddress;

    }


    public Integer getAge() {
        /* 215 */
        return this.age;

    }


    public void setAge(Integer age) {
        /* 223 */
        this.age = age;

    }


    public String getSex() {
        /* 231 */
        return this.sex;

    }


    public void setSex(String sex) {
        /* 239 */
        this.sex = sex;

    }


    public Date getBirthday() {
        /* 247 */
        return this.birthday;

    }


    public void setBirthday(Date birthday) {
        /* 255 */
        this.birthday = birthday;

    }


    public String getMobilePhone() {
        /* 263 */
        return this.mobilePhone;

    }


    public void setMobilePhone(String mobilePhone) {
        /* 271 */
        this.mobilePhone = mobilePhone;

    }


    public String getSecondPhone() {
        /* 279 */
        return this.secondPhone;

    }


    public void setSecondPhone(String secondPhone) {
        /* 287 */
        this.secondPhone = secondPhone;

    }


    public String getQqNumber() {
        /* 295 */
        return this.qqNumber;

    }


    public void setQqNumber(String qqNumber) {
        /* 303 */
        this.qqNumber = qqNumber;

    }


    public String getWeixinNumber() {
        /* 311 */
        return this.weixinNumber;

    }


    public void setWeixinNumber(String weixinNumber) {
        /* 319 */
        this.weixinNumber = weixinNumber;

    }


    public String getRemark() {
        /* 327 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 335 */
        this.remark = remark;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppUserInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */