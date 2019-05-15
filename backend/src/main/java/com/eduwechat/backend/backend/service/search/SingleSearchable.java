package com.eduwechat.backend.backend.service.search;

import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;

/**
 * @program: backend
 * @description: Searchable
 * @author: Vaskka
 * @create: 2019/5/13 4:47 PM
 **/

/**
 * 三种类（二级标题、标题、内容）单一搜索
 */
public interface SingleSearchable {

    /**
     * 只根据二级搜索
     * @param erjiKeyWord 二级标题的搜索关键字
     * @param size 页大小
     * @param page 页数
     * @return 搜索结果对象
     */
    SearchResult withErjiSearch(String erjiKeyWord, Integer size, Integer page);

    /**
     * 只根据标题搜索
     * @param titleKeyWord 标题的搜索关键字
     * @param size 页大小
     * @param page 页数
     * @return 搜索结果对象
     */
    SearchResult withTitleSearch(String titleKeyWord, Integer size, Integer page);

    /**
     * 只根据内容搜索
     * @param contentKeyWord 内容搜索关键字
     * @param size 页大小
     * @param page 页数
     * @return 搜索结果对象
     */
    SearchResult withContentSearch(String contentKeyWord, Integer size, Integer page);

}