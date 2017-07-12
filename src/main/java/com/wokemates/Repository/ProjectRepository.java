package com.wokemates.Repository;

import com.wokemates.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Project findProjectByMasterId(Integer masterId);

    List<Project> findProjectsByMasterId(Integer masterId);
}
