package com.eduwechat.backend.backend.entity.message;


import com.eduwechat.backend.backend.entity.base.BaseMessageEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "message")
public class MessageEntity extends BaseMessageEntity {

    @Id
    private String _id;

    private String createTime;

    private String title;

    private String content;

    private String name;

    private String location;

    private Integer index;

    private String type;

    public MessageEntity(List<String> replyIdList, String _id, String createTime, String title, String content, String name, String location, Integer index, String type) {
        super(replyIdList);
        this._id = _id;
        this.createTime = createTime;
        this.title = title;
        this.content = content;
        this.name = name;
        this.location = location;
        this.index = index;
        this.type = type;
    }
}
