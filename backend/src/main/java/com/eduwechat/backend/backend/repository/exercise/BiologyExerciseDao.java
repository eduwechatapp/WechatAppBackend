package com.eduwechat.backend.backend.repository.exercise;

import com.eduwechat.backend.backend.entity.exercise.BiologyExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiologyExerciseDao extends JpaRepository<BiologyExerciseEntity, Integer> {

    /**
     * 找一级标题list
     * @return List&lt;String&gt;
     */
    @Query(value = "SELECT yiji FROM math_lib GROUP BY yiji", nativeQuery = true)
    List<String> findYijiTitleList();

    /**
     * 找二级标题list
     * @param yiji 一级标题名称
     * @return List&lt;String&gt;
     */
    @Query(value = "SELECT erji FROM math_lib WHERE yiji = :yiji GROUP BY erji", nativeQuery = true)
    List<String> findErjiTitleList(@Param("yiji") String yiji);

    /**
     * 
     * @param yiji
     * @param erji
     * @return
     */
    List<BiologyExerciseEntity> findByYijiAndErji(String yiji, String erji);
}
