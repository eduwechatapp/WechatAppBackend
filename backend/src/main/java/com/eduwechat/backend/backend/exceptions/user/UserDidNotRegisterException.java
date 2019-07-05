package com.eduwechat.backend.backend.exceptions.user;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class UserDidNotRegisterException extends EduRuntimeException {

    public UserDidNotRegisterException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 4003;
    }
}
