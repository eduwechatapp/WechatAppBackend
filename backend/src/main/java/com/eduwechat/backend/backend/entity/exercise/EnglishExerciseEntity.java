package com.eduwechat.backend.backend.entity.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.entity.exercise.inner.AnalysisSet;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "english_lib")
@ToString
public class EnglishExerciseEntity extends BaseExerciseEntity {


    @Override
    public String getId() {
        return this._id;
    }

    @Override
    public String getYiji() {
        return this.yiji;
    }

    @Override
    public String getErji() {
        return this.erji;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public String getAnswer() {
        return this.answer;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public AnalysisSet getAnalysis() {
        return this.analysis;
    }

    @Override
    public List<String> getChoose() {
        return this.choose;
    }

    @Override
    public List<Integer> getAnswer_index() {
        return this.answer_index;
    }

    public EnglishExerciseEntity(String _id, String yiji, String erji, String content, String answer, String type, AnalysisSet analysis, List<String> choose, List<Integer> answer_index) {
        super(_id, yiji, erji, content, answer, type, analysis, choose, answer_index);
    }

    public EnglishExerciseEntity() {
    }
}
