package com.eduwechat.backend.backend.exceptions.exercise;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class ExerciseTypeNotSupportedException extends EduRuntimeException {
    private String errorType;

    @Override
    public Integer getErrorCode() {
        return 2002;
    }

    public ExerciseTypeNotSupportedException(String errorType) {
        this.errorType = errorType;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "===不支持的题型:" + errorType;
    }
}
