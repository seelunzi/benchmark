
package com.tangtang.trade.hry.trade.model;


public enum AccountRemarkEnum {
    /*  4 */   TYPE1("委托下单", 1),
    /*  5 */   TYPE2("交易成功，-买家解冻总金额转给卖家", 2),
    /*  6 */   TYPE3("买家市价，-完成还剩一点金额给解冻到自己账户", 3),
    /*  7 */   TYPE4("买家市价，+完成还剩一点金额给解冻到自己账户", 4),
    /*  8 */   TYPE5("买的价格向下浮动，-要退钱", 5),
    /*  9 */   TYPE6("买的价格向下浮动，+要退钱", 6),
    /* 10 */   TYPE7("交易成功，+卖家收入金额", 7),
    /* 11 */   TYPE8("交易成功，-卖家手续费", 8),
    /* 12 */   TYPE9("交易成功，+买家收入币", 9),
    /* 13 */   TYPE10("交易成功，-买家手续费", 10),
    /* 14 */   TYPE11("交易成功，-卖家虚拟币解冻转买家", 11),
    /* 15 */   TYPE12("撤销委托，解冻到自己钱包", 12),
    /* 16 */   TYPE21("充值确认", 21),
    /* 17 */   TYPE22("确认提现", 22),
    /* 18 */   TYPE23("手动充值", 23),
    /* 19 */   TYPE24("手动充值又撤销", 24),

    /* 21 */   TYPE31("充币", 31),
    /* 22 */   TYPE32("人民币提现", 32),
    /* 23 */   TYPE33("提币审核成功", 33),
    /* 24 */   TYPE34("提币手续费审核成功", 34),
    /* 25 */   TYPE35("申请币提现", 35),
    /* 26 */   TYPE36("申请币提现手续费", 36),
    /* 27 */   TYPE37("提币已驳回", 37),
    /* 28 */   TYPE38("人民币提现驳回", 38),

    /* 30 */   TYPE40("佣金派发", 40);

    private String name;


    /* 34 */
    private AccountRemarkEnum(String name, int index) {
        this.name = name;
        /* 35 */
        this.index = index;
    }


    private int index;

    /* 38 */
    public static String getName(int index) {
        for (AccountRemarkEnum c :) {
            /* 39 */
            if (c.getIndex() == index) {
                /* 40 */
                return c.name;

            }

        }
        /* 43 */
        return null;

    }


    public String getName() {
        /* 47 */
        return this.name;

    }


    /* 50 */
    public void setName(String name) {
        this.name = name;
    }


    public int getIndex() {
        /* 53 */
        return this.index;

    }


    /* 56 */
    public void setIndex(int index) {
        this.index = index;
    }

}


/* Location:              E:\trade.war!\WEB-INF\classes\hry\trade\model\AccountRemarkEnum.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */