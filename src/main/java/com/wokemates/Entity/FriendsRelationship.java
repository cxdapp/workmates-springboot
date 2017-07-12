package com.wokemates.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "FriendsRelationship")
public class FriendsRelationship {
    @Id
    @GeneratedValue
    private int id;
    private Integer masterId;
    private Integer friendId;

    public FriendsRelationship() {
        super();
    }

    public FriendsRelationship(Integer masterId, Integer friendId) {
        this.masterId = masterId;
        this.friendId = friendId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Integer getMasterId() {
        return masterId;
    }
    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getFriendId() {
        return friendId;
    }
    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }


}
