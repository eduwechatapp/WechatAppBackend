package com.eduwechat.backend.backend.service.base.inner.video;

import com.eduwechat.backend.backend.entity.v2.video.VideoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class VideoWithUrlAndName {
    private String url;

    private String name;

    /**
     * 得到实体，url后会补充.mp4后缀
     * @param entity 标准实体
     * @return 需要的实体
     */
    public static VideoWithUrlAndName getInstanceFromEntity(VideoEntity entity) {
        return new VideoWithUrlAndName(entity.getUrl() + ".mp4", entity.getName());
    }
}
