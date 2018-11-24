package com.example.abc.project_management;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitOwner {
    private  static final String BASE_URL1 ="http://192.168.43.205:8085/ParkingOwner/";
    private static RetrofitOwner mInstance;
    private Retrofit retrofit;

    public RetrofitOwner() {
        retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitOwner getInstance(){
        if(mInstance==null)
            mInstance = new RetrofitOwner();
        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }


}
