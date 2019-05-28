package com.eduwechat.backend.backend.repository.exercise.aggregation;

import com.eduwechat.backend.backend.entity.exercise.MathExerciseEntity;
import com.eduwechat.backend.backend.repository.base.AggregationExerciseDao;
import com.eduwechat.backend.backend.repository.base.set.SingleResultItem;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MathAggregationImpl extends AggregationExerciseDao {

    @Override
    public List<TotalTitleResultItem> getTotalTitle() {
        return this.fromEntityGetTotalList(MathExerciseEntity.class);
    }

    @Override
    public List<String> getTotalType() {
        return SingleResultItem.getSimpleStringList(this.fromEntityGetExerciseType(MathExerciseEntity.class));
    }
}
