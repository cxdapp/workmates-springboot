package com.workmates.Service;

import com.workmates.Entity.*;
import com.workmates.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectServiceImple implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UPParticipateRepository upParticipateRepository;
    @Autowired
    private USRolesRepository usRolesRepository;
    @Autowired
    private StepRepository stepRepository;
    @Autowired
    private UserRepository userRepository;

    @Override        //根据用户id查询用户主导的项目
    public List<Project> findMasterProjectsById(Long uid) {
        Users user = userRepository.findOne(uid);
        return projectRepository.findByCreator(user);
    }
    @Override        //根据用户查询用户主导的项目
    public List<Project> findMasterProjectsByUser(Users user) {
        return projectRepository.findByCreator(user);
    }


    @Override        //根据用户id查询用户参与的项目
    public List<Project> findParticipateProjectsByUser(Users user) {
        List<Project> list = new ArrayList<>();
        upParticipateRepository.findByParticipator(user).forEach(up->
                list.add(up.getProject()));
        return list;
    }

    @Override        //更新步骤进度，传入参数为参与者id，步骤id,新的完成度
    public void updateCompleteness(Integer uid, Integer sid, String completeness) {
        usRolesRepository.updateCompleteness(completeness,uid,sid);
    }

    @Override       //保存步骤
    public void saveStep(Step step) {
        stepRepository.save(step);
    }

    @Override       //保存步骤-用户关系
    public void saveUSRole(USRoles usRoles) {
        usRolesRepository.save(usRoles);
    }

    @Override       //根据项目id查询步骤信息
    public List<Step> findStepsByPid(Integer pid) {
        return stepRepository.findStepsByPId(pid);
    }

    @Override        //根据项目id查询项目信息
    public Project findProjectById(Long id) {
        return projectRepository.findOne(id);
    }
    @Override        //根据项目id增加\更新项目信息
    public void saveProject(Project project) {
        projectRepository.saveAndFlush(project);
    }
    @Override
    public Project saveAndGetProject(Project project){
        return projectRepository.saveAndFlush(project);
    }
    @Override        //根据项目id删除项目信息
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }
    public void deleteProject(Long id) {
        projectRepository.delete(id);
    }

}
