package com.eduwechat.backend.backend.entity.base;


import java.util.List;

public class BaseMessageEntity {

    protected List<String> replyIdList;

    public BaseMessageEntity() {}

    public BaseMessageEntity(List<String> replyIdList) {
        this.replyIdList = replyIdList;
    }


    public List<String> getReplyIdList() {
        return replyIdList;
    }
}
