package com.eduwechat.backend.backend.repository.exercise.simple;

import com.eduwechat.backend.backend.entity.exercise.MathExerciseEntity;
import com.eduwechat.backend.backend.repository.base.BaseExerciseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MathExerciseDao extends BaseExerciseRepository<MathExerciseEntity, String> {



}
