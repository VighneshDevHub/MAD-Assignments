package com.example.asynchronousprogramming;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchDataTask extends AsyncTask<String, Integer, String> {

    private TextView textView;
    private ProgressBar progressBar;

    // Constructor to initialize the TextView and ProgressBar
    public FetchDataTask(TextView textView, ProgressBar progressBar) {
        this.textView = textView;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        // Runs on the UI thread before doInBackground
        // Initialize and show a progress bar
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);
    }

    @Override
    protected String doInBackground(String... params) {
        // Perform background computation
        String urlString = params[0]; // URL to call
        String result = "";

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                result = response.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        // Runs on the UI thread when publishProgress is called
        // Update progress bar
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        // Runs on the UI thread after doInBackground completes
        // Hide progress bar and update UI with result
        progressBar.setVisibility(View.GONE);
        if (result != null) {
            textView.setText(result);
        } else {
            textView.setText("Error fetching data");
        }
    }
}

// Usage in an Activity or Fragment
public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        String url = "https://catfact.ninja/fact\n";
        new FetchDataTask(textView, progressBar).execute(url);
    }
}

