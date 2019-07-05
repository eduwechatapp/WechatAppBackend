package com.eduwechat.backend.backend.entity.v2.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ArticleReply {

    private Long creator;

    private String content;

    private String createTime;
}
