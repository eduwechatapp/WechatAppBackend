package com.eduwechat.backend.backend.repository.exercise.aggregation;

import com.eduwechat.backend.backend.repository.exercise.aggregation.set.SingleResultItem;
import com.eduwechat.backend.backend.repository.exercise.aggregation.set.TotalTitleResultItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;

public abstract class AggregationExerciseDao {

    public abstract List<TotalTitleResultItem> getTotalTitle();

    @Autowired
    MongoTemplate mongoTemplate;

    protected List<TotalTitleResultItem> fromEntityGetTitalList(Class<?> inputType) {

        // 得到以及标题
        Aggregation agg = newAggregation(
                group("yiji")
        );

        //Convert the aggregation result into a List
        AggregationResults<SingleResultItem> yijiGroupResults
                = mongoTemplate.aggregate(agg, inputType, SingleResultItem.class);

        List<SingleResultItem> yijiList = yijiGroupResults.getMappedResults();

        List<TotalTitleResultItem> result = new ArrayList<>(yijiList.size());

        // 针对每个一级标题拿到二级标题
        for (SingleResultItem yiji : yijiList) {
            String _yiji = yiji.get_id();

            Aggregation erjiAgg = newAggregation(
                    match(Criteria.where("yiji").is(_yiji)),
                    group("erji")
            );

            AggregationResults<SingleResultItem> erjiGroupResults
                    = mongoTemplate.aggregate(erjiAgg, inputType, SingleResultItem.class);

            List<SingleResultItem> erjiList = erjiGroupResults.getMappedResults();

            // 构造总标题Item
            List<String> totalErji = SingleResultItem.getSimpleStringList(erjiList);
            TotalTitleResultItem totalTitleResultItem = new TotalTitleResultItem(_yiji, totalErji);

            // 添加进结果
            result.add(totalTitleResultItem);
        }

        return result;
    }

}
