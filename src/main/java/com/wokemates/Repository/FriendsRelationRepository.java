package com.wokemates.Repository;

import com.wokemates.Entity.FriendsRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRelationRepository extends JpaRepository<FriendsRelationship, Integer> {
    List<FriendsRelationship> findFriendsRelationshipsByMasterId(Integer masterId);
}
