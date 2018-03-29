package com.tangtang.elasticsearchexample.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Author implements Serializable {

    private Long id;
    /**
     * 作者姓名
     */
    private String name;

    /**
     * 作者简介
     */
    private String remark;
}
