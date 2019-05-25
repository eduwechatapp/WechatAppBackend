package com.eduwechat.backend.backend.repository.exercise.aggregation;

import com.eduwechat.backend.backend.entity.exercise.EnglishExerciseEntity;
import com.eduwechat.backend.backend.repository.base.AggregationExerciseDao;
import com.eduwechat.backend.backend.repository.base.set.SingleResultItem;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnglishAggregationImpl extends AggregationExerciseDao {
    @Override
    public List<TotalTitleResultItem> getTotalTitle() {
        return this.fromEntityGetTotalList(EnglishExerciseEntity.class);
    }

    @Override
    public List<String> getTotalType() {
        return SingleResultItem.getSimpleStringList(this.fromEntityGetExerciseType(EnglishExerciseEntity.class));
    }
}
