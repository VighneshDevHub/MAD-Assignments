package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent i = new Intent(SplashActivity.this,MainActivity.class);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(i);
            finish();
        }
    },4000);
    }

}
