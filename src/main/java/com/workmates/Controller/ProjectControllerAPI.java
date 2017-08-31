package com.workmates.Controller;

import com.workmates.Entity.LeaderCheck;
import com.workmates.Entity.Project;
import com.workmates.Entity.Role;
import com.workmates.Entity.Users;
import com.workmates.Service.ProjectService;
import com.workmates.Service.UserService;
import com.workmates.config.CustomUserDetails;
import com.workmates.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/papi")
public class ProjectControllerAPI {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    private CustomUserDetails currentUser;


    @GetMapping(value = "/all")
    public List<Project> getAllProjects(){
        List<Project> list1 = getProjects1();
        List<Project> list2 = getProjects2();
        list1.addAll(list2);
        return list1;
    }

    @GetMapping(value = "/created")
    public List<Project> getProjects1(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userService.getUser(username);
        return projectService.findMasterProjectsByUser(user);
    }

    @GetMapping(value = "/participated")
    public List<Project> getProjects2(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userService.getUser(username);
        return projectService.findParticipateProjectsByUser(user);
    }

    @RequestMapping(value = "/leader_check",method = RequestMethod.GET)
    public List<LeaderCheck> getLeaderCheckList() throws MyException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Users user = userService.getUser(username);
        boolean flag = false;
        for (Role role:
             user.getRoles()) {
            if(role.getName().contains("ACTUATOR")) {
                flag = true;
            }
        }
        if (flag) {
            return projectService.getLeaderCheck(user);
        } else {
            throw new MyException("未授权！");
        }
    }

}
