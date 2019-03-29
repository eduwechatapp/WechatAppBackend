package com.eduwechat.backend.backend.controller;

import com.eduwechat.backend.backend.controller.base.CommonController;
import com.eduwechat.backend.backend.service.HighSchoolChemistryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Api(description = "化学接口")
@Controller
@RequestMapping(value = "/chemistry")
public class ChemistryController extends CommonController {

    @Autowired
    HighSchoolChemistryService service;

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
}