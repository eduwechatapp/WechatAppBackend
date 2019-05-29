package com.eduwechat.backend.backend.service.base.inner.message;

import com.eduwechat.backend.backend.entity.message.ReplyEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class ReplyWithReplyList {

    private String _id;

    private String name;

    private String content;

    private String time;

    private List<ReplyWithReplyList> reply;

    /**
     * 返回是否到达叶子节点
     * @return boolean
     */
    public boolean isLeaf() {
        return reply.size() == 0;
    }

    /**
     * 从实体得到此对象
     * @param entity 实体
     * @param reply replyList
     * @return ReplyWithReplyList
     */
    public static ReplyWithReplyList fromReplyEntityGetThisItem(ReplyEntity entity, List<ReplyWithReplyList> reply) {
        return new ReplyWithReplyList(entity.get_id(), entity.getName(), entity.getContent(), entity.getTime(), reply);
    }

    public ReplyWithReplyList(String _id, String name, String content, String time, List<ReplyWithReplyList> reply) {
        this._id = _id;
        this.name = name;
        this.content = content;
        this.time = time;
        this.reply = reply;
    }
}
