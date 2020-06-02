package com.example.roomretrorxjavaexample.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://ec2-3-7-71-137.ap-south-1.compute.amazonaws.com/";

    private static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

  public static  ApiService getApiService()
  {
       return  getRetrofitInstance().create(ApiService.class);
  }


}
