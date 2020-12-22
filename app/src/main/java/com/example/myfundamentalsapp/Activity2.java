package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        final EditText editText = findViewById(R.id.edit_text);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                intent.putExtra("message2",str);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        if (extra != null) {
            String message = extra.getString("message1");
            textView1.setText(R.string.received);
            textView2.setText(message);
        }
    }
}