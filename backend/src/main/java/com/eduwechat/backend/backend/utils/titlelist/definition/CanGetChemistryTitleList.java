package com.eduwechat.backend.backend.utils.titlelist.definition;

import com.eduwechat.backend.backend.service.base.inner.TitleListMapping;

import java.util.List;

public interface CanGetChemistryTitleList {
    List<TitleListMapping> getChemistryTitleList(List<String> list);
}