package com.eduwechat.backend.backend.entity;

import com.eduwechat.backend.backend.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "gzzz")
public class HighSchoolPolitical implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Lob
    @Column(columnDefinition = "text")
    private String yiji;

    @Lob
    @Column(columnDefinition = "text")
    private String erji;

    @Lob
    @Column(columnDefinition = "text")
    private String sanji;

    @Lob
    @Column(columnDefinition = "text")
    private String title;

    private Integer shoucang_int;

    private Integer level_int;

    @Lob
    @Column(columnDefinition = "text")
    private String content;

    public HighSchoolPolitical(String yiji, String erji, String sanji, String title, Integer shoucang_int, Integer level_int, String content) {
        this.yiji = yiji;
        this.erji = erji;
        this.sanji = sanji;
        this.title = title;
        this.shoucang_int = shoucang_int;
        this.level_int = level_int;
        this.content = content;
    }

    public HighSchoolPolitical() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getYiji() {
        return yiji;
    }

    public void setYiji(String yiji) {
        this.yiji = yiji;
    }

    @Override
    public String getErji() {
        return erji;
    }

    public void setErji(String erji) {
        this.erji = erji;
    }

    public String getSanji() {
        return sanji;
    }

    public void setSanji(String sanji) {
        this.sanji = sanji;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getShoucang_int() {
        return shoucang_int;
    }

    public void setShoucang_int(Integer shoucang_int) {
        this.shoucang_int = shoucang_int;
    }

    public Integer getLevel_int() {
        return level_int;
    }

    public void setLevel_int(Integer level_int) {
        this.level_int = level_int;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
