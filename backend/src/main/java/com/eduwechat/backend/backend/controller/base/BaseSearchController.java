package com.eduwechat.backend.backend.controller.base;

import com.eduwechat.backend.backend.exceptions.search.SearchParamMissingException;
import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;
import com.eduwechat.backend.backend.service.search.impl.*;
import net.minidev.json.JSONObject;

import java.util.Map;

/**
 * @program: backend
 * @description: BaseSearchController
 * @author: Vaskka
 * @create: 2019/5/15 10:14 AM
 **/

public abstract class BaseSearchController {

    /**
     * 单学科查询
     * @param openid openid
     * @param jsonObject 查询具体关键字json对象
     * @param subject 学科 拼音首字母 yy yw sx wl hx sw dl ls zz
     * @param size 每页大小
     * @param page 页偏移
     * @return 可序列化为Json对象的Map对象
     */
    public abstract Map<String, Object> doDetailSearch(String openid, JSONObject jsonObject, String subject, Integer size, Integer page);


    /**
     * 简单查询
     * @param openid openid
     * @param size size
     * @param page page
     * @param keyWord 关键字
     * @return 可序列化为Json对象的Map对象
     */
    public abstract Map<String, Object> doSimpleSearch(String openid, String keyWord, Integer size, Integer page);

    /* 2019-05-15 ==== 9科的内部查询接口，代码过于冗余后续一定要重构（搜索模块服务层设计不合理)  */

    protected SearchResult fromSearchDataGetBiologicalSearchResult(BiologicalBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException, NullPointerException {

        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }

    }

    protected SearchResult fromSearchDataGetChemistrySearchResult(ChemistryBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException {


        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }
    }

    protected SearchResult fromSearchDataGetChineseSearchResult(ChineseBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException {


        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }
    }

    protected SearchResult fromSearchDataGetEnglishSearchResult(EnglishBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException {


        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }

    }

    protected SearchResult fromSearchDataGetGeographySearchResult(GeographyBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException {


        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }

    }

    protected SearchResult fromSearchDataGetHistorySearchResult(HistoryBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException {

        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }

    }

    protected SearchResult fromSearchDataGetMathSearchResult(MathBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException {


        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }
    }

    protected SearchResult fromSearchDataGetPhysicsSearchResult(PhysicsBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException {


        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }

    }

    protected SearchResult fromSearchDataGetPoliticalSearchResult(PoliticalBaseSearchService searchService, JSONObject data, Integer size, Integer page) throws SearchParamMissingException {

        // 获取查询数据
        Object title = data.get("title");

        Object content = data.get("content");

        Object erji = data.get("erji");

        // 分类
        if (title == null && content == null && erji == null) {
            throw new SearchParamMissingException("请输入至少一种搜索关键字");
        }
        else if (title != null && content != null && erji != null) {
            return searchService.fullSearch(erji.toString(), title.toString(), content.toString(), size, page);
        }
        else if (erji == null && title != null && content != null) {
            return searchService.withTitleOrContentSearch(title.toString(), content.toString(), size, page);
        }
        else if (title != null && erji == null) {
            return searchService.withTitleSearch(title.toString(), size, page);
        }
        else if (content != null && erji == null) {
            return searchService.withContentSearch(content.toString(), size, page);
        }
        else if (title == null && content == null) {
            return searchService.withErjiSearch(erji.toString(), size, page);
        }
        else {
            if (content == null) {
                throw new NullPointerException("不支持的查询");
            }
            return searchService.withContentSearch(content.toString(), size, page);
        }

    }
}
