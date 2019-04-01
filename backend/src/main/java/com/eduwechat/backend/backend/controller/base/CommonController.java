package com.eduwechat.backend.backend.controller.base;


import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.inner.Content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonController {

    /**
     * 处理一般情况List->data->mapping
     * @param list List&lt;Content&gt;
     * @return Map&lt;String, Object&gt;
     */
    protected Map<String, Object> innerCommonFromListGetMap(List<Content> list) {
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);

        map.put("data", list);

        return map;
    }

    /**
     * 处理能获取知识点的接口
     * @param service 服务层引用
     * @param which 根据which选择教材
     * @param number_every_page size
     * @param page_offset page
     * @return Map&lt;String, Object&gt;
     */
    protected Map<String, Object> innerGetKnowledge(CommonService service, Integer which, Integer number_every_page, Integer page_offset) {
        return this.innerCommonFromListGetMap(service.getKnowledge(which, number_every_page, page_offset));
    }

    /**
     * 处理TitleMappingList情况List->data->mapping
     * @param service CommonService
     * @return Map&lt;String, Object&gt;
     */
    protected Map<String, Object> innerGetTitleMappingFromListGetMap(CommonService service) {
        Map<String, Object> map = new HashMap<>();

        map.put("code", 0);

        map.put("data", service.getTitleList());

        return map;
    }

}
