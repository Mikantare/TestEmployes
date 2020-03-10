package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class addNote extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDayOfWeek;
    private RadioGroup radioGroupPriority;

    private NotesDBHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        dbHelper = new NotesDBHelper(this);
        database = dbHelper.getWritableDatabase();
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerDayOfWeek = findViewById(R.id.spinnerDayOfWeek);
        radioGroupPriority = findViewById(R.id.radioGroupPriority);


    }

    public void addNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String dayOfWeek = spinnerDayOfWeek.getSelectedItem().toString();
        int buttonId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton button = findViewById(buttonId);
        int priority = Integer.parseInt(button.getText().toString());
        if (isField(title,description)){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE,title);
        contentValues.put(NotesContract.NotesEntry.COLUMN_DESCRIPTION,description);
        contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK,dayOfWeek);
        contentValues.put(NotesContract.NotesEntry.COLUMN_PRIORITY,priority);
        database.insert(NotesContract.NotesEntry.TABLE_NAME,null,contentValues);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);}
        else {
            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isField (String tittle,String description) {
        return !tittle.isEmpty() | !description.isEmpty();
    }

}
