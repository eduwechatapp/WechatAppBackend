package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.repository.exercise.*;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseDetailResultItem;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseTitleResultItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseExerciseService {

    @Autowired
    private BiologyExerciseDao biologyExerciseDao;

    @Autowired
    private ChemistryExerciseDao chemistryExerciseDao;

    @Autowired
    private ChineseExerciseDao chineseExerciseDao;

    @Autowired
    private EnglishExerciseDao englishExerciseDao;

    @Autowired
    private GeographyExerciseDao geographyExerciseDao;

    @Autowired
    private HistoryExerciseDao historyExerciseDao;

    @Autowired
    private MathExerciseDao mathExerciseDao;

    @Autowired
    private PhysicsExerciseDao physicsExerciseDao;

    @Autowired
    private PoliticsExerciseDao politicsExerciseDao;

    /**
     * 获取yiji题库标题list
     * @param subject 学科中文名
     * @return List&lt;ExerciseTitleResultItem&gt;
     */
    public abstract List<ExerciseTitleResultItem> getYijiTitleList(String subject);

    /**
     * 获取erji题库标题list
     * @param subject 学科中文名
     * @param yijiId 一级id
     * @return List&lt;ExerciseTitleResultItem>
     */
    public abstract List<ExerciseTitleResultItem> getErjiTitleList(String subject, Integer yijiId);

    /**
     * 获取题目的标题list
     * @param subject 学科中文名
     * @param yijiId 一级id
     * @param erjiId 二级id
     * @param size 每页的大小
     * @param page 页偏移量
     * @return List&lt;ExerciseTitleResultItem&gt;
     */
    public abstract List<ExerciseTitleResultItem> getExerciseTitleList(String subject,
                                                                       Integer yijiId,
                                                                       Integer erjiId,
                                                                       Integer size,
                                                                       Integer page);

    /**
     * 获取某个题目的详细信息
     * @param subject 科中文名
     * @param yijiId 一级id
     * @param erjiId 二级id
     * @param exerciseId 具体联系id
     * @return ExerciseDetailResultItem
     */
    public abstract ExerciseDetailResultItem getExerciseDetail(String subject, Integer yijiId, Integer erjiId, String exerciseId);

    /**
     * 获取yiji标题及编号
     * @param subject 学科中文
     * @return List&lt;ExerciseTitleResultItem&gt;
     * @throws SubjectDoesNotSupportedException 不支持此学科的查询
     */
    protected List<ExerciseTitleResultItem> fromSubjectGetYijiResult(String subject) throws SubjectDoesNotSupportedException {

        List<ExerciseTitleResultItem> result;

        switch (subject) {
            case "语文":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(chineseExerciseDao.findYijiTitleList());
                break;
            case "数学":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(mathExerciseDao.findYijiTitleList());
                break;
            case "英语":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(englishExerciseDao.findYijiTitleList());
                break;
            case "物理":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(physicsExerciseDao.findYijiTitleList());
                break;
            case "化学":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(chemistryExerciseDao.findYijiTitleList());
                break;
            case "生物":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(biologyExerciseDao.findYijiTitleList());
                break;
            case "地理":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(geographyExerciseDao.findYijiTitleList());
                break;
            case "历史":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(historyExerciseDao.findYijiTitleList());
                break;
            case "政治":
                result = ExerciseTitleResultItem.fromStringListGetTitleResultList(politicsExerciseDao.findYijiTitleList());
                break;
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }

        return result;
    }

}
