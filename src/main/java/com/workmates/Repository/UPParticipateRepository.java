package com.workmates.Repository;

import com.workmates.Entity.Project;
import com.workmates.Entity.UPParticipate;
import com.workmates.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UPParticipateRepository extends JpaRepository<UPParticipate,Long> {

    //根据用户id查询用户参与的项目，查到的是UPParticipate
    List<UPParticipate> findByParticipator(Users participator);

    //根据项目id查询项目的参与者。。。
    List<UPParticipate> findByProject(Project project);
}
