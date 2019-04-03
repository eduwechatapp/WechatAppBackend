package com.eduwechat.backend.backend.utils.titlelist.definition;

import com.eduwechat.backend.backend.service.base.inner.TitleListMapping;

import java.util.List;

public interface CanGetPoliticalTitleList {
    List<TitleListMapping> getPoliticalTitleList(List<String> list);
}
