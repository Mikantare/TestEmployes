package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private boolean isRunning = false;
    private int seconds = 0;
    private TextView textViewTimer;
    private Button buttonStart;
    private Button buttonPause;
    private Button buttonStop;
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textViewTimer);
        buttonStart= findViewById(R.id.buttonStart);
        buttonPause= findViewById(R.id.buttonPause);
        buttonStop= findViewById(R.id.buttonStop);
        run();
    }

    public void onClickStart(View view) {
        isRunning = true;
        color = ContextCompat.getColor(this,R.color.colorGreen);
    }

    public void onClickPause(View view) {
        isRunning = false;
        color = ContextCompat.getColor(this,R.color.colorRed);
    }

    public void onClickStop(View view) {
        isRunning = false;
        seconds = 0;
        color = ContextCompat.getColor(this,R.color.colorBlack);
    }

    public void run() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) /60;
                int secs = seconds % 3600;
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d",hours,minutes,secs);
                textViewTimer.setText(time);
                textViewTimer.setTextColor(color);
                buttonPause.setBackgroundColor(color);
                buttonStart.setBackgroundColor(color);
                buttonStop.setBackgroundColor(color);


                if (isRunning) {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}
