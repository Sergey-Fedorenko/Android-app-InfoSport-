package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Endomorph extends AppCompatActivity {

    TextView textView89,textView82,textView85;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endomorph);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_endomorph);

        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView89 = findViewById(R.id.textViewDay1);
        textView82 = findViewById(R.id.textViewDay2);
        textView85 = findViewById(R.id.textViewDay3);
    }

    //Переход на план тренеровок в зависимости от выбранного дня
    public void onClick(View v) {
       switch (v.getId()) {
            case R.id.textViewDay1:
                Intent intent = new Intent(this, GymEndomorphDay1.class);
                startActivity(intent);
                break;
            case R.id.textViewDay2:
                Intent intent1 = new Intent(this,GymEndomorphDay2.class);
                startActivity(intent1);
                break;
            case R.id.textViewDay3:
                Intent intent2 = new Intent(this,GymEndomorphDay3.class);
                startActivity(intent2);
                break;
        }
    }
}