package com.example.infosport;
//Адаптер для статей

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.embersoft.expandabletextview.ExpandableTextView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<Item> items;
    private Context context;

    public Adapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder,int position) {

        final Item item = items.get(position);
        holder.imageView.setImageResource(item.getImageResourse());
        holder.titleTextView1.setText(item.getTitle());
        holder.descTextView1.setText(item.getDesc());
        holder.descTextView1.setOnStateChangeListener(isShrink -> {
            Item contentItem = items.get(position);
            contentItem.setShrink(isShrink);
            items.set(position, contentItem);
        });

        holder.descTextView1.setText(item.getDesc());
        holder.descTextView1.resetState(item.isShrink());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        ExpandableTextView descTextView1;
        TextView titleTextView1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            descTextView1 = itemView.findViewById(R.id.descTextView);
            titleTextView1 = itemView.findViewById(R.id.titleTextView);
        }
    }
}
