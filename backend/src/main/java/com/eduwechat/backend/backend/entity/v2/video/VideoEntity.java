package com.eduwechat.backend.backend.entity.v2.video;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "video")
public class VideoEntity {
    @Id
    private String _id;

    private String url;

    private String type;

    private String name;

    private String createTime;

    public VideoEntity() {}
}
