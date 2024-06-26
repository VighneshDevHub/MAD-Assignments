package com.example.registrationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoggedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged_activity);

        String username = getIntent().getStringExtra("username");

        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Welcome, " + username +" !");
    }
}
