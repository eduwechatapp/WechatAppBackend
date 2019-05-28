package com.eduwechat.backend.backend.controller.message;

import com.eduwechat.backend.backend.controller.base.BaseMessageController;
import com.eduwechat.backend.backend.exceptions.message.MessageNotFoundException;
import com.eduwechat.backend.backend.exceptions.message.ReplyNotFoundException;
import com.eduwechat.backend.backend.service.message.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "创建留言" ,  notes="创建留言")
    @ResponseBody
    @PostMapping("/create/{openid}")
    public Map<String, Object> createMessage(@PathVariable(value = "openid") String openid,
                                             @RequestBody JSONObject body) {

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
    @ApiOperation(value = "分页获取指定板块的留言列表" ,  notes="分页获取指定板块的留言列表")
    @ResponseBody
    @GetMapping("/get/{openid}/{type}/{number_every_page}/{page_offset}")
    public Map<String, Object> getMessageList(@PathVariable(value = "openid") String openid,
                                              @PathVariable(value = "type") String type,
                                              @PathVariable(value = "number_every_page") Integer size,
                                              @PathVariable(value = "page_offset") Integer page) {

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
    @ApiOperation(value = "获取指定某条留言详细内容" ,  notes="获取指定某条留言详细内容")
    @ResponseBody
    @GetMapping("/detail/{openid}/{id}")
    public Map<String, Object> getMessageTextDetail(@PathVariable(value = "openid") String openid,
                                                    @PathVariable(value = "id") String id) {
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
    @ApiOperation(value = "获取指定某条留言的全部回复" ,  notes="获取指定某条留言的全部回复")
    @ResponseBody
    @GetMapping("/reply/get/{openid}/{id}")
    public Map<String, Object> getMessageReplyDetail(@PathVariable(value = "openid") String openid,
                                                     @PathVariable(value = "id") String id) {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("data", service.getReply(id));
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
     * 创建某个文章的留言
     * @param openid openid
     * @param id 留言id
     * @return json
     */
    @Override
    @ApiOperation(value = "创建某个文章的留言" ,  notes="创建某个文章的留言")
    @ResponseBody
    @PostMapping("/reply/create/message/{openid}/{message_id}")
    public Map<String, Object> createMessageReply(@PathVariable(value = "openid") String openid,
                                                  @PathVariable(value = "message_id") String id,
                                                  @RequestBody JSONObject body) {
        Map<String, Object> map = new HashMap<>();

        try {
            service.createReplyWithMessage(id,  body.get("time").toString(), body.get("name").toString(), body.get("content").toString());
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
     * 创建留言的留言
     * @param openid openid
     * @param id 回复id
     * @return json
     */
    @Override
    @ApiOperation(value = "创建留言的留言" ,  notes="为某个文章下面的某个回复创建回复")
    @ResponseBody
    @PostMapping("/reply/create/reply/{openid}/{reply_id}")
    public Map<String, Object> createReplyReply(@PathVariable(value = "openid") String openid,
                                                @PathVariable(value = "reply_id") String id,
                                                @RequestBody JSONObject body) {
        Map<String, Object> map = new HashMap<>();

        try {
            service.createReplyWithReply(id, body.get("time").toString(), body.get("name").toString(), body.get("content").toString());
        } catch (ReplyNotFoundException e) {
            map.put("data", null);
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        }
        map.put("code", 0);
        map.put("msg", "success");

        return map;
    }
}
