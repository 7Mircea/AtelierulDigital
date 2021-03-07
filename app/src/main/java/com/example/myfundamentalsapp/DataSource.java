package com.example.myfundamentalsapp;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit;
    public void getMovie(MovieListener listener) {
        MovieAPI api = getRetrofit().create(MovieAPI.class);
        Call<TopRatedMovies> topRatedMoviesCall = api.getTopRatedMovies();
        topRatedMoviesCall.enqueue(new Callback<TopRatedMovies>() {
            @Override
            public void onResponse(Call<TopRatedMovies> call, Response<TopRatedMovies> response) {
                if (response.isSuccessful()) {
                    listener.onMovieFetchedFromServer(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<TopRatedMovies> call, Throwable t) {
                Log.d("DataSource.java","top rated movies call failed.");
            }
        });
    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
