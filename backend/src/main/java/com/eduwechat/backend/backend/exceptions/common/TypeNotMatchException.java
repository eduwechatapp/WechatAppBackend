package com.eduwechat.backend.backend.exceptions.common;

import com.eduwechat.backend.backend.exceptions.base.BaseEduException;

/**
 * 类型未匹配异常
 */
public class TypeNotMatchException extends BaseEduException {
    public enum WhichType {
        YIJI,     // 一级标题映射未匹配
        SUBJECT,  // 学科映射未匹配
        UNKNOW
    }

    private String missingType;

    private WhichType whichType;

    public String getMissingType() {
        return missingType;
    }

    public TypeNotMatchException(String message, String missingType, WhichType whichType) {
        super(message);
        this.missingType = missingType;
        if (whichType == null) {
            whichType = WhichType.UNKNOW;
        }
        this.whichType = whichType;
    }

    public WhichType getWhichType() {
        return whichType;
    }
}
