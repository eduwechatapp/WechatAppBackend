package com.eduwechat.backend.backend.service.base.inner.message;

import com.eduwechat.backend.backend.entity.message.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageWithoutReplyAndContentResultItem {

    private String _id;

    private String createTime;

    private String title;

    private String name;

    private String location;

    private String index;

    private String type;

    /**
     * 转换留言实体到此ResultItem
     * @param entity 留言实体
     * @return MessageWithoutReplyAndContentResultItem
     */
    public static MessageWithoutReplyAndContentResultItem fromMessageEntityGetThisResultItem(MessageEntity entity) {
        return new MessageWithoutReplyAndContentResultItem(entity.get_id(),
                entity.getCreateTime(),
                entity.getTitle(),
                entity.getName(),
                entity.getLocation(),
                entity.getIndex(),
                entity.getType());
    }
}
