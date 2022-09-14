package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ectomorph extends AppCompatActivity {

    TextView day1,day2,day3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ectomorph);


        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_ectomorph);

        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        day1 = findViewById(R.id.textViewDay11);
        day2 = findViewById(R.id.textViewDay22);
        day3 = findViewById(R.id.textViewDay33);
    }
    //Переход на план тренеровок в зависимости от выбранного дня
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textViewDay11:
                Intent intent = new Intent(this, GymEctomorphDay1.class);
                startActivity(intent);
                break;
            case R.id.textViewDay22:
                Intent intent1 = new Intent(this, GymEctomorphDay2.class);
                startActivity(intent1);
                break;
            case R.id.textViewDay33:
                Intent intent2 = new Intent(this,GymEctomorphDay3.class);
                startActivity(intent2);
                break;
        }
    }
}