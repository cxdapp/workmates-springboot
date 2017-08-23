package com.workmates.Controller;

import com.workmates.Entity.Project;
import com.workmates.Entity.Users;
import com.workmates.Service.ProjectService;
import com.workmates.Service.UserService;
import com.workmates.config.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = userService.getUser(currentUser.getUsername());
        return projectService.findMasterProjectsByUser(user);
    }

    @GetMapping(value = "/participated")
    public List<Project> getProjects2(){
        CustomUserDetails currentUser = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = userService.getUser(currentUser.getUsername());
        return projectService.findParticipateProjectsByUser(user);
    }
}
