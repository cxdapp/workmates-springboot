package com.workmates.Entity;

import javax.persistence.*;

@Entity
@Table(name = "FriendsRelationship")
public class FriendsRelationship {
    @Id
    @GeneratedValue
    private int id;
    private Long masterId;
    private Long friendId;

    public FriendsRelationship() {
        super();
    }

    public FriendsRelationship(Long masterId, Long friendId) {
        this.masterId = masterId;
        this.friendId = friendId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Long getMasterId() {
        return masterId;
    }
    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }

    public Long getFriendId() {
        return friendId;
    }
    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }


}
