package com.workmates.Entity;

import javax.persistence.*;

@Entity
@Table(name = "USRoles")
public class USRoles {
    @Id
    @GeneratedValue
    private int id;
    private Integer uId;
    private Integer stepId;
    private Integer roleId;
    private String completeness;

    public USRoles() {
        super();
    }

    public USRoles(Integer uId, Integer stepId, Integer roleId, String completeness) {
        this.uId = uId;
        this.stepId = stepId;
        this.roleId = roleId;
        this.completeness = completeness;
    }

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

    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }



    public String getCompleteness() {
        return completeness;
    }
    public void setCompleteness(String completeness) {
        this.completeness = completeness;
    }


}
