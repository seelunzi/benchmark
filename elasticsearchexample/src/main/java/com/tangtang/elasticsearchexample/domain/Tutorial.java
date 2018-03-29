package com.tangtang.elasticsearchexample.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tutorial implements Serializable {

    private Long id;

    // 教程名称
    private String name;

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
