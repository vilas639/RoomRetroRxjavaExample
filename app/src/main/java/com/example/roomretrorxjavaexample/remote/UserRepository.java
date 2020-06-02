package com.example.roomretrorxjavaexample.remote;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.roomretrorxjavaexample.model.User;
import com.example.roomretrorxjavaexample.room.UserDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private Context context;

    UserDatabase userDatabase;

    private LiveData<List<User>>  userlistlivedata = new MutableLiveData<>();




    public UserRepository(Context context) {

        userDatabase=  Room.databaseBuilder(context,UserDatabase.class,"vilasDatabase").build();
       // userDatabase = Room.databaseBuilder(context,UserDatabase.class,"vilasDatabase").build();
        this.context = context;
    }

    public void getUserList()
    {
        ApiService apiService = RetroClass.getApiService();
        Call<List<User>> userListCall =apiService.getUserList();
        userListCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, final Response<List<User>> response) {

                Log.d("userlist",""+response.body());




                Completable.fromAction(new Action() {
                    @Override
                    public void run() throws Exception {

                        List<User> heroList = response.body();

                        //Creating an String array for the ListView
                String[] heroes = new String[heroList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getFirstName();
                    Log.d("userlist",""+heroes[i] );

                    User u = new User(heroList.get(i).getFirstName(),heroList.get(i).getLastName(),heroList.get(i).getAge());

                    userDatabase.userData1().InsertAll(u);

                }


                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                        Toast.makeText(context,"Data Inserted", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context,"ONError", Toast.LENGTH_LONG).show();

                    }
                });


            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Log.d("userlist",""+t.getMessage());
            }
        });
    }



    public LiveData<List<User>> getUserlivedataList() {

        userlistlivedata = userDatabase.userData1().getAllfromdb();
        return userlistlivedata;
    }

}
