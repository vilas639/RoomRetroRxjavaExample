package com.example.roomretrorxjavaexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomretrorxjavaexample.R;
import com.example.roomretrorxjavaexample.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {


        private List<User> userList;

        Context context;

            public UserAdapter(List<User> userList, Context context) {
                this.userList = userList;
                this.context = context;
            }

    public void setUserList(List<User> userList) {
            this.userList = userList;
            notifyDataSetChanged();
        }

        @Override
        public UserAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inner,parent,false);
            return new MyViewHolder(view);
        }



        @Override
        public void onBindViewHolder(UserAdapter.MyViewHolder holder, int position) {

                User u=userList.get(position);

                holder.firstname.setText(u.getFirstName());
                holder.lastanem.setText(u.getLastName());
                holder.age.setText(u.getAge());

                //holder.tvTitle.setText(userList.get(position).getName());
        }

        @Override
        public int getItemCount() {
            if(userList != null){
                return userList.size();
            }
            return 0;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView firstname,lastanem,age;

            public MyViewHolder(View itemView) {
                super(itemView);
                firstname = (TextView) itemView.findViewById(R.id.firstname);
                lastanem = (TextView) itemView.findViewById(R.id.lastname);
                age = (TextView) itemView.findViewById(R.id.age);
            }
        }
    }
