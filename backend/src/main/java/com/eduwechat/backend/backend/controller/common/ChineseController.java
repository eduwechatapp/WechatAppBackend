package com.eduwechat.backend.backend.controller.common;


import com.eduwechat.backend.backend.controller.base.CanGetKnowledgeTitleListController;
import com.eduwechat.backend.backend.controller.base.CanGetSummaryTitleListController;
import com.eduwechat.backend.backend.controller.base.CanGetTopicTitleListController;
import com.eduwechat.backend.backend.controller.base.CommonController;
import com.eduwechat.backend.backend.service.common.HighSchoolChineseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Api(description = "语文接口")
@Controller
@RequestMapping(value = "/chinese")
public class ChineseController extends CommonController implements CanGetKnowledgeTitleListController,
        CanGetTopicTitleListController,
        CanGetSummaryTitleListController
{

    @Autowired
    private HighSchoolChineseService highSchoolChineseService;

    @ApiOperation(value = "获取语文知识点" ,  notes="指定分页获取语文知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid,
                                            @PathVariable Integer which,
                                            @PathVariable Integer number_every_page,
                                            @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.highSchoolChineseService, which, number_every_page, page_offset);
    }

    @ApiOperation(value = "获取语文专题" ,  notes="指定分页获取语文专题")
    @ResponseBody
    @RequestMapping(value = "/topic/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getTopic(@PathVariable String openid,
                                        @PathVariable Integer which,
                                        @PathVariable Integer number_every_page,
                                        @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.highSchoolChineseService.getTopic(which, number_every_page, page_offset));
    }

    @ApiOperation(value = "获取语文归纳总结" ,  notes="指定分页获取语文归纳总结")
    @ResponseBody
    @RequestMapping(value = "/summary/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getSummary(@PathVariable String openid,
                                        @PathVariable Integer which,
                                        @PathVariable Integer number_every_page,
                                        @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.highSchoolChineseService.getSummary(which, number_every_page, page_offset));
    }

    @Override
    @ApiOperation(value = "获取语文知识点次级标题与which映射" ,  notes="获取语文知识点次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/knowledge/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getKnowledgeTitleList() {
        return this.innerGetTitleMappingFromListGetMap(highSchoolChineseService, "知识点", "knowledge", "yw");
    }

    @Override
    @ApiOperation(value = "获取语文归纳总结次级标题与which映射" ,  notes="获取语文归纳总结次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/summary/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getSummaryTitleList() {
        return this.innerGetTitleMappingFromListGetMap(highSchoolChineseService, "归纳总结", "summary", "yw");
    }

    @Override
    @ApiOperation(value = "获取语文专题次级标题与which映射" ,  notes="获取语文专题次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/topic/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getTopicTitleList() {
        return this.innerGetTitleMappingFromListGetMap(highSchoolChineseService, "专题", "topic", "yw");
    }
}
