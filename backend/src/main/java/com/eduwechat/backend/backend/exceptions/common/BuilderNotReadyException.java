package com.eduwechat.backend.backend.exceptions.common;

import com.eduwechat.backend.backend.exceptions.base.EduRuntimeException;
import lombok.Getter;

/**
 * @program: backend
 * @description: BuilderNotReadyException 构造器为完全初始化异常
 * @author: Vaskka
 * @create: 2019/5/15 12:36 AM
 **/

@Getter
public class BuilderNotReadyException extends EduRuntimeException {

    private String builderName;

    private String entityName;

    private String missingAttr;

    public BuilderNotReadyException(String builderName, String entityName, String missingAttr) {
        this.builderName = builderName;
        this.entityName = entityName;
        this.missingAttr = missingAttr;
    }


    @Override
    public String getMessage() {
        return super.getMessage()
                + "---错误的构造器:" + this.builderName
                + "---预构建的实体:" + this.entityName
                + "---缺失的属性:"  + this.missingAttr;
    }

    @Override
    public Integer getErrorCode() {
        return 1002;
    }
}
