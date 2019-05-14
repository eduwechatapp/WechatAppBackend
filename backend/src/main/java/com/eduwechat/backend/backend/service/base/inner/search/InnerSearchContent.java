package com.eduwechat.backend.backend.service.base.inner.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: backend
 * @description: InnerSearchContent
 * @author: Vaskka
 * @create: 2019/5/15 12:25 AM
 **/

@Getter
@Setter
@AllArgsConstructor
public class InnerSearchContent {

    /**
     * title 可以为简略形式（前几个字）可以为全文形式
     */
    private String title;

    /**
     * content 可以为简略形式（前几个字）可以为全文形式
     */
    private String content;

    /**
     * 二级标题 可以为简略形式（前几个字）可以为全文形式
     */
    private String erji;



}

