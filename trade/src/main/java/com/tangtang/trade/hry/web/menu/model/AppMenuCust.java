/*     */
package com.tangtang.trade.hry.web.menu.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

import javax.persistence.*;
import java.util.List;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
@Table(name = "app_menu_cust")
/*     */ public class AppMenuCust
        /*     */ extends BaseModel
        /*     */ {
    /*     */
    @Id
    /*     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*     */
    @Column(name = "id", unique = true, nullable = false)
    /*     */ private Long id;
    /*     */
    @Column(name = "mkey")
    /*     */ private String mkey;
    /*     */
    @Column(name = "pkey")
    /*     */ private String pkey;
    /*     */
    @Column(name = "appName")
    /*     */ private String appName;
    /*     */
    @Column(name = "name")
    /*     */ private String name;
    /*     */
    @Column(name = "url")
    /*     */ private String url;
    /*     */
    @Column(name = "shiroUrl")
    /*     */ private String shiroUrl;
    /*     */
    @Column(name = "isOpen")
    /*     */ private String isOpen;
    /*     */
    @Column(name = "isOutLink")
    /*     */ private String isOutLink;
    /*     */
    @Column(name = "orderNo")
    /*     */ private Integer orderNo;
    /*     */
    @Column(name = "type")
    /*     */ private String type;
    /*     */
    @Column(name = "isVisible")
    /*     */ private String isVisible;
    /*     */
    @Transient
    /*     */ private List<AppMenu> subMenu;

    /*     */
    /*     */
    public Long getId()
    /*     */ {
        /*  76 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /*  84 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getName()
    /*     */ {
        /*  93 */
        return this.name;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setName(String name)
    /*     */ {
        /* 101 */
        this.name = name;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getUrl()
    /*     */ {
        /* 109 */
        return this.url;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setUrl(String url)
    /*     */ {
        /* 117 */
        this.url = url;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getShiroUrl()
    /*     */ {
        /* 127 */
        return this.shiroUrl;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setShiroUrl(String shiroUrl)
    /*     */ {
        /* 135 */
        this.shiroUrl = shiroUrl;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getIsOpen()
    /*     */ {
        /* 143 */
        return this.isOpen;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsOpen(String isOpen)
    /*     */ {
        /* 151 */
        this.isOpen = isOpen;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getIsOutLink()
    /*     */ {
        /* 159 */
        return this.isOutLink;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsOutLink(String isOutLink)
    /*     */ {
        /* 167 */
        this.isOutLink = isOutLink;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getOrderNo()
    /*     */ {
        /* 176 */
        return this.orderNo;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setOrderNo(Integer orderNo)
    /*     */ {
        /* 184 */
        this.orderNo = orderNo;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getAppName()
    /*     */ {
        /* 192 */
        return this.appName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setAppName(String appName)
    /*     */ {
        /* 200 */
        this.appName = appName;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getMkey()
    /*     */ {
        /* 208 */
        return this.mkey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setMkey(String mkey)
    /*     */ {
        /* 216 */
        this.mkey = mkey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getPkey()
    /*     */ {
        /* 224 */
        return this.pkey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setPkey(String pkey)
    /*     */ {
        /* 232 */
        this.pkey = pkey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getType()
    /*     */ {
        /* 240 */
        return this.type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setType(String type)
    /*     */ {
        /* 248 */
        this.type = type;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getIsVisible()
    /*     */ {
        /* 256 */
        return this.isVisible;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsVisible(String isVisible)
    /*     */ {
        /* 264 */
        this.isVisible = isVisible;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public List<AppMenu> getSubMenu()
    /*     */ {
        /* 272 */
        return this.subMenu;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setSubMenu(List<AppMenu> subMenu)
    /*     */ {
        /* 280 */
        this.subMenu = subMenu;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\menu\model\AppMenuCust.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */