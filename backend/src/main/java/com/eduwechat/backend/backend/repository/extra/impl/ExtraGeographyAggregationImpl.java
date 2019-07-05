package com.eduwechat.backend.backend.repository.extra.impl;

import com.eduwechat.backend.backend.entity.extra.GeographyEntity;
import com.eduwechat.backend.backend.repository.base.AggregationNewKnowledgeDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: backend
 * @description: ExtraGeographyAggregationImpl
 * @author: Vaskka
 * @create: 2019/5/31 3:14 AM
 **/
@Repository
public class ExtraGeographyAggregationImpl extends AggregationNewKnowledgeDao {

    /**
     * 获取标题映射
     * @return List&lt;TotalTitleResultItem&gt;
     */
    @Override
    public List<String> getTotalList() {
        return this.fromEntityGetTitleList(GeographyEntity.class);
    }
}
