package com.eduwechat.backend.backend.repository.search;

import com.eduwechat.backend.backend.entity.HighSchoolBiological;
import com.eduwechat.backend.backend.entity.base.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighSchoolBiologicalSearchDao extends ElasticsearchRepository<HighSchoolBiological, Integer> {

    /**
     * 标题内容二级标题全搜索
     * @param title 标题搜索关键字
     * @param content 正文搜索关键字
     * @param erji 二级标题搜索关键字
     * @param pageable 可分页接口
     * @return Page对象
     */
    Page<BaseEntity> findByTitleLikeOrContentLikeOrErjiLike(String title, String content, String erji, Pageable pageable);

    /**
     * 标题和内容双选搜索
     * @param title 标题搜索关键字
     * @param content 内容搜索关键字
     * @param pageable 可分页接口
     * @return Page对象
     */
    Page<BaseEntity> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);

    /**
     * 只根据内容检索
     * @param content 内容搜索关键字
     * @param pageable 可分页接口
     * @return Page对象
     */
    Page<BaseEntity> findByContentLike(String content,Pageable pageable);

    /**
     * 只根据标题检索
     * @param title 标题搜索关键字
     * @param pageable 可分页接口
     * @return Page对象
     */
    Page<BaseEntity> findByTitleLike(String title,Pageable pageable);

    /**
     * 只根据二级标题检索
     * @param erji 二级标题搜索关键字
     * @param pageable 可分页接口
     * @return Page对象
     */
    Page<BaseEntity> findByErjiLike(String erji,Pageable pageable);
}
