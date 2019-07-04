package com.eduwechat.backend.backend.service.base.inner.article;

import com.eduwechat.backend.backend.entity.v2.user.UserV2Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserWithUidAndName {
    private Long uid;

    private String name;

    /**
     * 实体转this
     * @param entity UserV2Entity
     * @return UserWithUidAndName
     */
    public static UserWithUidAndName fromUserV2EntityGetThis(UserV2Entity entity) {
        return new UserWithUidAndName(entity.getUid(), entity.getName());
    }
}
