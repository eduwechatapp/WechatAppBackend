package com.eduwechat.backend.backend.entity.exercise.inner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 题库分析对象
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnalysisSet {

    private String original;

    private String  question_analysis;

    private String question_point;

    private String question_comment;

}
