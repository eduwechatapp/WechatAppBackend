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
     * @return List&lt;ExerciseDetailResultItem&gt;
     */
    public abstract List<ExerciseDetailResultItem> getExerciseDetail(String subject, Integer yijiId, Integer erjiId, String exerciseId);

    protected List<ExerciseTitleResultItem> fromSubjectGetYijiResult(String subject) throws SubjectDoesNotSupportedException {

        List<ExerciseTitleResultItem> result = new ArrayList<>();

        switch (subject) {
            case "语文":

                break;
            case "数学":
                break;
            case "英语":
                break;
            case "物理":
                break;
            case "化学":
                break;
            case "生物":
                break;
            case "地理":
                break;
            case "历史":
                break;
            case "政治":
                break;
            default:
                throw new SubjectDoesNotSupportedException(subject);
                break;
        }



    }

}
