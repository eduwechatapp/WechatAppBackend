package com.eduwechat.backend.backend.repository.v2.article;

import com.eduwechat.backend.backend.entity.v2.article.StudentArticle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentArticleDao extends MongoRepository<StudentArticle, String> {
    List<StudentArticle> findByCreator(Long creator, Pageable pageable);
}
