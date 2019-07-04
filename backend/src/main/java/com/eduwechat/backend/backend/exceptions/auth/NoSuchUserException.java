package com.eduwechat.backend.backend.exceptions.auth;

/**
 * 用户不存在
 */
public class NoSuchUserException extends AuthException {
    public NoSuchUserException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 5001;
    }
}
