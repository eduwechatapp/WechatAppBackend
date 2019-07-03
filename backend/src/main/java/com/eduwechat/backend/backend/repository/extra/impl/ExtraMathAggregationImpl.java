package com.eduwechat.backend.backend.repository.extra.impl;

import com.eduwechat.backend.backend.entity.extra.MathEntity;
import com.eduwechat.backend.backend.repository.base.AggregationNewKnowledgeDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: backend
 * @description: ExtraMathAggregationImpl
 * @author: Vaskka
 * @create: 2019/5/31 4:03 AM
 **/
@Repository
public class ExtraMathAggregationImpl extends AggregationNewKnowledgeDao {

    /**
     * 获取标题映射
     * @return List&lt;TotalTitleResultItem&gt;
     */
    @Override
    public List<String> getTotalList() {
        return this.fromEntityGetTitleList(MathEntity.class);
    }
}
