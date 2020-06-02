package com.example.roomretrorxjavaexample.room;

import android.service.autofill.UserData;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomretrorxjavaexample.model.User;


@Database(entities = {User.class},version = 1, exportSchema = false)
public  abstract  class UserDatabase extends RoomDatabase {

    public abstract UserDao1 userData1();
}
