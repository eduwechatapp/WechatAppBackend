package com.eduwechat.backend.backend.service.message;

import com.eduwechat.backend.backend.entity.message.MessageEntity;
import com.eduwechat.backend.backend.entity.message.ReplyEntity;
import com.eduwechat.backend.backend.exceptions.message.MessageNotFoundException;
import com.eduwechat.backend.backend.exceptions.message.ReplyNotFoundException;
import com.eduwechat.backend.backend.repository.message.MessageDao;
import com.eduwechat.backend.backend.repository.message.ReplyDao;
import com.eduwechat.backend.backend.service.base.BaseMessageService;
import com.eduwechat.backend.backend.service.base.inner.message.MessageWithoutReplyAndContentResultItem;
import com.eduwechat.backend.backend.service.base.inner.message.MessageWithoutReplyResultItem;
import com.eduwechat.backend.backend.service.base.inner.message.ReplyWithReplyList;
import com.eduwechat.backend.backend.utils.CommonUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService extends BaseMessageService {

    private MessageDao messageDao;

    private ReplyDao replyDao;

    /**
     * 创建留言
     * @param picIndex 图片id
     * @param type 类型
     * @param time 上传时间
     * @param location 日期
     * @param name 名字
     * @param title 标题
     * @param content 内容
     */
    @Override
    public void createMessage(Integer picIndex, String type, String time, String location, String name, String title, String content) {
        MessageEntity newEntity = new MessageEntity(new ArrayList<>(), CommonUtil.getMD5(String.valueOf(new Date().getTime())),
                time,
                title,
                content,
                name,
                location,
                picIndex,
                type);

        messageDao.save(newEntity);
    }

    /**
     * 得到留言列表
     * @param type 类型
     * @param size 页大小
     * @param page 页偏移
     * @return List&lt;MessageWithoutReplyAndContentResultItem&gt;
     */
    @Override
    public List<MessageWithoutReplyAndContentResultItem> getMessageList(String type, Integer size, Integer page) {
        List<MessageEntity> rawList = messageDao.findByType(type, PageRequest.of(page, size));

        // 剔除不需要字段
        List<MessageWithoutReplyAndContentResultItem> resultItemList = new ArrayList<>(rawList.size());
        for (MessageEntity item : rawList) {
            resultItemList.add(MessageWithoutReplyAndContentResultItem.fromMessageEntityGetThisResultItem(item));
        }

        return resultItemList;
    }

    /**
     * 获取留言详细内容（无回复）
     * @param id 留言id
     * @return MessageWithoutReplyResultItem
     * @throws MessageNotFoundException 留言未找到异常
     */
    @Override
    public MessageWithoutReplyResultItem getDetail(String id) throws MessageNotFoundException {
        Optional<MessageEntity> rawEntity = messageDao.findById(id);

        return rawEntity.map(MessageWithoutReplyResultItem::fromMessageEntityGetThisResultItem).orElseThrow(() -> new MessageNotFoundException("留言未找到", id));
    }

    /**
     * 获取某个留言的全部回复
     * @param id 留言id
     * @return List&lt;ReplyEntity&gt;
     */
    @Override
    public List<ReplyWithReplyList> getReply(String id) throws MessageNotFoundException {
        MessageEntity root = messageDao.findById(id).orElseThrow(() -> new MessageNotFoundException("留言未找到", id));

        // 递归展开根节点下全部回复
        return this.fromReplyIdListGetResultList(replyDao, root.getReplyIdList());
    }

    /**
     * 创建留言的回复
     * @param messageId 留言id
     * @param time 上传时间
     * @param name 用户名
     * @param content 正文
     * @throws MessageNotFoundException 留言未找到
     */
    @Override
    public void createReplyWithMessage(String messageId, String time, String name, String content) throws MessageNotFoundException {

        MessageEntity messageEntity = messageDao.findById(messageId).orElseThrow(() -> new MessageNotFoundException("留言未找到", messageId));

        // 更新父亲和自身
        this.addIntoFatherReplyListAndSaveIntoDataSource(messageDao, messageEntity, replyDao, time, name, content);
    }

    /**
     * 创建回复的回复
     * @param replyId 要回复的回复id
     * @param time 上传时间
     * @param name 用户名
     * @param content 正文
     * @throws ReplyNotFoundException 回复未找到
     */
    @Override
    public void createReplyWithReply(String replyId, String time, String name, String content) throws ReplyNotFoundException {
        ReplyEntity replyEntity = replyDao.findById(replyId).orElseThrow(() -> new ReplyNotFoundException("回复未找到", replyId));

        // 更新父亲和自身
        this.addIntoFatherReplyListAndSaveIntoDataSource(replyDao, replyEntity, replyDao, time, name, content);
    }
}
