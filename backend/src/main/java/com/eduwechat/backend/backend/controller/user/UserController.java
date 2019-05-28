package com.eduwechat.backend.backend.controller.user;

import com.eduwechat.backend.backend.service.user.UserService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by H on 2019/5/21.
 */
@RestController
@RequestMapping(value = "/session")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/get/{code}",method = RequestMethod.GET)
    public Map<String, Object> getInfo(@PathVariable String code) throws IOException, JSONException {
        JSONObject returnResult;
        returnResult = userService.GetSessionOpenID(code);
        Map<String, Object> map = new HashMap<>();
        if (returnResult.getInt("errcode") == 0) {
            String OpenID = returnResult.getString("openid");
            String SessionKey = returnResult.getString("session_key");
            userService.UpdateSkey(OpenID, SessionKey);
            map.put("errcode", returnResult.getInt("errcode"));
            map.put("skey", SessionKey);
        } else {
            map.put("errcode", returnResult.getInt("errcode"));
            map.put("errmsg", returnResult.getString("errmsg"));
        }
        return map;
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
