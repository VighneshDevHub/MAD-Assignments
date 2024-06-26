package com.example.database2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserDatabaseManager userDatabaseManager;
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextEmail;
    private TextView textViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use the modern approach for edge-to-edge
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        insetsController.setAppearanceLightStatusBars(true);

        setContentView(R.layout.activity_main);

        userDatabaseManager = new UserDatabaseManager(this);
        userDatabaseManager.open();

        editTextName = findViewById(R.id.editTextText);
        editTextAge = findViewById(R.id.editTextText2);
        editTextEmail = findViewById(R.id.editTextText3);  // Fixed variable name
        textViewUser = findViewById(R.id.textView2);

        Button adduserButton = findViewById(R.id.button);
        adduserButton.setOnClickListener(v -> addUsers());

        Button fetchUsersButton = findViewById(R.id.button2);
        fetchUsersButton.setOnClickListener(v -> fetchUsers());
    }

    private void addUsers() {
        String name = editTextName.getText().toString();
        String ageText = editTextAge.getText().toString();
        String email = editTextEmail.getText().toString();

        if (name.isEmpty() || ageText.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            userDatabaseManager.insertUser(name, age, email);
            Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show();
            clearFields();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid age format", Toast.LENGTH_SHORT).show();
        }
    }

    private void fetchUsers() {
        List<User> users = userDatabaseManager.getAllUsers();
        StringBuilder userDisplay = new StringBuilder();

        for (User user : users) {
            userDisplay.append("ID: ").append(user.getId())
                    .append(", Name: ").append(user.getName())
                    .append(", Age: ").append(user.getAge())
                    .append(", Email: ").append(user.getEmail())
                    .append("\n");
        }

        textViewUser.setText(userDisplay.toString());
    }

    private void clearFields() {
        editTextName.setText("");
        editTextAge.setText("");
        editTextEmail.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userDatabaseManager.close();
    }
}
