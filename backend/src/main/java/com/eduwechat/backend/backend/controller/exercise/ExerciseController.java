package com.eduwechat.backend.backend.controller.exercise;

import com.eduwechat.backend.backend.controller.base.BaseExerciseController;
import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.service.exercise.ExerciseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Api(description = "题库接口")
@RequestMapping(value = "/exercise")
@Controller
public class ExerciseController extends BaseExerciseController {

    @Autowired
    private ExerciseService service;

    @Override
    @ApiOperation(value = "题库获取指定学科的标题list" ,  notes="指定学科获取标题list")
    @ResponseBody
    @GetMapping("/title/{openid}/{subject}")
    public Map<String, Object> getAllTitleList(@PathVariable(value = "openid") String openid,
                                            @PathVariable(value = "subject") String subject) {

        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", service.getExerciseTitleList(subject));
            map.put("msg", "success");
            map.put("code", 0);
        } catch (SubjectDoesNotSupportedException e) {
            this.getExerciseErrorMap(map, SubjectDoesNotSupportedException.getErrorCode() , e.getMessage());
        }

        return map;
    }

    @Override
    @ApiOperation(value = "题库获取指定学科的题型list" ,  notes="获取指定学科的题型list")
    @ResponseBody
    @GetMapping("/type/{openid}/{subject}")
    public Map<String, Object> getExerciseType(@PathVariable(value = "openid") String openid,
                                               @PathVariable(value = "subject") String subject) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", service.getExerciseTypeList(subject));
            map.put("msg", "success");
            map.put("code", 0);
        } catch (SubjectDoesNotSupportedException e) {
            this.getExerciseErrorMap(map, SubjectDoesNotSupportedException.getErrorCode() , e.getMessage());
        }

        return map;
    }

    @Override
    @ApiOperation(value = "题库获取指定学科的试题list" ,  notes="指定学科获取试题list")
    @ResponseBody
    @GetMapping("/list/{openid}/{subject}/{yiji}/{erji}/{type}/{shrink}/{number_every_page}/{page_offset}")
    public Map<String, Object> getExerciseList(@PathVariable(value = "openid") String openid,
                                               @PathVariable(value = "subject") String subject,
                                               @PathVariable(value = "yiji") String yiji,
                                               @PathVariable(value = "erji") String erji,
                                               @PathVariable(value = "type") String type,
                                               @PathVariable(value = "shrink") Boolean shrink,
                                               @PathVariable(value = "number_every_page") Integer size,
                                               @PathVariable(value = "page_offset") Integer page) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", service.getExerciseList(subject, yiji, erji, type, shrink, size, page));
            map.put("msg", "success");
            map.put("code", 0);
        } catch (SubjectDoesNotSupportedException e) {
            this.getExerciseErrorMap(map, SubjectDoesNotSupportedException.getErrorCode() , e.getMessage());
        }

        return map;
    }

    @Override
    @ApiOperation(value = "题库获取指定题目的详细信息" ,  notes="给定id返回题目的详细信息")
    @ResponseBody
    @GetMapping("/detail/{openid}/{subject}/{id}")
    public Map<String, Object> getExerciseDetail(@PathVariable(value = "openid") String openid,
                                                 @PathVariable(value = "subject") String subject,
                                                 @PathVariable(value = "id") String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", service.getExerciseDetail(subject, id));
            map.put("msg", "success");
            map.put("code", 0);
        } catch (SubjectDoesNotSupportedException e) {
            this.getExerciseErrorMap(map, SubjectDoesNotSupportedException.getErrorCode() , e.getMessage());
        }

        return map;
    }

}
