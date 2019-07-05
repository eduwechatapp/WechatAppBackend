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
public class UserWithUidAndNameAndTime {
    private Long uid;

    private String name;

    private String createDate;

    /**
     * 实体转this
     * @param entity entity
     * @return UserWithUidAndNameAndTime
     */
    public static UserWithUidAndNameAndTime getInstanceFromUserV2Entity(UserV2Entity entity) {
        return new UserWithUidAndNameAndTime(entity.getUid(), entity.getName(), entity.getCouple().getCreateDate());
    }
}
