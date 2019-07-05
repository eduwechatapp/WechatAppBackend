package com.eduwechat.backend.backend.entity.v2.msg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "msg")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {

    @Id
    private String _id;

    // 创建时间
    private String createTime;

    // 内容
    private String content;

    // 消息类型 0-普通消息 1-结对请求
    private Integer type;

    // 阅读状态 0-未读 1-已读
    private Integer status;

    // 发送人
    private Long fromId;

    // 接收人
    private Long toId;
}
