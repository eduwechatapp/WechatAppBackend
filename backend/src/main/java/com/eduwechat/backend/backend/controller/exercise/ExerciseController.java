package com.eduwechat.backend.backend.controller.exercise;

import com.eduwechat.backend.backend.controller.base.BaseExerciseController;
import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseTitleResultItem;
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
import java.util.List;
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
    public Map<String, Object> getTitleList(@PathVariable(value = "openid") String openid,
                                            @PathVariable(value = "subject") String subject) {

        Map<String, Object> result = new HashMap<>();

        try {
            List<ExerciseTitleResultItem>  data = service.getExerciseTitleList(subject);
            result.put("code", 0);
            result.put("msg", "success");
            result.put("data", data);
        } catch (SubjectDoesNotSupportedException e) {
            this.getExerciseErrorMap(result, e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    @Override
    @ApiOperation(value = "题库获取指定学科的试题list" ,  notes="指定学科获取试题list")
    @ResponseBody
    @GetMapping("/list/{openid}/{subject}/{yiji}/{erji}/{number_every_page}/{page_offset}")
    public Map<String, Object> getExerciseList(@PathVariable(value = "openid") String openid,
                                               @PathVariable(value = "subject") String subject,
                                               @PathVariable(value = "yiji") String yiji,
                                               @PathVariable(value = "erji") String erji,
                                               @PathVariable(value = "number_every_page") Integer size,
                                               @PathVariable(value = "page_offset") Integer page) {
        Map<String, Object> result = new HashMap<>();

        try {
            List<BaseExerciseEntity> data = service.getExerciseList(subject, yiji, erji, size, page);
            result.put("code", 0);
            result.put("msg", "success");
            result.put("data", data);
        } catch (SubjectDoesNotSupportedException e) {
            this.getExerciseErrorMap(result, e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
}
