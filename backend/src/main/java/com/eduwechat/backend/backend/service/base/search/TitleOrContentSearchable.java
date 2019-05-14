package com.eduwechat.backend.backend.service.base.search;

import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;

/**
 * 标题和内容均匹配搜索
 */
public interface TitleOrContentSearchable extends SingleSearchable {

    /**
     * 根据标题关键字和内容关键字同时搜索
     * @param titleKeyWord 标题关键字
     * @param contentKeyWord 内容关键字
     * @param size 页大小
     * @param page 页数量
     * @return 搜索结果
     */
    SearchResult withTitleOrContentSearch(String titleKeyWord, String contentKeyWord, boolean fullText, Integer size, Integer page);
}
