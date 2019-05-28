package com.eduwechat.backend.backend.repository.exercise.simple;

import com.eduwechat.backend.backend.entity.exercise.PhysicsExerciseEntity;
import com.eduwechat.backend.backend.repository.base.BaseExerciseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicsExerciseDao extends BaseExerciseRepository<PhysicsExerciseEntity, String> {

}
