package com.e.hamrobaazar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.hamrobaazar.R;
import com.e.hamrobaazar.models.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter <ItemAdapter.ViewHolder>{
    Context context;
    List<Item>items;

    public ItemAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //attaching layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate((R.layout.itemslayout),parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //attaching  data one by one
        Item item=items.get(position);
        holder.itemName.setText(item.getName());
        holder.itemImg.setImageResource(item.getImgId());
        holder.itemPrice.setText("Rs "+item.getPrice()+"");
        holder.itemCondition.setText(item.getCondition());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView itemImg;
        TextView itemName, itemPrice, itemCondition;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImg=itemView.findViewById(R.id.itemImg);
            itemName=itemView.findViewById(R.id.itemName);
            itemPrice=itemView.findViewById(R.id.itemPrice);
            itemCondition=itemView.findViewById(R.id.itemCondition);
        }
    }
}
