package com.wokemates.Service;

import com.wokemates.Entity.Project;

import java.util.List;

public interface ProjectService {
    Project getProjectByMasterId(Integer masterId);

    List<Project> getAllProjectsByMasterId(Integer masterId);
}
