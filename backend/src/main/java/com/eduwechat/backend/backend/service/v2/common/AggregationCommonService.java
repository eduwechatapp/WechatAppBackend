package com.eduwechat.backend.backend.service.v2.common;

import com.eduwechat.backend.backend.exceptions.common.SearchNotRightException;
import com.eduwechat.backend.backend.repository.v2.common.AggregationCommonDao;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import com.eduwechat.backend.backend.service.v2.base.AggregationBaseService;
import java.util.List;

import com.eduwechat.backend.backend.utils.v2.V2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: backend
 * @description: AggregationCommonService 知识点等聚合服务层 重构Common层逻辑，简化初版复杂的耦合操作，提供灵活的查询接口，
 * 更正上一版本不能在ONLY_GROUP_BY的环境下运行的奇葩操作。
 * @author: Vaskka
 * @create: 2019/7/1 11:49 AM
 **/

@Service
public class AggregationCommonService extends AggregationBaseService {

    @Autowired
    private AggregationCommonDao commonDao;

    /**
     * 根据表名，查询二级which映射
     * @param table 表名
     * @param yiji 一级名
     * @return List
     */
    public List<TitleListMapping> getWhichMapping(String table, String yiji) {
        return V2Util.startFromZero(commonDao.getWhichFromTableAndYiji(table, yiji));
    }

    /**
     * 分页获取某个具体的文章列表
     * @param table 表名
     * @param yiji 一级名
     * @param erjiWhich 二级which
     * @param size size
     * @param page page
     * @return List
     */
    //////
    //////
    //////
    public List<Content> getArticleFromErjiWhichAndYijiName(String table, String yiji, Integer erjiWhich, Integer size, Integer page) {
        List<TitleListMapping> titleListMappingList = V2Util.startFromZero(commonDao.getWhichFromTableAndYiji(table, yiji));

        try {
            String name = V2Util.searchNameFromWhich(titleListMappingList, erjiWhich);
        } catch (SearchNotRightException e) {

        }

        return null;
    }
}
