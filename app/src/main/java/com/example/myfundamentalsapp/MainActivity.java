package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button topRatedMoviesButton;
    private Button upComingMoviesButton;
    private Button nowPlayingMoviesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        topRatedMoviesButton = findViewById(R.id.top_rated_movies_button);
        upComingMoviesButton = findViewById(R.id.up_coming_movies_button);
        nowPlayingMoviesButton = findViewById(R.id.now_playing_movies_button);

        topRatedMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TopRatedMoviesActivity.class);
                startActivity(intent);
            }
        });

        upComingMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UpComingMoviesActivity.class);
                startActivity(intent);
            }
        });

        nowPlayingMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NowPlayingMoviesActivity.class);
                startActivity(intent);
            }
        });

    }

    

}