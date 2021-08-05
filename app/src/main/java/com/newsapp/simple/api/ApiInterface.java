package com.newsapp.simple.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<MainNews> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<MainNews> getCategoryNews(
            @ Query("country") String country,
            @ Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey") String apiKey
    );



}
