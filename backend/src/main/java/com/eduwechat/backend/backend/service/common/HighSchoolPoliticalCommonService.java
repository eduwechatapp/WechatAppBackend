package com.eduwechat.backend.backend.service.common;


import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.entity.common.HighSchoolPolitical;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.repository.common.HighSchoolPoliticalRepository;
import com.eduwechat.backend.backend.service.base.BaseCommonService;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolPoliticalCommonService extends BaseCommonService {

    @Autowired
    private HighSchoolPoliticalRepository repository;


    /**
     * 获取知识点章节映射
     * @param which Integer
     * @return String
     */
    private static String fromWhichGetKnowledgeErji(Integer which) {
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
                return "必修一（旧教材）";
            case 5:
                return "必修二（旧教材）";
            case 6:
                return "必修三（旧教材）";
            case 7:
                return "必修四（旧教材）";
            case 8:
                return "选修三（旧教材）";
            case 9:
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
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetKnowledgeErji(which), PageRequest.of(page, size));
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

    /**
     * 根据二级和title得到文章
     * @param title 标题
     * @return BaseCommonEntity
     * @throws ArticleNotFoundException 文章未找到
     */
    @Override
    public HighSchoolPolitical getArticleFromErjiAndTitle(String title) throws ArticleNotFoundException {
        List<BaseCommonEntity> list = repository.findByTitle(title);

        if (list.size() == 0) {
            throw new ArticleNotFoundException("文章未找到");
        }

        return (HighSchoolPolitical) list.get(0);
    }
}
