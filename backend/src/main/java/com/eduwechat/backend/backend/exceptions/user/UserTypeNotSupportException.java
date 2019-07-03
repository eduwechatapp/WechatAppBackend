package com.eduwechat.backend.backend.exceptions.user;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class UserTypeNotSupportException extends EduRuntimeException {
    public UserTypeNotSupportException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 4002;
    }
}
