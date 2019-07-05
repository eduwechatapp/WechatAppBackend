package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.exceptions.exercise.ExerciseIdDoesNotExistException;
import com.eduwechat.backend.backend.exceptions.exercise.ExerciseTypeNotSupportedException;
import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.repository.exercise.aggregation.*;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;
import com.eduwechat.backend.backend.repository.exercise.simple.*;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseSimpleResultItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public abstract class BaseExerciseService {

    // common jpa dao

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

    // mongodb impl dao

    @Autowired
    private BiologyAggregationImpl biologyAggregation;

    @Autowired
    private ChemistryAggregationImpl chemistryAggregation;

    @Autowired
    private ChineseAggregationImpl chineseAggregation;

    @Autowired
    private EnglishAggregationImpl englishAggregation;

    @Autowired
    private GeographyAggregationImpl geographyAggregation;

    @Autowired
    private HistoryAggregationImpl historyAggregation;

    @Autowired
    private MathAggregationImpl mathAggregation;

    @Autowired
    private PhysicsAggregationImpl physicsAggregation;

    @Autowired
    private  PoliticsAggregationImpl politicsAggregation;

    /**
     * 获取标题list
     * @param subject 学科中文名
     * @return List&lt;ExerciseTitleResultItem>
     */
    public abstract List<TotalTitleResultItem> getExerciseTitleList(String subject) throws SubjectDoesNotSupportedException;


    /**
     * 获取某个学科的题型
     * @param subject 指定学科
     * @return List&lt;String&gt;
     * @throws SubjectDoesNotSupportedException 学科不支持
     */
    public abstract List<String> getExerciseTypeList(String subject) throws SubjectDoesNotSupportedException;

    /**
     * 得到指定标题下分页题目
     * @param subject String 学科
     * @param yiji String 一级标题
     * @param erji String 二级 标题
     * @param type String 题型中文名
     * @param shrink Boolean 是否为缩略模式
     * @param size Integer 页大小
     * @param page Integer 页偏移
     * @return List&lt;ExerciseSimpleResultItem&gt;
     * @throws SubjectDoesNotSupportedException 学科不支持
     */
    public abstract List<ExerciseSimpleResultItem> getExerciseList(String subject,
                                                                  String yiji,
                                                                  String erji,
                                                                  String type,
                                                                  Boolean shrink,
                                                                  Integer size,
                                                                  Integer page)
            throws SubjectDoesNotSupportedException;

    /**
     * 获取某个题目的详细信息
     * @param subject String 学科
     * @param exerciseId String 具体习题id
     * @return BaseExerciseEntity 题目具体信息
     */
    public abstract BaseExerciseEntity getExerciseDetail(String subject, String exerciseId)
            throws SubjectDoesNotSupportedException;


    /**
     * 得到指定学科的总标题
     * @param subject 指定学科
     * @return List&lt;TotalTitleResultItem&gt;
     * @throws SubjectDoesNotSupportedException 学科不合法
     */
    protected List<TotalTitleResultItem> getTotalTitle(String subject) throws SubjectDoesNotSupportedException {
        switch (subject) {
            case "语文":
                return  chineseAggregation.getTotalTitle();
            case "数学":
                return mathAggregation.getTotalTitle();
            case "英语":
                return englishAggregation.getTotalTitle();
            case "物理":
                return physicsAggregation.getTotalTitle();
            case "化学":
                return chemistryAggregation.getTotalTitle();
            case "生物":
                return biologyAggregation.getTotalTitle();
            case "地理":
                return geographyAggregation.getTotalTitle();
            case "历史":
                return historyAggregation.getTotalTitle();
            case "政治":
                return politicsAggregation.getTotalTitle();
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }
    }

    /**
     * 得到指定学科的题型列表
     * @param subject 学科中文名
     * @return List&lt;String&gt;
     * @throws SubjectDoesNotSupportedException 学科不支持
     */
    protected List<String> fromSubjectGetExerciseType(String subject) throws SubjectDoesNotSupportedException {
        switch (subject) {
            case "语文":
                return  chineseAggregation.getTotalType();
            case "数学":
                return mathAggregation.getTotalType();
            case "英语":
                return englishAggregation.getTotalType();
            case "物理":
                return physicsAggregation.getTotalType();
            case "化学":
                return chemistryAggregation.getTotalType();
            case "生物":
                return biologyAggregation.getTotalType();
            case "地理":
                return geographyAggregation.getTotalType();
            case "历史":
                return historyAggregation.getTotalType();
            case "政治":
                return politicsAggregation.getTotalType();
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }
    }

    /**
     * 获取指定标题和题型的分页题目
     * @param subject 学科
     * @param yiji 一级
     * @param erji 二级
     * @param type 题型
     * @param shrink 是否为缩略模式
     * @param size 页大小
     * @param page 页偏移
     * @return List&lt;ExerciseSimpleResultItem&gt;
     * @throws SubjectDoesNotSupportedException 学科不支持
     */
    protected List<ExerciseSimpleResultItem> getExercisePageableList(String subject,
                                                         String yiji,
                                                         String erji,
                                                         String type,
                                                         Boolean shrink,
                                                         Integer size,
                                                         Integer page) throws SubjectDoesNotSupportedException {
        switch (subject) {
            case "语文":
                return  ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        chineseExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            case "数学":
                return ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        mathExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            case "英语":
                return ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        englishExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            case "物理":
                return ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        physicsExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            case "化学":
                return ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        chemistryExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            case "生物":
                return ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        biologyExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            case "地理":
                return ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        geographyExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            case "历史":
                return ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        historyExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            case "政治":
                return ExerciseSimpleResultItem.fromEntityGetResultItem(shrink,
                        politicsExerciseDao.findByTypeAndYijiAndErji(type, yiji, erji, PageRequest.of(page, size)));
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }
    }

    /**
     * 根据题目id获取题目详情
     * @param subject 学科
     * @param id 题目id
     * @throws SubjectDoesNotSupportedException 学科不支持
     */
    protected BaseExerciseEntity fromIdGetExerciseDetail(String subject, String id) throws SubjectDoesNotSupportedException {
        switch (subject) {
            case "语文":
                return  chineseExerciseDao.findById(id).orElse(null);
            case "数学":
                return mathExerciseDao.findById(id).orElse(null);
            case "英语":
                return englishExerciseDao.findById(id).orElse(null);
            case "物理":
                return physicsExerciseDao.findById(id).orElse(null);
            case "化学":
                return chemistryExerciseDao.findById(id).orElse(null);
            case "生物":
                return biologyExerciseDao.findById(id).orElse(null);
            case "地理":
                return geographyExerciseDao.findById(id).orElse(null);
            case "历史":
                return historyExerciseDao.findById(id).orElse(null);
            case "政治":
                return politicsExerciseDao.findById(id).orElse(null);
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }
    }
}
