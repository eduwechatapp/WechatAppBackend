package com.eduwechat.backend.backend.entity.user;

import javax.persistence.*;

/**
 * Created by H on 2019/5/22.
 */
@Entity
@Table(name="user")
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private  Long userId;
    @Column(name = "userName")
    private String name;

    @Column(name = "openid")
    private String openID;

    @Column(name = "skey")
    private String secureSession;

    public Long getUserId(){return this.userId;}

    public String getOpenID(){
        return this.openID;
    }

    public String getSecureSession(){
        return this.secureSession;
    }

    public String getName(){return this.name;}

    public void setOpenID(String OpenID){
        this.openID = OpenID;
    }

    public void setSecureSession(String SecureSession){
        this.secureSession  = SecureSession;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    User(){};
    User(Long userId, String OpenID, String SecureSession, String Name){
        this.openID = OpenID;
        this.secureSession = SecureSession;
        this.name = Name;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User [id=" + userId.toString() + ", name=" + name + ",openid="+openID+",skey="+secureSession+"]";
    }

}
