package com.eduwechat.backend.backend.controller.article;

import com.eduwechat.backend.backend.exceptions.base.AuthException;
import com.eduwechat.backend.backend.exceptions.base.ThirdPartException;
import com.eduwechat.backend.backend.service.v2.article.StudentArticleService;
import com.eduwechat.backend.backend.utils.cos.COSUtil;
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
    @RequestMapping(value = "/upload/{openid}/{uid}", method = RequestMethod.POST)
    public Map<String, Object> upload(@PathVariable(value = "openid") String openid,
                                      @PathVariable(value = "uid") Long uid,
                                      @RequestParam("file") MultipartFile file){
        Map<String, Object> map = new HashMap<>();

        try {
            service.upload(openid, uid, file.getInputStream(), file.getOriginalFilename());
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

    @ApiOperation(value = "获取我的志愿者信息")
    @RequestMapping(value = "/get/volunteer/{openid}/{uid}", method = RequestMethod.GET)
    public String  getVolunteer(@PathVariable(value = "openid") String openid,
                                 @PathVariable(value = "uid") Long uid){
        return "{\n" +
                "    \"code\": 0, \n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"uid\": \"72113\",\n" +
                "        \"name\": \"志愿者微信昵称\",\n" +
                "        \"createDate\": \"结对时间，格式 %Y-%m-%d\"\n" +
                "    }\n" +
                "}";
    }

    @ApiOperation(value = "获取我的全部作文")
    @RequestMapping(value = "/get/all/{openid}/{uid}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public String  getAllMyArticles(@PathVariable(value = "openid") String openid,
                                @PathVariable(value = "uid") Long uid,
                                @PathVariable(value = "number_every_page") String size,
                                @PathVariable(value = "page_offset") String page){
        return "{\n" +
                "    \"code\": 0,         \n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"_id\": \"作文id_1\",\n" +
                "            \"url\": \"https://edu-1255976561.cos.ap-chengdu.myqcloud.com/article/IMG_20180828_192053.jpg\",\n" +
                "            \"reply\": {\n" +
                "                \"content\": \"批改人_意见\",\n" +
                "                \"createTime\": \"创建时间\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"作文id_2\",\n" +
                "            \"url\": \"https://edu-1255976561.cos.ap-chengdu.myqcloud.com/article/IMG_20180828_192053.jpg\",\n" +
                "            \"reply\": {\n" +
                "                \"content\": \"批改人_意见\",\n" +
                "                \"createTime\": \"创建时间\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
