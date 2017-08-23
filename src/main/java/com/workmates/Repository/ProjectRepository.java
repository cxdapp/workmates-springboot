package com.workmates.Repository;

import com.workmates.Entity.Project;
import com.workmates.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findByCreator(Users creator);

}
