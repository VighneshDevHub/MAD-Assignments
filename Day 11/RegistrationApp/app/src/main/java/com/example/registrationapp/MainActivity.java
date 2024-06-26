package com.example.registrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private UserDatabaseManager userDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDatabaseManager = new UserDatabaseManager(this);
        userDatabaseManager.open();

        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText confirmPassword = findViewById(R.id.confirmPassword);
        RadioGroup genderGroup = findViewById(R.id.genderGroup);
        CheckBox terms = findViewById(R.id.terms);
        Button registerButton = findViewById(R.id.registerButton);
        TextView login = findViewById(R.id.login);

        registerButton.setOnClickListener(view -> {
            String usernameStr = username.getText().toString().trim();
            String emailStr = email.getText().toString().trim();
            String passwordStr = password.getText().toString().trim();
            String confirmPasswordStr = confirmPassword.getText().toString().trim();
            int selectedGenderId = genderGroup.getCheckedRadioButtonId();

            String genderStr = "";
            if (selectedGenderId != -1) {
                RadioButton selectedGender = findViewById(selectedGenderId);
                genderStr = selectedGender.getText().toString();
            }

            if (usernameStr.isEmpty() || emailStr.isEmpty() ||
                    passwordStr.isEmpty() || confirmPasswordStr.isEmpty() || genderStr.isEmpty() || !terms.isChecked()) {
                Toast.makeText(MainActivity.this, "Please fill all fields and agree to the terms.", Toast.LENGTH_SHORT).show();
            } else if (!passwordStr.equals(confirmPasswordStr)) {
                Toast.makeText(MainActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            } else {
                long result = userDatabaseManager.insertUser(usernameStr, emailStr, passwordStr, genderStr);
                if (result != -1) {
                    Toast.makeText(MainActivity.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("username", usernameStr);
                    intent.putExtra("email", emailStr);
                    intent.putExtra("gender", genderStr);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Registration failed. Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userDatabaseManager.close();
    }
}
