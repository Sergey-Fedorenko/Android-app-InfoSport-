package com.example.infosport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NutritionAdapter4 extends RecyclerView.Adapter<NutritionAdapter4.ViewHolder> {

    ArrayList<MainModel3> mainModels3;
    Context context;

    public NutritionAdapter4(Context context, ArrayList<MainModel3> mainModels3){
        this.context = context;
        this.mainModels3 = mainModels3;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_itemnutrition,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageV.setImageResource(mainModels3.get(position).getLangLogo());
        holder.textV.setText(mainModels3.get(position).getLangName());
        holder.textViewD.setText(mainModels3.get(position).getLangDes());
        holder.textViewT.setText(mainModels3.get(position).getLangtime());

        holder.imageV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("image",mainModels3.get(position).getLangLogo()); //Передача фото на другое activity
                intent.putExtra("title",mainModels3.get(position).getLangName()); //Передача названия на др. activity
                intent.putExtra("describe",mainModels3.get(position).getLangDes()); //Передача кол-во ккал в др. activity
                intent.putExtra("time",mainModels3.get(position).getLangtime()); //Передача времени готовки в др. activity

                intent.putExtra("key",mainModels3.get(position).getLangRec());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mainModels3.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageV;
        TextView textV, textViewD,textViewT;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageV=itemView.findViewById(R.id.image_view);
            textV = itemView.findViewById(R.id.text_view);
            textViewD = itemView.findViewById(R.id.des);
            textViewT = itemView.findViewById(R.id.time);

        }
    }
}
