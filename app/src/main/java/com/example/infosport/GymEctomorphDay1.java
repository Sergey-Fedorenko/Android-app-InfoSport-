package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GymEctomorphDay1 extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Gym> list = new ArrayList<>();
    RecyclerViewAdapterEndomorphDay1 adapterEndomorphDay1;

    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_ectomorph_day1);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ActionBar Title по центру
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_ectomorph_day1);

        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String username[] = getResources().getStringArray(R.array.usernameDay1);
        int profileImage[] = {R.drawable.icon_gymlega,R.drawable.icon_gymtangi,R.drawable.icon_razvod,
                R.drawable.icon_gymbrus,R.drawable.icon_gymuzkim,R.drawable.icon_gymfranc,R.drawable.icon_tricepsnabloke,
                R.drawable.icon_korpuspodemi};

        String descForAll[] = getResources().getStringArray(R.array.userDescDay1);

        String desc[]= getResources().getStringArray(R.array.userDescrip1);

        for (int i=0;i<username.length;i++)
        {
            Gym gym = new Gym(profileImage[i],username[i],descForAll[i],desc[i]);
            list.add(gym);
        }
        adapterEndomorphDay1=new RecyclerViewAdapterEndomorphDay1(this,list);
        recyclerView.setAdapter(adapterEndomorphDay1);

    }
}