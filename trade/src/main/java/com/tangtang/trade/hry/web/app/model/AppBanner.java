/*     */
package com.tangtang.trade.hry.web.app.model;
/*     */
/*     */

import hry.core.mvc.model.BaseModel;

import javax.persistence.*;

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
@Table(name = "app_banner")
/*     */ public class AppBanner
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
    @Column(name = "name")
    /*     */ private String name;
    /*     */
    @Column(name = "picturePath")
    /*     */ private String picturePath;
    /*     */
    @Column(name = "status")
    /*     */ private Integer status;
    /*     */
    @Column(name = "isTop")
    /*     */ private Integer isTop;
    /*     */
    @Column(name = "isShow")
    /*     */ private Integer isShow;
    /*     */
    @Column(name = "sort")
    /*     */ private Integer sort;
    /*     */
    @Column(name = "remark1")
    /*     */ private String remark1;
    /*     */
    @Column(name = "remark2")
    /*     */ private String remark2;
    /*     */
    @Column(name = "remark3")
    /*     */ private String remark3;

    /*     */
    /*     */
    public String getRemark1()
    /*     */ {
        /*  56 */
        return this.remark1;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getRemark2()
    /*     */ {
        /*  64 */
        return this.remark2;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getRemark3()
    /*     */ {
        /*  72 */
        return this.remark3;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setRemark1(String remark1)
    /*     */ {
        /*  80 */
        this.remark1 = remark1;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setRemark2(String remark2)
    /*     */ {
        /*  88 */
        this.remark2 = remark2;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setRemark3(String remark3)
    /*     */ {
        /*  96 */
        this.remark3 = remark3;
        /*     */
    }

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
    public Long getId()
    /*     */ {
        /* 109 */
        return this.id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getName()
    /*     */ {
        /* 117 */
        return this.name;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public String getPicturePath()
    /*     */ {
        /* 125 */
        return this.picturePath;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getStatus()
    /*     */ {
        /* 133 */
        return this.status;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getIsTop()
    /*     */ {
        /* 141 */
        return this.isTop;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getIsShow()
    /*     */ {
        /* 149 */
        return this.isShow;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setId(Long id)
    /*     */ {
        /* 160 */
        this.id = id;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setName(String name)
    /*     */ {
        /* 168 */
        this.name = name;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setPicturePath(String picturePath)
    /*     */ {
        /* 176 */
        this.picturePath = picturePath;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setStatus(Integer status)
    /*     */ {
        /* 184 */
        this.status = status;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsTop(Integer isTop)
    /*     */ {
        /* 192 */
        this.isTop = isTop;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setIsShow(Integer isShow)
    /*     */ {
        /* 200 */
        this.isShow = isShow;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public Integer getSort()
    /*     */ {
        /* 209 */
        return this.sort;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    /*     */
    public void setSort(Integer sort)
    /*     */ {
        /* 217 */
        this.sort = sort;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\AppBanner.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */