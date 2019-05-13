package com.eduwechat.backend.backend.utils.titlelist;

import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import com.eduwechat.backend.backend.utils.base.BaseGetTitleListUtil;
import com.eduwechat.backend.backend.utils.titlelist.definition.*;

import java.util.List;

public class KnowledgeTitleListUtil extends BaseGetTitleListUtil implements
        CanGetBiologicalTitleList,
        CanGetChemistryTitleList,
        CanGetChineseTitleList,
        CanGetEnglishTitleList,
        CanGetGeographyTitleList,
        CanGetHistoryTitleList,
        CanGetPhysicsTitleList,
        CanGetPoliticalTitleList,
        CanGetMathTitleList
{

    private static KnowledgeTitleListUtil instance;

    private KnowledgeTitleListUtil() {}

    public static KnowledgeTitleListUtil getInstance() {
        if (instance == null) {
            return new KnowledgeTitleListUtil();
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
            case "sw":
                return getBiologicalTitleList(list);
            case "hx":
                return getChemistryTitleList(list);
            case "dl":
                return getGeographyTitleList(list);
            case "ls":
                return getHistoryTitleList(list);
            case "zz":
                return getPoliticalTitleList(list);
            case "yw":
                return getChineseTitleList(list);
            case "sx":
                return getMathTitleList(list);
            case "wl":
                return getPhysicsTitleList(list);
        }

        throw new TypeNotMatchException("具体学科映射未匹配，请检查编码。", type, TypeNotMatchException.WhichType.SUBJECT);
    }

    @Override
    public List<TitleListMapping> getMathTitleList(List<String> list) {
        return startFromZero(list);
    }

    @Override
    public List<TitleListMapping> getBiologicalTitleList(List<String> list) {
        return startFromZero(list);
    }

    @Override
    public List<TitleListMapping> getChemistryTitleList(List<String> list) {
        return startFromZero(list);
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

    @Override
    public List<TitleListMapping> getHistoryTitleList(List<String> list) {
        return startFromZero(list);
    }

    @Override
    public List<TitleListMapping> getPhysicsTitleList(List<String> list) {
        return startFromZero(list);
    }

    @Override
    public List<TitleListMapping> getPoliticalTitleList(List<String> list) {
        return startFromZero(list);
    }

}
