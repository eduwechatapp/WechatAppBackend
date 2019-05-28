package com.eduwechat.backend.backend.repository.base;

import com.eduwechat.backend.backend.entity.base.BaseCommonEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseCommonRepository<TD, I> extends JpaRepository<TD, I> {

    /**
     * 根据二级标题和标题返回查询结果
     * @param title 标题
     * @return Optional&lt;BaseCommonEntity&gt;
     */
    List<BaseCommonEntity> findByTitle(String title);
}
