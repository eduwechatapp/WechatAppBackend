package com.eduwechat.backend.backend.controller.base;

import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseExerciseController {

    public abstract Map<String, Object> getAllTitleList(String openid, String subject);

    public abstract Map<String, Object> getExerciseType(String openid, String subject);

    public abstract Map<String, Object> getExerciseList(String openid, String subject, String yiji, String erji,String type, Boolean shrink, Integer size, Integer page);

    public abstract Map<String, Object> getExerciseDetail(String openid, String subject, String id);

    /**
     * 设置错误的json Mapping对象
     * @param errorMap 错误Mapping
     * @param errorMsg 错误信息
     */
    protected void getExerciseErrorMap(Map<String, Object> errorMap, Integer errorCode,  String errorMsg) {
        errorMap.put("code", errorCode);
        errorMap.put("msg", errorMsg);
        errorMap.put("data", null);
    }

}
