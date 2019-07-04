package com.eduwechat.backend.backend.controller.article;

import com.eduwechat.backend.backend.exceptions.auth.AuthException;
import com.eduwechat.backend.backend.exceptions.base.ApplicationLevelException;
import com.eduwechat.backend.backend.exceptions.base.ThirdPartException;
import com.eduwechat.backend.backend.service.v2.article.StudentArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Api(description = "学生作文接口")
@RestController
@RequestMapping(value = "/article/student")
public class StudentController {

    @Resource
    private StudentArticleService service;

    @ApiOperation(value = "上传作文")
    @RequestMapping(value = "/upload/{openid}/{uid}/{title}", method = RequestMethod.POST)
    public Map<String, Object> upload(@PathVariable(value = "openid") String openid,
                                      @PathVariable(value = "uid") Long uid,
                                      @PathVariable(value = "title") String title,
                                      @RequestParam("file") MultipartFile file){
        Map<String, Object> map = new HashMap<>();

        try {
            service.upload(openid, uid, file.getInputStream(), file.getOriginalFilename(), title);
            map.put("code", 0);
            map.put("msg", "success");

        } catch (AuthException e) {
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        } catch (ThirdPartException e) {
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        } catch (IOException e) {
            map.put("code", 1);
            map.put("msg", e.getMessage());
        }

        return map;
    }

    @ApiOperation(value = "获取全部志愿者")
    @RequestMapping(value = "/get/all/volunteer/{openid}/{uid}", method = RequestMethod.GET)
    public Map<String, Object>  getAllVolunteer(@PathVariable(value = "openid") String openid,
                                                @PathVariable(value = "uid") Long uid){
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", service.getAllVolunteer(openid, uid));
            map.put("code", 0);
            map.put("msg", "success");

        } catch (AuthException e) {
            map.put("code", e.getErrorCode());
            map.put("data", null);
            map.put("msg", e.getMessage());
        }

        return map;
    }

    @ApiOperation(value = "结对志愿者")
    @RequestMapping(value = "/couple/volunteer/{openid}/{uid}/{vuid}", method = RequestMethod.GET)
    public Map<String, Object> coupleVolunteer(@PathVariable(value = "openid") String openid,
                                                @PathVariable(value = "uid") Long uid,
                                                @PathVariable(value = "vuid") Long vuid){
        Map<String, Object> map = new HashMap<>();

        try {
            service.couple(openid, uid, vuid);
            map.put("code", 0);
            map.put("msg", "success");

        } catch (AuthException e) {
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        } catch (ApplicationLevelException e) {
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        }

        return map;
    }

    @ApiOperation(value = "获取我的志愿者信息")
    @RequestMapping(value = "/get/volunteer/{openid}/{uid}", method = RequestMethod.GET)
    public Map<String, Object> getVolunteer(@PathVariable(value = "openid") String openid,
                                 @PathVariable(value = "uid") Long uid){
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", service.getMyCouple(openid, uid));
            map.put("code", 0);
            map.put("msg", "success");

        } catch (AuthException e) {
            map.put("data", null);
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        } catch (ApplicationLevelException e) {
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
            map.put("data", null);
        }

        return map;
    }

    @ApiOperation(value = "获取我的全部作文")
    @RequestMapping(value = "/get/all/{openid}/{uid}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> getAllMyArticles(@PathVariable(value = "openid") String openid,
                                @PathVariable(value = "uid") Long uid,
                                @PathVariable(value = "number_every_page") Integer size,
                                @PathVariable(value = "page_offset") Integer page){
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", service.getMyArticle(openid, uid, page, size));
            map.put("code", 0);
            map.put("msg", "success");

        } catch (AuthException e) {
            map.put("data", null);
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        }

        return map;
    }
}
