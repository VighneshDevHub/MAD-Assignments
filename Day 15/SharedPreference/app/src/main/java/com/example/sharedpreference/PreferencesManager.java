package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {
    private static final String PREFS_NAME = "UserPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_NOTIFICATIONS_ENABLED = "notifications_enabled";
    private static final String KEY_FONT_SIZE = "font_size";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public PreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // Save username
    public void setUsername(String username) {
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    // Retrieve username
    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, "");
    }

    // Save notifications enabled
    public void setNotificationsEnabled(boolean enabled) {
        editor.putBoolean(KEY_NOTIFICATIONS_ENABLED, enabled);
        editor.apply();
    }

    // Retrieve notifications enabled
    public boolean areNotificationsEnabled() {
        return sharedPreferences.getBoolean(KEY_NOTIFICATIONS_ENABLED, true);
    }

    // Save font size
    public void setFontSize(int fontSize) {
        editor.putInt(KEY_FONT_SIZE, fontSize);
        editor.apply();
    }

    // Retrieve font size
    public int getFontSize() {
        return sharedPreferences.getInt(KEY_FONT_SIZE, 14);
    }
}
