package com.example.myfundamentalsapp;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit;
    private static MovieAPI api;
    public void getTopRatedMovies(MovieListener listener) {
        api = getAPI();
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

    public void getUpComingMovies(MovieListener listener) {
        api = getAPI();
        Call<UpComingMovies> upComingMoviesCall = api.getUpComingMovies();
        upComingMoviesCall.enqueue(new Callback<UpComingMovies>() {
            @Override
            public void onResponse(Call<UpComingMovies> call, Response<UpComingMovies> response) {
                if(response.isSuccessful()) {
                    listener.onMovieFetchedFromServer(response.body().getResults());
                } else {
                    Toast.makeText((Activity)listener,"Nu am putut prelua de la server lista " +
                            "de filme care urmeaza sa fie vazute",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UpComingMovies> call, Throwable t) {
                Log.d("DataSource.java","top rated movies call failed.");
            }
        });
    }

    public void getNowPlayingMovies(MovieListener listener) {
        MovieAPI  api = getAPI();
        Call<NowPlayingMovies> nowPlayingMoviesCall = api.getNowPlayingMovies();
        nowPlayingMoviesCall.enqueue(new Callback<NowPlayingMovies>() {
            @Override
            public void onResponse(Call<NowPlayingMovies> call, Response<NowPlayingMovies> response) {
                if(response.isSuccessful()) {
                    listener.onMovieFetchedFromServer(response.body().getResults());
                    Log.d("DataSource.java", "result = "+response.body().getResults().size());
                }else {
                    Toast.makeText((Activity)listener,"Nu am putut prelua de la server lista " +
                            "de filme care urmeaza sa fie vazute",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NowPlayingMovies> call, Throwable t) {
                Toast.makeText((Activity)listener,"Nu am putut prelua de la server lista " +
                        "de filme care urmeaza sa fie vazute",Toast.LENGTH_LONG).show();
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

    private MovieAPI getAPI() {
        if (api == null) {
            api = getRetrofit().create(MovieAPI.class);
        }
        return api;
    }
}
