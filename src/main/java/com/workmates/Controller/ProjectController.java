package com.workmates.Controller;

import com.workmates.Entity.Project;
import com.workmates.Entity.Users;
import com.workmates.Service.ProjectService;
import com.workmates.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.File;

//个人中心，及项目管理
@Controller
@RequestMapping(value = "/u")
public class ProjectController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;



    @RequestMapping(value = "/projects/create",method = RequestMethod.GET)
    public String createProject(){
        return "/project_add";
    }
    @RequestMapping(value = "/projects/create",method = RequestMethod.POST)
    public String createProject(@RequestBody  Project project,Model model){
        String uname = SecurityContextHolder.getContext().getAuthentication().getName();
        Project project1 = projectService.saveAndGetProject(project);
        model.addAttribute("project", project1);
        return "redirect:/u/"+uname+"/p/"+project1.getId();
    }

    @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
    public String uploadfile(File file){
        return "";
    }

    @RequestMapping(value = "/{username}/p/{proId}",method = RequestMethod.POST)
    public String check2(@PathVariable String username,@PathVariable String proId,ModelMap modelMap){
        Project project = projectService.findProjectById(Long.parseLong(proId));
        modelMap.addAttribute("project", project);
        modelMap.addAttribute("name", project.getTitle());
        return "project";
    }
}
