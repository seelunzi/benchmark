
package com.tangtang.trade.hry.oauth.user.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.util.Date;


@Table(name = "app_organization")
public class AppOrganization
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "pid")
    private Long pid;

    @Column(name = "isDelete")
    /*  48 */ private String isDelete = "0";


    @Column(name = "orderNo")
    /*  52 */ private String orderNo = "1";


    @Column(name = "logoPath")
    private String logoPath;




    @Column(name = "name")
    private String name;



    @Column(name = "shortName")
    private String shortName;



    @Column(name = "companyNo")
    private String companyNo;



    @Column(name = "englishName")
    private String englishName;



    @Column(name = "person")
    private String person;



    @Column(name = "mobile")
    private String mobile;



    @Column(name = "fax")
    private String fax;



    @Column(name = "setDate")
    private Date setDate;



    @Column(name = "address")
    private String address;



    @Column(name = "postalcode")
    private String postalcode;



    @Column(name = "remark")
    private String remark;


    public Long getId() {
        /* 108 */
        return this.id;

    }


    public void setId(Long id) {
        /* 117 */
        this.id = id;

    }


    public String getName() {
        /* 126 */
        return this.name;

    }


    public void setName(String name) {
        /* 135 */
        this.name = name;

    }


    public String getType() {
        /* 144 */
        return this.type;

    }


    public void setType(String type) {
        /* 153 */
        this.type = type;

    }


    public String getShortName() {
        /* 162 */
        return this.shortName;

    }


    public void setShortName(String shortName) {
        /* 171 */
        this.shortName = shortName;

    }


    public String getCompanyNo() {
        /* 180 */
        return this.companyNo;

    }


    public void setCompanyNo(String companyNo) {
        /* 189 */
        this.companyNo = companyNo;

    }


    public String getEnglishName() {
        /* 198 */
        return this.englishName;

    }


    public void setEnglishName(String englishName) {
        /* 207 */
        this.englishName = englishName;

    }


    public String getPerson() {
        /* 216 */
        return this.person;

    }


    public void setPerson(String person) {
        /* 225 */
        this.person = person;

    }


    public String getMobile() {
        /* 234 */
        return this.mobile;

    }


    public void setMobile(String mobile) {
        /* 243 */
        this.mobile = mobile;

    }


    public String getFax() {
        /* 252 */
        return this.fax;

    }


    public void setFax(String fax) {
        /* 261 */
        this.fax = fax;

    }


    public Date getSetDate() {
        /* 270 */
        return this.setDate;

    }


    public void setSetDate(Date setDate) {
        /* 279 */
        this.setDate = setDate;

    }


    public String getAddress() {
        /* 288 */
        return this.address;

    }


    public void setAddress(String address) {
        /* 297 */
        this.address = address;

    }


    public String getPostalcode() {
        /* 306 */
        return this.postalcode;

    }


    public void setPostalcode(String postalcode) {
        /* 315 */
        this.postalcode = postalcode;

    }


    public String getRemark() {
        /* 324 */
        return this.remark;

    }


    public void setRemark(String remark) {
        /* 333 */
        this.remark = remark;

    }


    public String getLogoPath() {
        /* 342 */
        return this.logoPath;

    }


    public void setLogoPath(String logoPath) {
        /* 351 */
        this.logoPath = logoPath;

    }


    public Long getPid() {
        /* 360 */
        return this.pid;

    }


    public void setPid(Long pid) {
        /* 369 */
        this.pid = pid;

    }


    public String getIsDelete() {
        /* 378 */
        return this.isDelete;

    }


    public void setIsDelete(String isDelete) {
        /* 387 */
        this.isDelete = isDelete;

    }


    public String getOrderNo() {
        /* 396 */
        return this.orderNo;

    }


    public void setOrderNo(String orderNo) {
        /* 405 */
        this.orderNo = orderNo;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\oauth\user\model\AppOrganization.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */