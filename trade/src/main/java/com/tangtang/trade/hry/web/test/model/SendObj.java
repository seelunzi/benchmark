
package com.tangtang.trade.hry.web.test.model;


public class SendObj {
    private String name;
    private int money;
    private int id;



    public String getName() {
        /*  9 */
        return this.name;

    }


    public void setName(String name) {
        /* 13 */
        this.name = name;

    }


    public int getMoney() {
        /* 17 */
        return this.money;

    }


    public void setMoney(int money) {
        /* 21 */
        this.money = money;

    }


    public int getId() {
        /* 25 */
        return this.id;

    }


    public void setId(int id) {
        /* 29 */
        this.id = id;

    }


    public SendObj(String name, int money, int id) {
        /* 34 */
        this.name = name;
        /* 35 */
        this.money = money;
        /* 36 */
        this.id = id;

    }


    public String toString() {
        /* 41 */
        return "SendObj [name=" + this.name + ", money=" + this.money + ", id=" + this.id + "]";

    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\web\test\model\SendObj.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */