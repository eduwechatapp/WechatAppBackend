package com.eduwechat.backend.backend.service;


import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.repository.HighSchoolPoliticalRepository;
import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.inner.Content;
import com.eduwechat.backend.backend.service.base.inner.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolPoliticalService extends CommonService {

    @Autowired
    private HighSchoolPoliticalRepository repository;


    /**
     * 获取知识点章节映射
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetKnowledgeErji(Integer which) {
        switch (which) {
            case 1:
                return "必修一";
            case 2:
                return "必修一（旧教材）";
            case 3:
                return "必修二";
            case 4:
                return "必修二（旧教材）";
            case 5:
                return "必修三";
            case 6:
                return "必修三（旧教材）";
            case 7:
                return "必修四";
            case 8:
                return "必修四（旧教材）";
            case 9:
                return "选修三（旧教材）";
            case 10:
                return "选修四（旧教材）";
        }

        return null;
    }

    /**
     * 获取归纳总结映射
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetSummaryErji(Integer which) {
        switch (which) {
            case 0:
                return "高中政治常识主要原理归纳总结";
        }

        return null;
    }

    @Override
    public List<Content> getKnowledge(Integer which, Integer size, Integer page) {
        Page<BaseEntity> pages = repository.findByErji(fromWhichGetKnowledgeErji(which), PageRequest.of(page, size));
        return this.fromPageGetList(pages);
    }

    /**
     * 分页获取归纳总结
     * @param which 指定内容
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
        return this.innerGetTitleList(repository.findByTitleList("知识点"), "zz");
    }

}
