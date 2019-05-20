package com.eduwechat.backend.backend.service.base.inner.exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ExerciseTitleResultItem extends ExerciseBaseResultItem {

    private String title;

    public ExerciseTitleResultItem(Integer id, String title) {
        super(id);
        this.title = title;
    }

    /**
     * 转换字符串list到标题结果list
     * @param stringList 字符串list
     * @return 标题结果list
     */
    public static List<ExerciseTitleResultItem> fromStringListGetTitleResultList(List<String> stringList) {

        List<ExerciseTitleResultItem> list = new ArrayList<>(stringList.size());
        for (int i = 0; i < stringList.size(); i++) {
            ExerciseTitleResultItem item = new ExerciseTitleResultItem(i, stringList.get(i));
        }

        return list;
    }
}
