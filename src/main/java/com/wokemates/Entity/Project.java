package com.wokemates.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue
    private int id;
    private Integer masterId;
    private Timestamp createdTime;
    private Integer totalHours;
    private Boolean isRewarded;
    private Integer rewardedCoin;
    private String title;
    private String description;
    private Integer projectAreaId;

    public Project() {
        super();
    }

    public Project(Integer masterId, Timestamp createdTime, Integer totalHours, Boolean isRewarded, Integer rewardedCoin, String title, String description, Integer projectAreaId) {
        this.masterId = masterId;
        this.createdTime = createdTime;
        this.totalHours = totalHours;
        this.isRewarded = isRewarded;
        this.rewardedCoin = rewardedCoin;
        this.title = title;
        this.description = description;
        this.projectAreaId = projectAreaId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Integer getMasterId() {
        return masterId;
    }
    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getTotalHours() {
        return totalHours;
    }
    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    public Boolean getRewarded() {
        return isRewarded;
    }
    public void setRewarded(Boolean rewarded) {
        isRewarded = rewarded;
    }

    public Integer getRewardedCoin() {
        return rewardedCoin;
    }
    public void setRewardedCoin(Integer rewardedCoin) {
        this.rewardedCoin = rewardedCoin;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProjectAreaId() {
        return projectAreaId;
    }
    public void setProjectAreaId(Integer projectAreaId) {
        this.projectAreaId = projectAreaId;
    }


}
