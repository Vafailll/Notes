package com.example.notes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner  spinnerDayOfWeek;
    private RadioGroup radioGroupPriority;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        editTextTitle=(EditText)findViewById(R.id.editTextTitle);
        editTextDescription=(EditText)findViewById(R.id.editTextDescription);
        spinnerDayOfWeek=(Spinner)findViewById(R.id.spinnerDayOfWeek);
        radioGroupPriority=(RadioGroup)findViewById(R.id.radioGroupPriority);
    }

    public void onClickSaveNote(View view) {
        String title=editTextTitle.getText().toString().trim();
        String desciption=editTextDescription.getText().toString().trim();
        int dayOfWeek=spinnerDayOfWeek.getSelectedItemPosition();
        int radioButtonId=radioGroupPriority.getCheckedRadioButtonId();
        RadioButton radioButton=findViewById(radioButtonId);
        int priority=Integer.parseInt(radioButton.getText().toString());
        if(isFilled(title,desciption)) {
            Note note=new Note(title,desciption,dayOfWeek,priority);
           viewModel.insertNote(note);
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Все поля должны быть заполнены!", Toast.LENGTH_SHORT).show();
        }

    }
    private boolean isFilled(String tittle,String description){
       return !tittle.isEmpty()&&!description.isEmpty();
    }
}
