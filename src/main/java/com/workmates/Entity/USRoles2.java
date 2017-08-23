package com.workmates.Entity;

import javax.persistence.*;

@Entity
@Table(name = "USRoles2")
public class USRoles2 {
    @Id
    @GeneratedValue
    private int id;
    private Integer uId;
    private Integer stepId;
//    @ManyToOne
//    private Role role;
    private String completeness;

    public USRoles2() {
        super();
    }

    public USRoles2(Integer uId, Integer stepId, String completeness) {
        this.uId = uId;
        this.stepId = stepId;
        this.completeness = completeness;
    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getStepId() {
        return stepId;
    }
    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public String getCompleteness() {
        return completeness;
    }
    public void setCompleteness(String completeness) {
        this.completeness = completeness;
    }


}
