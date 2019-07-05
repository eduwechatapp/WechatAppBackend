package com.eduwechat.backend.backend.exceptions.base;

/**
 * 第三方异常
 */
public class ThirdPartException extends EduRuntimeException {
    public ThirdPartException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 6000;
    }
}
