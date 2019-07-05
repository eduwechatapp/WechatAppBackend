package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseExtraEntity;
import com.eduwechat.backend.backend.entity.extra.ChemistryEntity;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: backend
 * @description: BaseExtraService
 * @author: Vaskka
 * @create: 2019/5/31 3:18 AM
 **/

public abstract class BaseExtraService<T> {

    /**
     * 分页获取新知识点的全部数据
     * @param size 每页宽
     * @param page 页偏移
     * @return List&lt;T&gt;
     */
    public abstract List<T> getNewKnowledge(int size, int page);

    /**
     * 获取标题映射
     * @return List&lt;TotalTitleResultItem&gt; 总标题映射
     */
    public abstract List<String> getTotalList();

    /**
     * 根据yiji和title拿数据
     * @param yiji yiji
     * @param size 页大小
     * @param page 页偏移
     * @return List&lt;T&gt;
     */
    public abstract List<String> getNewKNowledgeFromYiji(String yiji, Integer size, Integer page) throws ArticleNotFoundException;

    /**
     * 根据标题得到文章具体内容
     * @param title 标题
     * @return T
     */
    public abstract T getContentFromTitle(String title) throws ArticleNotFoundException;

    /**
     * 得到列表第一个元素
     * @param list 列表
     * @return T
     * @throws ArticleNotFoundException 文章未找到
     */
    protected T fromListGetFirst(List<T> list) throws ArticleNotFoundException {
        if (list.size() == 0) {
            throw new ArticleNotFoundException("文章未找到");
        }

        return list.get(0);
    }

    protected  List<String> fromEntityGetTitle(List<T> list) throws ArticleNotFoundException {
        if (list.size() == 0) {
            throw new ArticleNotFoundException("一级标题未找到");
        }

        List<String> r = new ArrayList<>();
        for (T entity : list) {
            r.add(((BaseExtraEntity) entity).getTitle());
        }

        return r;
    }
}
