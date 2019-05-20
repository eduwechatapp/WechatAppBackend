package com.eduwechat.backend.backend.service.common;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.exceptions.common.TypeNotMatchException;
import com.eduwechat.backend.backend.repository.common.HighSchoolMathRepository;
import com.eduwechat.backend.backend.service.base.inner.common.CommonService;
import com.eduwechat.backend.backend.service.base.inner.common.Content;
import com.eduwechat.backend.backend.service.base.inner.common.TitleListMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighSchoolMathCommonService extends CommonService {



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


}
