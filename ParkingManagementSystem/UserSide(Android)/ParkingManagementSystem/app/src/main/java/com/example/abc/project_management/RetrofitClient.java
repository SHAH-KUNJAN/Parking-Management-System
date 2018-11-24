package com.example.abc.project_management;

import java.util.concurrent.SynchronousQueue;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private  static final String BASE_URL ="http://192.168.43.205:8085/user/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    public RetrofitClient() {
        retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null)
            mInstance = new RetrofitClient();
        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
