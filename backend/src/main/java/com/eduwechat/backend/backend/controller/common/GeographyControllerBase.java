package com.eduwechat.backend.backend.controller.common;


import com.eduwechat.backend.backend.controller.base.*;
import com.eduwechat.backend.backend.service.common.HighSchoolGeographyCommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Api(description = "地理接口")
@Controller
@RequestMapping(value = "/geography")
public class GeographyControllerBase extends BaseCommonController implements CanGetKnowledgeTitleListController,
        CanGetTemplateTitleListController,
        CanGetSummaryTitleListController,
        CanGetTopicTitleListController
{

    @Autowired
    private HighSchoolGeographyCommonService service;

    @ApiOperation(value = "获取地理知识点" ,  notes="指定分页获取地理知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid,
                                            @PathVariable Integer which,
                                            @PathVariable Integer number_every_page,
                                            @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.service, which, number_every_page, page_offset);
    }

    @ApiOperation(value = "获取地理专题" ,  notes="指定分页获取地理专题")
    @ResponseBody
    @RequestMapping(value = "/topic/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getTopic(@PathVariable String openid,
                                        @PathVariable Integer which,
                                        @PathVariable Integer number_every_page,
                                        @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.service.getTopic(which, number_every_page, page_offset));
    }


    @ApiOperation(value = "获取地理归纳总结" ,  notes="指定分页获取地理归纳总结")
    @ResponseBody
    @RequestMapping(value = "/summary/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getSummary(@PathVariable String openid,
                                          @PathVariable Integer which,
                                          @PathVariable Integer number_every_page,
                                          @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.service.getSummary(which, number_every_page, page_offset));
    }

    @ApiOperation(value = "获取地理答题模板" ,  notes="指定分页获取地理答题模板")
    @ResponseBody
    @RequestMapping(value = "/template/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getTemplate(@PathVariable String openid,
                                           @PathVariable Integer which,
                                           @PathVariable Integer number_every_page,
                                           @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.service.getTemplate(which, number_every_page, page_offset));
    }

    @Override
    @ApiOperation(value = "获取地理知识点次级标题与which映射" ,  notes="获取地理知识点次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/knowledge/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getKnowledgeTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "知识点", "knowledge", "dl");
    }

    @Override
    @ApiOperation(value = "获取地理归纳总结次级标题与which映射" ,  notes="获取地理归纳总结次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/summary/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getSummaryTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "归纳总结", "summary", "dl");
    }

    @Override
    @ApiOperation(value = "获取地理答题模板次级标题与which映射" ,  notes="获取地理答题模板次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/template/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getTemplateTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "答题模板", "template", "dl");
    }

    @Override
    @ApiOperation(value = "获取地理专题次级标题与which映射" ,  notes="获取地理专题次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/topic/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getTopicTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "专题", "topic", "dl");
    }
}


