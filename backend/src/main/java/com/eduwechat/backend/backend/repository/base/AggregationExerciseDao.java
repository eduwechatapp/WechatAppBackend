package com.eduwechat.backend.backend.repository.base;

import com.eduwechat.backend.backend.repository.base.set.SingleResultItem;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;
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

    /**
     * 得到总标题列表
     * @return List&lt;TotalTitleResultItem&gt;
     */
    public abstract List<TotalTitleResultItem> getTotalTitle();

    /**
     * 得到题型列表
     * @return List&lt;String&gt;
     */
    public abstract List<String> getTotalType();

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 获取题库学科标题列表
     * @param inputType 学科实体类对象
     * @return List&lt;TotalTitleResultItem&gt;
     */
    protected List<TotalTitleResultItem> fromEntityGetTotalList(Class<?> inputType) {

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

    /**
     * 得到题库题型列表
     * @param inputType 学科实体类对象
     * @return List&lt;TotalTitleResultItem&gt;
     */
    protected List<SingleResultItem> fromEntityGetExerciseType(Class<?> inputType) {
        Aggregation aggregation = newAggregation(
                group("type")
        );

        // get result list
        AggregationResults<SingleResultItem> typeGroupResults
                = mongoTemplate.aggregate(aggregation, inputType, SingleResultItem.class);

        return typeGroupResults.getMappedResults();
    }



}
