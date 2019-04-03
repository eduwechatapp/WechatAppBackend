package com.eduwechat.backend.backend.exceptions.base;

/**
 * 所有异常基类
 */
public class BaseEduException extends Exception {
    public BaseEduException() {
    }

    public BaseEduException(String message) {
        super(message);
    }
}
