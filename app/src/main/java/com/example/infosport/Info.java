package com.example.infosport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Info extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //Убрать ActionBar
        getSupportActionBar().hide();

        textView = findViewById(R.id.textVk);


    }

    public void onClick(View view) {
        Intent browserVK = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/club212990507"));
        startActivity(browserVK);
    }
}