package com.eduwechat.backend.backend.utils.v2;

import com.eduwechat.backend.backend.exceptions.common.SearchNotRightException;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: backend
 * @description: V2Util
 * @author: Vaskka
 * @create: 2019/7/2 11:31 AM
 **/

public class V2Util {

    public static List<TitleListMapping> startFromZero(List<String> list) {

        List<TitleListMapping> res = new ArrayList<>(list.size());

        int i = 0;
        for (String s : list) {
            res.add(new TitleListMapping(s, i));
            i++;
        }

        return res;
    }

    public static String searchNameFromWhich(List<TitleListMapping> list, int which) throws SearchNotRightException {
        for (TitleListMapping item : list) {
            if (item.getWhich() == which) {
                return item.getTitleName();
            }
        }

        throw new SearchNotRightException("未找到which对应的erjiName");
    }
}
