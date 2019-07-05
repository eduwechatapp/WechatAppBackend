package com.eduwechat.backend.backend.repository.v2.msg;

import com.eduwechat.backend.backend.entity.v2.msg.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsgDao extends MongoRepository<Message, String> {

    List<Message> findByType(Integer type);

    List<Message> findByStatus(Integer status);

    List<Message> findByStatusAndTypeAndToId(Integer status, Integer type, Long toId);

    List<Message> findByFromIdAndToIdAndStatusAndType(Long fromId, Long toId, Integer status, Integer type);
}
