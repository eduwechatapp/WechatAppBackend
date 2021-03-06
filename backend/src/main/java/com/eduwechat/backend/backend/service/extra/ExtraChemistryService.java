package com.eduwechat.backend.backend.service.extra;

import com.eduwechat.backend.backend.entity.extra.ChemistryEntity;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.repository.extra.ExtraChemistryDao;
import com.eduwechat.backend.backend.repository.extra.impl.ExtraChemistryAggregationImpl;
import com.eduwechat.backend.backend.service.base.BaseExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: backend
 * @description: ExtraChemistryService
 * @author: Vaskka
 * @create: 2019/5/31 1:01 AM
 **/
@Service
public class ExtraChemistryService extends BaseExtraService<ChemistryEntity> {

    @Autowired
    private ExtraChemistryDao commonDao;

    @Autowired
    private ExtraChemistryAggregationImpl aggregationDao;

    /**
     * 分页获取新知识点的全部数据
     * @param size 每页宽
     * @param page 页偏移
     * @return List
     */
    @Override
    public List<ChemistryEntity> getNewKnowledge(int size, int page) {
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
     * 根据yiji、title拿标题列表
     * @param yiji yiji
     * @param size 页大小
     * @param page 页偏移
     * @return ChemistryEntity
     */
    @Override
    public List<String> getNewKNowledgeFromYiji(String yiji, Integer size, Integer page) throws ArticleNotFoundException {
        List<ChemistryEntity> res = commonDao.findByYiji(yiji, PageRequest.of(page, size));

        return fromEntityGetTitle(res);
    }

    /**
     * 根据标题得到文章详情
     * @param title 标题
     * @return ChemistryEntity
     * @throws ArticleNotFoundException 文章未找到
     */
    @Override
    public ChemistryEntity getContentFromTitle(String title) throws ArticleNotFoundException {
        List<ChemistryEntity> list = commonDao.findByTitle(title);

        return this.fromListGetFirst(list);
    }
}
