package com.eduwechat.backend.backend.service.base;

import java.util.List;

public abstract class CommonService extends BaseService {

    public abstract List<Content> getKnowledge(Integer which, Integer size, Integer page);
}
