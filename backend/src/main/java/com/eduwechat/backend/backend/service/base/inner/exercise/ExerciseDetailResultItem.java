package com.eduwechat.backend.backend.service.base.inner.exercise;

import cn.wanghaomiao.xpath.exception.NoSuchAxisException;
import cn.wanghaomiao.xpath.exception.NoSuchFunctionException;
import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.entity.exercise.*;
import com.eduwechat.backend.backend.utils.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ExerciseDetailResultItem {

    private Integer id;

    private String type;

    private String content;

    private List<String> choose;

    private String answer;

    private Integer answerIndex;

    private String analysis;

    public static ExerciseDetailResultItem fromEntityGetBiologyDetailItem(BiologyExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    public static ExerciseDetailResultItem fromEntityGetChemistryDetailItem(ChemistryExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    public static ExerciseDetailResultItem fromEntityGetChineseDetailItem(ChineseExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    public static ExerciseDetailResultItem fromEntityGetEnglishDetailItem(EnglishExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    public static ExerciseDetailResultItem fromEntityGetGeographyDetailItem(GeographyExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    public static ExerciseDetailResultItem fromEntityGetHistoryDetailItem(HistoryExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    public static ExerciseDetailResultItem fromEntityGetMathDetailItem(MathExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    public static ExerciseDetailResultItem fromEntityGetPhysicsDetailItem(PhysicsExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    public static ExerciseDetailResultItem fromEntityGetPoliticsDetailItem(PoliticsExerciseEntity entity) {
        return fromBaseExerciseEntityGetResultItem(entity);
    }

    /**
     * 从实体得到返回对象
     * @param entity 实体基类
     * @return 返回对象
     */
    private static ExerciseDetailResultItem fromBaseExerciseEntityGetResultItem(BaseExerciseEntity entity) {
        Integer id = entity.getId();
        String content = entity.getContent();
        String analysis = entity.getAnalysis();

        List<String> choose = new ArrayList<>();
        String answer = entity.getAnswer();
        Integer answerIndex = null;

        // 解析html
        JXDocument jxDocument = new JXDocument(content);
        List<Object> rs = null;

        try {
            rs = jxDocument.sel("//tr/td/text()");
        } catch (NoSuchAxisException | XpathSyntaxErrorException | NoSuchFunctionException e) {
            e.printStackTrace();
        }

        // 不是选择题
        if (rs == null || rs.size() == 0) {
            return new ExerciseDetailResultItem(id, "非选择题", content, choose, answer, null, analysis);
        }

        // 是选择题
        for (Object o : rs) {
            choose.add(StringUtils.strip(o.toString()));
        }

        // 处理答案为空
        if (answer.length() == 0) {
            return new ExerciseDetailResultItem(id, "选择题", content, choose, answer, null, analysis);
        }

        // 计算选项
        answerIndex = CommonUtil.fromCharGetIntegerString(StringUtils.strip(entity.getAnswer()).charAt(0));
        if (answerIndex == null) {
            return new ExerciseDetailResultItem(id, "选择题", content, choose, entity.getAnswer(), null, analysis);
        }

        // 预期结果
        return new ExerciseDetailResultItem(id, "选择题", content, choose, answer, answerIndex, analysis);
    }

}
