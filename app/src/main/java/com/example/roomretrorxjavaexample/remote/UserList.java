package com.example.roomretrorxjavaexample.remote;

import com.example.roomretrorxjavaexample.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    @SerializedName("records")
    @Expose
    private List<User> userlist = null;

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }
}
