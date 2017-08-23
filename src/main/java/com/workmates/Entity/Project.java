package com.workmates.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.workmates.dto.Group;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Users creator;
    @Transient
    private Group group;
    private Date createdTime;
    private Integer totalHours;
    private Boolean isRewarded;
    private Integer rewardedCoin;
    private String title;
    private String description;
    private Integer projectAreaId;
    private Integer status;

    public Project() {
        super();
    }

    public Project(Users creator, Date createdTime, Integer totalHours, Boolean isRewarded, Integer rewardedCoin, String title, String description, Integer projectAreaId, Integer status) {
        this.creator = creator;
        this.createdTime = createdTime;
        this.totalHours = totalHours;
        this.isRewarded = isRewarded;
        this.rewardedCoin = rewardedCoin;
        this.title = title;
        this.description = description;
        this.projectAreaId = projectAreaId;
        this.status = status;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getCreator() {
        return creator;
    }

    public void setCreator(Users creator) {
        this.creator = creator;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
