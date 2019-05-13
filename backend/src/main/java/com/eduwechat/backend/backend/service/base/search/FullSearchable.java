package com.eduwechat.backend.backend.service.base.search;

import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;

/**
 * 二级标题、标题、内容全匹配搜索
 */
public interface FullSearchable extends TitleOrContentSearchable {

    /**
     * 根据二级标题和标题和内容共同搜索（or的关系）
     * @param erji 二级标题关键字
     * @param titleKeyWord 标题关键字
     * @param contentKeyWord 内容关键字
     * @param size 页大小
     * @param page 页数
     * @return 搜索结果对象
     */
    SearchResult fullSearch(String erji, String titleKeyWord, String contentKeyWord, boolean fullText, Integer size, Integer page, String subject);
}
