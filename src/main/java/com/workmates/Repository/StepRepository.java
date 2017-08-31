package com.workmates.Repository;


import com.workmates.Entity.Project;
import com.workmates.Entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepRepository extends JpaRepository<Step,Long> {

    //根据项目查询项目的步骤


    //根据更新步骤信息

}
