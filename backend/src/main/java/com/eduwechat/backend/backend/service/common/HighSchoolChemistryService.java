package com.eduwechat.backend.backend.service.common;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.repository.HighSchoolChemistryRepository;
import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolChemistryService extends CommonService {

    /**
     * 根据which选择对应教材
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetKnowledgeErji(Integer which) {

        switch (which) {
            case 0:
                return "必修一：元素及其化合物";
            case 1:
                return "选修一：化学与生活";
            case 2:
                return "化学基本概念和理论";
            case 3:
                return "化学实验基础";
            case 4:
                return "有机化学基础";
            case 5:
                return "物质结构与性质";
            default:
                return null;
        }
    }

    /**
     * 根据which选择对应教材
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetTemplateErji(Integer which) {

        switch (which) {
            case 0:
                return "解题思路";
            case 1:
                return "必修一";
            case 2:
                return "必修二";
            case 3:
                return "选修三";
            case 4:
                return "选修四";
            case 5:
                return "选修五";
            default:
                return null;
        }
    }

    @Autowired
    private HighSchoolChemistryRepository repository;

    @Override
    public List<Content> getKnowledge(Integer which, Integer size, Integer page) {
        Page<BaseEntity> pages = repository.findByErji(fromWhichGetKnowledgeErji(which), PageRequest.of(page, size));

        return this.fromPageGetList(pages);
    }

    /**
     * 分页获取答题模板
     * @param which Integer
     * @param size Integer
     * @param page Integer start with 0
     * @return List&lt;Content&gt;
     */
    public List<Content> getTemplate(Integer which, Integer size, Integer page) {
        Page<BaseEntity> pages = repository.findByErji(fromWhichGetTemplateErji(which), PageRequest.of(page, size));

        return this.fromPageGetList(pages);
    }

    /**
     * 通用获取二级标题列表接口
     * @param yijiString String 数据库中一级标题字段名称
     * @param yijiType String 一级类型 knowledge topic summary template
     * @param subjectType String 学科类型 zz hx yy yw sx ls dl sw wl
     * @throws TypeNotMatchException 一级类型或学科类型未匹配
     * @return List&lt;TitleListMapping&gt; 映射后标题列表
     */
    @Override
    public List<TitleListMapping> getTitleList(String yijiString, String yijiType, String subjectType) throws TypeNotMatchException {
        return this.innerGetTitleList(repository.findByTitleList(yijiString), yijiType, subjectType);
    }


}
