package com.wokemates.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "UPParticipate")
public class UPParticipate {
    @Id
    @GeneratedValue
    private int id;
    private Integer uId;
    private Integer pId;
    private Timestamp joinTime;

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

    public Integer getpId() {
        return pId;
    }
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getJoinTime() {
        return joinTime;
    }
    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }

}
