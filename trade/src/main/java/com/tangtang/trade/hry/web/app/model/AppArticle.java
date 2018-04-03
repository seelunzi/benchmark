
package com.tangtang.trade.hry.web.app.model;


import hry.core.mvc.model.BaseModel;
import org.springframework.web.util.HtmlUtils;

import javax.persistence.*;


@Table(name = "app_article")
public class AppArticle
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "seoTitle")
    private String seoTitle;

    @Column(name = "seoKeyword")
    private String seoKeyword;

    @Column(name = "seoDescribe")
    private String seoDescribe;

    @Column(name = "website")
    private String website;

    @Column(name = "sort")
    private Integer sort;


    public String getWebsite() {
        /*  48 */
        return this.website;

    }


    public void setWebsite(String website) {
        /*  52 */
        this.website = website;

    }


    @Column(name = "isStick")
    private Integer isStick;



    @Column(name = "content")
    private String content;



    @Column(name = "isOutLink")
    private Integer isOutLink;



    @Column(name = "outLink")
    private String outLink;


    @Column(name = "titleImage")
    private String titleImage;


    @Column(name = "shortContent")
    private String shortContent;


    @Column(name = "writer")
    private String writer;


    @Column(name = "source")
    private String source;


    @Column(name = "hits")
    private Integer hits;


    @Transient
    private AppArticle upAppArticle;


    @Transient
    private AppArticle nextAppArticle;


    public AppArticle getUpAppArticle() {
        /*  95 */
        return this.upAppArticle;

    }


    public void setUpAppArticle(AppArticle upAppArticle) {
        /*  99 */
        this.upAppArticle = upAppArticle;

    }


    public AppArticle getNextAppArticle() {
        /* 103 */
        return this.nextAppArticle;

    }


    public void setNextAppArticle(AppArticle nextAppArticle) {
        /* 107 */
        this.nextAppArticle = nextAppArticle;

    }


    public Long getId() {
        /* 111 */
        return this.id;

    }


    public void setId(Long id) {
        /* 115 */
        this.id = id;

    }


    public Integer getStatus() {
        /* 119 */
        return this.status;

    }


    public void setStatus(Integer status) {
        /* 123 */
        this.status = status;

    }


    public String getTitle() {
        /* 127 */
        return this.title;

    }


    public void setTitle(String title) {
        /* 131 */
        this.title = title;

    }


    public String getCategoryName() {
        /* 135 */
        return this.categoryName;

    }


    public void setCategoryName(String categoryName) {
        /* 139 */
        this.categoryName = categoryName;

    }


    public Long getCategoryId() {
        /* 143 */
        return this.categoryId;

    }


    public void setCategoryId(Long categoryId) {
        /* 147 */
        this.categoryId = categoryId;

    }


    public Integer getStaus() {
        /* 151 */
        return this.status;

    }


    public void setStaus(Integer staus) {
        /* 155 */
        this.status = staus;

    }


    public String getSeoTitle() {
        /* 159 */
        return this.seoTitle;

    }


    public void setSeoTitle(String seoTitle) {
        /* 163 */
        this.seoTitle = seoTitle;

    }


    public String getSeoKeyword() {
        /* 167 */
        return this.seoKeyword;

    }


    public void setSeoKeyword(String seoKeyword) {
        /* 171 */
        this.seoKeyword = seoKeyword;

    }


    public String getSeoDescribe() {
        /* 175 */
        return this.seoDescribe;

    }


    public void setSeoDescribe(String seoDescribe) {
        /* 179 */
        this.seoDescribe = seoDescribe;

    }


    public Integer getSort() {
        /* 183 */
        return this.sort;

    }


    public void setSort(Integer sort) {
        /* 187 */
        this.sort = sort;

    }


    public Integer getIsStick() {
        /* 191 */
        return this.isStick;

    }


    public void setIsStick(Integer isStick) {
        /* 195 */
        this.isStick = isStick;

    }


    public String getContent() {
        /* 199 */
        return HtmlUtils.htmlUnescape(this.content);

    }


    public void setContent(String content) {
        /* 203 */
        this.content = content;

    }


    public Integer getIsOutLink() {
        /* 207 */
        return this.isOutLink;

    }


    public void setIsOutLink(Integer isOutLink) {
        /* 211 */
        this.isOutLink = isOutLink;

    }


    public String getOutLink() {
        /* 215 */
        return this.outLink;

    }


    public void setOutLink(String outLink) {
        /* 219 */
        this.outLink = outLink;

    }


    public String getTitleImage() {
        /* 223 */
        return this.titleImage;

    }


    public void setTitleImage(String titleImage) {
        /* 227 */
        this.titleImage = titleImage;

    }


    public String getShortContent() {
        /* 231 */
        return this.shortContent;

    }


    public void setShortContent(String shortContent) {
        /* 235 */
        this.shortContent = shortContent;

    }


    public String getWriter() {
        /* 239 */
        return this.writer;

    }


    public void setWriter(String writer) {
        /* 243 */
        this.writer = writer;

    }


    public String getSource() {
        /* 247 */
        return this.source;

    }


    public void setSource(String source) {
        /* 251 */
        this.source = source;

    }


    public Integer getHits() {
        /* 255 */
        return this.hits;

    }


    public void setHits(Integer hits) {
        /* 259 */
        this.hits = hits;

    }


    public AppArticle(Long id, String title, String categoryName, Long categoryId, Integer status, String seoTitle, String seoKeyword, String seoDescribe, Integer sort, Integer isStick, String content, Integer isOutLink, String outLink, String titleImage, String shortContent, String writer, String source, Integer hits) {
        /* 269 */
        this.id = id;
        /* 270 */
        this.title = title;
        /* 271 */
        this.categoryName = categoryName;
        /* 272 */
        this.categoryId = categoryId;
        /* 273 */
        this.status = status;
        /* 274 */
        this.seoTitle = seoTitle;
        /* 275 */
        this.seoKeyword = seoKeyword;
        /* 276 */
        this.seoDescribe = seoDescribe;
        /* 277 */
        this.sort = sort;
        /* 278 */
        this.isStick = isStick;
        /* 279 */
        this.content = content;
        /* 280 */
        this.isOutLink = isOutLink;
        /* 281 */
        this.outLink = outLink;
        /* 282 */
        this.titleImage = titleImage;
        /* 283 */
        this.shortContent = shortContent;
        /* 284 */
        this.writer = writer;
        /* 285 */
        this.source = source;
        /* 286 */
        this.hits = hits;

    }


    public AppArticle() {
    }


    public String toString() {
        /* 295 */
        return "AppArticle [id=" + this.id + ", title=" + this.title + ", categoryName=" + this.categoryName + ", categoryId=" + this.categoryId + ", staus=" + this.status + ", seoTitle=" + this.seoTitle + ", seoKeyword=" + this.seoKeyword + ", seoDescribe=" + this.seoDescribe + ", sort=" + this.sort + ", isStick=" + this.isStick + ", content=" + this.content + ", isOutLink=" + this.isOutLink + ", outLink=" + this.outLink + ", titleTmage=" + this.titleImage + ", shortContent=" + this.shortContent + ", writer=" + this.writer + ", source=" + this.source + ", hits=" + this.hits + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppArticle.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */