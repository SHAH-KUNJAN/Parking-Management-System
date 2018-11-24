package com.example.abc.project_management;


import com.example.abc.project_management.POJOs.SlotDetails;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @POST("add")
    Call<ResponseBody> add(@Body UserDetails user);

    @POST("login")
    Call<ResponseBody> login(@Body LoginDetails lgdin);

    @GET("delete")
    Call<ResponseBody> cancel(@Body CancelDetail canceldetail);

    @POST("addBooking")
    Call<ResponseBody> booking(@Body BookDetails bookDetails);

    @POST("Organisation/{organisation}")
    Call<SlotDetails>  homesearch(@Path("organisation") String organizationName);

}
