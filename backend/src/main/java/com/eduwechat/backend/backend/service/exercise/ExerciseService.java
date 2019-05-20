package com.eduwechat.backend.backend.service.exercise;

import com.eduwechat.backend.backend.repository.exercise.*;
import com.eduwechat.backend.backend.service.base.BaseExerciseService;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseDetailResultItem;
import com.eduwechat.backend.backend.service.base.inner.exercise.ExerciseTitleResultItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService extends BaseExerciseService {


    @Override
    public List<ExerciseTitleResultItem> getYijiTitleList(String subject) {
        return null;
    }

    @Override
    public List<ExerciseTitleResultItem> getErjiTitleList(String subject, Integer yijiId) {
        return null;
    }

    @Override
    public List<ExerciseTitleResultItem> getExerciseTitleList(String subject, Integer yijiId, Integer erjiId, Integer size, Integer page) {
        return null;
    }

    @Override
    public List<ExerciseDetailResultItem> getExerciseDetail(String subject, Integer yijiId, Integer erjiId, String exerciseId) {
        return null;
    }
}
