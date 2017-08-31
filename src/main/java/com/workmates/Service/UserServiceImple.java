package com.workmates.Service;

import com.workmates.Entity.*;
import com.workmates.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private FriendsRelationRepository friendsRelationRepository;
    @Autowired
    private USRolesRepository2 usRolesRepository2;
    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    public void save(Users users) {
        users.setPassword(getPasswordEncoder().encode(users.getPassword()));
        userRepo.save(users);
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoRepo.save(userInfo);
    }

    //查询用户
    @Override
    public Users getUser(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }
    @Override
    public Users getUser(String username ){
        return userRepo.findByUsername(username);
    }
    public Users getUser(Long id) {
        return userRepo.findOne(id);
    }

    //根据用户id查找朋友信息
    @Override
    public List<Users> getAllFriendsByMasterId(Long masterId) {
        List<Users> results=  new ArrayList<>();
        List<FriendsRelationship> frs = friendsRelationRepository.findByMasterId(masterId);
        if (frs.size() > 0) {
            for (FriendsRelationship fr :
                    frs) {
                Users user = userRepo.findOne(fr.getFriendId());
                results.add(user);
            }
            return results;
        } else {
            return null;
        }
    }

    @Override
    public Role getRole(String id) {
        return roleRepository.findOne(id);
    }

    @Override
    public void addUSRoles(USRoles2 usRoles2) {
        usRolesRepository2.save(usRoles2);
    }

}
