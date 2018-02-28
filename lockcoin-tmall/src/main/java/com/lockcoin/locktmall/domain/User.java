package com.lockcoin.locktmall.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tangwenbo
 * @date 2018/2/1
 * @since JDK1.8
 */
@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;

}
