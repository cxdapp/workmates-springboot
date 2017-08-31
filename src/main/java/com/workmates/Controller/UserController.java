package com.workmates.Controller;

import com.workmates.Entity.UserInfo;
import com.workmates.Entity.Users;
import com.workmates.Service.UserService;
import com.workmates.config.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
//    @Autowired
//    private TokenStore tokenStore;

    @RequestMapping("/")
    public  String index(){
        return "attend";
    }

    @PostMapping(value = "/saveUserInfo")
    public String saveInfo(@RequestBody UserInfo userInfo, Model model){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userInfo.setUser(userService.getUser(userDetails.getUsername()));
        userService.save(userInfo);
        model.addAttribute("me", userInfo);
        return "me";
    }

    @RequestMapping(value = "/{username}")
    public String check(@PathVariable String username,ModelMap modelMap){
        Users user = userService.getUser(username);
        String myname = SecurityContextHolder.getContext().getAuthentication().getName();
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("myname", myname);
        return "/personal";
    }

    @RequestMapping(value = "/settings")
    public String settings(){
        return "";
    }



}
