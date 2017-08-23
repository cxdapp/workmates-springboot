package com.workmates.Controller;

import com.workmates.Entity.UserInfo;
import com.workmates.Entity.Users;
import com.workmates.Service.UserService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserControllerAPI {

    @Autowired
    private UserService userService;

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
    public List<UserInfo> getFriends(@PathVariable(value = "myid") Long myid) {
        return userService.getAllFriendsByMasterId(myid);
    }
    @RequestMapping(value = "/getfriends")
    public List<UserInfo> getFriends(@RequestBody UserInfo user) {
        return userService.getAllFriendsByMasterId(user.getUser().getId());
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
