package com.eduwechat.backend.backend.repository.exercise;

import com.eduwechat.backend.backend.entity.exercise.MathExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MathExerciseDao extends JpaRepository<MathExerciseEntity, Integer> {
}
