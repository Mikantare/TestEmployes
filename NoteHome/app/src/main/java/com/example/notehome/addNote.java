package com.example.notehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;

public class addNote extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDayOfWeek;
    private RadioGroup radioGroupPrioryti;
    private NotesDBHelper dbHelper;
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.editTextTitle);
        dbHelper = new NotesDBHelper(this);
        database = dbHelper.getWritableDatabase();
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerDayOfWeek = findViewById(R.id.spinnerDayOfWeek);
        radioGroupPrioryti = findViewById(R.id.radioGroupPriority);

    }

    public void addNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        int dayOfWeek = spinnerDayOfWeek.getSelectedItemPosition() + 1;
        int radiButtonId = radioGroupPrioryti.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radiButtonId);
        int priority = Integer.parseInt(radioButton.getText().toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE,title);
        contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION,description);
        contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK,dayOfWeek);
        contentValues.put(NotesContract.NotesEntry.COLUMN_PRIORITY,priority);
        database.insert(NotesContract.NotesEntry.TABLE_NAME,null,contentValues);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
