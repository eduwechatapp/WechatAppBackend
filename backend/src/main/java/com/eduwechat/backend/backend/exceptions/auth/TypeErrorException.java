package com.eduwechat.backend.backend.exceptions.auth;

public class TypeErrorException extends AuthException {

    public TypeErrorException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 5002;
    }
}
