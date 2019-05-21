package com.eduwechat.backend.backend.service.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.service.base.BaseExerciseService;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseDetailResultItem;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseTitleResultItem;
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
    public List<ExerciseTitleResultItem> getExerciseTitleList(String subject) throws SubjectDoesNotSupportedException {
        return this.fromSubjectGetTitleListResult(subject);
    }

    @Override
    public List<BaseExerciseEntity> getExerciseList(String subject, String yiji, String erji, Integer size, Integer page) throws SubjectDoesNotSupportedException {
        return this.fromSubejctAndPageableGetExerciseEntity(subject, yiji, erji, size, page);
    }

    @Override
    public ExerciseDetailResultItem getExerciseDetail(String subject, Integer exerciseId) {
        return null;
    }
}
