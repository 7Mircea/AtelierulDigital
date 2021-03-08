package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.widget.LinearLayout;

import java.util.List;

public class UpComingMoviesActivity extends AppCompatActivity implements MovieListener {
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_coming_movies);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.up_coming_movies_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(manager);
        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        DataSource source = new DataSource();
        source.getUpComingMovies(this);
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