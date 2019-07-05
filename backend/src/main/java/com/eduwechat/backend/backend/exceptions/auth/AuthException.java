package com.eduwechat.backend.backend.exceptions.auth;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class AuthException extends EduRuntimeException {

    public AuthException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 5000;
    }
}
