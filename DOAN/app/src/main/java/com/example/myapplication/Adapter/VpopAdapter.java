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

import com.example.myapplication.Domain.Vpop;
import com.example.myapplication.PhatNhac.VpopActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class VpopAdapter extends RecyclerView.Adapter<VpopAdapter.VpopViewHolder> {
    ArrayList<Vpop> mListVpop;
    Context context;


    public VpopAdapter(ArrayList<Vpop> mListVpop, Context context) {
        this.mListVpop = mListVpop;
        this.context = context;

    }
    @NonNull
    @Override
    public VpopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate( R.layout.viewholder_vpop, parent, false);
        VpopViewHolder vpopviewHolder = new VpopViewHolder(view);
        return vpopviewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull VpopViewHolder holder, int position) {
        final Vpop vpop = mListVpop.get(position);
        holder.tvTenVpop.setText(vpop.getTvTenVpop());
        holder.imgVpop.setImageResource(vpop.getImgVpop());
        holder.frame_vpop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToPhatNhacVpop(vpop);
            }
        } );
    }
    private void onClickGoToPhatNhacVpop(Vpop vpop){
        Intent i = new Intent(context, VpopActivity.class );
        context.startActivity( i );
    }
    @Override
    public int getItemCount() {
        return mListVpop.size();
    }

    public class VpopViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgVpop;
        private TextView tvTenVpop;
        private FrameLayout frame_vpop;
        public VpopViewHolder(@NonNull View itemView) {
            super(itemView);
            imgVpop = itemView.findViewById(R.id.imgVpop);
            tvTenVpop = itemView.findViewById(R.id.tvTenVpop);
            frame_vpop = itemView.findViewById( R.id.frame_vpop );
        }
    }
}