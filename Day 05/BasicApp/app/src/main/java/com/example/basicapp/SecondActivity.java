package com.example.basicapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView username = findViewById(R.id.usernameField);
        TextView email = findViewById(R.id.emailField);
        TextView gender = findViewById(R.id.genderField);

        Bundle bundle = getIntent().getExtras();
        String userText = bundle.getString("Username");
        String emailText = bundle.getString("Email");
        String genderText = bundle.getString("Gender");

        username.setText("Username: "+userText);
        email.setText("Email: "+ emailText);
        gender.setText("Gender: "+ genderText);

    }
}