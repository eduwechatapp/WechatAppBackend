package com.eduwechat.backend.backend.service.base.inner.article;

import com.eduwechat.backend.backend.entity.v2.msg.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class MessageWithIdAndName {

    private String _id;

    private String content;

    private String fromName;

    /**
     * 换取接口需要实体
     * @param entity 实体
     * @param fromName 请求人Name
     * @return MessageWithIdAndName
     */
    public static MessageWithIdAndName getInstanceFromEntity(Message entity, String fromName) {
        return new MessageWithIdAndName(entity.get_id(), entity.getContent(), fromName);
    }
}
