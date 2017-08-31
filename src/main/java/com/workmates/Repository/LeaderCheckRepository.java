package com.workmates.Repository;

import com.workmates.Entity.LeaderCheck;
import com.workmates.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaderCheckRepository extends JpaRepository<LeaderCheck,Long> {
    List<LeaderCheck> findByReceiver(Users receiver);
}
