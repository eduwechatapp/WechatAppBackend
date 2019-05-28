package com.eduwechat.backend.backend.entity.base;


/**
 * 知识点等实体类积累
 */
public  interface BaseCommonEntity extends BaseEntity {
    Integer getId();

    String getTitle();

    String getContent();

    String getErji();

    String getYiji();
}
