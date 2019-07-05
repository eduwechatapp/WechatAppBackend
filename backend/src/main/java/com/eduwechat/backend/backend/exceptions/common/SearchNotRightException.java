package com.eduwechat.backend.backend.exceptions.common;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

/**
 * @program: backend
 * @description: SearchNotRightException
 * @author: Vaskka
 * @create: 2019/7/2 11:36 AM
 **/

public class SearchNotRightException extends EduRuntimeException {

    public SearchNotRightException(String message) {
        super(message);
    }

    @Override
    public Integer getErrorCode() {
        return 1003;
    }
}
