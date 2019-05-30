package com.eduwechat.backend.backend.controller.common;

import com.eduwechat.backend.backend.controller.base.CanGetKnowledgeTitleListController;
import com.eduwechat.backend.backend.controller.base.CanGetTemplateTitleListController;
import com.eduwechat.backend.backend.controller.base.BaseCommonController;
import com.eduwechat.backend.backend.service.common.HighSchoolChemistryCommonService;
import com.eduwechat.backend.backend.service.extra.ExtraChemistryService;
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

@Api(description = "化学接口")
@Controller
@RequestMapping(value = "/chemistry")
public class ChemistryControllerBase extends BaseCommonController implements CanGetKnowledgeTitleListController,
        CanGetTemplateTitleListController
{

    @Autowired
    HighSchoolChemistryCommonService service;

    @Autowired
    private ExtraChemistryService extraService;

    @ApiOperation(value = "获取化学知识点" ,  notes="指定分页获取化学知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid,
                                            @PathVariable Integer which,
                                            @PathVariable Integer number_every_page,
                                            @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.service, which, number_every_page, page_offset);
    }


    @ApiOperation(value = "获取化学答题模板" ,  notes="指定分页获取化学答题模板")
    @ResponseBody
    @RequestMapping(value = "/template/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getTemplate(@PathVariable String openid,
                                            @PathVariable Integer which,
                                            @PathVariable Integer number_every_page,
                                            @PathVariable Integer page_offset) {
        return this.innerCommonFromListGetMap(this.service.getTemplate(which, number_every_page, page_offset));
    }

    @Override
    @ApiOperation(value = "获取化学知识点次级标题与which映射" ,  notes="获取化学知识点次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/knowledge/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getKnowledgeTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "知识点", "knowledge", "hx");
    }


    @Override
    @ApiOperation(value = "获取化学答题模板次级标题与which映射" ,  notes="获取化学答题模板次级标题与which映射")
    @ResponseBody
    @RequestMapping(value = "/template/mapping/get", method = RequestMethod.GET)
    public Map<String, Object> getTemplateTitleList() {
        return this.innerGetTitleMappingFromListGetMap(service, "答题模板", "template", "hx");
    }


    @ApiOperation(value = "获取化学新的知识点接口" ,  notes="一起拿全，分页")
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

}
