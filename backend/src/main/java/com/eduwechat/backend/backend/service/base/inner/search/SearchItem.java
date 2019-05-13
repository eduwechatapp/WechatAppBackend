package com.eduwechat.backend.backend.service.base.inner.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: backend
 * @description: SearchItem
 * @author: Vaskka
 * @create: 2019/5/13 4:54 PM
 **/

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SearchItem {

    /**
     * 所属学科 yy yw sx wl hx sw dl ls zz
     */
    private String subject;

    /**
     * 可用于定位具体文章的which
     */
    private Integer erjiWhich;

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
