package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.service.base.inner.Content;
import com.eduwechat.backend.backend.service.base.inner.TitleListMapping;
import com.eduwechat.backend.backend.utils.KnowledgeTitleListUtil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class CommonService extends BaseService {

    public abstract List<Content> getKnowledge(Integer which, Integer size, Integer page);

    public abstract List<TitleListMapping> getTitleList();

    protected List<TitleListMapping> innerGetTitleList(List<String> list, String type) {

        List<TitleListMapping> res = new ArrayList<>(list.size());

        return KnowledgeTitleListUtil.fromTypeGetTitleList(list, type);
    }

}
