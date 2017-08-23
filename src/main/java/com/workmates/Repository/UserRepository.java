package com.workmates.Repository;

import com.workmates.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String username);

    Users findByUsernameAndPassword(String username, String password);
}
