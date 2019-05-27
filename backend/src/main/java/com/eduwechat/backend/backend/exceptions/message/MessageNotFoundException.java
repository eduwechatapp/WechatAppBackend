package com.eduwechat.backend.backend.exceptions.message;

public class MessageNotFoundException extends RuntimeException {

    private String errorMessageId;

    public MessageNotFoundException(String message, String errorMessageId) {
        super(message);
        this.errorMessageId = errorMessageId;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "===未找到的message_id:" + errorMessageId;
    }
}
