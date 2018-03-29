package com.lockcoin.locktmall.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangwenbo
 * @date 2018/1/29
 * @since JDK1.8
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 用户ID
     */
    private Long id;

    /***
     *用户名
     * */
    private String userName;

}
