/*     */
package com.tangtang.trade.hry.web.dictionary.model;
/*     */
/*     */

import javax.persistence.Column;
import javax.persistence.Table;

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
@Table(name = "app_dic_multilevel")
/*     */ public class AppDicMultilevel
        /*     */ extends AppDicBase
        /*     */ {
    /*     */
    @Column(name = "path")
    /*     */ protected String path;
    /*     */
    @Column(name = "rootKey")
    /*     */ protected String rootKey;
    /*     */
    @Column(name = "remark1")
    /*     */ protected String remark1;
    /*     */
    @Column(name = "remark2")
    /*     */ protected String remark2;
    /*     */
    @Column(name = "remark3")
    /*     */ protected String remark3;
    /*     */
    @Column(name = "remark4")
    /*     */ protected String remark4;

    /*     */
    /*     */
    public String getPath()
    /*     */ {
        /*  54 */
        return this.path;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setPath(String path)
    /*     */ {
        /*  61 */
        this.path = path;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getRootKey()
    /*     */ {
        /*  68 */
        return this.rootKey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setRootKey(String rootKey)
    /*     */ {
        /*  75 */
        this.rootKey = rootKey;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getRemark1()
    /*     */ {
        /*  82 */
        return this.remark1;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setRemark1(String remark1)
    /*     */ {
        /*  89 */
        this.remark1 = remark1;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getRemark2()
    /*     */ {
        /*  96 */
        return this.remark2;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setRemark2(String remark2)
    /*     */ {
        /* 103 */
        this.remark2 = remark2;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getRemark3()
    /*     */ {
        /* 110 */
        return this.remark3;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setRemark3(String remark3)
    /*     */ {
        /* 117 */
        this.remark3 = remark3;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public String getRemark4()
    /*     */ {
        /* 124 */
        return this.remark4;
        /*     */
    }

    /*     */
    /*     */
    /*     */
    /*     */
    public void setRemark4(String remark4)
    /*     */ {
        /* 131 */
        this.remark4 = remark4;
        /*     */
    }
    /*     */
}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\dictionary\model\AppDicMultilevel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */