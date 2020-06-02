package com.example.roomretrorxjavaexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;

import com.example.roomretrorxjavaexample.adapter.UserAdapter;
import com.example.roomretrorxjavaexample.model.User;
import com.example.roomretrorxjavaexample.remote.UserRepository;
import com.example.roomretrorxjavaexample.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    UserRepository userRepository;

    private SwipeRefreshLayout  swipeRefreshLayout;
    private RecyclerView recyclerView;
    private UserViewModel  userViewModel;



    private UserAdapter  userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userRepository = new UserRepository(this);
        userRepository.getUserList();


        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        recyclerView = (RecyclerView) findViewById(R.id.listorder);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        userViewModel = new UserViewModel(this);

        CallData();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                CallData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    public void CallData()
    {
        userViewModel.getUserlivedataList();
        userViewModel.getUserlivedataList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter = new UserAdapter(users,MainActivity.this);
                recyclerView.setLayoutManager((new LinearLayoutManager(MainActivity.this)));
                recyclerView.setAdapter(userAdapter);
            }
        });
    }
}
