package com.eduwechat.backend.backend.controller.common;

import com.eduwechat.backend.backend.controller.base.CanGetKnowledgeTitleListController;
import com.eduwechat.backend.backend.controller.base.BaseCommonController;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.service.common.HighSchoolPhysicsCommonService;
import com.eduwechat.backend.backend.service.extra.ExtraPhysicsService;
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


@Api(description = "物理接口")
@Controller
@RequestMapping(value = "/physics")
public class PhysicsControllerBase extends BaseCommonController implements CanGetKnowledgeTitleListController {

    @Autowired
    HighSchoolPhysicsCommonService service;

    @Autowired
    private ExtraPhysicsService extraService;

    @ApiOperation(value = "获取物理知识点" ,  notes="指定必修选修知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid, @PathVariable Integer which, @PathVariable Integer number_every_page, @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.service, which, number_every_page, page_offset);
    }

    @Override
    @ApiOperation(value = "获取物理知识点次级标题与which映射" ,  notes="获取物理知识点次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/knowledge/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getKnowledgeTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "知识点", "knowledge", "wl");
    }

    @ApiOperation(value = "获取物理新的知识点接口" ,  notes="一起拿全，分页")
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

    @ApiOperation(value = "获取物理新的知识点标题列表" ,  notes="拿到标题list")
    @ResponseBody
    @RequestMapping(value = "/new/title/get/{openid}", method = RequestMethod.GET)
    public Map<String, Object> getNewTitle(@PathVariable("openid") String openid) {
        Map<String, Object> r = new HashMap<>();

        r.put("code", 0);
        r.put("msg", "success");
        r.put("data", extraService.getTotalList());

        return r;
    }

    @ApiOperation(value = "根据标题筛选物理新的知识点列表" ,  notes="拿到分页数据")
    @ResponseBody
    @RequestMapping(value = "/new/title/get/{openid}/{yiji}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getFromYiji(@PathVariable("openid") String openid,
                                           @PathVariable("yiji") String yiji,
                                           @PathVariable("number_every_page") Integer size,
                                           @PathVariable("page_offset") Integer page) {
        Map<String, Object> r = new HashMap<>();

        try {
            r.put("data", extraService.getNewKNowledgeFromYiji(yiji, size, page));
            r.put("code", 0);
            r.put("msg", "success");
        } catch (ArticleNotFoundException e) {
            r.put("data", null);
            r.put("code", e.getErrorCode());
            r.put("msg", e.getMessage());
        }

        return r;
    }
}
