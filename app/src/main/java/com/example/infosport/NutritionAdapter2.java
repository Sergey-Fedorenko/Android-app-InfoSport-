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

public class NutritionAdapter2 extends RecyclerView.Adapter<NutritionAdapter2.ViewHolder> {

    ArrayList<MainModel1> mainModels1;
    Context context;

    public NutritionAdapter2(Context context, ArrayList<MainModel1> mainModels1){
        this.context = context;
        this.mainModels1 = mainModels1;
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
        holder.imageV.setImageResource(mainModels1.get(position).getLangLogo());
        holder.textV.setText(mainModels1.get(position).getLangName());
        holder.textViewD.setText(mainModels1.get(position).getLangDes());
        holder.textViewT.setText(mainModels1.get(position).getLangtime());

        holder.imageV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("image",mainModels1.get(position).getLangLogo()); //Передача фото на другое activity
                intent.putExtra("title",mainModels1.get(position).getLangName()); //Передача названия на др. activity
                intent.putExtra("describe",mainModels1.get(position).getLangDes()); //Передача кол-во ккал в др. activity
                intent.putExtra("time",mainModels1.get(position).getLangtime()); //Передача времени готовки в др. activity

                intent.putExtra("key",mainModels1.get(position).getLangRe());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mainModels1.size();
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
