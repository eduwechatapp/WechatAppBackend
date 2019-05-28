package com.eduwechat.backend.backend.repository;

import com.eduwechat.backend.backend.entity.savaInfo.UserClickInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by H on 2019/5/27.
 */
@Transactional
public interface UserClickInfoRepository extends JpaRepository<UserClickInfo, Long>{
    @Modifying
    @Query(value = "insert into userclickinfo(openid,type,content) values (:openid, :type, :content)", nativeQuery = true)
    void insertInfo(@Param("openid") String OpenID, @Param("type") int type, @Param("content") String content);

    @Query(value = "select type from userclickinfo where openid = :openid", nativeQuery = true)
    List<Integer> getInfoTypeByOpenId(@Param("openid") String OpenId);

    @Query(value = "select content from userclickinfo where openid = :openid", nativeQuery = true)
    List<String> getInfoContentByOpenId(@Param("openid") String OpenId);

}
