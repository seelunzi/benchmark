package com.tangtang.elasticsearchexample.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/***
 * @author tang
 * */
@Data
@Document(indexName = "projectname", type = "article", indexStoreType = "fs", shards = 5, replicas = 1, refreshInterval = "-1")
public class Article implements Serializable {
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String abstracts;

    /**
     * 内容
     */
    private String content;

    /**
     * 发表时间
     */
    private Date postTime;

    /**
     * 点击率
     */
    private Long clickCount;

    /**
     * 作者
     */
    private Author author;

    /**
     * 所属教程
     */
    private Tutorial tutorial;
}
