package com.eduwechat.backend.backend.service.v2.article;

import com.eduwechat.backend.backend.entity.v2.article.ArticleReply;
import com.eduwechat.backend.backend.entity.v2.article.StudentArticle;
import com.eduwechat.backend.backend.entity.v2.msg.Message;
import com.eduwechat.backend.backend.entity.v2.user.UserV2Entity;
import com.eduwechat.backend.backend.exceptions.auth.NoSuchUserException;
import com.eduwechat.backend.backend.exceptions.auth.TypeErrorException;
import com.eduwechat.backend.backend.exceptions.base.ApplicationLevelException;
import com.eduwechat.backend.backend.repository.v2.article.StudentArticleDao;
import com.eduwechat.backend.backend.repository.v2.msg.MessageDao;
import com.eduwechat.backend.backend.repository.v2.user.UserV2Dao;
import com.eduwechat.backend.backend.service.base.inner.article.ArticleWithUrl;
import com.eduwechat.backend.backend.service.base.inner.article.UserWithUidAndNameAndTime;
import com.eduwechat.backend.backend.service.v2.base.AuthService;
import com.eduwechat.backend.backend.utils.CommonUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VolunteerArticleService extends AuthService {

    @Resource
    private MessageDao messageDao;

    @Resource
    private UserV2Dao userV2Dao;

    @Resource
    private StudentArticleDao studentArticleDao;

    /**
     * 获取未读的结对请求
     * @param openid openid
     * @param uid uid
     * @return List
     * @throws NoSuchUserException 用户不存在
     * @throws TypeErrorException 用户类型有误
     */
    public List<Message> getCoupleMsg(String openid, Long uid) throws NoSuchUserException, TypeErrorException {
        this.auth(openid, uid, "volunteer");

        // 获取未读的结对请求
        return messageDao.findByStatusAndTypeAndToid(0, 1, uid);
    }

    /**
     * 确认消息
     * @param openid openid
     * @param uid uid
     * @param mid mid message_id
     * @throws NoSuchUserException 用户不存在
     * @throws TypeErrorException 用户类型有误
     * @throws ApplicationLevelException 消息未找到
     */
    public void confirmCoupleMessage(String openid, Long uid, String mid) throws NoSuchUserException, TypeErrorException, ApplicationLevelException {

        Message msg = this.authAndGetMessage(openid, uid, mid);

        Long from = msg.getFromId();
        Long to = msg.getToId();

        msg.setStatus(1);
        messageDao.save(msg);

        // 为用户指定couple
        UserV2Entity fromUser = userV2Dao.findByUid(from).get(0);
        UserV2Entity toUser = userV2Dao.findByUid(to).get(0);
        fromUser.getCouple().setCuid(to);
        fromUser.getCouple().setCreateDate(CommonUtil.getNowDate());
        toUser.getCouple().setCuid(from);
        fromUser.getCouple().setCreateDate(CommonUtil.getNowDate());

        userV2Dao.save(fromUser);
        userV2Dao.save(toUser);
    }

    /**
     * 否认消息
     * @param openid openid
     * @param uid uid
     * @param mid mid message_id
     * @throws NoSuchUserException 用户不存在
     * @throws TypeErrorException 用户类型有误
     * @throws ApplicationLevelException 消息未找到
     */
    public void cancelCoupleMessage(String openid, Long uid, String mid) throws NoSuchUserException, TypeErrorException, ApplicationLevelException {

        Message msg = this.authAndGetMessage(openid, uid, mid);
        msg.setStatus(1);
        messageDao.save(msg);
    }

    /**
     * 得到我的结对信息
     * @param openid openid
     * @param uid uid
     * @return UserWithUidAndNameAndTime
     * @throws NoSuchUserException 用户不存在
     * @throws TypeErrorException 用户类型有误
     * @throws ApplicationLevelException 未结对
     */
    public UserWithUidAndNameAndTime getMyCouple(String openid, Long uid) throws NoSuchUserException, TypeErrorException, ApplicationLevelException {
        this.auth(openid, uid, "volunteer");

        UserV2Entity entity = userV2Dao.findByUid(uid).get(0);

        if (entity.getCouple().getCuid() == -1) {
            throw new ApplicationLevelException("您还未结对") {
                @Override
                public Integer getErrorCode() {
                    return 20002;
                }
            };
        }

        return UserWithUidAndNameAndTime.getInstanceFromUserV2Entity(entity);
    }

    /**
     * 获取学生作文
     * @param openid openid
     * @param uid uid
     * @param sid sid
     * @param page page
     * @param size size
     * @return List
     * @throws NoSuchUserException 用户不存在
     * @throws TypeErrorException 用户类型有误
     */
    public List<ArticleWithUrl> getStudentArticles(String openid, Long uid, Long sid, Integer page, Integer size) throws NoSuchUserException, TypeErrorException {
        this.auth(openid, uid, "volunteer");

        List<StudentArticle> r = studentArticleDao.findByCreator(sid, PageRequest.of(page, size));
        List<ArticleWithUrl> result = new ArrayList<>();

        // 转换实体表示形式
        for (StudentArticle article : r) {
            result.add(ArticleWithUrl.getInstanceFromEntity(article));
        }

        return result;
    }

    /**
     * 批改作文
     * @param openid openid
     * @param uid uid
     * @param aid aid
     * @param content content
     * @throws NoSuchUserException 用户不存在
     * @throws TypeErrorException 用户类型有误
     * @throws ApplicationLevelException 文章不存在
     */
    public void mark(String openid, Long uid, String aid, String content) throws NoSuchUserException, TypeErrorException, ApplicationLevelException {
        this.auth(openid, uid, "volunteer");

        Optional<StudentArticle> articleOptional = studentArticleDao.findById(aid);
        if (!articleOptional.isPresent()) {
            throw new ApplicationLevelException("文章不存在") {
                @Override
                public Integer getErrorCode() {
                    return 20003;
                }
            };
        }

        StudentArticle article = articleOptional.get();
        ArticleReply reply = new ArticleReply(uid, content, CommonUtil.getNowTime());
        article.getReplys().add(reply);
        studentArticleDao.save(article);
    }

    /**
     * 鉴权并查找消息
     * @param openid openid
     * @param uid uid
     * @param mid mid
     * @return Message
     * @throws NoSuchUserException 用户不存在
     * @throws TypeErrorException 用户类型有误
     * @throws ApplicationLevelException 消息未找到
     */
    private Message authAndGetMessage(String openid, Long uid, String mid) throws ApplicationLevelException, NoSuchUserException, TypeErrorException {
        this.auth(openid, uid, "volunteer");

        Optional<Message> op = messageDao.findById(mid);

        if (!op.isPresent()) {
            throw new ApplicationLevelException("消息未找到") {
                @Override
                public Integer getErrorCode() {
                    return 20001;
                }
            };
        }

        return op.get();
    }

}
