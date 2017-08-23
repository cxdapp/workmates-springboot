package com.workmates.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "UserInfo")
public class UserInfo {

    @Id
    @GeneratedValue(generator = "customForeignGenerator")
    @org.hibernate.annotations.GenericGenerator(
            name = "customForeignGenerator",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "users")
    )
    private Long id;
    @OneToOne(mappedBy="userInfo")
    @PrimaryKeyJoinColumn
    private Users user;
    private String nickName;
    private String email;
    private Date birthday;
    private String sex;
    private String studyArea;
    private String photoSrc;

    public UserInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Users getUser() {
        return user;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudyArea() {
        return studyArea;
    }

    public void setStudyArea(String studyArea) {
        this.studyArea = studyArea;
    }

    public String getPhotoSrc() {
        return photoSrc;
    }

    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

}
