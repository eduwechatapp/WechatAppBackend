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
    @Query(value = "update user set skey = :skey, session_key = :session where openid= :openid", nativeQuery = true)
    void updateSkeyByOpenID(@Param("openid") String OpenID, @Param("skey") String skey, @Param("session") String session);

    @Modifying
    @Query(value = "insert into user(openid,session_key,skey) values (:openid, :session, :skey)", nativeQuery = true)
    void insertOpenIDAndSkey(@Param("openid") String OpenID,@Param("session") String session, @Param("skey") String skey);

    @Query(value = "select openid from user where openid = :openid", nativeQuery = true)
    List<String> findUserByOpenID(@Param("openid") String OpenID);

    @Query(value = "select openid from user where skey = :skey", nativeQuery = true)
    List<String> getOpenIdBySkey(@Param("skey")String Skey);

    @Query(value = "select subject from user where skey = :skey", nativeQuery = true)
    List<String> getSubjectBySkey(@Param("skey")String Skey);

    @Query(value = "select grade from user where skey = :skey", nativeQuery = true)
    List<Integer> getGradeBySkey(@Param("skey")String Skey);

}
