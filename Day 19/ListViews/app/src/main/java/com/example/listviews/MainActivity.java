package com.example.listviews;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_country;
    ArrayList<String> arrCountry = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lv_country = findViewById(R.id.lv_country);

        arrCountry.add("India");
        arrCountry.add("United States");
        arrCountry.add("Canada");
        arrCountry.add("Australia");
        arrCountry.add("United Kingdom");
        arrCountry.add("Germany");
        arrCountry.add("France");
        arrCountry.add("China");
        arrCountry.add("Japan");
        arrCountry.add("Brazil");
        arrCountry.add("South Africa");
        arrCountry.add("Russia");
        arrCountry.add("Italy");
        arrCountry.add("Mexico");
        arrCountry.add("South Korea");
        arrCountry.add("Indonesia");
        arrCountry.add("Saudi Arabia");
        arrCountry.add("Turkey");
        arrCountry.add("Argentina");
        arrCountry.add("Netherlands");
        arrCountry.add("Spain");
        arrCountry.add("Nigeria");
        arrCountry.add("Egypt");
        arrCountry.add("Vietnam");
        arrCountry.add("Thailand");
        arrCountry.add("Malaysia");
        arrCountry.add("Singapore");
        arrCountry.add("New Zealand");
        arrCountry.add("Chile");
        arrCountry.add("Colombia");
        arrCountry.add("Philippines");
        arrCountry.add("Pakistan");
        arrCountry.add("Bangladesh");
        arrCountry.add("Sweden");
        arrCountry.add("Norway");
        arrCountry.add("Denmark");
        arrCountry.add("Finland");
        arrCountry.add("Ireland");
        arrCountry.add("Switzerland");
        arrCountry.add("Austria");
        arrCountry.add("Belgium");
        arrCountry.add("Portugal");
        arrCountry.add("Greece");
        arrCountry.add("Israel");
        arrCountry.add("UAE");
        arrCountry.add("Qatar");
        arrCountry.add("Kuwait");
        arrCountry.add("Oman");
        arrCountry.add("Morocco");
        arrCountry.add("Kenya");
        arrCountry.add("Ethiopia");
        arrCountry.add("Peru");
        arrCountry.add("Venezuela");
        arrCountry.add("Cuba");
        arrCountry.add("Iraq");
        arrCountry.add("Syria");
        arrCountry.add("Jordan");
        arrCountry.add("Lebanon");
        arrCountry.add("Afghanistan");
        arrCountry.add("Nepal");
        arrCountry.add("Sri Lanka");
        arrCountry.add("Myanmar");
        arrCountry.add("Cambodia");
        arrCountry.add("Laos");
        arrCountry.add("Kazakhstan");
        arrCountry.add("Uzbekistan");
        arrCountry.add("Turkmenistan");
        arrCountry.add("Azerbaijan");
        arrCountry.add("Georgia");
        arrCountry.add("Armenia");
        arrCountry.add("Mongolia");
        arrCountry.add("North Korea");
        arrCountry.add("Zimbabwe");
        arrCountry.add("Zambia");
        arrCountry.add("Uganda");
        arrCountry.add("Tanzania");
        arrCountry.add("Sudan");
        arrCountry.add("Somalia");
        arrCountry.add("Senegal");
        arrCountry.add("Ivory Coast");
        arrCountry.add("Ghana");
        arrCountry.add("Madagascar");
        arrCountry.add("Mozambique");
        arrCountry.add("Algeria");
        arrCountry.add("Tunisia");
        arrCountry.add("Libya");
        arrCountry.add("Jordan");
        arrCountry.add("Palestine");
        arrCountry.add("Lebanon");
        arrCountry.add("Bahrain");
        arrCountry.add("Cyprus");
        arrCountry.add("Iceland");
        arrCountry.add("Luxembourg");
        arrCountry.add("Monaco");
        arrCountry.add("Liechtenstein");
        arrCountry.add("Malta");
        arrCountry.add("San Marino");
        arrCountry.add("Andorra");
        arrCountry.add("Vatican City");
        arrCountry.add("Estonia");
        arrCountry.add("Latvia");
        arrCountry.add("Lithuania");
        arrCountry.add("Slovenia");
        arrCountry.add("Slovakia");
        arrCountry.add("Croatia");
        arrCountry.add("Bosnia and Herzegovina");
        arrCountry.add("Serbia");
        arrCountry.add("Montenegro");
        arrCountry.add("Macedonia");
        arrCountry.add("Albania");
        arrCountry.add("Kosovo");


        // Creating an ArrayAdapter
        ArrayAdapter<String> ad = new ArrayAdapter<>(
                this, // Context
                android.R.layout.simple_list_item_1, // Layout for individual items
                arrCountry // Data source

        );


        // Setting the adapter to the ListView
        lv_country.setAdapter(ad);

        // Set item click listener
        lv_country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Show a toast with the selected item
                Toast.makeText(MainActivity.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
        






    }
}