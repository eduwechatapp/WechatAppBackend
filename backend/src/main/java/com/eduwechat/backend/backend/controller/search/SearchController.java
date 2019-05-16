package com.eduwechat.backend.backend.controller.search;

import com.eduwechat.backend.backend.controller.base.BaseSearchController;
import com.eduwechat.backend.backend.exceptions.search.SearchParamMissingException;
import com.eduwechat.backend.backend.service.base.inner.search.SearchResult;
import com.eduwechat.backend.backend.service.search.impl.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class SearchController extends BaseSearchController {

    @Autowired
    private BiologicalSearchService biologicalSearchService;

    @Autowired
    private MathSearchService mathSearchService;

    @Autowired
    private EnglishSearchService englishSearchService;

    @Autowired
    private ChineseSearchService chineseSearchService;

    @Autowired
    private PhysicsSearchService physicsSearchService;

    @Autowired
    private ChemistrySearchService chemistrySearchService;

    @Autowired
    private GeographySearchService geographySearchService;

    @Autowired
    private PoliticalSearchService politicalSearchService;

    @Autowired
    private HistorySearchService historySearchService;

    @Override
    @ApiOperation(value = "单科分页搜索" ,  notes="指定分页获取单科搜索结果")
    @ResponseBody
    @PostMapping("/detail/{openid}/{subject}/{number_every_page}/{page_offset}")
    public Map<String, Object> doDetailSearch(@PathVariable String openid,
                                        @RequestBody JSONObject jsonObject,
                                        @PathVariable(value = "subject") String subject,
                                        @PathVariable(value = "number_every_page") Integer size,
                                        @PathVariable(value = "page_offset") Integer page) {
        Map<String, Object> map = new HashMap<>();

        SearchResult searchResult;
        try {
            switch (subject) {
                case "sx":
                    searchResult = this.fromSearchDataGetMathSearchResult(mathSearchService, jsonObject, size, page);
                    break;
                case "yw":
                    searchResult = this.fromSearchDataGetChineseSearchResult(chineseSearchService, jsonObject, size, page);
                    break;
                case "yy":
                    searchResult = this.fromSearchDataGetEnglishSearchResult(englishSearchService, jsonObject, size, page);
                    break;
                case "wl":
                    searchResult = this.fromSearchDataGetPhysicsSearchResult(physicsSearchService, jsonObject, size, page);
                    break;
                case "hx":
                    searchResult = this.fromSearchDataGetChemistrySearchResult(chemistrySearchService, jsonObject, size, page);
                    break;
                case "sw":
                    searchResult = this.fromSearchDataGetBiologicalSearchResult(biologicalSearchService, jsonObject, size, page);
                    break;
                case "dl":
                    searchResult = this.fromSearchDataGetGeographySearchResult(geographySearchService, jsonObject, size, page);
                    break;
                case "ls":
                    searchResult = this.fromSearchDataGetHistorySearchResult(historySearchService, jsonObject, size, page);
                    break;
                case "zz":
                    searchResult = this.fromSearchDataGetPoliticalSearchResult(politicalSearchService, jsonObject, size, page);
                    break;
                default:
                    searchResult = null;
                    break;
            }

            // 搜索成功
            if (searchResult != null) {
                map.put("code", 0);
                map.put("msg", "success");
                map.put("data", searchResult);
            }
            else {
                map.put("code", 1);
                map.put("msg", "subject字段无效，有效字段应为相应学科拼音首字母，e.g. yy yw sx...");
                map.put("data", null);
            }

        }
        catch (SearchParamMissingException | NullPointerException e) {
            // 根据附带异常信息返回
            map.put("code", 0);
            map.put("msg", e.getMessage());
            map.put("data", null);
        }


        return map;
    }

    @Override
    @ApiOperation(value = "简单搜索" ,  notes="根据分页关键字确定simple搜素结果")
    @ResponseBody
    @PostMapping("/simple/{openid}/{keyWord}/{number_every_page}/{page_offset}")
    public Map<String, Object> doSimpleSearch(@PathVariable(value = "openid") String openid,
                                              @PathVariable(value = "keyWord") String keyWord,
                                              @PathVariable(value = "number_every_page") Integer size,
                                              @PathVariable(value = "page_offset") Integer page) {

        Map<String, Object> map = new HashMap<>();
        List<SearchResult> dataList = new ArrayList<>();

        dataList.add(mathSearchService.fullSearch(keyWord, keyWord, keyWord, size, page));
        dataList.add(chineseSearchService.fullSearch(keyWord, keyWord, keyWord, size, page));
        dataList.add(englishSearchService.fullSearch(keyWord, keyWord, keyWord, size, page));
        dataList.add(physicsSearchService.fullSearch(keyWord, keyWord, keyWord, size, page));
        dataList.add(chemistrySearchService.fullSearch(keyWord, keyWord, keyWord, size, page));
        dataList.add(biologicalSearchService.fullSearch(keyWord, keyWord, keyWord, size, page));
        dataList.add(geographySearchService.fullSearch(keyWord, keyWord, keyWord, size, page));
        dataList.add(historySearchService.fullSearch(keyWord, keyWord, keyWord, size, page));
        dataList.add(politicalSearchService.fullSearch(keyWord, keyWord, keyWord, size, page));

        map.put("code", 0);
        map.put("msg", "success");
        map.put("data", dataList);

        return map;
    }


}
