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

import java.io.Serializable;
import java.util.ArrayList;

public class NutritionAdapter1   extends RecyclerView.Adapter<NutritionAdapter1.ViewHolder>{

    ArrayList<MainModel> mainModels;
    Context context;

    public NutritionAdapter1(Context context, ArrayList<MainModel> mainModels){
        this.context = context;
        this.mainModels = mainModels;
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
        holder.imageView.setImageResource(mainModels.get(position).getLangLogo());
        holder.textView.setText(mainModels.get(position).getLangName());
        holder.textViewDes.setText(mainModels.get(position).getLangDes());
        holder.textViewTime.setText(mainModels.get(position).getLangtime());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("image",mainModels.get(position).getLangLogo()); //Передача фото на другое activity
                intent.putExtra("title",mainModels.get(position).getLangName()); //Передача названия на др. activity
                intent.putExtra("describe",mainModels.get(position).getLangDes()); //Передача кол-во ккал в др. activity
                intent.putExtra("time",mainModels.get(position).getLangtime()); //Передача времени готовки в др. activity

                 intent.putExtra("key",mainModels.get(position).getLangRecipe());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView, textViewDes,textViewTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
            textViewDes = itemView.findViewById(R.id.des);
            textViewTime = itemView.findViewById(R.id.time);

        }
    }
}
