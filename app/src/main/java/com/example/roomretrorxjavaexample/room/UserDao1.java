package com.example.roomretrorxjavaexample.room;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomretrorxjavaexample.model.User;

import java.util.List;

@Dao
public abstract interface UserDao1 {

    @Query("select * from users")
    LiveData<List<User>>  getAllfromdb();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void InsertAll(User ... users);
}
