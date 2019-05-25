package com.eduwechat.backend.backend.repository.base;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;


import java.util.List;


@NoRepositoryBean
public interface BaseExerciseRepository<T, ID> extends MongoRepository<T, ID> {


     /**
      * 查找题型
      * @param type 题型
      * @return List&lt;T&gt;
      */
     List<T> findByType(String type);

     /**
      * 分页请求指定标题和题型的题目列表
      * @param type 题型
      * @param yiji 一级
      * @param erji 二级
      * @param pageable 分页能力
      * @return List&lt;T&gt;
      */
     List<BaseExerciseEntity> findByTypeAndYijiAndErji(String type, String yiji, String erji, Pageable pageable);
}
