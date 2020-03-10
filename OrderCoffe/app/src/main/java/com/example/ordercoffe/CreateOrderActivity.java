package com.example.ordercoffe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CreateOrderActivity extends AppCompatActivity {

    private String name;
    private String password;
    private String drink;

    private TextView textViewAditives;
    private TextView textViewGreating;
    private RadioGroup radioGroupDrink;
    private Spinner spinnerTea;
    private Spinner spinnerCoffe;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxLemon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        textViewGreating = findViewById(R.id.textViewGreating);
        textViewAditives= findViewById(R.id.textViewAditives);
        radioGroupDrink = findViewById(R.id.radioGroupDrink);
        spinnerCoffe = findViewById(R.id.spinnerCoffe);
        spinnerTea = findViewById(R.id.spinnerTea);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        password = intent.getStringExtra("password");
        textViewGreating.setText(String.format(getResources().getString(R.string.greatin_text), name));
        drink = getResources().getString(R.string.radio_button_tea);
        textViewAditives.setText(String.format(getResources().getString(R.string.aditives_text),drink));


    }


    public void onClickChoiseDrink(View view) {
       int id =radioGroupDrink.getCheckedRadioButtonId();
       if (id == R.id.radioButtonTea) {
           drink = getResources().getString(R.string.radio_button_tea);
           spinnerTea.setVisibility(View.VISIBLE);
           spinnerCoffe.setVisibility(View.INVISIBLE);
           checkBoxLemon.setVisibility(View.VISIBLE);
       } if (id == R.id.radioButtonCoffe) {
            drink = getResources().getString(R.string.radio_button_coffe);
            spinnerTea.setVisibility(View.INVISIBLE);
            spinnerCoffe.setVisibility(View.VISIBLE);
            checkBoxLemon.setVisibility(View.INVISIBLE);
        }
        textViewAditives.setText(String.format(getResources().getString(R.string.aditives_text),drink));

    }

    public void onClickToCreateOrder(View view) {
        String aditievs;
        String typeOfDrink = null;
        StringBuilder builder = new StringBuilder();
        if (checkBoxSugar.isChecked()) {
            builder.append(getString(R.string.checkbox_sugar) + " ");
        } if (checkBoxMilk.isChecked()){
            builder.append(getString(R.string.checkbox_milk) + " ");
        } if (checkBoxLemon.isChecked() && drink.equals(getString(R.string.radio_button_tea))) {
            builder.append(getString(R.string.checkbox_lemon)+ " ");
        }
        if (builder.length() > 0) {
            aditievs = builder.toString();
        } else {
            aditievs = getResources().getString(R.string.without_aditievs);
        }
        if (drink.equals(getString(R.string.radio_button_tea))) {
            typeOfDrink = spinnerTea.getSelectedItem().toString();
        } if (drink.equals(getString(R.string.radio_button_coffe))) {
            typeOfDrink = spinnerCoffe.getSelectedItem().toString();
        }
        Intent intent = new Intent(this,OrderInfoActivity.class);
        String order = String.format("Уважаемый %s. \nВаш пароль: %s \nВаш напиток: %s. \nВаши добавки: %s. \nТип напитка: %s",name, password, drink, aditievs,typeOfDrink);
        intent.putExtra("order",order);
        startActivity(intent);
    }
}
