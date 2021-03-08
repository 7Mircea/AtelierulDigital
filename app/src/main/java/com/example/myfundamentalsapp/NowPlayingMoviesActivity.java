package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class NowPlayingMoviesActivity extends AppCompatActivity implements MovieListener {
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing_movies);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(manager);
        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        DataSource data = new DataSource();
        data.getNowPlayingMovies(this);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onMovieFetchedFromServer(List<Movie> movieList) {
        adapter.setData(movieList);
    }
}