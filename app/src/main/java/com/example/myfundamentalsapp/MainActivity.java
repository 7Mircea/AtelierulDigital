package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MovieListener{

    private static Retrofit retrofit;
    private List<Movie> movieListTemp;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        //recycler view part
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        //data source part.
        //am lasat-o ultima deoarece este considerata partea cea mai lenta
        DataSource dataSource = new DataSource();
        dataSource.getMovie(this);
    }

    @Override
    public void onMovieFetchedFromServer(List<Movie> movieList) {
        adapter.setData(movieList);
    }
}