package com.example.ordercoffe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderInfoActivity extends AppCompatActivity {

    private TextView textViewInfoOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        textViewInfoOrder = findViewById(R.id.textViewInfoOrder);
        Intent intent = getIntent();
        String order = intent.getStringExtra("order");
        textViewInfoOrder.setText(order);
    }
}
