package com.example.sharedpreference;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private PreferencesManager preferencesManager;
    private EditText usernameEditText;
    private CheckBox notificationsCheckBox;
    private SeekBar fontSizeSeekBar;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferencesManager = new PreferencesManager(this);

        usernameEditText = findViewById(R.id.usernameEditText);
        notificationsCheckBox = findViewById(R.id.notificationsCheckBox);
        fontSizeSeekBar = findViewById(R.id.fontSizeSeekBar);
        saveButton = findViewById(R.id.saveButton);

        // Load saved preferences
        loadPreferences();

        // Save preferences on button click
        saveButton.setOnClickListener(v -> savePreferences());
    }

    private void loadPreferences() {
        String username = preferencesManager.getUsername();
        boolean notificationsEnabled = preferencesManager.areNotificationsEnabled();
        int fontSize = preferencesManager.getFontSize();

        usernameEditText.setText(username);
        notificationsCheckBox.setChecked(notificationsEnabled);
        fontSizeSeekBar.setProgress(fontSize);
    }

    private void savePreferences() {
        String username = usernameEditText.getText().toString();
        boolean notificationsEnabled = notificationsCheckBox.isChecked();
        int fontSize = fontSizeSeekBar.getProgress();

        preferencesManager.setUsername(username);
        preferencesManager.setNotificationsEnabled(notificationsEnabled);
        preferencesManager.setFontSize(fontSize);

        Log.d("PreferencesManager", "Preferences saved");
    }
}
