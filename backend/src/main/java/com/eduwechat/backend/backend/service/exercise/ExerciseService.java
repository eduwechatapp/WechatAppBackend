package com.eduwechat.backend.backend.service.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.exceptions.exercise.ExerciseIdDoesNotExistException;
import com.eduwechat.backend.backend.exceptions.exercise.ExerciseTypeNotSupportedException;
import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.repository.base.set.TotalTitleResultItem;
import com.eduwechat.backend.backend.service.base.BaseExerciseService;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseSimpleResultItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService extends BaseExerciseService {


    /**
     * 获得学科的标题列表
     * @param subject 学科中文名
     * @return List&lt;ExerciseTitleResultItem&gt;
     * @throws SubjectDoesNotSupportedException 学科不合法
     */
    @Override
    public List<TotalTitleResultItem> getExerciseTitleList(String subject) throws SubjectDoesNotSupportedException {
        return this.getTotalTitle(subject);
    }

    /**
     * 获取学科的题型列表
     * @param subject 指定学科
     * @return List&lt;String&gt;
     * @throws SubjectDoesNotSupportedException 学科不支持
     */
    @Override
    public List<String> getExerciseTypeList(String subject) throws SubjectDoesNotSupportedException {
        return this.fromSubjectGetExerciseType(subject);
    }

    /**
     * 获取分页的题目list
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
    @Override
    public List<ExerciseSimpleResultItem> getExerciseList(String subject, String yiji, String erji, String type, Boolean shrink, Integer size, Integer page) throws SubjectDoesNotSupportedException {
        return this.getExercisePageableList(subject, yiji, erji, type, shrink, size, page);
    }

    /**
     * 根据学科id获取某道题的具体信息
     * @param subject String 学科
     * @param exerciseId String 具体习题id
     * @return BaseExerciseEntity 题目实体
     * @throws SubjectDoesNotSupportedException 学科不支持
     */
    @Override
    public BaseExerciseEntity getExerciseDetail(String subject, String exerciseId) throws SubjectDoesNotSupportedException {
        return this.fromIdGetExerciseDetail(subject, exerciseId);
    }


}
