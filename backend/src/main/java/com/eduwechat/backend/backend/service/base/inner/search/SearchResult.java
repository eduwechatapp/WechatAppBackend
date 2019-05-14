package com.eduwechat.backend.backend.service.base.inner.search;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: backend
 * @description: SearchResult
 * @author: Vaskka
 * @create: 2019/5/13 4:49 PM
 **/

@Getter
@Setter
@ToString
public class SearchResult {

    SearchResult(Integer size, Integer page, String subject, List<InnerSearchContent> dataList) {
        this.size = size;
        this.page = page;
        this.subject = subject;
        this.dataList = dataList;
    }

    /**
     * 本次搜索的分页大小
     */
    private Integer size;

    /**
     * 本次搜索的分页页数
     */
    private Integer page;

    /**
     * 所属学科 yy yw sx wl hx sw dl ls zz
     */
    private String subject;

    /**
     * 承载内容的list
     */
    private List<InnerSearchContent> dataList;


}
