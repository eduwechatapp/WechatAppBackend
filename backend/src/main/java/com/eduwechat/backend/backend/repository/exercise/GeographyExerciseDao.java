package com.eduwechat.backend.backend.repository.exercise;

import com.eduwechat.backend.backend.entity.exercise.GeographyExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeographyExerciseDao extends JpaRepository<GeographyExerciseEntity, Integer> {
}
