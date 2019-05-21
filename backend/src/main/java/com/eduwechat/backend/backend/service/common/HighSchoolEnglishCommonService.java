package com.eduwechat.backend.backend.service.common;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.repository.common.HighSchoolEnglishRepository;
import com.eduwechat.backend.backend.service.base.BaseCommonService;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolEnglishCommonService extends BaseCommonService {

    /**
     * 根据which选择对应教材
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetKnowledgeErji(Integer which) {

        switch (which) {
            case 0:
                return "必修一词汇表与重点语法";
            case 1:
                return "必修二词汇表与重点语法";
            case 2:
                return "必修三词汇表与重点语法";
            case 3:
                return "必修四词汇表与重点语法";
            case 4:
                return "必修五词汇表与重点语法";
            case 5:
                return "选修六词汇表与重点语法";
            case 6:
                return "选修七词汇表与重点语法";
            case 7:
                return "选修八词汇表与重点语法";
            case 8:
                return "选修九词汇表与重点语法";
            case 9:
                return "选修十词汇表与重点语法";
            case 10:
                return "选修十一词汇表";
            default:
                return null;
        }
    }


    /**
     * 根据which选择对应专题
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetTopicErji(Integer which) {

        switch (which) {
            case 0:
                return "阅读理解";
            case 1:
                return "语法";
            case 2:
                return "写作指导";
            default:
                return null;
        }
    }


    /**
     * 根据which选择对应归纳总结
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetSummaryErji(Integer which) {

        switch (which) {
            case 0:
                return "高考知识点";
            case 1:
                return "高考核心单词";
            default:
                return null;
        }
    }

    @Autowired
    private HighSchoolEnglishRepository repository;

    /**
     * 分页获取知识点
     * @param which 指定教材
     * @param size 每页数据组数
     * @param page 页数偏移量从0开始
     * @return List
     */
    @Override
    public List<Content> getKnowledge(Integer which, Integer size, Integer page) {
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetKnowledgeErji(which), PageRequest.of(page, size));
        return this.fromPageGetList(pages);
    }

    /**
     * 分页获取专题
     * @param which 指定专题
     * @param size 每页数据组数
     * @param page 页数偏移量从0开始
     * @return List
     */
    public List<Content> getTopic(Integer which, Integer size, Integer page) {
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetTopicErji(which), PageRequest.of(page, size));
        return this.fromPageGetList(pages);
    }

    /**
     * 分页获取归纳总结
     * @param which 指定总结
     * @param size 每页数据组数
     * @param page 页数偏移量从0开始
     * @return List
     */
    public List<Content> getSummary(Integer which, Integer size, Integer page) {
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetSummaryErji(which), PageRequest.of(page, size));
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
