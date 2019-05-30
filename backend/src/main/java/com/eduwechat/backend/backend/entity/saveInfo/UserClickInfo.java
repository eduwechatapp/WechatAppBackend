package com.eduwechat.backend.backend.entity.saveInfo;

import javax.persistence.*;

/**
 * Created by H on 2019/5/27.
 */
@Entity
@Table(name = "UserClickInfo")
public class UserClickInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(name = "openid")
    private String openID;

    @Column(name = "type")
    private int type;

    @Column(name = "content")
    private String content;

    public  Long getId(){return this.Id;}

    public String getOpenID(){return this.openID;}

    public int getType(){return this.type;}

    public String getContent(){return this.content;}

    public void setId(Long Id){this.Id = Id;}

    public void setOpenID(String OpenId){this.openID = OpenId;}

    public void setType(int type){this.type = type;}

    public void setContent(String Content){this.content = Content;}

}
