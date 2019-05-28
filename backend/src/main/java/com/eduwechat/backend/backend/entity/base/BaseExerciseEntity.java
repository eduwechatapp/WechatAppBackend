package com.eduwechat.backend.backend.entity.base;

import com.eduwechat.backend.backend.entity.exercise.inner.AnalysisSet;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * 题库实体基类
 */
@AllArgsConstructor
public abstract class BaseExerciseEntity implements BaseEntity {
    @Id
    protected String _id;

    protected String yiji;

    protected String erji;

    protected String content;

    protected String answer;

    protected String type;

    protected AnalysisSet analysis;

    protected List<String> choose;

    protected List<Integer> answer_index;

    public abstract String getId();

    public abstract String getYiji();

    public abstract String getErji();

    public abstract String getContent();

    public abstract String getAnswer();

    public abstract String getType();

    public abstract AnalysisSet getAnalysis();

    public abstract List<String> getChoose();

    public abstract List<Integer> getAnswer_index();

    public BaseExerciseEntity() {
    }
}
