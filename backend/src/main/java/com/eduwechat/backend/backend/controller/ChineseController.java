package com.eduwechat.backend.backend.controller;


import com.eduwechat.backend.backend.controller.base.CommonController;
import com.eduwechat.backend.backend.service.HighSchoolChineseService;
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
public class ChineseController extends CommonController {

    @Autowired
    private HighSchoolChineseService highSchoolEnglishService;

    @ApiOperation(value = "获取语文知识点" ,  notes="指定分页获取语文知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid,
                                            @PathVariable Integer which,
                                            @PathVariable Integer number_every_page,
                                            @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.highSchoolEnglishService, which, number_every_page, page_offset);
    }

    @ApiOperation(value = "获取语文专题" ,  notes="指定分页获取语文专题")
    @ResponseBody
    @RequestMapping(value = "/topic/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getTopic(@PathVariable String openid,
                                        @PathVariable Integer which,
                                        @PathVariable Integer number_every_page,
                                        @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.highSchoolEnglishService.getTopic(which, number_every_page, page_offset));
    }

    @ApiOperation(value = "获取语文归纳总结" ,  notes="指定分页获取语文归纳总结")
    @ResponseBody
    @RequestMapping(value = "/summary/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getSummary(@PathVariable String openid,
                                        @PathVariable Integer which,
                                        @PathVariable Integer number_every_page,
                                        @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.highSchoolEnglishService.getSummary(which, number_every_page, page_offset));
    }

}
