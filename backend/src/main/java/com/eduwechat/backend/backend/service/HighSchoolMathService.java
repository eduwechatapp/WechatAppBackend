package com.eduwechat.backend.backend.service;

import com.eduwechat.backend.backend.entity.HighSchoolMath;
import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.repository.HighSchoolMathRepository;
import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HighSchoolMathService extends CommonService {



    /**
     * which映射二级标题字符串
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetErji(Integer which) {
        switch (which) {

            case 0:
                return "必修一";
            case 1:
                return "必修二";
            case 2:
                return "必修三";
            case 3:
                return "必修四";
            case 4:
                return "必修五";
            case 5:
                return "选修2-1";
            case 6:
                return "选修2-2";
            case 7:
                return "选修2-3";
            case 8:
                return "选修4-2";
            case 9:
                return "选修4-4";
            case 10:
                return "选修4-5";
            default:
                return null;
        }
    }


    @Autowired
    private HighSchoolMathRepository repository;

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
