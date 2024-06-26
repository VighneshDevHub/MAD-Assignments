package com.example.database2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

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
    public long insertUser(String name, int age, String email) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("email", email);
        return db.insert("users", null, values);
    }

    // Read (Query) all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Cursor cursor = db.query("users", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int age = cursor.getInt(cursor.getColumnIndexOrThrow("age"));
            String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            users.add(new User(id, name, age, email));
        }
        cursor.close();
        return users;
    }

    // Update a user's details
    public int updateUser(String name, int newAge, String newEmail) {
        ContentValues values = new ContentValues();
        values.put("age", newAge);
        values.put("email", newEmail);
        String selection = "name = ?";
        String[] selectionArgs = {name};
        return db.update("users", values, selection, selectionArgs);
    }

    // Delete a user
    public int deleteUser(String name) {
        String selection = "name LIKE ?";
        String[] selectionArgs = {name};
        return db.delete("users", selection, selectionArgs);
    }

    private static class MyDatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "userdatabase.db";
        private static final int DATABASE_VERSION = 1;

        private static final String TABLE_USERS = "users";
        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "name";
        private static final String COLUMN_AGE = "age";
        private static final String COLUMN_EMAIL = "email";

        private static final String TABLE_CREATE =
                "CREATE TABLE " + TABLE_USERS + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_AGE + " INTEGER, " +
                        COLUMN_EMAIL + " TEXT);";

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
