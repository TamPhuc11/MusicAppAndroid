package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DangKyActivity;
import com.example.myapplication.Domain.Item;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    ArrayList<Item> mListItem;
    Context context;

    // ItemOnClickListener ItemOnClickListener;
    public ItemAdapter(ArrayList<Item> mListItem, Context context) {
        this.mListItem = mListItem;
        this.context = context;
        // this.ItemOnClickListener = ItemOnClickListener;
    }
    /*public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_library, parent,false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }*/

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_nhacthuvien, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item item = mListItem.get(position);
        holder.tvLibh.setText(item.getTvLibh());
        holder.tvLics.setText(item.getTvLics());
        holder.img.setImageResource(item.getImg());

    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvLibh;
        private TextView tvLics;
        private FrameLayout frame_li;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgLi);
            tvLibh = itemView.findViewById(R.id.tvLibh);
            tvLics = itemView.findViewById(R.id.tvLics);
            frame_li = itemView.findViewById( R.id.frame_li );
        }
    }
}
