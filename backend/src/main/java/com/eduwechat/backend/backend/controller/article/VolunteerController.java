package com.eduwechat.backend.backend.controller.article;

import com.eduwechat.backend.backend.exceptions.auth.AuthException;
import com.eduwechat.backend.backend.exceptions.base.ApplicationLevelException;
import com.eduwechat.backend.backend.service.v2.article.VolunteerArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(description = "志愿者作文接口")
@RestController
@RequestMapping(value = "/article/volunteer")
public class VolunteerController {

    @Resource
    private VolunteerArticleService service;

    @ApiOperation(value = "获取我的结对信息")
    @RequestMapping(value = "/get/unread/{openid}/{uid}",method = RequestMethod.GET)
    public Map<String, Object> getMsg(@PathVariable(value = "openid") String openid,
                                      @PathVariable(value = "uid") Long uid){
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", service.getCoupleMsg(openid, uid));
            map.put("code", 0);
            map.put("msg", "success");

        } catch (AuthException e) {
            map.put("data", null);
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        }

        return map;
    }

    @ApiOperation(value = "确认结对信息")
    @RequestMapping(value = "/couple/confirm/{openid}/{uid}/{mid}",method = RequestMethod.GET)
    public Map<String, Object> confirmMsg(@PathVariable(value = "openid") String openid,
                                      @PathVariable(value = "uid") Long uid,
                                      @PathVariable(value = "mid") String mid){
        Map<String, Object> map = new HashMap<>();

        try {
            service.confirmCoupleMessage(openid, uid, mid);
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

    @ApiOperation(value = "否认结对信息")
    @RequestMapping(value = "/couple/cancel/{openid}/{uid}/{mid}",method = RequestMethod.GET)
    public Map<String, Object> cancelMsg(@PathVariable(value = "openid") String openid,
                                         @PathVariable(value = "uid") Long uid,
                                         @PathVariable(value = "mid") String mid){
        Map<String, Object> map = new HashMap<>();

        try {
            service.cancelCoupleMessage(openid, uid, mid);
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

    @ApiOperation(value = "获取我的帮扶学生信息")
    @RequestMapping(value = "/get/student/{openid}/{uid}",method = RequestMethod.GET)
    public Map<String, Object>  getMyStudent(@PathVariable(value = "openid") String openid,
                          @PathVariable(value = "uid") Long uid){
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", service.getMyCouple(openid, uid));
            map.put("code", 0);
            map.put("msg", "success");
        } catch (AuthException e) {
            map.put("data",null);
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        } catch (ApplicationLevelException e) {
            map.put("data",null);
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        }

        return map;
    }


    @ApiOperation(value = "获取某个帮扶学生的全部作文")
    @RequestMapping(value = "/get/article/{openid}/{uid}/{student_uid}/{number_every_page}/{page_offset}",method = RequestMethod.GET)
    public Map<String, Object> getStudentAllArticles(@PathVariable(value = "openid") String openid,
                                         @PathVariable(value = "uid") Long uid,
                                         @PathVariable(value = "student_uid") Long studentId,
                                         @PathVariable(value = "number_every_page") Integer size,
                                         @PathVariable(value = "page_offset") Integer page){
        Map<String, Object> map = new HashMap<>();

        try {
            map.put("data", service.getStudentArticles(openid, uid, studentId, page, size));
            map.put("code", 0);
            map.put("msg", "success");
        } catch (AuthException e) {
            map.put("data",null);
            map.put("code", e.getErrorCode());
            map.put("msg", e.getMessage());
        }

        return map;
    }

    @ApiOperation(value = "批改某篇作文")
    @RequestMapping(value = "/mark/{openid}/{uid}/{article_id}",method = RequestMethod.POST)
    public Map<String, Object> mark(@PathVariable(value = "openid") String openid,
                        @PathVariable(value = "uid") Long uid,
                        @PathVariable(value = "article_id") String articleId,
                        @RequestBody JSONObject body){
        String content = body.getAsString("content");
        Map<String, Object> map = new HashMap<>();

        try {
            service.mark(openid, uid, articleId, content);
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

}
