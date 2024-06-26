package com.example.day07;

import android.os.Bundle;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Day 07
        CheckBox checkBox = findViewById(R.id.checkBox);
        boolean isChecked = checkBox.isChecked();

        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        boolean isChecked2 = checkBox.isChecked();

        CheckBox checkBox3 = findViewById(R.id.checkBox);
        boolean isChecked3 = checkBox.isChecked();

    }
}