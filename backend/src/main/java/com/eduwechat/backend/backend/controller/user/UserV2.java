package com.eduwechat.backend.backend.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@Api(description = "鉴权V2接口")
@RestController
@RequestMapping(value = "/user")
public class UserV2 {

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody JSONObject body){
        return "{\n" +
                "    \"code\": 0,                      \n" +
                "    \"msg\": \"success\",\n" +
                "    \"uid\": \"14234\"                \n" +
                "}";
    }

}
