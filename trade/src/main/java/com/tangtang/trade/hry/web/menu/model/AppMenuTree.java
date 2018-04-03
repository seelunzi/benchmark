
package com.tangtang.trade.hry.web.menu.model;


import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.util.List;


@Table(name = "app_menu_Tree")
public class AppMenuTree
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "okey")
    private String okey;

    @Column(name = "mkey")
    private String mkey;

    @Column(name = "pkey")
    private String pkey;

    @Column(name = "appName")
    private String appName;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "shiroUrl")
    private String shiroUrl;

    @Column(name = "isOpen")
    private String isOpen;

    @Column(name = "isOutLink")
    private String isOutLink;

    @Column(name = "orderNo")
    private Integer orderNo;

    @Column(name = "type")
    private String type;

    @Column(name = "isVisible")
    private String isVisible;

    @Transient
    private List<AppMenu> subMenu;


    public Long getId() {
        /*  79 */
        return this.id;

    }


    public void setId(Long id) {
        /*  87 */
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


    public String getUrl() {
        /* 112 */
        return this.url;

    }


    public void setUrl(String url) {
        /* 120 */
        this.url = url;

    }


    public String getShiroUrl() {
        /* 130 */
        return this.shiroUrl;

    }


    public void setShiroUrl(String shiroUrl) {
        /* 138 */
        this.shiroUrl = shiroUrl;

    }


    public String getIsOpen() {
        /* 146 */
        return this.isOpen;

    }


    public void setIsOpen(String isOpen) {
        /* 154 */
        this.isOpen = isOpen;

    }


    public String getIsOutLink() {
        /* 162 */
        return this.isOutLink;

    }


    public void setIsOutLink(String isOutLink) {
        /* 170 */
        this.isOutLink = isOutLink;

    }


    public Integer getOrderNo() {
        /* 180 */
        return this.orderNo;

    }


    public void setOrderNo(Integer orderNo) {
        /* 188 */
        this.orderNo = orderNo;

    }


    public String getAppName() {
        /* 196 */
        return this.appName;

    }


    public void setAppName(String appName) {
        /* 204 */
        this.appName = appName;

    }


    public String getMkey() {
        /* 212 */
        return this.mkey;

    }


    public void setMkey(String mkey) {
        /* 220 */
        this.mkey = mkey;

    }


    public String getPkey() {
        /* 228 */
        return this.pkey;

    }


    public void setPkey(String pkey) {
        /* 236 */
        this.pkey = pkey;

    }


    public String getType() {
        /* 244 */
        return this.type;

    }


    public void setType(String type) {
        /* 252 */
        this.type = type;

    }


    public String getIsVisible() {
        /* 260 */
        return this.isVisible;

    }


    public void setIsVisible(String isVisible) {
        /* 268 */
        this.isVisible = isVisible;

    }


    public List<AppMenu> getSubMenu() {
        /* 276 */
        return this.subMenu;

    }


    public void setSubMenu(List<AppMenu> subMenu) {
        /* 284 */
        this.subMenu = subMenu;

    }


    public String getOkey() {
        /* 292 */
        return this.okey;

    }


    public void setOkey(String okey) {
        /* 300 */
        this.okey = okey;

    }


    public int hashCode() {
        /* 308 */
        int prime = 31;
        /* 309 */
        int result = 1;
        /* 310 */
        result = 31 * result + (this.appName == null ? 0 : this.appName.hashCode());
        /* 311 */
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        /* 312 */
        result = 31 * result + (this.isOpen == null ? 0 : this.isOpen.hashCode());
        /* 313 */
        result = 31 * result + (this.isOutLink == null ? 0 : this.isOutLink.hashCode());
        /* 314 */
        result = 31 * result + (this.isVisible == null ? 0 : this.isVisible.hashCode());
        /* 315 */
        result = 31 * result + (this.mkey == null ? 0 : this.mkey.hashCode());
        /* 316 */
        result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
        /* 317 */
        result = 31 * result + (this.okey == null ? 0 : this.okey.hashCode());
        /* 318 */
        result = 31 * result + (this.orderNo == null ? 0 : this.orderNo.hashCode());
        /* 319 */
        result = 31 * result + (this.pkey == null ? 0 : this.pkey.hashCode());
        /* 320 */
        result = 31 * result + (this.shiroUrl == null ? 0 : this.shiroUrl.hashCode());
        /* 321 */
        result = 31 * result + (this.subMenu == null ? 0 : this.subMenu.hashCode());
        /* 322 */
        result = 31 * result + (this.type == null ? 0 : this.type.hashCode());
        /* 323 */
        result = 31 * result + (this.url == null ? 0 : this.url.hashCode());
        /* 324 */
        return result;

    }


    public boolean equals(Object obj) {
        /* 332 */
        if (this == obj)
            /* 333 */ return true;
        /* 334 */
        if (obj == null)
            /* 335 */ return false;
        /* 336 */
        if (getClass() != obj.getClass())
            /* 337 */ return false;
        /* 338 */
        AppMenuTree other = (AppMenuTree) obj;
        /* 339 */
        if (this.appName == null) {
            /* 340 */
            if (other.appName != null)
                /* 341 */ return false;
            /* 342 */
        } else if (!this.appName.equals(other.appName))
            /* 343 */ return false;
        /* 344 */
        if (this.id == null) {
            /* 345 */
            if (other.id != null)
                /* 346 */ return false;
            /* 347 */
        } else if (!this.id.equals(other.id))
            /* 348 */ return false;
        /* 349 */
        if (this.isOpen == null) {
            /* 350 */
            if (other.isOpen != null)
                /* 351 */ return false;
            /* 352 */
        } else if (!this.isOpen.equals(other.isOpen))
            /* 353 */ return false;
        /* 354 */
        if (this.isOutLink == null) {
            /* 355 */
            if (other.isOutLink != null)
                /* 356 */ return false;
            /* 357 */
        } else if (!this.isOutLink.equals(other.isOutLink))
            /* 358 */ return false;
        /* 359 */
        if (this.isVisible == null) {
            /* 360 */
            if (other.isVisible != null)
                /* 361 */ return false;
            /* 362 */
        } else if (!this.isVisible.equals(other.isVisible))
            /* 363 */ return false;
        /* 364 */
        if (this.mkey == null) {
            /* 365 */
            if (other.mkey != null)
                /* 366 */ return false;
            /* 367 */
        } else if (!this.mkey.equals(other.mkey))
            /* 368 */ return false;
        /* 369 */
        if (this.name == null) {
            /* 370 */
            if (other.name != null)
                /* 371 */ return false;
            /* 372 */
        } else if (!this.name.equals(other.name))
            /* 373 */ return false;
        /* 374 */
        if (this.okey == null) {
            /* 375 */
            if (other.okey != null)
                /* 376 */ return false;
            /* 377 */
        } else if (!this.okey.equals(other.okey))
            /* 378 */ return false;
        /* 379 */
        if (this.orderNo == null) {
            /* 380 */
            if (other.orderNo != null)
                /* 381 */ return false;
            /* 382 */
        } else if (!this.orderNo.equals(other.orderNo))
            /* 383 */ return false;
        /* 384 */
        if (this.pkey == null) {
            /* 385 */
            if (other.pkey != null)
                /* 386 */ return false;
            /* 387 */
        } else if (!this.pkey.equals(other.pkey))
            /* 388 */ return false;
        /* 389 */
        if (this.shiroUrl == null) {
            /* 390 */
            if (other.shiroUrl != null)
                /* 391 */ return false;
            /* 392 */
        } else if (!this.shiroUrl.equals(other.shiroUrl))
            /* 393 */ return false;
        /* 394 */
        if (this.subMenu == null) {
            /* 395 */
            if (other.subMenu != null)
                /* 396 */ return false;
            /* 397 */
        } else if (!this.subMenu.equals(other.subMenu))
            /* 398 */ return false;
        /* 399 */
        if (this.type == null) {
            /* 400 */
            if (other.type != null)
                /* 401 */ return false;
            /* 402 */
        } else if (!this.type.equals(other.type))
            /* 403 */ return false;
        /* 404 */
        if (this.url == null) {
            /* 405 */
            if (other.url != null)
                /* 406 */ return false;
            /* 407 */
        } else if (!this.url.equals(other.url))
            /* 408 */ return false;
        /* 409 */
        return true;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\menu\model\AppMenuTree.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */