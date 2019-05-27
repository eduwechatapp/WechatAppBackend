package com.eduwechat.backend.backend.service.base.inner.message;

import com.eduwechat.backend.backend.entity.message.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageWithoutReplyResultItem {

    private String _id;

    private String createTime;

    private String title;

    private String content;

    private String name;

    private String location;

    private Integer index;

    private String type;

    /**
     * 转换留言实体到此ResultItem
     * @param entity 留言实体
     * @return MessageWithoutReplyResultItem
     */
    public static MessageWithoutReplyResultItem fromMessageEntityGetThisResultItem(MessageEntity entity) {
        return new MessageWithoutReplyResultItem(entity.get_id(),
                entity.getCreateTime(),
                entity.getTitle(),
                entity.getContent(),
                entity.getName(),
                entity.getLocation(),
                entity.getIndex(),
                entity.getType());
    }

}
