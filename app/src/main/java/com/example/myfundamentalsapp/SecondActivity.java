package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        TextView paragraph = findViewById(R.id.paragraph);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        if (extra != null) {
            String var = extra.getString("type");
            if (var != null) {
                switch (var) {
                    case "freedom":
                        String paragraphFreedom = "";
                        for (int i = 0; i < 50; ++i) {
                            paragraphFreedom += getApplicationContext().getString(R.string.freedom);
                        }
                        paragraph.setText(paragraphFreedom);
                        break;
                    case "history":
                        String paragraphHistory = "";
                        for (int i = 0; i < 50; ++i) {
                            paragraphHistory += getApplicationContext().getString(R.string.history);
                        }
                        paragraph.setText(paragraphHistory);
                        break;
                    case "constitution":
                        String paragraphConstitution = "";
                        for (int i = 0; i < 50; ++i) {
                            paragraphConstitution += getApplicationContext().getString(R.string.constitution);
                        }
                        paragraph.setText(paragraphConstitution);
                        break;
                }
            }
        } else {
            paragraph.setText("No extra was set on the incoming intent.");
        }
    }
}