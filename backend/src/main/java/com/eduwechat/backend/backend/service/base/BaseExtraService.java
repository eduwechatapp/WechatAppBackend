package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;

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
    public abstract List<T> getNewKNowledgeFromYiji(String yiji, Integer size, Integer page) throws ArticleNotFoundException;

}
