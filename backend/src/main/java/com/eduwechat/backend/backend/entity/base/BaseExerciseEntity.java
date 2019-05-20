package com.eduwechat.backend.backend.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * 题库实体基类
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class BaseExerciseEntity implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String yiji;

    private String erji;

    @Lob
    @Column(columnDefinition = "text")
    private String content;

    @Lob
    @Column(columnDefinition = "text")
    private String answer;

    @Lob
    @Column(columnDefinition = "text")
    private String analysis;

}
