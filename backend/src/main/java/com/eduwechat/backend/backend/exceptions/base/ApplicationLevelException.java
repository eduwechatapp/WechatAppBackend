package com.eduwechat.backend.backend.exceptions.base;

public class ApplicationLevelException extends EduRuntimeException {
    public ApplicationLevelException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 10000;
    }
}
