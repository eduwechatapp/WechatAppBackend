package com.eduwechat.backend.backend.service.v2.user;

import com.eduwechat.backend.backend.entity.v2.user.CoupleSet;
import com.eduwechat.backend.backend.entity.v2.user.UserV2Entity;
import com.eduwechat.backend.backend.exceptions.user.UserAlreadyRegisterException;
import com.eduwechat.backend.backend.exceptions.user.UserDidNotRegisterException;
import com.eduwechat.backend.backend.exceptions.user.UserTypeNotSupportException;
import com.eduwechat.backend.backend.repository.v2.user.UserV2Dao;
import com.eduwechat.backend.backend.utils.CommonUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserV2Service {

    @Resource
    private UserV2Dao userV2Dao;

    /**
     * 注册
     * @param openid openid
     * @param type 用户类型
     * @param name 昵称
     * @return Long uid
     * @throws UserAlreadyRegisterException 用户已经注册
     * @throws UserTypeNotSupportException 用户类型不正确
     */
    public Long register(String openid, String type, String name, String url) throws UserAlreadyRegisterException, UserTypeNotSupportException {
        List<UserV2Entity> list = userV2Dao.findByOpenid(openid);

        // 设置头像url
        if (url == null) {
            url = "https://vaskka.com/static/avatar.jpeg";
        }

        // 检查注册情况
        if (list.size() != 0) {
            throw new UserAlreadyRegisterException("用户已经注册");
        }

        // 检查type
        if (!type.equals("volunteer") && !type.equals("student")) {
            throw new UserTypeNotSupportException("用户类型有误，只能为volunteer或者student");
        }

        // 生成uid
        long uid = getUID();

        // 插入新用户
        UserV2Entity entity = new UserV2Entity(CommonUtil.getUniqueId(), uid, openid, name, url, type, new CoupleSet(-1L, ""),CommonUtil.getNowDate());
        userV2Dao.insert(entity);

        return uid;
    }

    /**
     * 登录 返回uid
     * @param openid openid
     * @return UserV2Entity
     * @throws UserDidNotRegisterException 用户未注册
     */
    public UserV2Entity login(String openid) throws UserDidNotRegisterException {
        List<UserV2Entity> r = userV2Dao.findByOpenid(openid);

        if (r.size() == 0) {
            throw new UserDidNotRegisterException("用户还没注册");
        }

        return r.get(0);
    }


    /**
     * 随机获取全局唯一长整性uid
     * @return long
     */
    private long getUID() {
        int k = 5;
        long curr = Math.abs(CommonUtil.rand() % ((long) Math.pow(10, k)));

        int count = 0;
        while (checkUidRedundancy(curr)) {
            // 6次找不到扩展位数
            if (count > 5) {
                count = 0;
                k++;
            }
            curr  = Math.abs(CommonUtil.rand() % ((long) Math.pow(10, k)));
            count ++;
        }

        return curr;
    }

    /**
     * 是否uid重复
     * @param uid uid
     * @return boolean
     */
    private boolean checkUidRedundancy(long uid) {
        return userV2Dao.findByUid(uid).size() != 0;
    }
}
