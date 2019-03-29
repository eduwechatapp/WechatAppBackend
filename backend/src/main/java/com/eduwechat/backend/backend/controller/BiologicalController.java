package com.eduwechat.backend.backend.controller;


import com.eduwechat.backend.backend.controller.base.CommonController;
import com.eduwechat.backend.backend.service.HighSchoolBiologicalService;
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
public class BiologicalController extends CommonController {

    @Autowired
    HighSchoolBiologicalService service;

    @ApiOperation(value = "获取生物知识点" ,  notes="指定分页获取生物知识点")
    @ResponseBody
    @RequestMapping(value = "/knowledge/get/{openid}/{which}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getKnowledge(@PathVariable String openid, @PathVariable Integer which, @PathVariable Integer number_every_page, @PathVariable Integer page_offset) {
        return this.innerGetKnowledge(this.service, which, number_every_page, page_offset);
    }



}
