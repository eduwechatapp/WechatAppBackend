package com.eduwechat.backend.backend.repository.v2.msg;

import com.eduwechat.backend.backend.entity.v2.msg.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageDao extends MongoRepository<Message, String> {

    List<Message> findByType(Integer type);

    List<Message> findByStatus(Integer status);

    List<Message> findByStatusAndTypeAndToid(Integer status, Integer type, Long toId);

    List<Message> findByFromidAndToidAndStatusAndType(Long fromId, Long toId, Integer status, Integer type);
}
