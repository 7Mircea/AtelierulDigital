package com.example.myfundamentalsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface MovieAPI {
    @GET("movie/top_rated?api_key=dd8e2c1d76bd2c6268a6aa54d950561c")
    Call<TopRatedMovies> getTopRatedMovies();
}
