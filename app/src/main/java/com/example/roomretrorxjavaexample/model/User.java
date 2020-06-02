package com.example.roomretrorxjavaexample.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private int id;

    @ColumnInfo(name="first_name")
    @SerializedName("first_name")
    @Expose
    private String firstName;

    @ColumnInfo(name="last_name")
    @SerializedName("last_name")
    @Expose
    private String lastName;

    @ColumnInfo(name="age")
    @SerializedName("age")
    @Expose
    private String age;

    public User(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
