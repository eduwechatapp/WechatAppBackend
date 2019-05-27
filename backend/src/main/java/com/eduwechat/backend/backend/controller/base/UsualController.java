package com.eduwechat.backend.backend.controller.base;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.service.common.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Api(description = "通用接口")
@Controller
@RequestMapping(value = "/usual")
public class UsualController {

    @Autowired
    private HighSchoolBiologicalCommonService biologicalCommonService;

    @Autowired
    private HighSchoolChemistryCommonService chemistryCommonService;

    @Autowired
    private HighSchoolChineseCommonService chineseCommonService;

    @Autowired
    private HighSchoolEnglishCommonService englishCommonService;

    @Autowired
    private HighSchoolGeographyCommonService geographyCommonService;

    @Autowired
    private HighSchoolHistoryCommonService historyCommonService;

    @Autowired
    private HighSchoolMathCommonService mathCommonService;

    @Autowired
    private HighSchoolPhysicsCommonService physicsCommonService;

    @Autowired
    private HighSchoolPoliticalCommonService politicalCommonService;

    @ApiOperation(value = "根据二级标题和标题获取文章" ,  notes="根据二级标题和标题获取文章")
    @ResponseBody
    @RequestMapping(value = "/common/erji-title/{openid}/{subject}/{erji}/{title}", method = RequestMethod.GET)
    public Map<String, Object> fromErjiAndTitleGetArticle(@PathVariable(value = "openid") String openid,
                                                          @PathVariable(value = "subject") String subject,
                                                          @PathVariable(value = "erji") String erji,
                                                          @PathVariable(value = "title") String title) {

        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", this.fromSubjectErjiTitleGetEntity(subject, erji, title));
            map.put("msg", "success");
            map.put("code", 0);
        } catch (SubjectDoesNotSupportedException e) {
            map.put("data", null);
            map.put("msg", e.getMessage());
            map.put("code", e.getErrorCode());
        } catch (ArticleNotFoundException e) {
            map.put("data", null);
            map.put("msg", e.getMessage());
            map.put("code", e.getErrorCode());
        }

        return map;
    }

    /**
     * 根据学科和二级、标题获取文章内容跟
     * @param subject 学科
     * @param erji 二级标题
     * @param title 标题
     * @return BaseCommonEntity
     * @throws SubjectDoesNotSupportedException 学科不支持
     * @throws ArticleNotFoundException 文章未找到
     */
    private BaseCommonEntity fromSubjectErjiTitleGetEntity(String subject, String erji, String title) throws SubjectDoesNotSupportedException, ArticleNotFoundException {
        switch (subject) {
            case "语文":
                return  chineseCommonService.getArticleFromErjiAndTitle(erji, title);
            case "数学":
                return mathCommonService.getArticleFromErjiAndTitle(erji, title);
            case "英语":
                return englishCommonService.getArticleFromErjiAndTitle(erji, title);
            case "物理":
                return physicsCommonService.getArticleFromErjiAndTitle(erji, title);
            case "化学":
                return chemistryCommonService.getArticleFromErjiAndTitle(erji, title);
            case "生物":
                return biologicalCommonService.getArticleFromErjiAndTitle(erji, title);
            case "地理":
                return geographyCommonService.getArticleFromErjiAndTitle(erji, title);
            case "历史":
                return historyCommonService.getArticleFromErjiAndTitle(erji, title);
            case "政治":
                return politicalCommonService.getArticleFromErjiAndTitle(erji, title);
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }
    }

}
