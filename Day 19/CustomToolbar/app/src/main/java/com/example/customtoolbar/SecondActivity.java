package com.example.customtoolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }

//        toolbar.setTitle("Toolbar");
//        toolbar.setSubtitle("Toolbar Example");



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemID = item.getItemId();

        if(itemID == R.id.group){
            Toast.makeText(this, "Crate a new Group", Toast.LENGTH_SHORT).show();
        }else if(itemID == R.id.broadcast){
            Toast.makeText(this, "Create a new Broadcast", Toast.LENGTH_SHORT).show();
        } else if (itemID == R.id.linked) {
            Toast.makeText(this, "Check Linked Devices", Toast.LENGTH_SHORT).show();
        } else if (itemID == R.id.starMsg) {
            Toast.makeText(this, "Check Starred Messages", Toast.LENGTH_SHORT).show();
        } else if (itemID == R.id.settings) {
            Toast.makeText(this, "Got to Settings", Toast.LENGTH_SHORT).show();
        } else if (itemID == R.id.payments) {
            Toast.makeText(this, "Send Payment", Toast.LENGTH_SHORT).show();
      }
//        else if (itemID == android.R.id.home) {
//            super.onBackPressed();
//
//        }


        return super.onOptionsItemSelected(item);
    }
}

