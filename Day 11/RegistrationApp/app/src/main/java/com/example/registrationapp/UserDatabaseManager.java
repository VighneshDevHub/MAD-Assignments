package com.example.registrationapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabaseManager {
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public UserDatabaseManager(Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Create (Insert) a new user
    public long insertUser(String username, String email, String password, String gender) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);
        values.put("gender", gender);
        return db.insert("users", null, values);
    }

    // Read (Query) user by username
    public Cursor getUserByUsername(String username) {
        String[] columns = {"username", "email", "password", "gender"};
        String selection = "username = ?";
        String[] selectionArgs = {username};
        return db.query("users", columns, selection, selectionArgs, null, null, null);
    }

    private static class MyDatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "userdatabase.db";
        private static final int DATABASE_VERSION = 1;

        private static final String TABLE_USERS = "users";
        private static final String COLUMN_USERNAME = "username";
        private static final String COLUMN_EMAIL = "email";
        private static final String COLUMN_PASSWORD = "password";
        private static final String COLUMN_GENDER = "gender";

        private static final String TABLE_CREATE =
                "CREATE TABLE " + TABLE_USERS + " (" +
                        COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
                        COLUMN_EMAIL + " TEXT, " +
                        COLUMN_PASSWORD + " TEXT, " +
                        COLUMN_GENDER + " TEXT);";

        MyDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            onCreate(db);
        }
    }
}
