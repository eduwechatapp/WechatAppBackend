package com.eduwechat.backend.backend.service.base.inner.exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExerciseTitleResultItem extends ExerciseBaseResultItem {

    private String title;

    public ExerciseTitleResultItem(Integer id, String title) {
        super(id);
        this.title = title;
    }
}
