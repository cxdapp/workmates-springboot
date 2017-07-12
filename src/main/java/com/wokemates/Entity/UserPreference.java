package com.wokemates.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "UserPreference")
public class UserPreference {
    @Id
    @GeneratedValue
    private int id;
    private Integer age;
    private String sex;
    private String studyArea;
    private String university;
    private String city;
    private String photoSrc;

    public UserPreference() {
        super();
    }

    public UserPreference(Integer age, String sex, String studyArea, String university, String city, String photoSrc) {
        this.age = age;
        this.sex = sex;
        this.studyArea = studyArea;
        this.university = university;
        this.city = city;
        this.photoSrc = photoSrc;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getStudyArea() {
        return studyArea;
    }

    public void setStudyArea(String studyArea) {
        this.studyArea = studyArea;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhotoSrc() {
        return photoSrc;
    }

    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }

    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }


}
