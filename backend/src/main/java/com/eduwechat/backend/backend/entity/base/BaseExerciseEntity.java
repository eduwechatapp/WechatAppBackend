package com.eduwechat.backend.backend.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * 题库实体基类
 */

public abstract class BaseExerciseEntity implements BaseEntity {
    public abstract Integer getId();

    public abstract String getYiji();

    public abstract String getErji();

    public abstract String getContent();

    public abstract String getAnswer();

    public abstract String getAnalysis();
}
