package com.eduwechat.backend.backend.service.v2.base;

import com.eduwechat.backend.backend.entity.v2.user.UserV2Entity;
import com.eduwechat.backend.backend.exceptions.auth.NoSuchUserException;
import com.eduwechat.backend.backend.exceptions.auth.TypeErrorException;
import com.eduwechat.backend.backend.repository.v2.user.UserV2Dao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AuthService {

    @Resource
    private UserV2Dao dao;

    /**
     * 鉴权
     * @param openid openid
     * @param uid uid
     * @param shouldType 应该的类型
     * @throws NoSuchUserException openid或uid错误
     * @throws TypeErrorException 用户类型有误
     */
    public void auth(String openid, Long uid, String shouldType) throws NoSuchUserException, TypeErrorException {
        switch (this.doAuth(openid, uid, shouldType)) {
            case 1:
                throw new NoSuchUserException("openid或uid不存在或不正确");
            case 2:
                throw new TypeErrorException("用户类型有误");
        }
    }

    /**
     * 需要鉴权的方法使用
     * @param openid openid
     * @param uid uid
     * @param shouldType 应该的类型
     * @return int 0-true 1-openid uid error 2-类型错误
     */
    private int doAuth(String openid, Long uid, String shouldType) {

        List<UserV2Entity> r  = dao.findByUidAndOpenid(uid, openid);

        if (r.size() == 0) {
            return 1;
        }

        if (!r.get(0).getType().equals(shouldType)) {
            return 2;
        }

        return 0;
    }

}
