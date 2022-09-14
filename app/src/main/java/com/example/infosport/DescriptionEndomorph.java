package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DescriptionEndomorph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_endomorph);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_endomorph);

        //Активации кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public void textEndomorph(View view) {
        Intent intent = new Intent(DescriptionEndomorph.this, Endomorph.class);
        startActivity(intent);
    }
}