package com.wokemates.Repository;

import com.wokemates.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface UserRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findUserInfoByUsernameAndPassword(String username, String password);

    List<UserInfo> findUserInfosBySex(String sex);

    UserInfo findUserInfosByBirthdayBefore(Timestamp date);
}
