package com.eduwechat.backend.backend.service.base.inner.article;

import com.eduwechat.backend.backend.entity.v2.article.ArticleReply;
import com.eduwechat.backend.backend.entity.v2.article.StudentArticle;
import com.eduwechat.backend.backend.utils.cos.COSUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ArticleWithUrl {
    private String _id;

    private String url;

    private String title;

    private List<ArticleReply> reply;

    /**
     * 从实体得到this
     * @param article article
     * @return ArticleWithUrl
     */
    public static ArticleWithUrl getInstanceFromEntity(StudentArticle article) {
        // 换取url
        String url = COSUtil.getUrlFromObjectKey(article.getKey());

        return new ArticleWithUrl(article.get_id(), url, article.getTitle(), article.getReplys());
    }
}
