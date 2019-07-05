package com.eduwechat.backend.backend.controller.user;

import com.eduwechat.backend.backend.entity.v2.user.UserV2Entity;
import com.eduwechat.backend.backend.exceptions.user.UserAlreadyRegisterException;
import com.eduwechat.backend.backend.exceptions.user.UserDidNotRegisterException;
import com.eduwechat.backend.backend.exceptions.user.UserTypeNotSupportException;
import com.eduwechat.backend.backend.service.v2.user.UserV2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Api(description = "鉴权V2接口")
@RestController
@RequestMapping(value = "/user")
public class UserV2 {

    @Resource
    private UserV2Service service;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(@RequestBody JSONObject body){
        String openid = body.getAsString("openid");
        String type = body.getAsString("type");
        String name = body.getAsString("name");
        String url  = body.getAsString("url");

        Map<String, Object> map = new HashMap<>();

        try {
            Long uid = service.register(openid, type, name, url);
            map.put("code", 0);
            map.put("msg", "success");
            map.put("uid", uid);
        } catch (UserAlreadyRegisterException e) {
            // 处理用户已经注册
            Logger.getLogger("com.eduwechat.backend.backend.controller.user.UserV2").log(Level.SEVERE,
                    e.getExceptionDetail(),
                    new Object[] {String.format("openid:%s", openid)});
            map.put("code", 4001);
            map.put("msg", e.getMessage());
            map.put("uid", -1);
        } catch (UserTypeNotSupportException e) {
            // 处理type不正确
            Logger.getLogger("com.eduwechat.backend.backend.controller.user.UserV2").log(Level.SEVERE,
                    e.getExceptionDetail(),
                    new Object[] {String.format("type:%s", type)});
            map.put("code", 4002);
            map.put("msg", e.getMessage());
            map.put("uid", -1);
        }

        return map;
    }


    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody JSONObject body){
        String openid = body.getAsString("openid");

        Map<String, Object> map = new HashMap<>();

        try {
            UserV2Entity entity = service.login(openid);
            map.put("code", 0);
            map.put("msg", "success");
            map.put("uid", entity.getUid());
            map.put("type", entity.getType());

        } catch (UserDidNotRegisterException e) {
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
            map.put("uid", -1);
            map.put("type", null);
        }

        return map;
    }

}
