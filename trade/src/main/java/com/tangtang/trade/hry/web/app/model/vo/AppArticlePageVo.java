
package com.tangtang.trade.hry.web.app.model.vo;


import hry.web.app.model.AppArticle;

import java.util.List;


public class AppArticlePageVo {
    public Integer totalPage;
    public List<AppArticle> appArticle;


    public Integer getTotalPage() {
        /* 24 */
        return this.totalPage;

    }


    public void setTotalPage(Integer totalPage) {
        /* 28 */
        this.totalPage = totalPage;

    }


    public List<AppArticle> getAppArticle() {
        /* 32 */
        return this.appArticle;

    }


    public void setAppArticle(List<AppArticle> appArticle) {
        /* 36 */
        this.appArticle = appArticle;

    }


    public AppArticlePageVo(Integer totalPage, List<AppArticle> appArticle) {
        /* 41 */
        this.totalPage = totalPage;
        /* 42 */
        this.appArticle = appArticle;

    }


    public AppArticlePageVo() {
    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\app\model\vo\AppArticlePageVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */