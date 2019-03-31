package com.eduwechat.backend.backend.repository;

import com.eduwechat.backend.backend.entity.HighSchoolChinese;
import com.eduwechat.backend.backend.entity.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighSchoolChineseRepository extends JpaRepository<HighSchoolChinese, Integer> {
    /**
     * 根据二级标题分页查找
     * @param erji 二级标题
     * @param pageable 分页接口
     * @return Page&lt;HighSchoolBiological&gt;
     */
    Page<BaseEntity> findByErji(String erji, Pageable pageable);
}
