package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BodyTypeMan extends AppCompatActivity implements  View.OnClickListener {

    private  Button buttonEn, buttonEc, buttonMe;
    private TextView textViewBodyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_type_man);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_bodytypeman);

        //Активации кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        buttonEn = findViewById(R.id.buttonEndomorph);
        buttonEc = findViewById(R.id.buttonEctomorph);
        buttonMe = findViewById(R.id.buttonMesomorph);
        textViewBodyType = findViewById(R.id.textBodyType);

        buttonEn.setOnClickListener((View.OnClickListener) this);
        buttonEc.setOnClickListener((View.OnClickListener) this);
        buttonMe.setOnClickListener((View.OnClickListener) this);
        textViewBodyType.setOnClickListener((View.OnClickListener) this);

    }

    //Переход на программы тренировок в зависимости от телосложения
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonEndomorph:
                Intent intent = new Intent(this, Endomorph.class);
                startActivity(intent);
                break;

            case R.id.buttonEctomorph:
                Intent intent1 = new Intent(this, Ectomorph.class);
                startActivity(intent1);
                break;

            case R.id.buttonMesomorph:
                Intent intent2 = new Intent(this, Mesomorph.class);
                startActivity(intent2);
                break;

            case R.id.textBodyType:
                Intent intent3 = new Intent(this, BodyTypeCalculator.class);
                startActivity(intent3);
                break;

        }
    }
}