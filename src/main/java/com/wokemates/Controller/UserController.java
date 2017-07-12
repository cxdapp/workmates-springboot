package com.wokemates.Controller;

import com.wokemates.Entity.UserInfo;
import com.wokemates.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{viewname}")
    public String view(@PathVariable(value = "viewname") String viewname) {
        return "/view/"+viewname + ".html";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST,produces = "text/html")
    public String validateLogin(String username, String userPassword) {
        UserInfo user = userService.getUserByNameAndPassword(username, userPassword);
        if (user != null) {
            return "/main";
        }
        return "/index";
    }


}
