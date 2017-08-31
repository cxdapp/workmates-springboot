package com.workmates.dto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.*;
import java.util.List;

@RestController
public class NoticeQueue {
    public static NoticeQueue instance = new NoticeQueue();

    private static List<Notice> noticeList = new ArrayList<>();
    
    public void enQueue(Notice e){
        noticeList.add(e);
    }
    public void enQueue(List<Notice> list){
        noticeList.addAll(list);
    }
    public void peekQueue(int i){
        noticeList.remove(i);
    }



    public List<Notice> getNoticeList() {
        return noticeList;
    }
    public List<Notice> getSortableNoticeList() {
        noticeList.sort(new Comparator<Notice>() {
            @Override
            public int compare(Notice o1, Notice o2) {
                return (int) (o2.getNoticeTime().getTime()-o1.getNoticeTime().getTime());
            }
        });
        return noticeList;
    }

    public void setNoticeList(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }
}
