package com.eduwechat.backend.backend.exceptions.user;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class UserAlreadyRegisterException extends EduRuntimeException {
    public UserAlreadyRegisterException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 4001;
    }
}
