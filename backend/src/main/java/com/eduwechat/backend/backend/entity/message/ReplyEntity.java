package com.eduwechat.backend.backend.entity.message;

import com.eduwechat.backend.backend.entity.base.BaseMessageEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@NoArgsConstructor
@Document(collection = "reply")
public class ReplyEntity extends BaseMessageEntity {

    @Id
    private String _id;

    private String name;

    private String content;

    private String time;

    public ReplyEntity(List<String> replyIdList, String _id, String name, String content, String time) {
        super(replyIdList);
        this._id = _id;
        this.name = name;
        this.content = content;
        this.time = time;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }
}
