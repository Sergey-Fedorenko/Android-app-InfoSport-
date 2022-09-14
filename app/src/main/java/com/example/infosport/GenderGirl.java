package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class GenderGirl extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView11, imageView22, imageView33, imageView44, imageView55, imageView66;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_girl);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layouts);

        //Кнопка назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView11 = findViewById(R.id.imageViewGirl);
        imageView22 = findViewById(R.id.imageVieManNutrition);
        imageView33 = findViewById(R.id.imageViewTime);
        imageView44 = findViewById(R.id.imageViewSportPit);
        imageView55 = findViewById(R.id.imageViewArticles);
        imageView66 = findViewById(R.id.imageViewProducts);


        imageView11.setOnClickListener((View.OnClickListener) this);
        imageView22.setOnClickListener((View.OnClickListener) this);
        imageView33.setOnClickListener((View.OnClickListener) this);
        imageView44.setOnClickListener((View.OnClickListener) this);
        imageView55.setOnClickListener((View.OnClickListener) this);
        imageView66.setOnClickListener((View.OnClickListener) this);
    }



    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.imageViewGirl:
                Intent intent = new Intent(this,BodyTypeGirl.class);
                startActivity(intent);
                break;
            case R.id.imageVieManNutrition:
                Intent intent1 = new Intent(this, Nutrition_man.class);
                startActivity(intent1);
                break;
            case R.id.imageViewTime:
                Intent intent2 = new Intent(this, TimerManAndGirl.class);
                startActivity(intent2);
                break;
            case R.id.imageViewSportPit:
                Intent intent3 = new Intent(this, NotePad.class);
                startActivity(intent3);
                break;
            case R.id.imageViewArticles:
                Intent intent4 = new Intent(this, Articles.class);
                startActivity(intent4);
                break;
            case R.id.imageViewProducts:
                Intent intent5 = new Intent(this, DetermineWeightGirl.class);
                startActivity(intent5);
                break;
        }
    }
}