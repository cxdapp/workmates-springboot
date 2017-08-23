package com.workmates.dto;

import com.workmates.Entity.Users;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class Group {

    private String groupName;
    private List<Users> members;

    public Group() {
    }

    public Group(String groupName, List<Users> members) {
        this.groupName = groupName;
        this.members = members;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Users> getMembers() {
        return members;
    }

    public void setMembers(List<Users> members) {
        this.members = members;
    }
}
