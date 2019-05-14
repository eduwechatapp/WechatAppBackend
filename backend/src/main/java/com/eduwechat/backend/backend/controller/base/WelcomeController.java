package com.eduwechat.backend.backend.controller.base;


import com.eduwechat.backend.backend.utils.CommonUtil;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class WelcomeController implements ErrorController {

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return CommonUtil.indexFileContent;
    }

    @ResponseBody
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public Map<String, Object> error(HttpServletRequest request) {
        Map<String, Object> res = new HashMap<>();

        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        res.put("code", statusCode);
        res.put("status", "error");

        return res;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
