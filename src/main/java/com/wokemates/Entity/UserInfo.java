package com.wokemates.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "UserInfo")
public class UserInfo {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private String email;
    private Timestamp birthday;
    private String sex;
    private String studyArea;
    private String photoSrc;

    public UserInfo() {
        super();
    }

    public String getStudyArea() {
        return studyArea;
    }

    public void setStudyArea(String studyArea) {
        this.studyArea = studyArea;
    }

    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }

    public UserInfo(String username, String password, String email, Timestamp birthday, String sex, String studyArea, String photoSrc) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.studyArea = studyArea;
        this.photoSrc = photoSrc;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getBirthday() {
        return birthday;
    }
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

}
