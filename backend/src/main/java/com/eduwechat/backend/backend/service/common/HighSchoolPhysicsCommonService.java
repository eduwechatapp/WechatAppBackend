package com.eduwechat.backend.backend.service.common;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.entity.common.HighSchoolPhysics;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.repository.common.HighSchoolPhysicsRepository;
import com.eduwechat.backend.backend.service.base.BaseCommonService;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolPhysicsCommonService extends BaseCommonService {



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
        Page<BaseCommonEntity> pages = repository.findByErji(fromWhichGetErji(which), PageRequest.of(page, size));

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
    public HighSchoolPhysics getArticleFromErjiAndTitle(String title) throws ArticleNotFoundException {
        List<BaseCommonEntity> list = repository.findByTitle(title);

        if (list.size() == 0) {
            throw new ArticleNotFoundException("文章未找到");
        }

        return (HighSchoolPhysics) list.get(0);
    }
}
