package com.eduwechat.backend.backend.repository.common;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import com.eduwechat.backend.backend.entity.common.HighSchoolEnglish;
import com.eduwechat.backend.backend.repository.base.BaseCommonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighSchoolEnglishRepository extends BaseCommonRepository<HighSchoolEnglish, Integer> {
    /**
     * 根据二级标题分页查找
     * @param erji 二级标题
     * @param pageable 分页接口
     * @return Page&lt;HighSchoolBiological&gt;
     */
    Page<BaseCommonEntity> findByErji(String erji, Pageable pageable);

    @Query(value = "select erji from gzyy where yiji = :yiji group by erji order by id", nativeQuery = true)
    List<String> findByTitleList(@Param("yiji") String yiji);

    /* search api */

    Page<BaseCommonEntity> findByTitleContainingOrContentContainingOrErjiContaining(String title, String content, String erji, Pageable pageable);

    Page<BaseCommonEntity> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);

    Page<BaseCommonEntity> findByTitleContaining(String title, Pageable pageable);

    Page<BaseCommonEntity> findByContentContaining(String content, Pageable pageable);

    Page<BaseCommonEntity> findByErjiContaining(String erji, Pageable pageable);
}
