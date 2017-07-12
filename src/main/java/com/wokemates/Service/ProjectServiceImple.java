package com.wokemates.Service;

import com.wokemates.Entity.Project;
import com.wokemates.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectServiceImple implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project getProjectByMasterId(Integer masterId) {
        return projectRepository.findProjectByMasterId(masterId);
    }

    @Override
    public List<Project> getAllProjectsByMasterId(Integer masterId) {
        return projectRepository.findProjectsByMasterId(masterId);
    }
}
