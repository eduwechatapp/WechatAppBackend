package com.eduwechat.backend.backend.entity.article;

import com.eduwechat.backend.backend.entity.article.inner.ArticleReply;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "article")
@ToString
public class StudentArticle {

    @Id
    private String _id;

    private String creator;

    // qcloud key
    private String key;

    private List<ArticleReply> replys;

    private String createtime;
}

