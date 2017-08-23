package com.workmates.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "UPParticipate")
public class UPParticipate {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Users participator;
    @ManyToOne
    private Project project;
    private Date joinTime;

    public UPParticipate() {
        super();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Users getParticipator() {
        return participator;
    }

    public void setParticipator(Users participator) {
        this.participator = participator;
    }

    @JsonIgnore
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
