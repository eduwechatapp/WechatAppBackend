package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.entity.exercise.*;
import com.eduwechat.backend.backend.exceptions.exercise.ExerciseIdDoesNotExistException;
import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.repository.exercise.*;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseDetailResultItem;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseTitleResultItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
     * 获取标题list
     * @param subject 学科中文名
     * @return List&lt;ExerciseTitleResultItem>
     */
    public abstract List<ExerciseTitleResultItem> getExerciseTitleList(String subject) throws SubjectDoesNotSupportedException;

    /**
     * 获取一级二级下的题目list，返回分页请求结果
     * @param subject 学科中文名
     * @param yiji 一级id
     * @param erji 二级id
     * @param size 每页的大小
     * @param page 页偏移量
     * @return List&lt;ExerciseTitleResultItem&gt;
     */
    public abstract List<BaseExerciseEntity> getExerciseList(String subject,
                                                                  String yiji,
                                                                  String erji,
                                                                  Integer size,
                                                                  Integer page) throws SubjectDoesNotSupportedException;

    /**
     * 获取某个题目的详细信息
     * @param subject 学科中文名
     * @param exerciseId 具体联系id
     * @return ExerciseDetailResultItem
     */
    public abstract ExerciseDetailResultItem getExerciseDetail(String subject, Integer exerciseId);

    /**
     * 获取yiji标题及编号
     * @param subject 学科中文
     * @return List&lt;ExerciseTitleResultItem&gt;
     * @throws SubjectDoesNotSupportedException 不支持此学科的查询
     */
    protected List<ExerciseTitleResultItem> fromSubjectGetTitleListResult(String subject) throws SubjectDoesNotSupportedException {

        switch (subject) {
            case "语文":
                return  ExerciseTitleResultItem.fromStringListGetChineseTitleResultList(subject, chineseExerciseDao);
            case "数学":
                return ExerciseTitleResultItem.fromStringListGetMathTitleResultList(subject, mathExerciseDao);
            case "英语":
                return ExerciseTitleResultItem.fromStringListGetEnglishTitleResultList(subject, englishExerciseDao);
            case "物理":
                return ExerciseTitleResultItem.fromStringListGetPhysicsTitleResultList(subject, physicsExerciseDao);
            case "化学":
                return ExerciseTitleResultItem.fromStringListGetChemistryTitleResultList(subject, chemistryExerciseDao);
            case "生物":
                return ExerciseTitleResultItem.fromStringListGetBiologyTitleResultList(subject, biologyExerciseDao);
            case "地理":
                return ExerciseTitleResultItem.fromStringListGetGeographyTitleResultList(subject, geographyExerciseDao);
            case "历史":
                return ExerciseTitleResultItem.fromStringListGetHistoryTitleResultList(subject, historyExerciseDao);
            case "政治":
                return ExerciseTitleResultItem.fromStringListGetPoliticsTitleResultList(subject, politicsExerciseDao);
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }

    }

    /**
     * 根据学科额一二级标题得到分页题目
     * @param subject 学科
     * @param yiji 一级标题
     * @param erji 二级标题
     * @param size 页大小
     * @param page 页偏移
     * @return List&lt;BaseExerciseEntity&gt;
     * @throws SubjectDoesNotSupportedException 学科不合法
     */
    protected List<BaseExerciseEntity> fromSubejctAndPageableGetExerciseEntity(String subject, String yiji, String erji, int size, int page) throws SubjectDoesNotSupportedException {
        switch (subject) {
            case "语文":
                return  chineseExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            case "数学":
                return mathExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            case "英语":
                return englishExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            case "物理":
                return physicsExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            case "化学":
                return chemistryExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            case "生物":
                return biologyExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            case "地理":
                return geographyExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            case "历史":
                return historyExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            case "政治":
                return politicsExerciseDao.findByYijiAndErji(yiji, erji, PageRequest.of(page, size));
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }

    }

    /**
     * 根据学科和id得到某道题的具体信息
     * @param subject 中文学科名
     * @param id id
     * @return ExerciseDetailResultItem
     */
    protected ExerciseDetailResultItem fromSubjectAndIdGetExerciseDetail(String subject, Integer id) throws SubjectDoesNotSupportedException, ExerciseIdDoesNotExistException {
        switch (subject) {
            case "语文":
                Optional<ChineseExerciseEntity> optionalYW = chineseExerciseDao.findById(id);
                if (!optionalYW.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetChineseDetailItem(optionalYW.get());
            case "数学":
                Optional<MathExerciseEntity> optionalSX = mathExerciseDao.findById(id);
                if (!optionalSX.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetMathDetailItem(optionalSX.get());
            case "英语":
                Optional<EnglishExerciseEntity> optionalYY = englishExerciseDao.findById(id);
                if (!optionalYY.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetEnglishDetailItem(optionalYY.get());
            case "物理":
                Optional<PhysicsExerciseEntity> optionalWL = physicsExerciseDao.findById(id);
                if (!optionalWL.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetPhysicsDetailItem(optionalWL.get());
            case "化学":
                Optional<ChemistryExerciseEntity> optionalHX = chemistryExerciseDao.findById(id);
                if (!optionalHX.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetChemistryDetailItem(optionalHX.get());
            case "生物":
                Optional<BiologyExerciseEntity> optionalSW = biologyExerciseDao.findById(id);
                if (!optionalSW.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetBiologyDetailItem(optionalSW.get());
            case "地理":
                Optional<GeographyExerciseEntity> optionalDL = geographyExerciseDao.findById(id);
                if (!optionalDL.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetGeographyDetailItem(optionalDL.get());
            case "历史":
                Optional<HistoryExerciseEntity> optionalLS = historyExerciseDao.findById(id);
                if (!optionalLS.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetHistoryDetailItem(optionalLS.get());
            case "政治":
                Optional<PoliticsExerciseEntity> optionalZZ = politicsExerciseDao.findById(id);
                if (!optionalZZ.isPresent()) {
                    throw new ExerciseIdDoesNotExistException(id);
                }
                return ExerciseDetailResultItem.fromEntityGetPoliticsDetailItem(optionalZZ.get());
            default:
                throw new SubjectDoesNotSupportedException(subject);
        }
    }
}
