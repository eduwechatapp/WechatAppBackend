package com.eduwechat.backend.backend.utils.titlelist;

import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import com.eduwechat.backend.backend.utils.base.BaseGetTitleListUtil;
import com.eduwechat.backend.backend.utils.titlelist.definition.CanGetChineseTitleList;
import com.eduwechat.backend.backend.utils.titlelist.definition.CanGetEnglishTitleList;
import com.eduwechat.backend.backend.utils.titlelist.definition.CanGetGeographyTitleList;

import java.util.List;

public class TopicTitleListUtil extends BaseGetTitleListUtil implements
        CanGetChineseTitleList,
        CanGetEnglishTitleList,
        CanGetGeographyTitleList
{

    private static TopicTitleListUtil instance;

    private TopicTitleListUtil() {}

    public static TopicTitleListUtil getInstance() {
        if (instance == null) {
            return new TopicTitleListUtil();
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
            case "yy":
                return getEnglishTitleList(list);
            case "dl":
                return getGeographyTitleList(list);
            case "yw":
                return getChineseTitleList(list);
        }

        throw new TypeNotMatchException("具体学科映射未匹配，请检查编码。", type, TypeNotMatchException.WhichType.SUBJECT);
    }

    @Override
    public List<TitleListMapping> getChineseTitleList(List<String> list) {
        return startFromZero(list);
    }

    @Override
    public List<TitleListMapping> getEnglishTitleList(List<String> list) {
        return startFromZero(list);
    }

    @Override
    public List<TitleListMapping> getGeographyTitleList(List<String> list) {
        return startFromZero(list);
    }

}
