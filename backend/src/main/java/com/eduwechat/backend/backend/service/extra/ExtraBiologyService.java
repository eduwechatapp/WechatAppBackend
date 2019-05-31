package com.eduwechat.backend.backend.service.extra;


import com.eduwechat.backend.backend.entity.extra.BiologyEntity;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.repository.extra.ExtraBiologyDao;
import com.eduwechat.backend.backend.repository.extra.aggregation.ExtraBiologyAggregationImpl;
import com.eduwechat.backend.backend.service.base.BaseExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraBiologyService extends BaseExtraService<BiologyEntity>  {


    @Autowired
    private ExtraBiologyDao commonDao;

    @Autowired
    private ExtraBiologyAggregationImpl aggregationDao;

    /**
     * 分页获取新知识点的全部数据
     * @param size 每页宽
     * @param page 页偏移
     * @return List
     */
    @Override
    public List<BiologyEntity> getNewKnowledge(int size, int page) {
        return commonDao.findAll(PageRequest.of(page, size)).getContent();
    }

    /**
     * 获取标题映射
     * @return 总标题映射
     */
    @Override
    public List<String> getTotalList() {
        return aggregationDao.getTotalList();
    }

    /**
     * 根据yiji、title拿数据
     * @param yiji yiji
     * @param size 页大小
     * @param page 页偏移
     * @return ChemistryEntity
     */
    @Override
    public List<BiologyEntity> getNewKNowledgeFromYiji(String yiji, Integer size, Integer page) throws ArticleNotFoundException {
        List<BiologyEntity> res = commonDao.findByYiji(yiji, PageRequest.of(page, size));

        if (res.size() == 0) {
            throw new ArticleNotFoundException("文章未找到");
        }

        return res;
    }
}
