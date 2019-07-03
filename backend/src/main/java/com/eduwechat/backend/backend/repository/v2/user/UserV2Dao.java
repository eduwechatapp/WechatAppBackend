package com.eduwechat.backend.backend.repository.v2.user;

import com.eduwechat.backend.backend.entity.v2.user.UserV2Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserV2Dao extends MongoRepository<UserV2Entity, String> {

    /**
     * 根据openid 查找
     * @param openid openid
     * @return List
     */
    List<UserV2Entity> findByOpenid(String openid);

    /**
     * 根据uid 查找
     * @param uid uid
     * @return List
     */
    List<UserV2Entity> findByUid(Long uid);

    /**
     * 根据uid 和 openid 查找
     * @param uid uid
     * @param openid openid
     * @return List
     */
    List<UserV2Entity> findByUidAndOpenid(Long uid, String openid);
}
