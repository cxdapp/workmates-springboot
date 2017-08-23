package com.workmates.Repository;

import com.workmates.Entity.FriendsRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRelationRepository extends JpaRepository<FriendsRelationship, Long> {
    List<FriendsRelationship> findByMasterId(Long masterId);
}
