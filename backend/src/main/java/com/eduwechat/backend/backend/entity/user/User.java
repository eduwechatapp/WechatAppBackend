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

    @Column(name = "session_key")
    private String session;

    @Column(name = "subject")
    private String subject;

    @Column(name = "grade")
    private int grade;

    @Column(name = "score_down")
    private int score_down;

    @Column(name = "score_up")
    private  int score_up;

    public Long getUserId(){return this.userId;}

    public String getOpenID(){return this.openID;}

    public String getSecureSession(){
        return this.secureSession;
    }

    public String getName(){return this.name;}

    public String getSession(){return this.session;}

    public String getSubject(){return this.subject;}

    public int getGrade(){return this.grade;}

    public int getScore_down(){return this.score_down;}

    public int getScore_up(){return this.score_up;}

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

    public void setSession(String session){this.session = session;}

    public void setSubject(String subject){this.subject = subject;}

    public void setGrade(int grade){this.grade = grade;}

    public void setScore_down(int score_down){this.score_down = score_down;}

    public void setScore_up(int score_up){this.score_up = score_up;}

    User(){};
    User(Long userId,String OpenID, String SecureSession, String Name, String Session, String Subject, int Grade, int Score_down, int Score_up){
        this.openID = OpenID;
        this.secureSession = SecureSession;
        this.name = Name;
        this.userId = userId;
        this.session = Session;
        this.subject = Subject;
        this.grade = Grade;
        this.score_down = Score_down;
        this.score_up = Score_up;
    }

    @Override
    public String toString() {
        return "User [id=" + userId.toString() + ", name=" + name + ",openid="+openID+",skey="+secureSession+"]";
    }

}
