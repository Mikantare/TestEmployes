package com.example.star;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private String posh24 = "http://www.posh24.se/kandisar";
    private String result;
    private ArrayList<Star> stars;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ImageView imageView;
    private String image = null;
    private int trueStarNumber;
    private String trueName;
    private String defaultName2;
    private String defaultName3;
    private String defaultName4;
    private ArrayList <Button> buttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        imageView = findViewById(R.id.imageView);
        buttons = new ArrayList<>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);

        getContent();
        startGame();





    }

    private void getContent () {
        DownloadTask downloadTask = new DownloadTask();
        stars = new ArrayList<>();
        try {
            result = downloadTask.execute(posh24).get();
            String url = result.toString();
            Pattern patternImage = Pattern.compile("img src=\"(.*?)\" alt");
            Matcher matcherImage = patternImage.matcher(url);
            Pattern patternName = Pattern.compile("alt=\"(.*?)\"/");
            Matcher matcherName = patternName.matcher(url);
            while (matcherImage.find() && matcherName.find()) {
                stars.add(new Star(matcherName.group(1), matcherImage.group(1)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private void setTrueStarNumber () {
        trueStarNumber = (int) ((float) stars.size() *  Math.random());
    }

    private void startGame () {
        setTrueStarNumber();
        Star star = stars.get(trueStarNumber);
        String urlImage = star.getImageUrl();
        String trueName = star.getName();
        Log.i("MyResult",urlImage);
        DownloadImage downloadImage = new DownloadImage();
        try {
            Bitmap bitmap =downloadImage.execute(urlImage).get();
            imageView.setImageBitmap(bitmap);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int numberTrueButton = (int) (Math.random() * buttons.size());
        for (int i = 0; i< buttons.size();i++){
            if (i == numberTrueButton){
                buttons.get(i).setText(star.getName());
            } else {
                Star starI = stars.get(((int) (Math.random()*stars.size())));
                buttons.get(i).setText(starI.getName());
            }

        }
    }


    private static class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url = null;
            HttpURLConnection urlConnection = null;
            StringBuilder resultImage = new StringBuilder();
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
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
    }

    public void OnClikName(View view) {


    }

    private static class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuilder result = new StringBuilder();
            URL url = null;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    result.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return result.toString();
        }
    }
}
