package com.workmates.Repository;

import com.workmates.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    List<UserInfo> findBySex(String sex);

}
