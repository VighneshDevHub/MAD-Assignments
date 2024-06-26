package com.example.registrationapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private UserDatabaseManager userDatabaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        userDatabaseManager = new UserDatabaseManager(this);
        userDatabaseManager.open();

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.loginButton);
        TextView signUp = findViewById(R.id.signUp);

        loginButton.setOnClickListener(view -> {
            String usernameStr = username.getText().toString().trim();
            String passwordStr = password.getText().toString().trim();

            if (usernameStr.isEmpty() || passwordStr.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
            } else {
                Cursor cursor = userDatabaseManager.getUserByUsername(usernameStr);
                if (cursor.moveToFirst()) {
                    String storedPassword = cursor.getString(cursor.getColumnIndexOrThrow("password"));
                    if (storedPassword.equals(passwordStr)) {
                        Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, LoggedActivity.class);
                        intent.putExtra("username", usernameStr);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Incorrect password.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "User not found.", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userDatabaseManager.close();
    }
}
