package com.eduwechat.backend.backend.utils.titlelist.definition;

import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;

import java.util.List;

public interface CanGetGeographyTitleList {
    List<TitleListMapping> getGeographyTitleList(List<String> list);
}
