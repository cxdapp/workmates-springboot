package com.workmates.Service;

import com.workmates.Entity.*;

import java.util.List;

public interface ProjectService {

    List<Project> findMasterProjectsById(Long masterId);
    List<Project> findMasterProjectsByUser(Users user);

    List<Project> findParticipateProjectsByUser(Users user);

    void updateCompleteness(Integer uid, Integer sid, String completeness);

    void saveStep(Step step);

    List<Step> findStepsByPid(Integer pid);

    void saveUSRole(USRoles usRoles);


    //删（增改）查
    void deleteProject(Project project);
    void deleteProject(Long id);
    void saveProject(Project project);
    Project saveAndGetProject(Project project);
    Project findProjectById(Long id);

    //获得leader_check组长审核表
    List<LeaderCheck> getLeaderCheck(Users receiver);
}
