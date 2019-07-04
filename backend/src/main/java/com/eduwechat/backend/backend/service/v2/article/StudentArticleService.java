package com.eduwechat.backend.backend.service.v2.article;

import com.eduwechat.backend.backend.entity.v2.article.StudentArticle;
import com.eduwechat.backend.backend.entity.v2.article.ArticleReply;
import com.eduwechat.backend.backend.entity.v2.msg.Message;
import com.eduwechat.backend.backend.entity.v2.user.UserV2Entity;
import com.eduwechat.backend.backend.exceptions.auth.AuthException;
import com.eduwechat.backend.backend.exceptions.auth.NoSuchUserException;
import com.eduwechat.backend.backend.exceptions.auth.TypeErrorException;
import com.eduwechat.backend.backend.exceptions.base.ApplicationLevelException;
import com.eduwechat.backend.backend.exceptions.base.ThirdPartException;
import com.eduwechat.backend.backend.repository.v2.article.StudentArticleDao;
import com.eduwechat.backend.backend.repository.v2.msg.MessageDao;
import com.eduwechat.backend.backend.repository.v2.user.UserV2Dao;
import com.eduwechat.backend.backend.service.base.inner.article.UserWithUidAndName;
import com.eduwechat.backend.backend.service.base.inner.article.UserWithUidAndNameAndTime;
import com.eduwechat.backend.backend.service.v2.base.AuthService;
import com.eduwechat.backend.backend.utils.CommonUtil;
import com.eduwechat.backend.backend.utils.cos.COSUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentArticleService extends AuthService {

    @Resource
    private StudentArticleDao dao;

    @Resource
    private UserV2Dao userV2Dao;

    @Resource
    private MessageDao messageDao;

    /**
     * 上传作文图片
     * @param openid id
     * @param uid 创建者uid
     * @param fileInputStream 文件输入流
     * @param fileName 文件名
     * @throws NoSuchUserException 用户不存在
     * @throws TypeErrorException 用户类型有误
     * @throws ThirdPartException 第三方(COS)异常
     */
    public void upload(String openid, Long uid, InputStream fileInputStream, String fileName) throws ThirdPartException, NoSuchUserException, TypeErrorException {

        this.auth(openid, uid, "student");

        String fileType = CommonUtil.fromNameGetType(fileName);
        String key = CommonUtil.getUniqueId().substring(16) + "-" + CommonUtil.getNowTime() + "." + fileType;

        String _id = CommonUtil.getUniqueId();
        String createtime = CommonUtil.getNowTime();

        // upload
        try {
            COSUtil.uploadWithInputStream(fileInputStream, key);
        } catch (IOException e) {
            throw new ThirdPartException("COS exception:" + e.getMessage());
        }

        dao.save(new StudentArticle(_id, uid, key, new ArrayList<>(), createtime));
    }

    /**
     * 得到全部的志愿者信息
     * @param openid openid
     * @param uid uid
     * @return List
     * @throws AuthException 鉴权异常
     */
    public List<UserWithUidAndName> getAllVolunteer(String openid, Long uid) throws AuthException {

        this.auth(openid, uid, "student");

        List<UserWithUidAndName> result = new ArrayList<>();
        List<UserV2Entity> allVolunteersFull = userV2Dao.findByType("volunteer");

        for (UserV2Entity entity : allVolunteersFull) {
            result.add(UserWithUidAndName.fromUserV2EntityGetThis(entity));
        }

        return result;
    }

    /**
     * 学生发送结对请求
     * @param openid openid
     * @param uid uid
     * @param vuid 志愿者uid
     * @throws NoSuchUserException openid uid 不存在
     * @throws TypeErrorException 类型不正确
     * @throws ApplicationLevelException 该同学已经结对
     */
    public void couple(String openid, Long uid, Long vuid) throws NoSuchUserException, TypeErrorException, ApplicationLevelException {

        this.auth(openid, uid, "student");

        UserV2Entity stu =  userV2Dao.findByUid(uid).get(0);
        Long coupleId = stu.getCouple().getCuid();

        if (coupleId != -1) {
            throw new ApplicationLevelException("该同学已经结对") {
                @Override
                public Integer getErrorCode() {
                    return 10001;
                }
            };
        }

        // 检查是否已经发过请求
        List<Message> r = messageDao.findByFromidAndToidAndStatusAndType(uid, vuid, 0, 1);
        if (r.size() > 0) {
            throw new ApplicationLevelException("您已经发送过请求，请耐心等待") {
                @Override
                public Integer getErrorCode() {
                    return 10003;
                }
            };
        }

        Message msg = new Message(CommonUtil.getUniqueId(), CommonUtil.getNowTime(), String.format("学生:%s向您发送了结对请求。", stu.getName()), 1, 0, uid, vuid);

        messageDao.save(msg);
    }

    /**
     * 查找我的结对志愿者
     * @param openid openid
     * @param uid uid
     * @return UserWithUidAndNameAndTime
     * @throws NoSuchUserException openid uid 不存在
     * @throws TypeErrorException 类型不正确
     * @throws ApplicationLevelException 学生未结对
     */
    public UserWithUidAndNameAndTime getMyCouple(String openid, Long uid) throws NoSuchUserException, TypeErrorException, ApplicationLevelException {

        this.auth(openid, uid, "student");

        UserV2Entity entity = userV2Dao.findByUid(uid).get(0);

        if (entity.getCouple().getCuid() == -1) {
            throw new ApplicationLevelException("该学生还未结对") {
                @Override
                public Integer getErrorCode() {
                    return 10002;
                }
            };
        }

        return UserWithUidAndNameAndTime.getInstanceFromUserV2Entity(entity);
    }


    /**
     * 获取我的作文
     * @param openid openid
     * @param uid uid
     * @return List
     * @throws NoSuchUserException openid uid 不存在
     * @throws TypeErrorException 类型不正确
     */
    public List<StudentArticle> getMyArticle(String openid, Long uid, Integer page, Integer size) throws NoSuchUserException, TypeErrorException {

        this.auth(openid, uid, "student");

        return dao.findByCreator(uid, PageRequest.of(page, size));
    }

}
