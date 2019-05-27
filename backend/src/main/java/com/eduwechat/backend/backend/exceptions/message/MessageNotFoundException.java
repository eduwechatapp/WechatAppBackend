package com.eduwechat.backend.backend.exceptions.message;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class MessageNotFoundException extends EduRuntimeException {

    private String errorMessageId;

    public MessageNotFoundException(String message, String errorMessageId) {
        super(message);
        this.errorMessageId = errorMessageId;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "===未找到的message_id:" + errorMessageId;
    }

    @Override
    public Integer getErrorCode() {
        return 3001;
    }
}
