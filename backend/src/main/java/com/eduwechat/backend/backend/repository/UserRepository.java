package com.eduwechat.backend.backend.repository;

import com.eduwechat.backend.backend.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by H on 2019/5/22.
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "update user set skey = :skey where openid= :openid", nativeQuery = true)
    void updateSkeyByOpenID(@Param("openid") String OpenID, @Param("skey") String skey);

    @Modifying
    @Query(value = "insert into user(openid, skey) values (':openid', ':skey')", nativeQuery = true)
    void insertOpenIDAndSkey(@Param("openid") String OpenID, @Param("skey") String skey);

    @Query(value = "select openid from user where openid = :openid", nativeQuery = true)
    List<String> findUserByOpenID(@Param("openid") String OpenID);

}
