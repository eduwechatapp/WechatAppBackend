package com.eduwechat.backend.backend.service.extra;

import com.eduwechat.backend.backend.entity.extra.PhysicsEntity;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.repository.extra.ExtraPhysicsDao;
import com.eduwechat.backend.backend.repository.extra.impl.ExtraPhysicsAggregationImpl;
import com.eduwechat.backend.backend.service.base.BaseExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: backend
 * @description: ExtraPhycicsService
 * @author: Vaskka
 * @create: 2019/5/31 4:10 AM
 **/
@Service
public class ExtraPhysicsService extends BaseExtraService<PhysicsEntity> {


    @Autowired
    private ExtraPhysicsDao commonDao;

    @Autowired
    private ExtraPhysicsAggregationImpl aggregationDao;

    /**
     * 分页获取新知识点的全部数据
     * @param size 每页宽
     * @param page 页偏移
     * @return List
     */
    @Override
    public List<PhysicsEntity> getNewKnowledge(int size, int page) {
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
     * @return PhysicsEntity
     */
    @Override
    public List<String> getNewKNowledgeFromYiji(String yiji, Integer size, Integer page) throws ArticleNotFoundException {
        List<PhysicsEntity> res = commonDao.findByYiji(yiji, PageRequest.of(page, size));

        return fromEntityGetTitle(res);
    }

    /**
     * 根据标题得到文章详情
     * @param title 标题
     * @return ChemistryEntity
     * @throws ArticleNotFoundException 文章未找到
     */
    @Override
    public PhysicsEntity getContentFromTitle(String title) throws ArticleNotFoundException {
        List<PhysicsEntity> list = commonDao.findByTitle(title);

        return this.fromListGetFirst(list);
    }
}
