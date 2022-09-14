package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mesomorph extends AppCompatActivity {

    TextView textDay1,textDay2,textDay3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesomorph);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_mesomorph);

        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textDay1 = findViewById(R.id.textViewDay12);
        textDay2 = findViewById(R.id.textViewDay23);
        textDay3 = findViewById(R.id.textViewDay34);
    }

    //Переход на план тренеровок в зависимости от выбранного дня
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewDay12:
                Intent intent = new Intent(this,GymMezomorphDay1.class);
                startActivity(intent);
                break;
            case R.id.textViewDay23:
                Intent intent1 = new Intent(this,GymMezomorphDay2.class);
                startActivity(intent1);
                break;
            case R.id.textViewDay34:
                Intent intent2 = new Intent(this,GymMezomorphDay3.class);
                startActivity(intent2);
                break;
        }

    }
}