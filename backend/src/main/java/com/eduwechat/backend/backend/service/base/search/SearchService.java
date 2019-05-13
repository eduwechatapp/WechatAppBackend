package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import com.eduwechat.backend.backend.service.base.inner.search.SearchItem;
import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: backend
 * @description: SearchService
 * @author: Vaskka
 * @create: 2019/5/13 6:01 PM
 **/

public class SearchService {

    @Override
    public SearchResult fullSearch(String erji, String titleKeyWord, String contentKeyWord, boolean fullText, Integer size, Integer page, String subject) {

        Page<BaseEntity> data = searchEngine.findByTitleLikeOrContentLikeOrErjiLike(titleKeyWord, contentKeyWord, erji, PageRequest.of(page, size));
        List<SearchItem> dataList = new ArrayList<>();

        for (BaseEntity rawDataItem : data) {

            List<TitleListMapping> middleMappingList;
            switch (rawDataItem.getYiji()) {
                case "知识点":
                    middleMappingList =
                    break;
                case "归纳总结":
                    break;
                case "专题":
                    break;
                case "答题模版":
                    break;
                default:
                    return null;
            }

            SearchItem item = new SearchItem();
            dataList.add(item);
        }

        return new SearchResult(size, page, fullText, );
    }

    @Override
    public SearchResult withTitleOrContentSearch(String titleKeyWord, String contentKeyWord, boolean fullText, Integer size, Integer page, String subject) {
        return null;
    }

    @Override
    public SearchResult withErjiSearch(String erjiKeyWord, boolean fullText, Integer size, Integer page, String subject) {
        return null;
    }

    @Override
    public SearchResult withTitleSearch(String titleKeyWord, boolean fullText, Integer size, Integer page, String subject) {
        return null;
    }

    @Override
    public SearchResult withContentSearch(String contentKeyWord, boolean fullText, Integer size, Integer page, String subject) {
        return null;
    }
}
