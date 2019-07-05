package com.eduwechat.backend.backend.controller.common;


import com.eduwechat.backend.backend.controller.base.CanGetKnowledgeTitleListController;
import com.eduwechat.backend.backend.controller.base.BaseCommonController;
import com.eduwechat.backend.backend.controller.base.ExtraController;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.service.common.HighSchoolBiologicalCommonService;
import com.eduwechat.backend.backend.service.extra.ExtraBiologyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Api(description = "生物接口")
@Controller
@RequestMapping(value = "/biology")
public class BiologicalControllerBase extends ExtraController implements CanGetKnowledgeTitleListController {

    @Autowired
    HighSchoolBiologicalCommonService service;


    @Autowired
    private ExtraBiologyService extraService;

    @ApiOperation(value = "获取生物知识点" ,  notes="指定分页获取生物知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid, @PathVariable Integer which, @PathVariable Integer number_every_page, @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.service, which, number_every_page, page_offset);
    }

    @Override
    @ApiOperation(value = "获取生物知识点次级标题与which映射" ,  notes="获取生物知识点次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/knowledge/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getKnowledgeTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "知识点", "knowledge", "sw");
    }

    @ApiOperation(value = "获取生物新的知识点接口（一次全部获取，弃用）" ,  notes="一起拿全，分页")
    @ResponseBody
    @RequestMapping(value = "/new/knowledge/get/{openid}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getNewKnowledge(@PathVariable("openid") String openid,
                                               @PathVariable(value = "number_every_page") Integer size,
                                               @PathVariable(value = "page_offset") Integer page) {
        Map<String, Object> r = new HashMap<>();

        r.put("code", 0);
        r.put("msg", "success");
        r.put("data", extraService.getNewKnowledge(size, page));

        return r;
    }

    @Override
    @ApiOperation(value = "Step 1 --- 新的知识点最大标题（yiji标题）列表" ,  notes="拿到yiji标题list")
    @ResponseBody
    @RequestMapping(value = "/new/title/get/{openid}", method = RequestMethod.GET)
    public Map<String, Object> getNewYijiTitleList(@PathVariable("openid") String openid) {
        return this.innerGetYijiList(extraService);
    }

    @Override
    @ApiOperation(value = "Step 2 --- 获取yiji标题下title列表" ,  notes="拿到分页标题")
    @ResponseBody
    @RequestMapping(value = "/new/title/get/{openid}/{yiji}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getFromYiji(@PathVariable("openid") String openid,
                                           @PathVariable("yiji") String yiji,
                                           @PathVariable("number_every_page") Integer size,
                                           @PathVariable("page_offset") Integer page) {
        return this.innerGetTitleList(yiji, size, page, extraService);
    }

    @Override
    @ApiOperation(value = "Step 3 --- 根据标题获取指定化学新的知识点文章" ,  notes="获取指定title的文章")
    @ResponseBody
    @RequestMapping(value = "/new/content/get/{openid}/{title}", method = RequestMethod.GET)
    public Map<String, Object> getFromTitle(@PathVariable("openid") String openid,
                                            @PathVariable("title") String title) {
        return this.innerGetContent(title, extraService);
    }

}
