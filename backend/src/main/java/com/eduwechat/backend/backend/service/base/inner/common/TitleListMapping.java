package com.eduwechat.backend.backend.service.base.inner;

public class TitleListMapping {
    private String titleName;

    private Integer which;

    public String getTitleName() {
        return titleName;
    }

    public Integer getWhich() {
        return which;
    }

    public TitleListMapping(String titleName, Integer which) {
        this.titleName = titleName;
        this.which = which;
    }
}
