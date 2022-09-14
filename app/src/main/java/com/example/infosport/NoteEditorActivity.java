package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);
        EditText editText = (EditText) findViewById(R.id.editText);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_notepad);

        Intent intent = getIntent();
        noteId=intent.getIntExtra("noteId",-1);

        if (noteId !=- 1){
        editText.setText(NotePad.notes.get(noteId));

        } else {
            NotePad.notes.add("");
            noteId= NotePad.notes.size()-1;
            NotePad.arrayAdapter.notifyDataSetChanged();

        }
    editText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            NotePad.notes.set(noteId,String.valueOf(charSequence));
            NotePad.arrayAdapter.notifyDataSetChanged();

            SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.noteappdemo", Context.MODE_PRIVATE);

            HashSet<String> set = new HashSet<>(NotePad.notes);
            sharedPreferences.edit().putStringSet("notes",set).apply();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    });
    }
}