package com.eduwechat.backend.backend.repository.message;

import com.eduwechat.backend.backend.entity.message.ReplyEntity;
import com.eduwechat.backend.backend.repository.base.BaseMessageDao;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyDao extends BaseMessageDao<ReplyEntity, String> {
}
