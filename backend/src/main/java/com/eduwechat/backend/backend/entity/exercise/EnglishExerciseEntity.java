package com.eduwechat.backend.backend.entity.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "english_lib")
@AllArgsConstructor
public class EnglishExerciseEntity extends BaseExerciseEntity {


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

    public EnglishExerciseEntity() {}
}
