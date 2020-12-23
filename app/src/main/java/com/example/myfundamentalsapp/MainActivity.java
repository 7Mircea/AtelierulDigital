package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = getFragmentManager().findFragmentById(R.id.main_fragment);
        //Fragment fragment = getFragmentManager().findFragmentById(R.id.main_fragment);
        Bundle bundle = new Bundle();
        bundle.putString("cheie","Am trimis un Bundle");
        if (fragment != null)
            fragment.setArguments(bundle);
        else
            Toast.makeText(MainActivity.this,"There's no fragment",Toast.LENGTH_LONG).show();

    }
}