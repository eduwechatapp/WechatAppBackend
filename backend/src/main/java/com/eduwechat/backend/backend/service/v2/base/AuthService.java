package com.eduwechat.backend.backend.service.v2.base;

import com.eduwechat.backend.backend.repository.v2.user.UserV2Dao;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;

@Component
public class AuthService {

    @Resource
    private UserV2Dao dao;

    /**
     * 需要鉴权的方法使用
     * @param openid openid
     * @param uid uid
     * @return boolean
     */
    protected boolean doAuth(String openid, Long uid) {
        return dao.findByUidAndOpenid(uid, openid).size() != 0;
    }
}
