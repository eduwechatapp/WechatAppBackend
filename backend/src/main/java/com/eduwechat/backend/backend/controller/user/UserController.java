package com.eduwechat.backend.backend.controller.user;

import com.eduwechat.backend.backend.service.saveInfo.UserClickInfoService;
import com.eduwechat.backend.backend.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by H on 2019/5/21.
 */
@Api(description = "鉴权接口")
@RestController
@RequestMapping(value = "/session")
public class UserController {

    @Resource
    UserService userService;
    @Resource
    UserClickInfoService userClickInfoService;


    @RequestMapping
    public String hello() {
        return "Hello Spring-Boot";
    }

    @ApiOperation(value = "temp")
    @RequestMapping(value = "/test/{openid}",method = RequestMethod.GET)
    public String  test(@PathVariable String openid){
        return userService.getUser(openid).toString();
    }

    @ApiOperation(value = "temp")
    @RequestMapping(value = "/testsaveButton/{skey}/{type}/{content}")
    public void testsaveUserClicked(@PathVariable String skey, @PathVariable String type, @PathVariable String content){
        int Type = Integer.parseInt(type);
        System.out.println(skey);

        String OpenId = userService.getOpenIdBySkey(skey);
        System.out.println(OpenId);
        userClickInfoService.insertInfo(OpenId,Type, content);

    }

    @ApiOperation(value = "temp")
    @RequestMapping(value = "/getSkey/{code}",method = RequestMethod.GET)
    public Map<String, String> getInfo(@PathVariable String code) throws IOException, JSONException {
        JSONObject returnResult;
        returnResult = userService.GetSessionOpenID(code);
        Map<String, String> map = new HashMap<>();
        if(returnResult.getInt("errcode")==0){
            String OpenID = returnResult.getString("openid");
            String SessionKey = returnResult.getString("session_key");
            String Skey = UUID.randomUUID().toString();
            userService.UpdateSkey(OpenID, SessionKey, Skey);
            map.put("skey",Skey);
            //!!!other info
        }
        else{
            map.put("errcode",returnResult.getString("errcode"));
            map.put("errmsg",returnResult.getString("errmsg"));
        }
        return map;

    }


    @RequestMapping(value = "/saveClickInfo/{skey}/{type}/{content}")
    public void saveUserClicked(@RequestParam(value = "skey", required = true) String skey, @RequestParam(name = "type", required = true)String type, @RequestParam(name = "content")String content){
        int Type = Integer.parseInt(type);
        String OpenId = userService.getOpenIdBySkey(skey);
        userClickInfoService.insertInfo(OpenId,Type, content);
    }

    @RequestMapping(value = "/getSavedInfo/{skey}")
    public Map<String, Object> getSavedInfo(@PathVariable String skey) throws JSONException {
        Map<String, Object> result = new HashMap<>();

        String OpenId = userService.getOpenIdBySkey(skey);

        List<Object> all = userClickInfoService.getInfoByOpenId(OpenId);
        result.put("result",all);
        return result;
    }

    @RequestMapping(value = "/getBasicInfo/{skey}")
    public Map<String, String> getBasicInfo(@PathVariable String skey){
        return userService.getBasicInfo(skey);
    }

}
