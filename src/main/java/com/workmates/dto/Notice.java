package com.workmates.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notice {

    private String pusher;
    private String target;
    private NoticeType noticeType;
    private Date noticeTime;
    private String statement;
    private String month;
    private String day;

    public Notice() {
    }

    public String getPusher() {
        return pusher;
    }

    public void setPusher(String pusher) {
        this.pusher = pusher;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    @Override
    public String toString() {
        String msg = "";
        switch (noticeType) {
            case LIKE:
                msg =  "点赞了你" ;
                break;
            case FOLLOW:
                msg =  "关注了你" ;
                break;
            case COMMENT:
                msg =  "评论了你" ;
                break;
            case MESSAGE:
                msg = "给你发了条消息";
                break;
            case REPLY:
                msg =  "回复了你" ;
                break;
        }
        this.statement = msg;
        return msg;
    }

    public String getStatement() {
        return toString();
    }

    public String getMonth() {
        return new SimpleDateFormat("MM").format(noticeTime) + "月";
    }

    public String getDay() {
        return new SimpleDateFormat("dd").format(noticeTime);
    }
}
