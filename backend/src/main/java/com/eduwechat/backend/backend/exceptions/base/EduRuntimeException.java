package com.eduwechat.backend.backend.exceptions.base;

import com.eduwechat.backend.backend.exceptions.base.BaseEduException;

public class EduRuntimeException extends BaseEduException {

    public EduRuntimeException(String message) {
        super(message);
    }

    public EduRuntimeException() {
    }
}
