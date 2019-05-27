package com.eduwechat.backend.backend.service.base;

import com.eduwechat.backend.backend.entity.base.BaseMessageEntity;
import com.eduwechat.backend.backend.entity.message.ReplyEntity;
import com.eduwechat.backend.backend.exceptions.message.MessageNotFoundException;
import com.eduwechat.backend.backend.exceptions.message.ReplyNotFoundException;
import com.eduwechat.backend.backend.repository.base.BaseMessageDao;
import com.eduwechat.backend.backend.repository.message.ReplyDao;
import com.eduwechat.backend.backend.service.base.inner.message.MessageWithoutReplyAndContentResultItem;
import com.eduwechat.backend.backend.service.base.inner.message.MessageWithoutReplyResultItem;
import com.eduwechat.backend.backend.utils.CommonUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BaseMessageService {

    /**
     * 创建一条留言
     * @param picIndex 图片id
     * @param type 类型
     * @param time 上传时间
     * @param location 日期
     * @param name 名字
     * @param title 标题
     * @param content 内容
     */
    public abstract void createMessage(String picIndex, String type, String time, String location, String name, String title, String content);

    /**
     * 获取指定类型的留言简列表
     * @param type 类型
     * @param size 页大小
     * @param page 页偏移
     * @return List&lt;MessageWithoutReplyAndContentResultItem&gt;
     */
    public abstract List<MessageWithoutReplyAndContentResultItem> getMessageList(String type, Integer size, Integer page);

    /**
     * 获取留言正文
     * @param id 留言id
     * @return 不带回复的留言实体
     * @throws MessageNotFoundException 留言未找到异常
     */
    public abstract MessageWithoutReplyResultItem getDetail(String id) throws MessageNotFoundException;

    /**
     * 获取某个留言下全部回复
     * @param id 留言id
     * @return 留言列表
     */
    public abstract List<ReplyEntity> getReply(String id);

    /**
     * 创建留言的回复
     * @param messageId 留言id
     * @param time 上传时间
     * @param name 用户名
     * @param content 正文
     * @throws MessageNotFoundException 留言未找到异常
     */
    public abstract void createReplyWithMessage(String messageId, String time, String name, String content) throws MessageNotFoundException;

    /**
     * 创建回复的回复
     * @param replyId 要回复的回复id
     * @param time 上传时间
     * @param name 用户名
     * @param content 正文
     * @throws MessageNotFoundException 留言未找到异常
     */
    public abstract void createReplyWithReply(String replyId, String time, String name, String content) throws ReplyNotFoundException;

    /**
     * 新生成一个reply并更新父级实体
     * @param fatherDao 父级dao
     * @param entity 自身实体引用
     * @param replyDao 自己的dao
     * @param time 创建时间
     * @param name 用户名
     * @param content 正文
     */
    protected void addIntoFatherReplyListAndSaveIntoDataSource(BaseMessageDao fatherDao, BaseMessageEntity entity, ReplyDao replyDao, String time, String name, String content) {

        // 先计算replyId
        String newReplyId = CommonUtil.getMD5(String.valueOf(new Date().getTime()));

        // 添加进父亲的回复列表中
        entity.getReplyIdList().add(newReplyId);

        // 保存父亲
        fatherDao.save(entity);

        // 保存自己
        replyDao.save(new ReplyEntity(new ArrayList<>(), newReplyId, name, content, time));
    }
}
