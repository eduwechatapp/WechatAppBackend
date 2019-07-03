package com.eduwechat.backend.backend.exceptions.base;

public class AuthException extends EduRuntimeException {

    public AuthException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 5001;
    }
}
