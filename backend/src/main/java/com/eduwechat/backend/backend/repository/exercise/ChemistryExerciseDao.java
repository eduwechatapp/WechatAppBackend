package com.eduwechat.backend.backend.repository.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.entity.exercise.ChemistryExerciseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChemistryExerciseDao extends JpaRepository<ChemistryExerciseEntity, Integer> {

    /**
     * 分页获取题目list
     * @param yiji 一级id
     * @param erji 二级id
     * @param pageable 可分页接口
     * @return List&lt;BiologyExerciseEntity&gt;
     */
    List<BaseExerciseEntity> findByYijiAndErji(String yiji, String erji, Pageable pageable);

    /**
     * 找一级标题list
     * @return List&lt;String&gt;
     */
    @Query(value = "SELECT yiji FROM chemistry_lib GROUP BY yiji", nativeQuery = true)
    List<String> findYijiTitleList();

    /**
     * 找二级标题list
     * @param yiji 一级标题名称
     * @return List&lt;String&gt;
     */
    @Query(value = "SELECT erji FROM chemistry_lib WHERE yiji = :yiji GROUP BY erji", nativeQuery = true)
    List<String> findErjiTitleList(@Param("yiji") String yiji);
}
