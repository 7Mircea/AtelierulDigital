package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import retrofit2.Retrofit;

public class TopRatedMoviesActivity extends AppCompatActivity implements MovieListener {
    private static Retrofit retrofit;
    private List<Movie> movieListTemp;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_rated_movies);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //recycler view part
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        //data source part.
        //am lasat-o ultima deoarece este considerata partea cea mai lenta
        DataSource dataSource = new DataSource();
        dataSource.getTopRatedMovies(this);
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