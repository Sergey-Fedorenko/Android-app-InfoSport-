package com.example.infosport;

import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;
        import java.util.List;

        import de.hdodenhof.circleimageview.CircleImageView;
        import ru.embersoft.expandabletextview.ExpandableTextView;

public class RecyclreViewAdapterGirl extends RecyclerView.Adapter<RecyclreViewAdapterGirl.MyViewHolder> {
    Context context;
    List<Gym> list;

    public RecyclreViewAdapterGirl(Context context, List<Gym> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclreViewAdapterGirl.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclreViewAdapterGirl.MyViewHolder holder, int position) {

        final Gym item = list.get(position);
        holder.profileImage.setImageResource(list.get(position).getImageProfile());
        holder.username.setText(list.get(position).getUsername());
        holder.userDesc.setText(list.get(position).getUserDes());
        holder.descTextView1.setText(item.getDesc());
        holder.descTextView1.setOnStateChangeListener(isShrink -> {
            Gym contentItem = list.get(position);
            contentItem.setShrink(isShrink);
            list.set(position, contentItem);
        });

        holder.descTextView1.setText(item.getDesc());
        holder.descTextView1.resetState(item.isShrink());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profileImage;
        TextView username, userDesc;
        ExpandableTextView descTextView1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage=itemView.findViewById(R.id.profileImage);
            userDesc=itemView.findViewById(R.id.userDesc);
            username=itemView.findViewById(R.id.username);
            descTextView1 = itemView.findViewById(R.id.descTextView);
        }
    }
}
