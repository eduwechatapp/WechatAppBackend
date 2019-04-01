package com.eduwechat.backend.backend.service;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.repository.HighSchoolBiologicalRepository;
import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.inner.Content;
import com.eduwechat.backend.backend.service.base.inner.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HighSchoolBiologicalService extends CommonService {



    /**
     * which映射二级标题字符串
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetErji(Integer which) {
        switch (which) {

            case 0:
                return "初高中知识对接";
            case 1:
                return "分子与细胞";
            case 2:
                return "遗传与进化";
            case 3:
                return "稳态与环境";
            case 4:
                return "生物技术与实践";
            case 5:
                return "现代生物技术专题";
            default:
                return null;
        }
    }


    @Autowired
    private HighSchoolBiologicalRepository repository;

    /**
     * 分页获取知识点
     * @param which Integer
     * @param size Integer
     * @param page Integer start with 0
     * @return List&lt;Content&gt;
     */
    @Override
    public List<Content> getKnowledge(Integer which, Integer size, Integer page) {
        Page<BaseEntity> pages = repository.findByErji(fromWhichGetErji(which), PageRequest.of(page, size));

        return this.fromPageGetList(pages);
    }

    @Override
    public List<TitleListMapping> getTitleList() {
        return this.innerGetTitleList(repository.findByTitleList("知识点"), "sw");
    }


}
