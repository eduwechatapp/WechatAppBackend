package com.eduwechat.backend.backend.service;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.repository.HighSchoolEnglishRepository;
import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.inner.Content;
import com.eduwechat.backend.backend.service.base.inner.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolEnglishService extends CommonService {

    /**
     * 根据which选择对应教材
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetKnowledgeErji(Integer which) {

        switch (which) {
            case 1:
                return "必修一词汇表与重点语法";
            case 2:
                return "必修二词汇表与重点语法";
            case 3:
                return "必修三词汇表与重点语法";
            case 4:
                return "必修四词汇表与重点语法";
            case 5:
                return "必修五词汇表与重点语法";
            case 6:
                return "选修六词汇表与重点语法";
            case 7:
                return "选修七词汇表与重点语法";
            case 8:
                return "选修八词汇表与重点语法";
            case 9:
                return "选修九词汇表与重点语法";
            case 10:
                return "选修十词汇表与重点语法";
            case 11:
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
        Page<BaseEntity> pages = repository.findByErji(fromWhichGetKnowledgeErji(which), PageRequest.of(page, size));
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
        Page<BaseEntity> pages = repository.findByErji(fromWhichGetTopicErji(which), PageRequest.of(page, size));
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
        Page<BaseEntity> pages = repository.findByErji(fromWhichGetSummaryErji(which), PageRequest.of(page, size));
        return this.fromPageGetList(pages);
    }

    @Override
    public List<TitleListMapping> getTitleList() {
        return this.innerGetTitleList(repository.findByTitleList("知识点"), "yy");
    }

}
