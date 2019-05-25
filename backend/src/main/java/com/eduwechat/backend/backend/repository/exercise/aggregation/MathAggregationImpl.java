package com.eduwechat.backend.backend.repository.exercise.aggregation.impl;

import com.eduwechat.backend.backend.entity.exercise.MathExerciseEntity;
import com.eduwechat.backend.backend.repository.exercise.aggregation.AggregationExerciseDao;
import com.eduwechat.backend.backend.repository.exercise.aggregation.set.TotalTitleResultItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MathAggregationImpl extends AggregationExerciseDao {

    @Override
    public List<TotalTitleResultItem> getTotalTitle() {
        return this.fromEntityGetTitalList(MathExerciseEntity.class);
    }
}
