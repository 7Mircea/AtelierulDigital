package com.example.myfundamentalsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextEmail = findViewById(R.id.email);
        final EditText editTextPhone = findViewById(R.id.phone);
        Button buttonSubmit = findViewById(R.id.submit);
        final CheckBox checkBox = findViewById(R.id.checkbox);
        final TextView textViewAfis = findViewById(R.id.textViewAfis);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String email = editTextEmail.getText().toString();
                String phone = editTextPhone.getText().toString();
                boolean t_c = checkBox.isChecked();
                boolean validEmail = email.trim().matches(emailPattern);
                if (email.isEmpty() || phone.isEmpty() || !t_c){
                    Toast.makeText(MainActivity.this,R.string.notifSecondChallenge,Toast.LENGTH_SHORT).show();
                }else if(validEmail) {
                    textViewAfis.setText(getString(R.string.afisSecondChallenge, email, phone, t_c));
                } else if(!validEmail) {
                    Toast.makeText(MainActivity.this,R.string.invalidEmail,Toast.LENGTH_SHORT).show();
                } else if (phone.length() != 10) {
                    Toast.makeText(MainActivity.this,R.string.invalidEmail,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}