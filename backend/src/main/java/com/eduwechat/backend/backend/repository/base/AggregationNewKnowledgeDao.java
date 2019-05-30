package com.eduwechat.backend.backend.repository.base;

import java.util.ArrayList;
import java.util.List;

import com.eduwechat.backend.backend.repository.base.set.SingleResultItem;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

/**
 * @program: backend
 * @description: AggregationNewKnowledgeDao
 * @author: Vaskka
 * @create: 2019/5/31 2:55 AM
 **/

public abstract class AggregationNewKnowledgeDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public abstract List<String> getTotalList();

    /**
     * 获取新知识点标题列表
     * @param inputType 学科实体类对象
     * @return List&lt;TotalTitleResultItem&gt;
     */
    protected List<String> fromEntityGetTitleList(Class<?> inputType) {


        // 得到以及标题
        Aggregation agg = newAggregation(
                group("yiji")
        );

        //Convert the aggregation result into a List
        AggregationResults<SingleResultItem> yijiGroupResults
                = mongoTemplate.aggregate(agg, inputType, SingleResultItem.class);

        List<SingleResultItem> yijiList = yijiGroupResults.getMappedResults();

        List<String> result = new ArrayList<>(yijiList.size());

        // 针对每个一级标题拿到二级标题
        for (SingleResultItem yiji : yijiList) {
            result.add(yiji.get_id());
        }

        return result;
    }



}
