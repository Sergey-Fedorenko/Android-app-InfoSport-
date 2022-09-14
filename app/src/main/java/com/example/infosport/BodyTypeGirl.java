package com.example.infosport;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.infosport.Gym;
import com.example.infosport.Item;
import com.example.infosport.R;
import com.example.infosport.RecyclerViewAdapterEndomorphDay1;

import java.util.ArrayList;
import java.util.List;

public class BodyTypeGirl extends AppCompatActivity {

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
        getSupportActionBar().setCustomView(R.layout.title_body_type_girl);

        //Активация кнопки назад
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String username[] = getResources().getStringArray(R.array.usernameDayqq);
        int profileImage[] = {R.drawable.girl1,R.drawable.girl2,R.drawable.girl3,
                R.drawable.girl4,R.drawable.girl5,R.drawable.girl6,R.drawable.girl7};

        String descForAll[] = getResources().getStringArray(R.array.userDescDaywqe);

        String desc[]= getResources().getStringArray(R.array.userDescrip12wqe);

        for (int i=0;i<username.length;i++)
        {
            Gym gym = new Gym(profileImage[i],username[i],descForAll[i],desc[i]);
            list.add(gym);
        }
        adapterEndomorphDay1=new RecyclerViewAdapterEndomorphDay1(this,list);
        recyclerView.setAdapter(adapterEndomorphDay1);

    }
}