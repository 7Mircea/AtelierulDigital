package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Person> mSource;
    private PersonRecyclerAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSource = getSource();
        mAdapter = getAdapter();
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    private List<Person> getSource() {
        List<Person> list = new ArrayList<>(12);
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());

        return list;
    }

    private PersonRecyclerAdapter getAdapter() {
        return new PersonRecyclerAdapter(mSource,this);
    }
}