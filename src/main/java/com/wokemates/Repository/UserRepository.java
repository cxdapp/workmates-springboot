package com.wokemates.Repository;

import com.wokemates.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findUserInfoByUsernameAndPassword(String username, String password);
}
