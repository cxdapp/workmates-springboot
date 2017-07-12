package com.wokemates.Service;

import com.wokemates.Entity.UserInfo;

import java.util.List;

public interface UserService {

    UserInfo getUserByNameAndPassword(String username, String password);

    List<UserInfo> getAllFriendsByMasterId(Integer masterId);
}
