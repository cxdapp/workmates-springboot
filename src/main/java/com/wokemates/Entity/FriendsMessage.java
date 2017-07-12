package com.wokemates.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "FriendsMessage")
public class FriendsMessage {
    @Id
    @GeneratedValue
    private int id;
    private Integer sendId;
    private Integer recieverId;
    private String message;
    private Boolean isRecieved;
    private Timestamp sendTime;

    public FriendsMessage() {
        super();
    }

    public FriendsMessage(Integer sendId, Integer recieverId, String message, Boolean isRecieved, Timestamp sendTime) {
        this.sendId = sendId;
        this.recieverId = recieverId;
        this.message = message;
        this.isRecieved = isRecieved;
        this.sendTime = sendTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSendId() {
        return sendId;
    }
    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getRecieverId() {
        return recieverId;
    }
    public void setRecieverId(Integer recieverId) {
        this.recieverId = recieverId;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getRecieved() {
        return isRecieved;
    }
    public void setRecieved(Boolean recieved) {
        isRecieved = recieved;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getSendTime() {
        return sendTime;
    }
    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }


}
