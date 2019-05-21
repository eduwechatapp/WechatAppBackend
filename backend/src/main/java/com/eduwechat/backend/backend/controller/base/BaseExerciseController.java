package com.eduwechat.backend.backend.controller.base;

import java.util.Map;

public abstract class BaseExerciseController {

    public abstract Map<String, Object> getTitleList(String openid, String subject);

    public abstract Map<String, Object> getExerciseList(String openid, String subject, String yiji, String erji, Integer size, Integer page);

    /**
     * 设置错误的json Mapping对象
     * @param errorMap 错误Mapping
     * @param errorMsg 错误信息
     */
    protected void getExerciseErrorMap(Map<String, Object> errorMap, String errorMsg) {
        errorMap.put("code", 1);
        errorMap.put("msg", errorMsg);
        errorMap.put("data", null);
    }
}
