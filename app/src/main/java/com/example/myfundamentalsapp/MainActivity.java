package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        final EditText editText = findViewById(R.id.edit_text);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("message1",str);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        if (extra != null) {
            String message = extra.getString("message2");
            textView1.setText(R.string.received);
            textView2.setText(message);
        }
    }
}