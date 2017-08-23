package com.workmates.Repository;


import com.workmates.Entity.FriendsMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FriendsMessageRepository extends JpaRepository<FriendsMessage,Integer> {

}
