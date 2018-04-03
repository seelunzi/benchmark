
package com.tangtang.trade.hry.web.file.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;


@Table(name = "app_file")
public class AppFile
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "fileid", unique = true, nullable = false)
    protected Long fileid;

    @Column(name = "filename")
    protected String filename;

    @Column(name = "fileTrueName")
    private String fileTrueName;

    @Column(name = "mark")
    protected String mark;

    @Column(name = "fileLocalpath")
    protected String fileLocalpath;

    @Column(name = "fileWebPath")
    protected String fileWebPath;

    @Column(name = "fileRemotePath")
    protected String fileRemotePath;

    @Column(name = "extendname")
    protected String extendname;

    @Column(name = "filesize")
    protected BigDecimal filesize;

    @Column(name = "creatorid")
    protected Long creatorid;

    @Column(name = "remark")
    protected String remark;

    @Transient
    private String username;


    public Long getFileid() {
        /*  74 */
        return this.fileid;

    }


    public void setFileid(Long aValue) {
        /*  81 */
        this.fileid = aValue;

    }


    public String getFilename() {
        /*  90 */
        return this.filename;

    }


    public void setFilename(String aValue) {
        /*  97 */
        this.filename = aValue;

    }


    public String getFileLocalpath() {
        /* 107 */
        return this.fileLocalpath;

    }


    public void setFileLocalpath(String fileLocalpath) {
        /* 115 */
        this.fileLocalpath = fileLocalpath;

    }


    public String getFileRemotePath() {
        /* 123 */
        return this.fileRemotePath;

    }


    public void setFileRemotePath(String fileRemotePath) {
        /* 131 */
        this.fileRemotePath = fileRemotePath;

    }


    public String getExtendname() {
        /* 140 */
        return this.extendname;

    }


    public void setExtendname(String aValue) {
        /* 147 */
        this.extendname = aValue;

    }


    public BigDecimal getFilesize() {
        /* 156 */
        return this.filesize;

    }


    public void setFilesize(BigDecimal aValue) {
        /* 163 */
        this.filesize = aValue;

    }


    public Long getCreatorid() {
        /* 172 */
        return this.creatorid;

    }


    public void setCreatorid(Long aValue) {
        /* 179 */
        this.creatorid = aValue;

    }


    public String getRemark() {
        /* 193 */
        return this.remark;

    }


    public void setRemark(String aValue) {
        /* 200 */
        this.remark = aValue;

    }


    public String getMark() {
        /* 209 */
        return this.mark;

    }


    public void setMark(String mark) {
        /* 217 */
        this.mark = mark;

    }


    public String getFileTrueName() {
        /* 225 */
        return this.fileTrueName;

    }


    public void setFileTrueName(String fileTrueName) {
        /* 233 */
        this.fileTrueName = fileTrueName;

    }


    public String getFileWebPath() {
        /* 241 */
        return this.fileWebPath;

    }


    public void setFileWebPath(String fileWebPath) {
        /* 249 */
        this.fileWebPath = fileWebPath;

    }


    public String getUsername() {
        /* 257 */
        return this.username;

    }


    public void setUsername(String username) {
        /* 265 */
        this.username = username;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\file\model\AppFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */