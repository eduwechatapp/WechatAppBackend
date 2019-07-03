package com.eduwechat.backend.backend.repository.v2.article;

import com.eduwechat.backend.backend.entity.v2.article.StudentArticle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentArticleDao extends MongoRepository<StudentArticle, String> {
}
