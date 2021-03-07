package com.example.myfundamentalsapp;

import java.util.List;

public interface MovieListener {
    void onMovieFetchedFromServer(List<Movie> movieList);
}
