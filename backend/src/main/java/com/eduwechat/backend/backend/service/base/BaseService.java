package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务层基类
 */
public class BaseService {

    /**
     * Page转List
     * @param pages
     * @return List&lt;Content&gt;
     */
    protected List<Content> fromPageGetList(Page<BaseEntity> pages) {
        List<Content> list = new ArrayList<>();

        for (BaseEntity english : pages) {
            list.add(new Content(english.getId(), english.getTitle(), english.getContent()));
        }

        return list;
    }
}
