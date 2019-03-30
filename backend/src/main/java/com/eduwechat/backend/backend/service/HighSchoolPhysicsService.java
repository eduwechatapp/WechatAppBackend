package com.eduwechat.backend.backend.service;

import com.eduwechat.backend.backend.entity.HighSchoolPhysics;
import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.repository.HighSchoolPhysicsRepository;
import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HighSchoolPhysicsService extends CommonService {



    /**
     * which映射二级标题字符串
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetErji(Integer which) {
        switch (which) {

            case 0:
                return "必修部分";
            case 1:
                return "选修部分";
            default:
                return null;
        }
    }


    @Autowired
    private HighSchoolPhysicsRepository repository;

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



}
