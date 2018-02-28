package com.tangtang.elasticsearchexample.domain;

import java.io.Serializable;

/**
 * Created by tianshouzhi on 2018/1/4.
 */
public class Tutorial implements Serializable {
    private Long id;

    // 教程名称
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
