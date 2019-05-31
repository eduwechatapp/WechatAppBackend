package com.eduwechat.backend.backend.repository.extra.aggregation;

import com.eduwechat.backend.backend.entity.extra.BiologyEntity;
import com.eduwechat.backend.backend.repository.base.AggregationNewKnowledgeDao;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ExtraBiologyAggregationImpl extends AggregationNewKnowledgeDao  {

    /**
     * 获取标题映射
     * @return List&lt;TotalTitleResultItem&gt;
     */
    @Override
    public List<String> getTotalList() {
        return this.fromEntityGetTitleList(BiologyEntity.class);
    }
}
