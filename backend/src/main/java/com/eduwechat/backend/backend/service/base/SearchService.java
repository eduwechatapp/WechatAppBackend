package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.exceptions.common.BuilderNotReadyException;
import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;
import com.eduwechat.backend.backend.service.base.inner.search.SearchResultBuilder;
import org.springframework.data.domain.Page;

/**
 * @program: backend
 * @description: SearchService 搜索服务层基类
 * @author: Vaskka
 * @create: 2019/5/15 1:08 AM
 **/

public class SearchService {

    /**
     * 根据Page信息得到SearchResult结果对象
     * @param page 分页页数
     * @param size 分页大小
     * @param subject 科目
     * @param seachResult PageList
     * @return SearchResult
     */
    protected SearchResult innerFromSubjectGetSearchResult(Integer page, Integer size, String subject, Page<BaseEntity> seachResult) {
        try {
            return SearchResultBuilder.init()
                    .confirmPage(page)
                    .confirmSize(size)
                    .confirmSubject(subject)
                    .confirmDataList(seachResult)
                    .build();
        } catch (BuilderNotReadyException ignored) { }

        return null;
    }
}
