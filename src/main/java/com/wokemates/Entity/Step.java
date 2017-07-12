package com.wokemates.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Step")
public class Step {
    @Id
    @GeneratedValue
    private int id;
    private Integer pId;
    private String stepTitle;
    private String stepContent;
    private Integer deadlineHours;

    public Step() {
        super();
    }

    public Step(Integer pId, String stepTitle, String stepContent, Integer deadlineHours) {
        this.pId = pId;
        this.stepTitle = stepTitle;
        this.stepContent = stepContent;
        this.deadlineHours = deadlineHours;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getStepTitle() {
        return stepTitle;
    }
    public void setStepTitle(String stepTitle) {
        this.stepTitle = stepTitle;
    }

    public String getStepContent() {
        return stepContent;
    }
    public void setStepContent(String stepContent) {
        this.stepContent = stepContent;
    }

    public Integer getDeadlineHours() {
        return deadlineHours;
    }
    public void setDeadlineHours(Integer deadlineHours) {
        this.deadlineHours = deadlineHours;
    }

}
