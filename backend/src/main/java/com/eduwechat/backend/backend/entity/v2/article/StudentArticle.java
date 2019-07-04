package com.eduwechat.backend.backend.entity.v2.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "article")
@ToString
@AllArgsConstructor
@Setter
@Getter
public class StudentArticle {

    @Id
    private String _id;

    private Long creator;

    private String title;

    // qcloud key
    private String key;

    private List<ArticleReply> replys;

    private String createTime;

    public StudentArticle() {}
}

