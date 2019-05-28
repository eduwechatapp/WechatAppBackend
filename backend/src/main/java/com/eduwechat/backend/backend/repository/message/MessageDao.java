package com.eduwechat.backend.backend.repository.message;

import com.eduwechat.backend.backend.entity.message.MessageEntity;
import com.eduwechat.backend.backend.repository.base.BaseMessageDao;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao extends BaseMessageDao<MessageEntity, String> {

    /**
     * 根据类型获取留言
     * @param type 类型
     * @param pageable 分页接口
     * @return 留言实体列表
     */
    List<MessageEntity> findByType(String type, Pageable pageable);
}
