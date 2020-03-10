package com.example.scrollbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ListView listView;
    private TextView textViewNumber;

    private ArrayList<Integer> nums;
    private int max = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        textViewNumber = findViewById(R.id.textViewNumber);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.getProgress() < 1) {
                    seekBar.setProgress(1);
                }

                nums = new ArrayList<>();
                for (int i = 1; i <= max; i++) {

                    nums.add(seekBar.getProgress() * i);
                }
                ListAdapter adapter = new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_list_item_1,nums);
                listView.setAdapter(adapter);
                textViewNumber.setText(String.format(getResources().getString(R.string.text_number),seekBar.getProgress() ));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textViewNumber.setText(String.format(getResources().getString(R.string.text_number), 0));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
        seekBar.setProgress(10);

    }
}
