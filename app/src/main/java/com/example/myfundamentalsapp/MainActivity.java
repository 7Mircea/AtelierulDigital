package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> mList;
    private ArrayAdapter<String> mAdapter;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.spinner);
        mList = getList();
        mAdapter = getAdapter();
        mSpinner.setAdapter(mAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                text ="Selected: "+text;
                Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("Cupcake");
        list.add("Donut");
        list.add("Eclair");
        list.add("KitKat");
        list.add("Pie");
        return list;
    }

    private ArrayAdapter<String> getAdapter() {
        return new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mList);
    }
}