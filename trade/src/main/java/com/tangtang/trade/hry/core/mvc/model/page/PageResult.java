
package com.tangtang.trade.hry.core.mvc.model.page;


import java.io.Serializable;
import java.util.List;


public class PageResult
        implements Serializable {
    private Integer draw;
    private Integer page;
    private Integer pageSize;
    /*  25 */   private Long totalPage = Long.valueOf(0L);
    private Long recordsTotal;
    private Long recordsFiltered;
    private List rows;


    public Integer getPage() {
        /*  32 */
        return this.page;

    }


    public void setPage(Integer page) {
        /*  36 */
        this.page = page;

    }


    public Integer getPageSize() {
        /*  40 */
        return this.pageSize;

    }


    public void setPageSize(Integer pageSize) {
        /*  44 */
        this.pageSize = pageSize;

    }


    public Long getTotalPage() {
        /*  48 */
        if (getPageSize() != null) {
            /*  49 */
            return Long.valueOf((getRecordsTotal().longValue() + getPageSize().intValue() - 1L) / getPageSize().intValue());

        }

        /*  52 */
        return this.totalPage;

    }


    public Long getRecordsTotal() {
        /*  64 */
        return this.recordsTotal;

    }


    public void setRecordsTotal(Long recordsTotal) {
        /*  75 */
        this.recordsTotal = recordsTotal;
        /*  76 */
        this.recordsFiltered = recordsTotal;

    }


    public void setTotalPage(Long totalPage) {
        /*  80 */
        this.totalPage = totalPage;

    }


    public List getRows() {
        /*  85 */
        return this.rows;

    }


    public void setRows(List rows) {
        /*  90 */
        this.rows = rows;

    }


    public Integer getDraw() {
        /* 100 */
        return this.draw;

    }


    public void setDraw(Integer draw) {
        /* 111 */
        this.draw = draw;

    }


    public Long getRecordsFiltered() {
        /* 122 */
        return this.recordsFiltered;

    }


    public void setRecordsFiltered(Long recordsFiltered) {
        /* 133 */
        this.recordsFiltered = recordsFiltered;

    }


    public String toString() {
        /* 138 */
        return "PageResult [draw=" + this.draw + ", page=" + this.page + ", pageSize=" + this.pageSize + ", totalPage=" + this.totalPage + ", recordsTotal=" + this.recordsTotal + ", recordsFiltered=" + this.recordsFiltered + ", rows=" + this.rows + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\core\mvc\model\page\PageResult.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */