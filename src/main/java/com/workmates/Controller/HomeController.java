package com.workmates.Controller;

import com.workmates.Service.UserService;
import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController  {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String main(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return "/user";
        } else {
            return "login";
        }
    }
    @RequestMapping(value = "/u")
    public String u(){
        String myname = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!myname.equals("anonymousUser")) {
            return "/u/" + myname;
        }
        return "/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @GetMapping(value = "/{viewname}")
    public String view(@PathVariable(value = "viewname") String viewname) {
        return viewname;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("uid");
        return "redirect:/login";
    }

    @GetMapping(value = "/me")
    public String validateLogin() {
        return "me";
    }

    @GetMapping(value = "/attend")
    public String attend(Model model) {
        model.addAttribute("myname","WOWOW");
        return "attend";
    }
}
