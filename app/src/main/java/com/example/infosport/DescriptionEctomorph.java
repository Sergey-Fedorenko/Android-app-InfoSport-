package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DescriptionEctomorph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_ectomorph);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_ectomorph);

        //Активации кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //Переход на план тренировок - Эктоморф
    public void textEctomorph(View view) {
        Intent intent = new Intent(DescriptionEctomorph.this, Ectomorph.class);
        startActivity(intent);
    }

    public void onClick(View view) {
    }
}