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
@AllArgsConstructor
@ToString
public class SearchResult {
    /**
     * 本次搜索的分页大小
     */
    private Integer size;

    /**
     * 本次搜索的分页页数
     */
    private Integer page;

    /**
     * 搜索的内容是否为全部内容（或为简略内容）
     */
    private boolean fullText;

    /**
     * 承载具体数据
     */
    private List<SearchItem> data;
}
