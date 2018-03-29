package com.tangtang.elasticsearchexample.es;

import com.tangtang.elasticsearchexample.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
}
