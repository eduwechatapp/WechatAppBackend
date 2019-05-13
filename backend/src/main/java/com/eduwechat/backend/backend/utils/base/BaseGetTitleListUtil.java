package com.eduwechat.backend.backend.utils.base;

import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseGetTitleListUtil {

    /**
     * 根据指定学科对未映射的二级标题进行映射
     * @param list 待映射 List&lt;String&gt;
     * @param type 学科类型
     * @return List&lt;TitleListMapping&gt;
     */
    public abstract List<TitleListMapping> fromTypeGetTitleList(List<String> list, String type) throws TypeNotMatchException;

    /**
     * 映射从0开始
     * @param list 待映射 List&lt;String&gt;
     * @return List&lt;TitleListMapping&gt;
     */
    protected static List<TitleListMapping> startFromZero(List<String> list) {
        List<TitleListMapping> res = new ArrayList<>(list.size());

        int i = 0;
        for (String s : list) {
            res.add(new TitleListMapping(s, i));
            i++;
        }

        return res;
    }

    /**
     * 映射从1开始
     * @param list 待映射 List&lt;String&gt;
     * @return List&lt;TitleListMapping&gt;
     */
    @Deprecated
    protected static List<TitleListMapping> startFromOne(List<String> list) {
        List<TitleListMapping> res = new ArrayList<>(list.size());

        int i = 1;
        for (String s : list) {
            res.add(new TitleListMapping(s, i));
            i++;
        }

        return res;
    }
}
