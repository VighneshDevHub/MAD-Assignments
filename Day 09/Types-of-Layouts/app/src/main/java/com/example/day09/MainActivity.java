package com.example.day09;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Button sendEmailButton = findViewById(R.id.sendEmailButton);
//        sendEmailButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Send Email Button Clicked");
//                Toast.makeText(MainActivity.this, "Send Email Button Clicked", Toast.LENGTH_SHORT).show();
//                sendEmail();
//            }
//        });
//    }
//
//    private void sendEmail() {
//        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
//                "mailto", "vighneshsalunkhe949gmail.com", null));
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
//
//        // Specify the Gmail app to handle the intent
//        emailIntent.setPackage("com.google.android.gm");
//
//        // Check if the Gmail app is installed and can handle the intent
//        if (emailIntent.resolveActivity(getPackageManager()) != null) {
//            startActivity(emailIntent);
//        } else {
//            Toast.makeText(this, "Gmail app not available", Toast.LENGTH_LONG).show();
//        }
    }
}
