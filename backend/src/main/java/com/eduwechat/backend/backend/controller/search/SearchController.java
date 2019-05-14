package com.eduwechat.backend.backend.controller.search;

import com.eduwechat.backend.backend.service.search.impl.BiologicalSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: backend
 * @description: SearchController
 * @author: Vaskka
 * @create: 2019/5/15 1:58 AM
 **/
@Api(description = "搜索接口")
@Controller
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private BiologicalSearchService biologicalSearchService;

    @ApiOperation(value = "生物类别搜索" ,  notes="指定分页获取生物搜索结果")
    @ResponseBody
    @PostMapping("/biological")
    public Map<String, Object> biologicalSearch(@RequestBody JSONObject jsonObject) {
        String content = jsonObject.get("content").toString();
        Map<String, Object> map = new HashMap<>();
        map.put("data", biologicalSearchService.withContentSearch(content, 20, 0));

        return map;
    }
}
