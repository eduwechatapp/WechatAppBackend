package com.eduwechat.backend.backend.service.base.search.impl;

import com.eduwechat.backend.backend.repository.search.HighSchoolBiologicalSearchDao;
import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;
import com.eduwechat.backend.backend.service.base.search.FullSearchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiologicalSearchService implements FullSearchable {

    @Autowired
    private HighSchoolBiologicalSearchDao searchDao;


    @Override
    public SearchResult fullSearch(String erji, String titleKeyWord, String contentKeyWord, boolean fullText, Integer size, Integer page) {
        return null;
    }

    @Override
    public SearchResult withTitleOrContentSearch(String titleKeyWord, String contentKeyWord, boolean fullText, Integer size, Integer page) {
        return null;
    }

    @Override
    public SearchResult withErjiSearch(String erjiKeyWord, boolean fullText, Integer size, Integer page) {
        return null;
    }

    @Override
    public SearchResult withTitleSearch(String titleKeyWord, boolean fullText, Integer size, Integer page) {
        return null;
    }

    @Override
    public SearchResult withContentSearch(String contentKeyWord, boolean fullText, Integer size, Integer page) {
        return null;
    }
}
