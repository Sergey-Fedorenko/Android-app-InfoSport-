package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Articles extends AppCompatActivity {

    private ArrayList<Item> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_articles);

        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new Adapter(items,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items.add(new Item(R.drawable.icon_1,getString(R.string.title1),getString(R.string.desc1)));
        items.add(new Item(R.drawable.icon_2,getString(R.string.title2),getString(R.string.desc2)));
        items.add(new Item(R.drawable.icon_3,getString(R.string.title3),getString(R.string.desc3)));
        items.add(new Item(R.drawable.icon_4,getString(R.string.title4),getString(R.string.desc4)));
        items.add(new Item(R.drawable.icon_5,getString(R.string.title5),getString(R.string.desc5)));
        items.add(new Item(R.drawable.icon_6,getString(R.string.title6),getString(R.string.desc6)));

    }
}