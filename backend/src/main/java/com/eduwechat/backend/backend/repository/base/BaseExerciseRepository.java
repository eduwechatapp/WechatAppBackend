package com.eduwechat.backend.backend.repository.exercise.simple;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;



@NoRepositoryBean
public interface BaseExerciseRepository<T, ID> extends MongoRepository<T, ID> {
     BaseExerciseEntity findById();
}
