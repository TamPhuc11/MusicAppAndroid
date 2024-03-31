package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Domain.Banner;
import com.example.myapplication.R;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    ArrayList<Banner> mListBanner;
    Context context;

    // ItemOnClickListener ItemOnClickListener;
    public BannerAdapter(ArrayList<Banner> mListBanner, Context context) {
        this.mListBanner = mListBanner;
        this.context = context;
        // this.ItemOnClickListener = ItemOnClickListener;
    }


    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.viewholder_banner, parent, false);
        BannerViewHolder bannerviewHolder = new BannerViewHolder(view);
        return bannerviewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        final Banner banner = mListBanner.get(position);
        holder.imgBanner.setImageResource(banner.getImgBanner());

    }
    @Override
    public int getItemCount() {
        return mListBanner.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgBanner;

        private FrameLayout frame_banner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBanner = itemView.findViewById(R.id.imgBanner);
            frame_banner = itemView.findViewById( R.id.frame_banner );
        }
    }
}
