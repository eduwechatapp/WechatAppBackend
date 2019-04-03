package com.eduwechat.backend.backend.controller;


import com.eduwechat.backend.backend.controller.base.CanGetKnowledgeTitleListController;
import com.eduwechat.backend.backend.controller.base.CanGetSummaryTitleListController;
import com.eduwechat.backend.backend.controller.base.CanGetTopicTitleListController;
import com.eduwechat.backend.backend.controller.base.CommonController;
import com.eduwechat.backend.backend.service.HighSchoolEnglishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Api(description = "英语接口")
@Controller
@RequestMapping(value = "/english")
public class EnglishController extends CommonController implements CanGetKnowledgeTitleListController,
        CanGetTopicTitleListController,
        CanGetSummaryTitleListController
{

    @Autowired
    private HighSchoolEnglishService highSchoolEnglishService;

    @ApiOperation(value = "获取英语知识点" ,  notes="指定分页获取英语知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid,
                                            @PathVariable Integer which,
                                            @PathVariable Integer number_every_page,
                                            @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.highSchoolEnglishService, which, number_every_page, page_offset);
    }

    @ApiOperation(value = "获取英语专题" ,  notes="指定分页获取英语专题")
    @ResponseBody
    @RequestMapping(value = "/topic/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getTopic(@PathVariable String openid,
                                        @PathVariable Integer which,
                                        @PathVariable Integer number_every_page,
                                        @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.highSchoolEnglishService.getTopic(which, number_every_page, page_offset));
    }

    @ApiOperation(value = "获取英语归纳总结" ,  notes="指定分页获取英语归纳总结")
    @ResponseBody
    @RequestMapping(value = "/summary/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getSummary(@PathVariable String openid,
                                        @PathVariable Integer which,
                                        @PathVariable Integer number_every_page,
                                        @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.highSchoolEnglishService.getSummary(which, number_every_page, page_offset));
    }

    @Override
    @ApiOperation(value = "获取英语知识点次级标题与which映射" ,  notes="获取英语知识点次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/knowledge/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getKnowledgeTitleList() {
        return this.innerGetTitleMappingFromListGetMap(highSchoolEnglishService, "知识点", "knowledge", "yy");
    }

    @Override
    @ApiOperation(value = "获取英语归纳总结次级标题与which映射" ,  notes="获取英语归纳总结次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/summary/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getSummaryTitleList() {
        return this.innerGetTitleMappingFromListGetMap(highSchoolEnglishService, "归纳总结", "summary", "yy");
    }

    @Override
    @ApiOperation(value = "获取英语专题次级标题与which映射" ,  notes="获取英语专题次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/topic/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getTopicTitleList() {
        return this.innerGetTitleMappingFromListGetMap(highSchoolEnglishService, "专题", "topic", "yy");
    }
}
