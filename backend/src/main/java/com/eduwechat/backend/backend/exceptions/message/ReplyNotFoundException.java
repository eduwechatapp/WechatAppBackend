package com.eduwechat.backend.backend.exceptions.message;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class ReplyNotFoundException extends EduRuntimeException {

    private String errorReplyId;

    public ReplyNotFoundException(String message, String errorReplyId) {
        super(message);
        this.errorReplyId = errorReplyId;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "===未找到的reply_id:" + errorReplyId;
    }
}
