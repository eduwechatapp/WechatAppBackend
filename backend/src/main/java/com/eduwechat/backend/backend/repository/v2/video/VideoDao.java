package com.eduwechat.backend.backend.repository.v2.video;

import com.eduwechat.backend.backend.entity.v2.video.VideoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoDao extends MongoRepository<VideoEntity, String> {

    /**
     * 根据分页拿视频
     * @param type 学科
     * @param pageable pageable
     * @return List
     */
    List<VideoEntity> findByType(String type, Pageable pageable);
}
