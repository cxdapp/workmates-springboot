package com.workmates.Service;

import com.workmates.Entity.*;

import java.util.List;

public interface UserService {

    Users getUser(String username, String password);
    Users getUser(Long id);
    Users getUser(String username);

    void save(Users users);
    void save(UserInfo userInfo);

    List<Users> getAllFriendsByMasterId(Long masterId);

    Role getRole(String id);
    void addUSRoles(USRoles2 usRoles2);
}
