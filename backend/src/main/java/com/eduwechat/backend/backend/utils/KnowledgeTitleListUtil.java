package com.eduwechat.backend.backend.utils;

import com.eduwechat.backend.backend.service.base.inner.TitleListMapping;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeTitleListUtil {

    public static List<TitleListMapping> fromTypeGetTitleList(List<String> list, String type) {
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

        return null;
    }

    private static List<TitleListMapping> startFromZero(List<String> list) {
        List<TitleListMapping> res = new ArrayList<>(list.size());

        int i = 0;
        for (String s : list) {
            res.add(new TitleListMapping(s, i));
            i++;
        }

        return res;
    }

    private static List<TitleListMapping> startFromOne(List<String> list) {
        List<TitleListMapping> res = new ArrayList<>(list.size());

        int i = 1;
        for (String s : list) {
            res.add(new TitleListMapping(s, i));
            i++;
        }

        return res;
    }

    private  static List<TitleListMapping> getMathTitleList(List<String> list) {
        return startFromZero(list);
    }
    private static List<TitleListMapping> getBiologicalTitleList(List<String> list) {
        return startFromZero(list);
    }
    private static List<TitleListMapping> getChemistryTitleList(List<String> list) {
        return startFromZero(list);
    }
    private static List<TitleListMapping> getChineseTitleList(List<String> list) {
        return startFromZero(list);
    }
    private static List<TitleListMapping> getEnglishTitleList(List<String> list) {
        return startFromOne(list);
    }
    private static List<TitleListMapping> getGeographyTitleList(List<String> list) {
        return startFromOne(list);
    }
    private static List<TitleListMapping> getHistoryTitleList(List<String> list) {
        return startFromOne(list);
    }
    private static List<TitleListMapping> getPhysicsTitleList(List<String> list) {
        return startFromZero(list);
    }
    private static List<TitleListMapping> getPoliticalTitleList(List<String> list) {
        return startFromOne(list);
    }

}
