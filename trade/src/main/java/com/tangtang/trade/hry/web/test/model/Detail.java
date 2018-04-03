
package com.tangtang.trade.hry.web.test.model;


import hry.core.mvc.model.BaseModel;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity

@Table(name = "t_detail")

@DynamicInsert(true)

@DynamicUpdate(true)
public class Detail
        extends BaseModel {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private int toBiaoMoney;
    private String biaoName;
    private String userName;
    private String date;


    public int getId() {
        /* 31 */
        return this.id.intValue();

    }


    public void setId(int id) {
        /* 35 */
        this.id = Integer.valueOf(id);

    }


    public int getToBiaoMoney() {
        /* 39 */
        return this.toBiaoMoney;

    }


    public void setToBiaoMoney(int toBiaoMoney) {
        /* 43 */
        this.toBiaoMoney = toBiaoMoney;

    }


    public String getBiaoName() {
        /* 47 */
        return this.biaoName;

    }


    public void setBiaoName(String biaoName) {
        /* 51 */
        this.biaoName = biaoName;

    }


    public String getUserName() {
        /* 55 */
        return this.userName;

    }


    public void setUserName(String userName) {
        /* 59 */
        this.userName = userName;

    }


    public String getDate() {
        /* 63 */
        return this.date;

    }


    public void setDate(String date) {
        /* 67 */
        this.date = date;

    }


    public Detail(int id, int toBiaoMoney, String biaoName, String userName, String date) {
        /* 73 */
        this.id = Integer.valueOf(id);
        /* 74 */
        this.toBiaoMoney = toBiaoMoney;
        /* 75 */
        this.biaoName = biaoName;
        /* 76 */
        this.userName = userName;
        /* 77 */
        this.date = date;

    }


    public Detail() {
    }


    public String toString() {
        /* 86 */
        return "Detail [id=" + this.id + ", toBiaoMoney=" + this.toBiaoMoney + ", biaoName=" + this.biaoName + ", userName=" + this.userName + ", date=" + this.date + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\test\model\Detail.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */