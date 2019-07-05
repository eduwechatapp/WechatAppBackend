package com.eduwechat.backend.backend.controller.base;

import com.eduwechat.backend.backend.exceptions.common.ArticleNotFoundException;
import com.eduwechat.backend.backend.service.base.BaseExtraService;

import java.util.HashMap;
import java.util.Map;

public abstract class ExtraController extends BaseCommonController {
    /**
     * 获取最大的yiji标题列表
     * @param openid
     * @return json
     */
    public abstract Map<String, Object> getNewYijiTitleList(String openid);

    /**
     * 根据上一个接口获取到的yiji标题获取其下文章title，分页
     * @param openid openid
     * @param yiji yiji
     * @param size size
     * @param page page
     * @return json
     */
    public abstract Map<String, Object> getFromYiji(String openid, String yiji, Integer size, Integer page);

    /**
     * 根据上一个接口获取到的title标题，拿到文章详情
     * @param openid openid
     * @param title title
     * @return json
     */
    public abstract Map<String, Object> getFromTitle(String openid, String title);

    /**
     * 获取yiji list内部方法
     * @param service service
     * @return json
     */
    protected Map<String, Object> innerGetYijiList(BaseExtraService service) {
        Map<String, Object> r = new HashMap<>();

        r.put("code", 0);
        r.put("msg", "success");
        r.put("data", service.getTotalList());

        return r;
    }

    /**
     * 获取title list内部方法
     * @param yiji yiji
     * @param size size
     * @param page page
     * @param service service
     * @return
     */
    protected Map<String, Object> innerGetTitleList( String yiji, Integer size, Integer page, BaseExtraService service) {
        Map<String, Object> r = new HashMap<>();

        try {
            r.put("data", service.getNewKNowledgeFromYiji(yiji, size, page));
            r.put("code", 0);
            r.put("msg", "success");
        } catch (ArticleNotFoundException e) {
            r.put("data", null);
            r.put("code", e.getErrorCode());
            r.put("msg", e.getMessage());
        }

        return r;
    }

    /**
     * 获取content内部方法
     * @param title title
     * @return json
     */
    protected Map<String, Object> innerGetContent(String title, BaseExtraService service) {
        Map<String, Object> r = new HashMap<>();

        try {
            r.put("data", service.getContentFromTitle(title));
            r.put("code", 0);
            r.put("msg", "success");
        } catch (ArticleNotFoundException e) {
            r.put("data", null);
            r.put("code", e.getErrorCode());
            r.put("msg", e.getMessage());
        }

        return r;
    }
}
