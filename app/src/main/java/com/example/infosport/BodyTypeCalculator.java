package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class BodyTypeCalculator extends AppCompatActivity{

    public EditText editText;
    public TextView textView;
    public ImageView imageView;
    public ImageView imageView1, imageView2, imageView3;
    public Button button;
      public  Double age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_type_calculator);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_calculator);

        //Активации кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView11);
        button = findViewById(R.id.button1);
        imageView=findViewById(R.id.ImageBodyType); //Картинка , которая появляется


        imageView = findViewById(R.id.ImageBodyType);
        imageView1 = findViewById(R.id.imageView2); // Эндоморф
        imageView2 = findViewById(R.id.imageView4); // Эктоморф
        imageView3 = findViewById(R.id.imageView3); // Мезоморф
    }

    public void BodyType(View view) {
        //Проверяем пустое поле или нет
        if (!editText.getText().toString().equals("")) {
            age = Double.parseDouble(editText.getText().toString());
            if (age < 18) {
                textView.setText(R.string.ectomorph);
                imageView.setImageResource(R.drawable.icon_ectomorph);
                imageView.setTag(R.drawable.icon_ectomorph);

            } else if (age >= 18 && age <= 20) {
                textView.setText(R.string.mezomorph);
                imageView.setImageResource(R.drawable.icon_mesomorph);
                imageView.setTag(R.drawable.icon_mesomorph);

            } else {
                textView.setText(R.string.endomorph);
                imageView.setImageResource(R.drawable.icon_endomorph);
                imageView.setTag(R.drawable.icon_endomorph);
            }
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.okr, Toast.LENGTH_SHORT).show();
        }
    }

    //Переход на описание типа телосложения
    public void onClick(View v) {
       Integer integer = (Integer)v.getTag();
        switch (integer) {
            case R.drawable.icon_ectomorph:
                Intent intent1 = new Intent(this, DescriptionEctomorph.class);
                startActivity(intent1);
             break;
            case R.drawable.icon_mesomorph:
                Intent intent3 = new Intent(this, DescriptionMesomorph.class);
                startActivity(intent3);
                break;
            case R.drawable.icon_endomorph:
                Intent intent5 = new Intent(this, DescriptionEndomorph.class);
                startActivity(intent5);
                break;
        }
    }

}

