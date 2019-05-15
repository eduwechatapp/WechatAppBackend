package com.eduwechat.backend.backend.exceptions.search;

import com.eduwechat.backend.backend.exceptions.base.BaseEduException;

/**
 * @program: backend
 * @description: SearchParamMissingException
 * @author: Vaskka
 * @create: 2019/5/15 10:23 AM
 **/

public class SearchParamMissingException extends BaseEduException {
    public SearchParamMissingException(String message) {
        super(message);
    }
}
