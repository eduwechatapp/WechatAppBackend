package com.eduwechat.backend.backend.service;

import com.eduwechat.backend.backend.entity.base.BaseEntity;
import com.eduwechat.backend.backend.repository.HighSchoolChineseRepository;
import com.eduwechat.backend.backend.service.base.CommonService;
import com.eduwechat.backend.backend.service.base.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolChineseService extends CommonService {

    /**
     * 根据which选择对应教材
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetKnowledgeErji(Integer which) {

        switch (which) {
            case 1:
                return "必修一";
            case 2:
                return "必修二";
            case 3:
                return "必修三";
            case 4:
                return "必修四";
            case 5:
                return "必修五";
            case 6:
                return "中国古代诗歌散文欣赏欣赏（选修）";
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
                return "作文素材";
            case 1:
                return "作文万能议论素材";
            case 2:
                return "作文题材通用例文";
            case 3:
                return "高考建议背诵篇目";
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
                return "高考常见易错成语";
            case 1:
                return "高考常见易错熟语";
            case 2:
                return "高考常见易错字型";
            case 3:
                return "高考作文高频易错字词";
            default:
                return null;
        }
    }

    @Autowired
    private HighSchoolChineseRepository repository;

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
}
