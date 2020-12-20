package com.example.myfundamentalsapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Log.i("NewActivity","onCreate()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("NewActivity","onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("NewActivity","onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("NewActivity","onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("NewActivity","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("NewActivity","onPause()");
    }
}
