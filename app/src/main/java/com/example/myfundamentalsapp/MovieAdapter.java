package com.example.myfundamentalsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<Movie> movieList = new LinkedList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getName().setText(movieList.get(position).getOriginalTitle());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setData(List<Movie> movieList) {
        //stergem continutul listei anterioare
        //si adaugam copiem lista primita
        //daca nu am copia contitul ci doar adresa, cineva din exterior ar putea modifica
        // ce afisam fara a folosi functia setData() ci folosind doar referinta listei
        this.movieList.clear();
        this.movieList.addAll(movieList);

        notifyDataSetChanged();//anuntam recycler view ca setul de date care trebuie afisat
        // a fost modificat
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }

        public TextView getName() {
            return name;
        }
    }
}
