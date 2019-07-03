package com.eduwechat.backend.backend.entity.v2.article.inner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleReply {

    private String creator;

    private String content;

    private String createtime;
}
