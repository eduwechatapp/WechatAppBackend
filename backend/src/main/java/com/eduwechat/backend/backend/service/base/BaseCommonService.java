package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import com.eduwechat.backend.backend.utils.titlelist.KnowledgeTitleListUtil;
import com.eduwechat.backend.backend.utils.titlelist.SummaryTitleListUtil;
import com.eduwechat.backend.backend.utils.titlelist.TemplateTitleListUtil;
import com.eduwechat.backend.backend.utils.titlelist.TopicTitleListUtil;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务层基类
 */
public abstract class BaseCommonService {

    /**
     * 获取知识点接口
     * @param which which
     * @param size size
     * @param page page
     * @return List&lt;Content&gt;
     */
    public abstract List<Content> getKnowledge(Integer which, Integer size, Integer page);

    /**
     * 通用获取二级标题列表接口
     * @param yijiString String 数据库中一级标题字段名称
     * @param yijiType String 一级类型 knowledge topic summary template
     * @param subjectType String 学科类型 zz hx yy yw sx ls dl sw wl
     * @throws TypeNotMatchException 一级类型或学科类型未匹配
     * @return List&lt;TitleListMapping&gt; 映射后标题列表
     */
    public abstract List<TitleListMapping> getTitleList(String yijiString, String yijiType, String subjectType) throws TypeNotMatchException;

    /**
     * 根据二级和标题得到文章
     * @param erji 二级标题
     * @param title 标题
     * @return BaseCommonEntity
     */
    public abstract BaseCommonEntity getArticleFromErjiAndTitle(String title) throws ArticleNotFoundException;

    /**
     * Page转List
     * @param pages
     * @return List&lt;Content&gt;
     */
    protected List<Content> fromPageGetList(Page<BaseCommonEntity> pages) {
        List<Content> list = new ArrayList<>();

        for (BaseCommonEntity english : pages) {
            list.add(new Content(english.getId(), english.getTitle(), english.getContent()));
        }

        return list;
    }

    /**
     * 基类方法，根据yijiType确定要mapping的一级标题，从而获得相应科目的二级标题映射
     * @param list List&lt;String&gt; 未映射的String List
     * @param yijiType 以及标题类型 knowledge topic summary template
     * @param subjectType String 学科类型 zz hx yy yw sx ls dl sw wl
     * @return List&lt;TitleListMapping&gt; 映射后标题列表
     */
    protected List<TitleListMapping> innerGetTitleList(List<String> list, String yijiType, String subjectType) throws TypeNotMatchException {

        switch (yijiType) {
            case "knowledge":
                return KnowledgeTitleListUtil.getInstance().fromTypeGetTitleList(list, subjectType);
            case "summary":
                return SummaryTitleListUtil.getInstance().fromTypeGetTitleList(list, subjectType);
            case "template":
                return TemplateTitleListUtil.getInstance().fromTypeGetTitleList(list, subjectType);
            case "topic":
                return TopicTitleListUtil.getInstance().fromTypeGetTitleList(list, subjectType);

        }


        throw new TypeNotMatchException("一级标题映射未匹配，请检查编码。", yijiType, TypeNotMatchException.WhichType.YIJI);
    }
}
