package com.eduwechat.backend.backend.repository.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.entity.exercise.MathExerciseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MathExerciseDao extends BaseExerciseRepository<MathExerciseEntity, String> {



}
