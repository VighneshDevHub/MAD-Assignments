package com.example.unitconverter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurrencyConversion extends AppCompatActivity {

    private Spinner spinnerFrom, spinnerTo;
    private EditText etAmount;
    private TextView tvResult;
    private Button btnConvert;
    private List<String> currencyList;
    private String apiKey = "your_api_key"; // Replace with your API key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_conversion);

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        etAmount = findViewById(R.id.etAmount);
        tvResult = findViewById(R.id.tvResult);
        btnConvert = findViewById(R.id.btnConvert);

        currencyList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencyList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        // Fetch currency list from API
        new FetchCurrencyListTask().execute();

        btnConvert.setOnClickListener(v -> {
            String fromCurrency = spinnerFrom.getSelectedItem().toString();
            String toCurrency = spinnerTo.getSelectedItem().toString();
            String amountStr = etAmount.getText().toString().trim();

            if (!amountStr.isEmpty()) {
                double amount = Double.parseDouble(amountStr);
                // Perform conversion
                new ConvertCurrencyTask().execute(fromCurrency, toCurrency, amountStr);
            } else {
                etAmount.setError("Please enter an amount.");
            }
        });
    }

    private void showErrorMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }

    private class FetchCurrencyListTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String jsonString;

            try {
                URL url = new URL("https://openexchangerates.org/api/currencies.json");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Read the input stream into a String
                StringBuilder buffer = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                jsonString = buffer.toString();

                // Parse JSON response
                JSONObject jsonObject = new JSONObject(jsonString);
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    String value = jsonObject.getString(key);
                    currencyList.add(key + " - " + value);
                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
                showErrorMessage("Error fetching currency list: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // Notify adapter that data set has changed
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) spinnerFrom.getAdapter();
            adapter.notifyDataSetChanged();
            ArrayAdapter<String> adapter2 = (ArrayAdapter<String>) spinnerTo.getAdapter();
            adapter2.notifyDataSetChanged();
        }
    }

    private class ConvertCurrencyTask extends AsyncTask<String, Void, Double> {

        @Override
        protected Double doInBackground(String... strings) {
            String fromCurrency = strings[0];
            String toCurrency = strings[1];
            String amountStr = strings[2];
            double amount = Double.parseDouble(amountStr);

            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String jsonString;
            double result = 0;

            try {
                URL url = new URL("https://openexchangerates.org/api/latest.json?app_id=" + apiKey);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Read the input stream into a String
                StringBuilder buffer = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                jsonString = buffer.toString();

                // Parse JSON response
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONObject rates = jsonObject.getJSONObject("rates");

                double rateFrom = rates.getDouble(fromCurrency);
                double rateTo = rates.getDouble(toCurrency);

                result = amount * (rateTo / rateFrom);

            } catch (IOException | JSONException e) {
                e.printStackTrace();
                showErrorMessage("Error converting currency: " + e.getMessage());
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return result;
        }

        @Override
        protected void onPostExecute(Double result) {
            super.onPostExecute(result);
            tvResult.setText(String.format("%.2f", result));
        }
    }
}
