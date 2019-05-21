package com.eduwechat.backend.backend.entity.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chinese_lib")
@AllArgsConstructor
public class ChineseExerciseEntity extends BaseExerciseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    protected String yiji;

    protected String erji;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getYiji() {
        return yiji;
    }

    @Override
    public String getErji() {
        return erji;
    }

    @Override
    public String getContent() {
        return content;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAnalysis() {
        return analysis;
    }

    @Lob
    @Column(columnDefinition = "text")
    protected String content;

    @Lob
    @Column(columnDefinition = "text")
    protected String answer;

    @Lob
    @Column(columnDefinition = "text")
    protected String analysis;

    public ChineseExerciseEntity() {}
}
