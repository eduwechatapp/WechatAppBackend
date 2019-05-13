package com.eduwechat.backend.backend.utils.titlelist;

import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import com.eduwechat.backend.backend.utils.base.BaseGetTitleListUtil;
import com.eduwechat.backend.backend.utils.titlelist.definition.CanGetChemistryTitleList;
import com.eduwechat.backend.backend.utils.titlelist.definition.CanGetGeographyTitleList;

import java.util.List;

public class TemplateTitleListUtil extends BaseGetTitleListUtil implements
        CanGetChemistryTitleList,
        CanGetGeographyTitleList
{

    private static TemplateTitleListUtil instance;

    private TemplateTitleListUtil() {}

    public static TemplateTitleListUtil getInstance() {
        if (instance == null) {
            return new TemplateTitleListUtil();
        }

        return instance;
    }

    /**
     * 根据指定学科对未映射的二级标题进行映射
     * @param list 待映射 List&lt;String&gt;
     * @param type 学科类型
     * @return List&lt;TitleListMapping&gt;
     */
    @Override
    public List<TitleListMapping> fromTypeGetTitleList(List<String> list, String type) throws TypeNotMatchException {
        switch (type) {
            case "hx":
                return getChemistryTitleList(list);
            case "dl":
                return getGeographyTitleList(list);
        }

        throw new TypeNotMatchException("具体学科映射未匹配，请检查编码。", type, TypeNotMatchException.WhichType.SUBJECT);
    }

    @Override
    public List<TitleListMapping> getChemistryTitleList(List<String> list) {
        return startFromZero(list);
    }

    @Override
    public List<TitleListMapping> getGeographyTitleList(List<String> list) {
        return startFromZero(list);
    }


}
