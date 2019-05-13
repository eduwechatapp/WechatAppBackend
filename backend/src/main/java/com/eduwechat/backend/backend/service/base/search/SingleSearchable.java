package com.eduwechat.backend.backend.service.base.search;

import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;

import java.util.List;

/**
 * @program: backend
 * @description: Searchable
 * @author: Vaskka
 * @create: 2019/5/13 4:47 PM
 **/

public interface SignleSearchable {

    SearchResult withErjiSearch(String titleKeyWord, Integer size, Integer page);

    SearchResult withTitleSearch(String titleKeyWord, Integer size, Integer page);

    SearchResult withContentSearch(String titleKeyWord, Integer size, Integer page);

}
