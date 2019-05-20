package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务层基类
 */
public class BaseCommonService {

    /**
     * Page转List
     * @param pages
     * @return List&lt;Content&gt;
     */
    protected List<Content> fromPageGetList(Page<BaseCommonEntity> pages) {
        List<Content> list = new ArrayList<>();

        for (BaseCommonEntity english : pages) {
            list.add(new Content(english.getId(), english.getTitle(), english.getContent()));
        }

        return list;
    }
}
