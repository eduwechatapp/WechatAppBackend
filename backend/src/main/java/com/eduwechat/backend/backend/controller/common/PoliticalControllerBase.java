package com.eduwechat.backend.backend.controller.common;

import com.eduwechat.backend.backend.controller.base.CanGetKnowledgeTitleListController;
import com.eduwechat.backend.backend.controller.base.CanGetSummaryTitleListController;
import com.eduwechat.backend.backend.controller.base.BaseCommonController;
import com.eduwechat.backend.backend.service.common.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Api(description = "政治接口")
@Controller
@RequestMapping(value = "/political")
public class PoliticalControllerBase extends BaseCommonController implements CanGetKnowledgeTitleListController,
        CanGetSummaryTitleListController
{

    @Autowired
    private CommonService service;

    @ApiOperation(value = "获取政治知识点" ,  notes="指定分页获取政治知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid,
                                            @PathVariable Integer which,
                                            @PathVariable Integer number_every_page,
                                            @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.service, which, number_every_page, page_offset);
    }

    @ApiOperation(value = "获取政治归纳总结" ,  notes="指定分页获取政治归纳总结")
    @ResponseBody
    @RequestMapping(value = "/summary/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getSummary(@PathVariable String openid,
                                          @PathVariable Integer which,
                                          @PathVariable Integer number_every_page,
                                          @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.service.getSummary(which, number_every_page, page_offset));
    }

    @Override
    @ApiOperation(value = "获取政治知识点次级标题与which映射" ,  notes="获取政治知识点次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/knowledge/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getKnowledgeTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "知识点", "knowledge", "zz");
    }

    @Override
    @ApiOperation(value = "获取政治归纳总结次级标题与which映射" ,  notes="获取政治归纳总结次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/summary/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getSummaryTitleList() {

        return this.innerGetTitleMappingFromListGetMap(service,"归纳总结", "summary", "zz");
    }
}
