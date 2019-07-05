package com.eduwechat.backend.backend.service.v2.video;

import com.eduwechat.backend.backend.entity.v2.video.VideoEntity;
import com.eduwechat.backend.backend.repository.v2.video.VideoDao;
import com.eduwechat.backend.backend.service.base.inner.video.VideoWithUrlAndName;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Resource
    private VideoDao dao;

    /**
     * 得到视频url
     * @param subject 学科
     * @param page 分页页偏移
     * @param size 分页页宽
     * @return List
     */
    public List<VideoWithUrlAndName> getVideoFromSubject(String subject, Integer page, Integer size) {
        List<VideoWithUrlAndName> result = new ArrayList<>();

        for (VideoEntity entity : dao.findByType(subject, PageRequest.of(page, size))) {
            result.add(VideoWithUrlAndName.getInstanceFromEntity(entity));
        }

        return result;
    }

}
