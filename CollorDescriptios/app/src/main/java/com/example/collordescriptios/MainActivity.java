package com.example.collordescriptios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView textViewDescription;
    private Button buttonShowCollorDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        textViewDescription = findViewById(R.id.textViewDescription);
        buttonShowCollorDescription = findViewById(R.id.buttonShowCollorDescription);
       
    }

    public void getDescription(View view) {
        String collor = (String) spinner.getSelectedItem();
        switch (collor) {
            case "Красный":
                textViewDescription.setText(getString(R.string.collor_red));
                buttonShowCollorDescription.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                buttonShowCollorDescription.setBackgroundColor(getResources().getColor(android.R.color.white));
                break;
            case "Белый":
                textViewDescription.setText(getString(R.string.collor_white));
                buttonShowCollorDescription.setTextColor(getResources().getColor(android.R.color.white));
                buttonShowCollorDescription.setBackgroundColor(getResources().getColor(android.R.color.black));
                break;
            case "Черный":
                textViewDescription.setText(getString(R.string.collor_black));
                buttonShowCollorDescription.setTextColor(getResources().getColor(android.R.color.black));
                buttonShowCollorDescription.setBackgroundColor(getResources().getColor(android.R.color.white));
                break;
            case "Желтый":
                textViewDescription.setText(getString(R.string.collor_yellow));
                buttonShowCollorDescription.setBackgroundColor(getResources().getColor(android.R.color.white));
                buttonShowCollorDescription.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
                break;
            case "Синий":
                textViewDescription.setText(getString(R.string.collor_blue));
                buttonShowCollorDescription.setBackgroundColor(getResources().getColor(android.R.color.white));
                buttonShowCollorDescription.setTextColor(getResources().getColor(android.R.color.holo_blue_light));
                break;
        }

    }
}
