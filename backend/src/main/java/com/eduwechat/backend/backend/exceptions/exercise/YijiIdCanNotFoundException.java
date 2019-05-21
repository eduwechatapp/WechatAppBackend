package com.eduwechat.backend.backend.exceptions.exercise;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;

/**
 * @program: backend
 * @description: YijiIdCanNotFoundException
 * @author: Vaskka
 * @create: 2019/5/21 2:49 PM
 **/

public class YijiIdCanNotFoundException extends EduRuntimeException {

    private Integer canNotFoundId;

    public YijiIdCanNotFoundException(Integer canNotFoundId) {
        this.canNotFoundId = canNotFoundId;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "===异常的一级id:" + String.valueOf(canNotFoundId);
    }
}
