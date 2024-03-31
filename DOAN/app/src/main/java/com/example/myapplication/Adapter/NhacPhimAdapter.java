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

import com.example.myapplication.Domain.NhacPhim;
import com.example.myapplication.Domain.Vpop;
import com.example.myapplication.PhatNhac.NhacPhimActivity;
import com.example.myapplication.PhatNhac.VpopActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class NhacPhimAdapter extends RecyclerView.Adapter<NhacPhimAdapter.NhacPhimViewHolder> {
    ArrayList<NhacPhim> mListNP;
    Context context;


    public NhacPhimAdapter(ArrayList<NhacPhim> mListNP, Context context) {
        this.mListNP = mListNP;
        this.context = context;

    }
    @NonNull
    @Override
    public NhacPhimViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate( R.layout.viewholder_nhacphim, parent, false);
        NhacPhimViewHolder nhacphimviewHolder = new NhacPhimViewHolder(view);
        return nhacphimviewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull NhacPhimViewHolder holder, int position) {
        final NhacPhim nhacphim = mListNP.get(position);
        holder.tvTenNP.setText(nhacphim.getTvTenNP());
        holder.imgNP.setImageResource(nhacphim.getImgNP());
        holder.frame_np.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToPhatNhacNP(nhacphim);
            }
        } );
    }
    private void onClickGoToPhatNhacNP(NhacPhim nhacphim){
        Intent i = new Intent(context, NhacPhimActivity.class );
        context.startActivity( i );
    }

    @Override
    public int getItemCount() {
        return mListNP.size();
    }

    public class NhacPhimViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgNP;
        private TextView tvTenNP;
        private FrameLayout frame_np;

        public NhacPhimViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNP = itemView.findViewById(R.id.imgNP);
            tvTenNP = itemView.findViewById(R.id.tvTenNP);
            frame_np = itemView.findViewById( R.id.frame_np );
        }
    }
}
