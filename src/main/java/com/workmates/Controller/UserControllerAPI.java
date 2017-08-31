package com.workmates.Controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.workmates.Entity.UserInfo;
import com.workmates.Entity.Users;
import com.workmates.Service.UserService;
import com.workmates.config.CustomUserDetails;
import com.workmates.dto.Notice;
import com.workmates.dto.NoticeQueue;
import com.workmates.dto.NoticeType;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NoType;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserControllerAPI {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/notice",method = RequestMethod.GET)
    public List<Notice> notifyFront(){
        return NoticeQueue.instance.getSortableNoticeList();
    }
    @RequestMapping(value = "/notice",method = RequestMethod.POST)
    public String notifyFront(String pusher,String target,String noticeType){
        Notice notice = new Notice();
        notice.setPusher(pusher);
        notice.setTarget(target);
        switch (noticeType) {
            case "LIKE":
                notice.setNoticeType(NoticeType.LIKE);
                break;
            case "COMMENT":
                notice.setNoticeType(NoticeType.COMMENT);
                break;
            case "REPLY":
                notice.setNoticeType(NoticeType.REPLY);
                break;
            case "FOLLOW":
                notice.setNoticeType(NoticeType.FOLLOW);
                break;
            case "MESSAGE":
                notice.setNoticeType(NoticeType.MESSAGE);
                break;
        }
        NoticeQueue.instance.enQueue(notice);
        return "success";
    }

    @GetMapping(value ="/getusername")
    public String getUsername(){
        return JSONParser.quote(SecurityContextHolder.getContext().getAuthentication().getName());
    }
    @GetMapping(value = "/getuser")
    public Users getUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getUser(username);
    }

    @RequestMapping(value = "/getfriends/{myid}")
    public List<Users> getFriends(@PathVariable(value = "myid") Long myid) {
        return userService.getAllFriendsByMasterId(myid);
    }
    @RequestMapping(value = "/searchfriends/{key}")
    public List<Users> searchFriends(@PathVariable(value = "key") String key) {
        String uname = (String) SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userService.getUser(uname);
        List<Users> results = new ArrayList<>();
        for (Users u : userService.getAllFriendsByMasterId(user.getId())) {
            if (u.getUserInfo().getNickName().contains(key)||u.getUsername().contains(key)||u.getUserInfo().getEmail().contains(key)) {
                results.add(u);
            }
        }
        return results;
    }
    @RequestMapping(value = "/getfriends")
    public List<Users> getFriends(@RequestBody Users user) {
        return userService.getAllFriendsByMasterId(user.getId());
    }

//    @RequestMapping(value = "/getUSRolesByRoleId/{roleId}", method = RequestMethod.POST)
//    public void addUSRoles2(@RequestBody USRoles2 usRoles2, @PathVariable String roleId) {
//        Role role = new Role(roleId,"");
//        usRoles2.setRole(role);
//        userService.addUSRoles(usRoles2);
//    }
//    @RequestMapping(value = "/getUSRolesByRoleId/{roleId}")
//    public List<USRoles2> getUSRoles2(@PathVariable String roleId) {
//        return userService.getUSRolesByRoleId(roleId);
//    }
}
