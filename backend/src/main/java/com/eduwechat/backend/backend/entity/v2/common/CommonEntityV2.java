package com.eduwechat.backend.backend.entity.v2.common;

import com.eduwechat.backend.backend.entity.v2.base.BaseEntityV2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: backend
 * @description: CommonEntityV2 聚合知识点实体（9科）
 * @author: Vaskka
 * @create: 2019/7/2 11:15 AM
 **/
@Entity
@Getter
@Setter
@AllArgsConstructor
public class CommonEntityV2 extends BaseEntityV2 {
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

    public CommonEntityV2() {}
}
