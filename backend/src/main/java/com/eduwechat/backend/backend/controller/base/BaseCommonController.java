package com.eduwechat.backend.backend.controller.base;


import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.service.base.BaseCommonService;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import com.eduwechat.backend.backend.service.common.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseCommonController {

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
    protected Map<String, Object> innerGetKnowledge(BaseCommonService service, Integer which, Integer number_every_page, Integer page_offset) {
        return this.innerCommonFromListGetMap(service.getKnowledge(which, number_every_page, page_offset));
    }

    /**
     * 处理TitleMappingList情况List->data->mapping
     * @param service CommonService 通用服务层对象
     * @param yijiString String 数据库中一级标题字段名称
     * @param yijiType String 一级类型 knowledge topic summary template
     * @param subjectType String 学科类型 zz hx yy yw sx ls dl sw wl
     * @return Map&lt;String, Object&gt;
     */
    protected Map<String, Object> innerGetTitleMappingFromListGetMap(BaseCommonService service,
                                                                     String yijiString,
                                                                     String yijiType,
                                                                     String subjectType) {
        Map<String, Object> map = new HashMap<>();

        try {
            List<TitleListMapping> list = service.getTitleList(yijiString, yijiType, subjectType);
            map.put("data", list);
            map.put("code", 0);
        }
        catch (TypeNotMatchException e) {
            switch (e.getWhichType()) {
                case SUBJECT:
                    map.put("data", "不存在此学科");
                    map.put("code", 1);
                case YIJI:
                    map.put("data", "此学科不存在" + e.getMissingType() + "类型的一级标题");
                    map.put("code", 2);
                default:
                    map.put("data", "unknow error");
                    map.put("code", 3);
            }
        }

        return map;
    }

}
