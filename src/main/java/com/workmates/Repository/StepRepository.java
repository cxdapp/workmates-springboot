package com.workmates.Repository;


import com.workmates.Entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepRepository extends JpaRepository<Step,Integer> {

    //根据项目id查询项目的步骤
    List<Step> findStepsByPId(Integer pid);

    //根据步骤id更新步骤信息
    @Modifying
    @Query("UPDATE Step s SET s.stepTitle=:stepTitle,s.stepContent=:stepContent,s.deadlineHours=:deadlineHours where s.id=:id")
    void updateStep(@Param("stepTitle") String stepTitle, @Param("stepContent") String stepContent, @Param("deadlineHours") Integer deadlineHours, @Param("id") int id);
}
