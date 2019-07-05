package com.eduwechat.backend.backend.controller.video;

import com.eduwechat.backend.backend.service.v2.video.VideoService;
import com.eduwechat.backend.backend.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(description = "鉴权V2接口")
@RestController
@RequestMapping(value = "/video")
public class VideoController {

    @Resource
    private VideoService service;

    @ApiOperation(value = "获取视频地址")
    @RequestMapping(value = "/{openid}/{subject}/{number_every_page}/{page_offset}", method = RequestMethod.GET)
    public Map<String, Object> register(@PathVariable("openid") String openid,
                                        @PathVariable("subject") String _subject,
                                        @PathVariable("number_every_page") Integer size,
                                        @PathVariable("page_offset") Integer page) {
        Map<String, Object> map = new HashMap<>();
        String subject = CommonUtil.fromFullChineseNameGetFullEnglishName(_subject);

        if (subject == null) {
            map.put("code", 6001);
            map.put("msg", "学科名非法");
            map.put("data", null);

            return map;
        }

        map.put("code", 0);
        map.put("msg", "success");
        map.put("data", service.getVideoFromSubject(subject, page, size));

        return map;
    }
}
