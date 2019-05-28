package com.eduwechat.backend.backend.controller.base;

import net.minidev.json.JSONObject;

import java.util.Map;

public abstract class BaseMessageController {

    /**
     * 创建留言
     * @param openid openid
     * @param body body json
     * @return json
     */
    public abstract Map<String, Object> createMessage(String openid, JSONObject body);

    /**
     * 分页获取指定板块的留言列表
     * @param openid openid
     * @param type 板块名称
     * @param size 页大小
     * @param page 页宽
     * @return json
     */
    public abstract Map<String, Object> getMessageList(String openid, String type, Integer size, Integer page);

    /**
     * 获取指定某条留言详细内容
     * @param openid openid
     * @param id id
     * @return json
     */
    public abstract Map<String, Object> getMessageTextDetail(String openid, String id);

    /**
     * 获取指定某条留言的全部回复
     * @param openid openid
     * @param id id
     * @return json
     */
    public abstract Map<String, Object> getMessageReplyDetail(String openid, String id);

    /**
     * 创建某个文章的留言
     * @param openid openid
     * @param id 留言id
     * @return json
     */
    public abstract Map<String, Object> createMessageReply(String openid, String id);

    /**
     * 创建留言的留言
     * @param openid openid
     * @param id 回复id
     * @return json
     */
    public abstract Map<String, Object> createReplyReply(String openid, String id);

}
