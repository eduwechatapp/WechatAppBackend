package com.eduwechat.backend.backend.repository;

import com.eduwechat.backend.backend.entity.HighSchoolPhysics;
import com.eduwechat.backend.backend.entity.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighSchoolPhysicsRepository extends JpaRepository<HighSchoolPhysics, Integer> {

    /**
     * 根据二级标题分页查找
     * @param erji 二级标题
     * @param pageable 分页接口
     * @return Page&lt;HighSchoolBiological&gt;
     */
    Page<BaseEntity> findByErji(String erji, Pageable pageable);

    @Query(value = "select erji from gzwl where yiji = :yiji group by erji order by id", nativeQuery = true)
    List<String> findByTitleList(@Param("yiji") String yiji);
}
