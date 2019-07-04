package com.eduwechat.backend.backend.service.v2.article;

import com.eduwechat.backend.backend.entity.v2.article.StudentArticle;
import com.eduwechat.backend.backend.service.base.inner.article.ArticleWithUrl;
import com.eduwechat.backend.backend.service.v2.base.AuthService;

import java.util.ArrayList;
import java.util.List;

public class BaseArticleService extends AuthService {

    /**
     * 转换Entity到结果需要的实体
     * @param original 源List
     * @return 转换后List
     */
     List<ArticleWithUrl> fromEntityListGetArticleWithUrlList(List<StudentArticle> original) {

        List<ArticleWithUrl> result = new ArrayList<>();
        for (StudentArticle article : original) {
            result.add(ArticleWithUrl.getInstanceFromEntity(article));
        }

        return result;
    }
}
