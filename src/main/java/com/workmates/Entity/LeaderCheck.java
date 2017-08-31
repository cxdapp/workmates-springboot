package com.workmates.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "leader_check")
public class LeaderCheck {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Users pusher;
    @ManyToOne
    private Users receiver;
    private String pushType;
    private String remarks;
    private Date pushTime;
    List<String> file_urls;
//    0未审核，1驳回，2通过
    private Integer status = 0;

    public LeaderCheck() {
    }

    public Users getReceiver() {
        return receiver;
    }

    public void setReceiver(Users receiver) {
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getPusher() {
        return pusher;
    }

    public void setPusher(Users pusher) {
        this.pusher = pusher;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LeaderCheck{" +
                "id=" + id +
                ", pusher=" + pusher +
                ", receiver=" + receiver +
                ", pushType='" + pushType + '\'' +
                ", remarks='" + remarks + '\'' +
                ", pushTime=" + pushTime +
                ", file_urls=" + file_urls +
                ", status=" + status +
                '}';
    }

    public List<String> getFile_urls() {
        return file_urls;
    }

    public void setFile_urls(List<String> file_urls) {
        this.file_urls = file_urls;
    }
}
