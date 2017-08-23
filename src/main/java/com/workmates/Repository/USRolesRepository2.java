package com.workmates.Repository;


import com.workmates.Entity.USRoles2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface USRolesRepository2 extends JpaRepository<USRoles2, Integer> {

    //根据stepid查询，得到USRoles，主要是参与者uid,扮演的角色，完成度
    USRoles2 findByStepId(Integer stepId);

    //根据参与者id及stepid更改进度
    @Modifying
    @Query("UPDATE USRoles u SET u.completeness=:completeness where u.uId=:uid and u.stepId=:stepid")
    void updateCompleteness(@Param("completeness") String completeness, @Param("uid") Integer uid, @Param("stepid") Integer stepid);

    //根据参与者id及stepid更改参与者的角色
//    @Modifying
//    @Query("UPDATE USRoles u SET u.roleId=:roleid where u.uId=:uid and u.stepId=:stepid")
//    void updateUSRole(@Param("roleid") Integer roleId, @Param("uid") Integer uid, @Param("stepid") Integer stepid);


}
