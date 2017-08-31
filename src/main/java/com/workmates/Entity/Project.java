package com.workmates.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.workmates.dto.Group;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private String projectArea;
    private Integer status;
    @OneToMany(mappedBy = "project",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Step> steps = new HashSet<>();

    public Project() {
        super();
    }

    public Set<Step> getSteps() {
        return steps;
    }

    public void setSteps(Set<Step> steps) {
        this.steps = steps;
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

    public String getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(String projectArea) {
        this.projectArea = projectArea;
    }
}
