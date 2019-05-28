package com.eduwechat.backend.backend.repository.exercise.simple;

import com.eduwechat.backend.backend.entity.exercise.EnglishExerciseEntity;
import com.eduwechat.backend.backend.repository.base.BaseExerciseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnglishExerciseDao extends BaseExerciseRepository<EnglishExerciseEntity, String> {

}
