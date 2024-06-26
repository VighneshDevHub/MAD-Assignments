package com.example.basicapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        Button b = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editText);
        EditText email = findViewById(R.id.email);
        EditText passW = findViewById(R.id.password);
        EditText confirmPassword = findViewById(R.id.confirmPassword);
        CheckBox checkBox = findViewById(R.id.checkBox);
        RadioGroup rg = findViewById(R.id.rg);

        b.setOnClickListener(v -> {
            // Get input values
            String s = editText.getText().toString();
            String emailAddress = email.getText().toString();
            String password = passW.getText().toString();
            String confirmPs = confirmPassword.getText().toString();
            int rid = rg.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(rid);

            if (s.isEmpty() || emailAddress.isEmpty() || password.isEmpty() || confirmPs.isEmpty()) {
                Toast.makeText(this, "Please enter all details!", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPs)) {
                Toast.makeText(this, "Password do not match!", Toast.LENGTH_SHORT).show();
            } else if (rid == -1) {
                Toast.makeText(this, "Please select a gender!", Toast.LENGTH_SHORT).show();
            } else {
                // Extract gender from selected radio button
                String gender = selectedRadioButton.getText().toString();

                // Display information
                Toast.makeText(this, "Succefully Registerd!", Toast.LENGTH_SHORT).show();

                if (checkBox.isChecked()) {
                    // Start new activity with extra data
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("Username", s);
                    intent.putExtra("Email", emailAddress);
                    intent.putExtra("Gender", gender);
                    startActivity(intent);
                }
            }
        });
    }
}
