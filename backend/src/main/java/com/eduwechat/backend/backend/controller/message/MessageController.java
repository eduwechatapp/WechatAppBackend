package com.eduwechat.backend.backend.controller.message;

import com.eduwechat.backend.backend.controller.base.BaseMessageController;
import com.eduwechat.backend.backend.exceptions.message.MessageNotFoundException;
import com.eduwechat.backend.backend.service.message.MessageService;
import io.swagger.annotations.Api;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api(description = "留言接口")
@RequestMapping(value = "/message")
public class MessageController extends BaseMessageController {

    @Autowired
    private MessageService service;

    /**
     * 创建留言
     * @param openid openid
     * @param body body json
     * @return json
     */
    @Override
    public Map<String, Object> createMessage(String openid, JSONObject body) {

        Map<String, Object> map = new HashMap<>();

        // 取json字段
        Integer index = Integer.valueOf(body.get("index").toString());
        String type = body.get("type").toString();
        String time = body.get("time").toString();
        String location = body.get("location").toString();
        String name = body.get("name").toString();
        String title = body.get("title").toString();
        String content = body.get("content").toString();

        service.createMessage(index, type, time, location, name, title, content);

        map.put("code", 0);
        map.put("msg", "success");

        return map;
    }

    /**
     * 分页获取指定板块的留言列表
     * @param openid openid
     * @param type 板块名称
     * @param size 页大小
     * @param page 页宽
     * @return json
     */
    @Override
    public Map<String, Object> getMessageList(String openid, String type, Integer size, Integer page) {

        Map<String, Object> map = new HashMap<>();

        map.put("data", service.getMessageList(type, size, page));
        map.put("code", 0);
        map.put("msg", "success");

        return map;
    }

    /**
     * 获取指定某条留言详细内容
     * @param openid openid
     * @param id id
     * @return json
     */
    @Override
    public Map<String, Object> getMessageTextDetail(String openid, String id) {
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", service.getDetail(id));
            map.put("code", 0);
            map.put("msg", "success");
        } catch (MessageNotFoundException e) {
            map.put("data", null);
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        }


        return map;
    }

    /**
     * 获取指定某条留言的全部回复
     * @param openid openid
     * @param id id
     * @return json
     */
    @Override
    public Map<String, Object> getMessageReplyDetail(String openid, String id) {
        return null;
    }

    /**
     * 创建某个文章的留言
     * @param openid openid
     * @param id 留言id
     * @return json
     */
    @Override
    public Map<String, Object> createMessageReply(String openid, String id) {
        return null;
    }

    /**
     * 创建留言的留言
     * @param openid openid
     * @param id 回复id
     * @return json
     */
    @Override
    public Map<String, Object> createReplyReply(String openid, String id) {
        return null;
    }
}
