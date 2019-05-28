package com.eduwechat.backend.backend.repository.exercise.simple;

import com.eduwechat.backend.backend.entity.exercise.ChineseExerciseEntity;
import com.eduwechat.backend.backend.repository.base.BaseExerciseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChineseExerciseDao extends BaseExerciseRepository<ChineseExerciseEntity, String> {

}
