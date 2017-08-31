package com.workmates.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Step")
public class Step {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "User_Step",
            joinColumns = { @JoinColumn(name = "stepId",columnDefinition = "long")  },
            inverseJoinColumns = { @JoinColumn(name = "principleId",columnDefinition = "long") })
    private Set<Users> principals;
    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name="project_id")
    private Project project;
    private String stepTitle;
    private String stepContent;
    private Integer deadlineHours;
    private Integer stepOrder;
    private List<String> fileUrls;



    public Step() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Users> getPrincipals() {
        return principals;
    }

    public void setPrincipals(Set<Users> principals) {
        this.principals = principals;
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

    public Integer getStepOrder() {
        return stepOrder;
    }

    public void setStepOrder(Integer stepOrder) {
        this.stepOrder = stepOrder;
    }

    @JsonIgnore
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<String> getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(List<String> fileUrls) {
        this.fileUrls = fileUrls;
    }
}
