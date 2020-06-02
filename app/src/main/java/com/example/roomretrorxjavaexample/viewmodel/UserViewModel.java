package com.example.roomretrorxjavaexample.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomretrorxjavaexample.model.User;
import com.example.roomretrorxjavaexample.remote.UserRepository;

import java.util.List;

public class UserViewModel extends ViewModel {

    private Context context;

    private UserRepository userRepository;

    private LiveData<List<User>> userlistdata = new MutableLiveData<>();

    public UserViewModel(Context context) {
        this.context = context;
        this.userRepository = new UserRepository(context);
        userlistdata = userRepository.getUserlivedataList();
    }


    public void getUser()
    {
        this.context = context;
        this.userRepository = new UserRepository(context);
        userlistdata = userRepository.getUserlivedataList();

    }



    public LiveData<List<User>> getUserlivedataList() {

        userlistdata = userRepository.getUserlivedataList();
        return userlistdata;
    }
}
