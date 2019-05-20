package com.eduwechat.backend.backend.service.base.inner.exercise;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ExerciseDetailResultItem extends ExerciseBaseResultItem {


    private String type;

    private String content;

    private List<String> choose;

    private String answer;

    private String analysis;

    public ExerciseDetailResultItem(Integer id, String type, String content, List<String> choose, String answer, String analysis) {
        super(id);
        this.analysis = analysis;
        this.answer = answer;
        this.choose = choose;
        this.content = content;
        this.type = type;
    }
}
