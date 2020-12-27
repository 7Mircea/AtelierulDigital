package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();
        SecondFragment secondFragment = new SecondFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fragment,mainFragment,"tag").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.second_fragment,secondFragment,"tag2")
        .commit();
    }

    public void add(int a, int b) {
        SecondFragment fragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag("tag2");
        fragment.addTwoNumbers(a,b);
    }
}