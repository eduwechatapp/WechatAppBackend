package com.eduwechat.backend.backend.exceptions.base;

import com.eduwechat.backend.backend.exceptions.base.BaseEduException;

public abstract class EduRuntimeException extends BaseEduException {

    public abstract Integer getErrorCode();

    public EduRuntimeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "--errorCode:" + String.valueOf(getErrorCode());
    }

    public EduRuntimeException() {
    }
}
