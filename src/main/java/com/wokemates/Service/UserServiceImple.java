package com.wokemates.Service;

import com.wokemates.Entity.FriendsRelationship;
import com.wokemates.Entity.UserInfo;
import com.wokemates.Repository.FriendsRelationRepository;
import com.wokemates.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FriendsRelationRepository friendsRelationRepository;

    @Override
    public UserInfo getUserByNameAndPassword(String username, String password) {
        List<UserInfo> userInfoList = userRepository.findAll();
//        userRepository.findUserInfosBySex(sex);
        return userRepository.findUserInfoByUsernameAndPassword(username, password);
    }

    @Override
    public List<UserInfo> getAllFriendsByMasterId(Integer masterId) {
        List<UserInfo> results=  new ArrayList<>();
        List<FriendsRelationship> frs = friendsRelationRepository.findFriendsRelationshipsByMasterId(masterId);
        if (frs.size() > 0) {
            for (FriendsRelationship fr :
                    frs) {
                UserInfo user = userRepository.findOne(fr.getId());
                results.add(user);
            }
            return results;
        } else {
            return null;
        }
    }
}
