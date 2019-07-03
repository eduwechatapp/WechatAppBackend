package com.eduwechat.backend.backend.entity.v2.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@AllArgsConstructor
@Getter
@Setter
public class UserV2Entity {
    @Id
    private String _id;

    // 业务级id
    private Long uid;

    // 微信id
    private String openid;

    // 微信昵称
    private String name;

    // 类型
    private String type;

    // 创建日期
    private String createDate;

    public UserV2Entity() {}
}
