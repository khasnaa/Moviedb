package com.example.moviedb.retrofit;

import com.example.moviedb.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("data.php")
    Call<MainModel> getData();
}
