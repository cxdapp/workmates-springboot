package com.wokemates.Controller;

import com.wokemates.Entity.UserInfo;
import com.wokemates.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerAPI {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getfriends/{myid}")
    public List<UserInfo> getFriends(@PathVariable(value = "myid") Integer myid) {
        return userService.getAllFriendsByMasterId(myid);
    }
    @RequestMapping(value = "/getfriends")
    public List<UserInfo> getFriends(@RequestBody UserInfo user) {
        return userService.getAllFriendsByMasterId(user.getId());
    }
}
