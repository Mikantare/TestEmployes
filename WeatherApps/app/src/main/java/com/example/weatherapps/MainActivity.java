package com.example.weatherapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private String url = "http://api.openweathermap.org/data/2.5/weather?q=Краснодар&APPID=12b7e38372f1206ff89ef6ba6d8b5498";
    private EditText editTextChooseCiti;
    private TextView textViewWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextChooseCiti = findViewById(R.id.editTextChooseCiti);
        textViewWeather = findViewById(R.id.textViewWeather);
        DownloadTask task = new DownloadTask();
        task.execute("http://api.openweathermap.org/data/2.5/weather?q=Владимир&APPID=12b7e38372f1206ff89ef6ba6d8b5498");



    }

    public void showWeather(View view) {
        if (editTextChooseCiti.length()>0) {
            String start = "http://api.openweathermap.org/data/2.5/weather?q=";
            String finish = "&APPID=12b7e38372f1206ff89ef6ba6d8b5498&units=metric&lang=ru";
            String city = editTextChooseCiti.getText().toString();
            url = start + city + finish;
            DownloadTask task = new DownloadTask();
            Log.i("MyResult", url);
            task.execute(url);
        } else {
            Toast.makeText(this, R.string.Warning_city, Toast.LENGTH_SHORT).show();
        }
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection urlConnection = null;
            StringBuilder builder = new StringBuilder();
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    builder.append(line);
                    line = bufferedReader.readLine();
                }
                return builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                String name = jsonObject.getString("name");
                Log.i("MyResult", name);
                JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
                int temp = jsonObjectMain.getInt("temp");
                JSONArray jsonArray = jsonObject.getJSONArray("weather");
                JSONObject jsonObjectWeather = jsonArray.getJSONObject(Integer.parseInt("0"));
                String weatherDescription = jsonObjectWeather.getString("description");
                textViewWeather.setText(String.format(getString(R.string.desctiption_weather),name,temp,weatherDescription));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }
}
