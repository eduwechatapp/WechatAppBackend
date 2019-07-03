package com.eduwechat.backend.backend.controller.article;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@Api(description = "志愿者作文接口")
@RestController
@RequestMapping(value = "/article/volunteer")
public class VolunteerController {

    @ApiOperation(value = "获取我的帮扶学生信息")
    @RequestMapping(value = "/get/student/{openid}/{uid}",method = RequestMethod.GET)
    public String  getMyStudent(@PathVariable(value = "openid") String openid,
                          @PathVariable(value = "uid") String uid){
        return "{\n" +
                "    \"code\": 0,   \n" +
                "    \"msg\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"uid\": \"12345\",\n" +
                "        \"name\": \"结对学生微信昵称\",\n" +
                "        \"createDate\": \"2019-07-03\"\n" +
                "    }\n" +
                "}";
    }


    @ApiOperation(value = "获取某个帮扶学生的全部作文")
    @RequestMapping(value = "/get/article/{openid}/{uid}/{student_uid}/{number_every_page}/{page_offset}",method = RequestMethod.GET)
    public String  getStudentAllArticles(@PathVariable(value = "openid") String openid,
                                         @PathVariable(value = "uid") String uid,
                                         @PathVariable(value = "student_uid") String studentId,
                                         @PathVariable(value = "number_every_page") String size,
                                         @PathVariable(value = "page_offset") String page){
        return "{\n" +
                "    \"code\": 0,   " +
                "    \"msg\": \"success\",\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"_id\": \"作文id\",\n" +
                "            \"url\": \"图片url\",\n" +
                "            \"reply\": {\n" +
                "                \"content\": \"批改人_意见\",\n" +
                "                \"createTime\": \"2019-07-03\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"_id\": \"作文id\",\n" +
                "            \"url\": \"图片url\",\n" +
                "            \"reply\": {\n" +
                "                \"content\": \"批改人_意见\",\n" +
                "                \"createTime\": \"2019-07-03\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    @ApiOperation(value = "批改某篇作文")
    @RequestMapping(value = "/mark/{openid}/{uid}/{article_id}",method = RequestMethod.POST)
    public String mark(@PathVariable(value = "openid") String openid,
                        @PathVariable(value = "uid") String uid,
                        @PathVariable(value = "article_id") String articleId,
                        @RequestBody JSONObject body){
        return "{\n" +
                "    \"code\": 0,        \n" +
                "    \"msg\": \"success\"\n" +
                "}";
    }
}
