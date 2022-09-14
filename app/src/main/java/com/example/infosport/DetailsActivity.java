package com.example.infosport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity  {

    private ImageView imageView;
    private TextView title,description,descriptiontime,detailDescriptionR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.imageView14);
        title = findViewById(R.id.detailTitle);
        description = findViewById(R.id.detailDescription);
        descriptiontime = findViewById(R.id.detailDescriptionTime);
        detailDescriptionR = findViewById(R.id.detailDescriptionRezept);

        imageView.setImageResource(getIntent().getIntExtra("image",0));
        title.setText(getIntent().getStringExtra("title"));
        description.setText(getIntent().getStringExtra("describe"));
        descriptiontime.setText(getIntent().getStringExtra("time"));


        detailDescriptionR.setText(getIntent().getStringExtra("key"));
    }
}