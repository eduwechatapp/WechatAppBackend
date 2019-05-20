package com.eduwechat.backend.backend.exceptions.exercise;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

public class SubjectDoesNotSupportedException extends EduRuntimeException {

    private String unsupportSuject;

    public SubjectDoesNotSupportedException(String unsupportSuject) {
        this.unsupportSuject = unsupportSuject;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "===不支持的学科：" + unsupportSuject;
    }
}
