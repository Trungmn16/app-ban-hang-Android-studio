package com.example.app_ban_hang.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit instane;

    public static Retrofit getInstane(String baseUrl){
        if(instane==null){
            instane = new Retrofit.Builder()
                    .baseUrl (baseUrl)
                    .addConverterFactory (GsonConverterFactory.create ())
                    .addCallAdapterFactory (RxJava3CallAdapterFactory.create ())
                    .build ();


        }
        return  instane;

    }

}
