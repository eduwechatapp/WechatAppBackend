package com.eduwechat.backend.backend.controller.article;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(description = "学生作文接口")
@RestController
@RequestMapping(value = "/article/student")
public class StudentController {

    @ApiOperation(value = "上传作文")
    @RequestMapping(value = "/upload/{openid}/{uid}",method = RequestMethod.POST)
    public String  upload(@PathVariable(value = "openid") String openid,
                        @PathVariable(value = "uid") String uid,
                        MultipartFile file){
        return "{\n" +
                "    \"code\": 0, \n" +
                "    \"msg\": \"success\"\n" +
                "}";
    }

    @ApiOperation(value = "获取我的志愿者信息")
    @RequestMapping(value = "/get/volunteer/{openid}/{uid}", method = RequestMethod.GET)
    public String  getVolunteer(@PathVariable(value = "openid") String openid,
                          @PathVariable(value = "uid") String uid){
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
                                @PathVariable(value = "uid") String uid,
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
