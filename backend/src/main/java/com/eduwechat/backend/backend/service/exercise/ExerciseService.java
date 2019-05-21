package com.eduwechat.backend.backend.service.exercise;

import com.eduwechat.backend.backend.exceptions.exercise.SubjectDoesNotSupportedException;
import com.eduwechat.backend.backend.exceptions.exercise.YijiIdCanNotFoundException;
import com.eduwechat.backend.backend.service.base.BaseExerciseService;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseDetailResultItem;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseTitleResultItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService extends BaseExerciseService {


    @Override
    public List<ExerciseTitleResultItem> getYijiTitleList(String subject) throws SubjectDoesNotSupportedException {
        return this.fromSubjectGetYijiResult(subject);
    }

    @Override
    public List<ExerciseTitleResultItem> getErjiTitleList(String subject, Integer yijiId) throws YijiIdCanNotFoundException, SubjectDoesNotSupportedException {
        return this.fromSubjectAndYijiIdGetResult(subject, yijiId);
    }

    @Override
    public List<ExerciseTitleResultItem> getExerciseTitleList(String subject, Integer yijiId, Integer erjiId, Integer size, Integer page) {
        return null;
    }

    @Override
    public ExerciseDetailResultItem getExerciseDetail(String subject, String exerciseId) {
        return null;
    }
}
