
package com.tangtang.trade.hry.web.dictionary.model;


import javax.persistence.Column;
import javax.persistence.Table;


@Table(name = "app_dic_onelevel")
public class AppDicOnelevel
        extends AppDicBase {

    @Column(name = "itemValue")
    protected String itemValue;


    public String getItemValue() {
        /* 37 */
        return this.itemValue;

    }


    public void setItemValue(String itemValue) {
        /* 45 */
        this.itemValue = itemValue;

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\dictionary\model\AppDicOnelevel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */