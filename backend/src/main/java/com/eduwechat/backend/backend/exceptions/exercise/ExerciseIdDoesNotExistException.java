package com.eduwechat.backend.backend.exceptions.exercise;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

import java.util.function.Supplier;

public class ExerciseIdDoesNotExistException extends EduRuntimeException {
    private Integer errorId;

    public ExerciseIdDoesNotExistException(Integer errorId) {
        this.errorId = errorId;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "===不存在的id:" + String.valueOf(errorId);
    }

    @Override
    public Integer getErrorCode() {
        return 2001;
    }
}
