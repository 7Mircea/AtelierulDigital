package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_view_activity);
        Button button = findViewById(R.id.button_send_to_fragment);
        final MainFragment mainFragment = new MainFragment();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageUsingMethod(mainFragment);
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fragment,mainFragment,"tag").commit();

    }

    private void sendMessageUsingMethod(MainFragment mainFragment) {
        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("tag");
        fragment.setTextView("Fragmentul a primit un mesaj din activitate printr-o metoda");
    }
}