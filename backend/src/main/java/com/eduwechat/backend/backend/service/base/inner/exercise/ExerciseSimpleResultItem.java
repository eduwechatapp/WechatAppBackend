package com.eduwechat.backend.backend.service.base.inner.exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: backend
 * @description: ExerciseSimpleResultItem
 * @author: Vaskka
 * @create: 2019/5/22 12:38 AM
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ExerciseSimpleResultItem {
    private Integer id;

    private String yiji;

    private String erji;

    private String content;

}
