package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DescriptionMesomorph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_mesomorph);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_mesomorph);

        //Активации кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    public void textMesomorph(View view) {
        Intent intent = new Intent(DescriptionMesomorph.this, Mesomorph.class);
        startActivity(intent);
    }
}