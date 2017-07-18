package com.wokemates.Controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wokemates.Entity.UserInfo;
import com.wokemates.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{viewname}")
    public String view(@PathVariable(value = "viewname") String viewname) {
        return viewname;
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String main(){
        return "login";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.GET,produces = "text/html")
    public String validateLogin(String username, String userPassword, HttpSession session, HttpServletRequest request, HttpServletResponse response,Model model) {
        UserInfo user = userService.getUserByNameAndPassword(username, userPassword);
        if (user != null) {
            session.setAttribute("user",user);
            Enumeration<String> hnames =request.getHeaderNames();
            String cookies = request.getHeader("Cookies");

            Cookie cookie = new Cookie("token", String.valueOf(user.getId()));
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            model.addAttribute("myname", user.getUsername());
            return "main";
        }
        return "main";
    }


}
