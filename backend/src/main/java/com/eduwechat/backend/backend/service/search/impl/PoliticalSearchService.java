package com.eduwechat.backend.backend.service.search.impl;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.repository.HighSchoolPoliticalRepository;
import com.eduwechat.backend.backend.service.base.SearchService;
import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;
import com.eduwechat.backend.backend.service.search.FullSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @program: backend
 * @description: PoliticalSearchService
 * @author: Vaskka
 * @create: 2019/5/15 3:01 AM
 **/
@Service
public class PoliticalSearchService extends SearchService implements FullSearchable {
    @Autowired
    private HighSchoolPoliticalRepository searchDao;

    @Override
    public SearchResult fullSearch(String erji, String titleKeyWord, String contentKeyWord, Integer size, Integer page) {
        Page<BaseEntity> seachResult = searchDao.findByTitleContainingOrContentContainingOrErjiContaining(titleKeyWord, contentKeyWord, erji, PageRequest.of(page, size));

        return this.innerFromSubjectGetSearchResult(page, size, "zz", seachResult);
    }

    @Override
    public SearchResult withTitleOrContentSearch(String titleKeyWord, String contentKeyWord, Integer size, Integer page) {
        Page<BaseEntity> seachResult = searchDao.findByTitleContainingOrContentContaining(titleKeyWord, contentKeyWord, PageRequest.of(page, size));

        return this.innerFromSubjectGetSearchResult(page, size, "zz", seachResult);
    }

    @Override
    public SearchResult withErjiSearch(String erjiKeyWord, Integer size, Integer page) {
        Page<BaseEntity> seachResult = searchDao.findByErjiContaining(erjiKeyWord, PageRequest.of(page, size));

        return this.innerFromSubjectGetSearchResult(page, size, "zz", seachResult);
    }

    @Override
    public SearchResult withTitleSearch(String titleKeyWord, Integer size, Integer page) {
        Page<BaseEntity> seachResult = searchDao.findByTitleContaining(titleKeyWord, PageRequest.of(page, size));

        return this.innerFromSubjectGetSearchResult(page, size, "zz", seachResult);
    }

    @Override
    public SearchResult withContentSearch(String contentKeyWord, Integer size, Integer page) {
        Page<BaseEntity> seachResult = searchDao.findByContentContaining(contentKeyWord, PageRequest.of(page, size));

        return this.innerFromSubjectGetSearchResult(page, size, "zz", seachResult);
    }
}
