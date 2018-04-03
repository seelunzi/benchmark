package com.tangtang.trade.hry.core.mvc.model.log;

import hry.core.mvc.model.BaseModel;

import javax.persistence.*;


@Table(name = "app_exception")
public class AppException
        extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "notes")
    private String notes;

    @Column(name = "type")
    private String type;

    @Column(name = "ip")
    private String ip;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "requestmethod")
    private String requestmethod;

    @Column(name = "requestaddress")
    private String requestaddress;


    public Long getId() {
        /*  80 */
        return this.id;

    }


    public void setId(Long id) {
        /*  88 */
        this.id = id;

    }


    public String getName() {
        /*  96 */
        return this.name;

    }


    public void setName(String name) {
        /* 104 */
        this.name = name;

    }


    public String getNotes() {
        /* 112 */
        return this.notes;

    }


    public void setNotes(String notes) {
        /* 120 */
        this.notes = notes;

    }


    public String getType() {
        /* 128 */
        return this.type;

    }


    public void setType(String type) {
        /* 136 */
        this.type = type;

    }


    public String getIp() {
        /* 144 */
        return this.ip;

    }


    public void setIp(String ip) {
        /* 152 */
        this.ip = ip;

    }


    public String getParameter() {
        /* 160 */
        return this.parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getRequestmethod() {
        return this.requestmethod;
    }


    public void setRequestmethod(String requestmethod) {
        this.requestmethod = requestmethod;
    }


    public String getRequestaddress() {
        return this.requestaddress;
    }

    public void setRequestaddress(String requestaddress) {
        this.requestaddress = requestaddress;
    }

}

