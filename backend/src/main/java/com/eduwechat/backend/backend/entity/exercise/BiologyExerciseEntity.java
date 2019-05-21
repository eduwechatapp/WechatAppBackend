package com.eduwechat.backend.backend.entity.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "biology_lib")
@AllArgsConstructor
public class BiologyExerciseEntity extends BaseExerciseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    protected String yiji;

    protected String erji;

    @Lob
    @Column(columnDefinition = "text")
    protected String content;

    @Lob
    @Column(columnDefinition = "text")
    protected String answer;

    @Lob
    @Column(columnDefinition = "text")
    protected String analysis;

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

    public String getContent() {
        return content;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAnalysis() {
        return analysis;
    }

    public BiologyExerciseEntity() {}
}
