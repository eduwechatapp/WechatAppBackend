package com.eduwechat.backend.backend.repository.extra.aggregation;

import com.eduwechat.backend.backend.entity.extra.MathEntity;
import com.eduwechat.backend.backend.entity.extra.PhysicsEntity;
import com.eduwechat.backend.backend.repository.base.AggregationNewKnowledgeDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: backend
 * @description: ExtraPhysicsAggregationImpl
 * @author: Vaskka
 * @create: 2019/5/31 4:04 AM
 **/
@Repository
public class ExtraPhysicsAggregationImpl extends AggregationNewKnowledgeDao {

    /**
     * 获取标题映射
     * @return List&lt;TotalTitleResultItem&gt;
     */
    @Override
    public List<String> getTotalList() {
        return this.fromEntityGetTitleList(PhysicsEntity.class);
    }
}
