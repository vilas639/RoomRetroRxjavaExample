package com.example.roomretrorxjavaexample.remote;

import com.example.roomretrorxjavaexample.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {


    @GET("androidservice/readuser.php")
    Call<List<User>>getUserList();
}
