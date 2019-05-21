package com.eduwechat.backend.backend.service.base.inner.exercise;

import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.repository.exercise.*;
import com.eduwechat.backend.backend.utils.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ExerciseTitleResultItem  {

    private String title;

    private List<String> children;


    public static List<ExerciseTitleResultItem>
    fromStringListGetBiologyTitleResultList(String subject, BiologyExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }

    public static List<ExerciseTitleResultItem>
    fromStringListGetChemistryTitleResultList(String subject, ChemistryExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }


    public static List<ExerciseTitleResultItem>
    fromStringListGetChineseTitleResultList(String subject, ChineseExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }

    public static List<ExerciseTitleResultItem>
    fromStringListGetEnglishTitleResultList(String subject, EnglishExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }

    public static List<ExerciseTitleResultItem>
    fromStringListGetGeographyTitleResultList(String subject, GeographyExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }

    public static List<ExerciseTitleResultItem>
    fromStringListGetHistoryTitleResultList(String subject, HistoryExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }

    public static List<ExerciseTitleResultItem>
    fromStringListGetMathTitleResultList(String subject, MathExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }

    public static List<ExerciseTitleResultItem>
    fromStringListGetPhysicsTitleResultList(String subject, PhysicsExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }

    public static List<ExerciseTitleResultItem>
    fromStringListGetPoliticsTitleResultList(String subject, PoliticsExerciseDao dao) {

        // 查询得到一级标题
        List<String> yijiList = dao.findYijiTitleList();

        List<ExerciseTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 遍历一级标题查二级标题
        for (String title : yijiList) {
            List<String> children = dao.findErjiTitleList(title);

            // 构造item
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(title, children);
            result.add(item);
        }

        return result;
    }
}
