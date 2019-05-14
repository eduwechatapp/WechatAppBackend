package com.eduwechat.backend.backend.service.base.inner.search;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.exceptions.common.BuilderNotReadyException;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: backend
 * @description: SearchResultBuilder
 * @author: Vaskka
 * @create: 2019/5/15 12:32 AM
 **/

public class SearchResultBuilder {

    private Integer size;

    private Integer page;

    private String subject;

    private List<InnerSearchContent> dataList;

    private SearchResultBuilder() {
    }


    /**
     * 工厂初始化方法
     * @return SearchResultBuilder
     */
    public static SearchResultBuilder init() {
        return new SearchResultBuilder();
    }


    public SearchResultBuilder confirmSize(Integer size) {
        this.size = size;

        return this;
    }

    public SearchResultBuilder confirmPage(Integer page) {
        this.page = page;

        return this;
    }

    public SearchResultBuilder confirmSubject(String subject) {
        this.subject = subject;

        return this;
    }

    /**
     * 整理分页数据
     * @param pageList Page&lt;BaseEntity&gt;
     * @return SearchResultBuilder
     */
    public SearchResultBuilder confirmDataList(Page<BaseEntity> pageList) {

        List<InnerSearchContent> list = new ArrayList<>(pageList.getSize());

        for (BaseEntity entity : pageList) {
            InnerSearchContent content = new InnerSearchContent(entity.getTitle(), entity.getContent(), entity.getErji());

            list.add(content);
        }

        this.dataList = list;

        return this;
    }

    /**
     * 构建结果对象
     * @return SearchResult
     * @throws BuilderNotReadyException 有为初始化的属性异常
     */
    public SearchResult build() throws BuilderNotReadyException {
        if (this.size == null) {
            throw new BuilderNotReadyException("SearchResultBuilder", "SearchResult", "size");
        }

        if (this.page == null) {
            throw new BuilderNotReadyException("SearchResultBuilder", "SearchResult", "page");
        }

        if (this.subject == null) {
            throw new BuilderNotReadyException("SearchResultBuilder", "SearchResult", "subject");
        }

        if (this.dataList == null) {
            throw new BuilderNotReadyException("SearchResultBuilder", "SearchResult", "dataList");
        }

        return new SearchResult(this.size, this.page, this.subject, this.dataList);
    }
}
