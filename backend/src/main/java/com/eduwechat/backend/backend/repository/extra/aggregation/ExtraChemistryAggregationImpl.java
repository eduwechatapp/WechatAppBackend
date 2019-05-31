package com.eduwechat.backend.backend.repository.extra.aggregation;

import com.eduwechat.backend.backend.entity.extra.ChemistryEntity;
import com.eduwechat.backend.backend.repository.base.AggregationNewKnowledgeDao;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: backend
 * @description: ExtraChemistryAggregationImpl
 * @author: Vaskka
 * @create: 2019/5/31 2:57 AM
 **/
@Repository
public class ExtraChemistryAggregationImpl extends AggregationNewKnowledgeDao {

    /**
     * 获取标题映射
     * @return List&lt;TotalTitleResultItem&gt;
     */
    @Override
    public List<String> getTotalList() {
        return this.fromEntityGetTitleList(ChemistryEntity.class);
    }
}
