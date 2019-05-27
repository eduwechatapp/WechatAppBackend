package com.eduwechat.backend.backend.exceptions.common;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class ArticleNotFoundException extends EduRuntimeException {
    @Override
    public Integer getErrorCode() {
        return 1001;
    }

    public ArticleNotFoundException(String message) {
        super(message);
    }
}
