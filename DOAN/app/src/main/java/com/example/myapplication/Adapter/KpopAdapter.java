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

import com.example.myapplication.Domain.Kpop;
import com.example.myapplication.Domain.Vpop;
import com.example.myapplication.PhatNhac.KpopActivity;
import com.example.myapplication.PhatNhac.VpopActivity;
import com.example.myapplication.R;

import java.util.ArrayList;

public class KpopAdapter extends RecyclerView.Adapter<KpopAdapter.KpopViewHolder> {
    ArrayList<Kpop> mListKpop;
    Context context;


    public KpopAdapter(ArrayList<Kpop> mListKpop, Context context) {
        this.mListKpop = mListKpop;
        this.context = context;

    }
    @NonNull
    @Override
    public KpopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate( R.layout.viewholder_kpop, parent, false);
        KpopViewHolder kpopviewHolder = new KpopViewHolder(view);
        return kpopviewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull KpopViewHolder holder, int position) {
        final Kpop kpop = mListKpop.get(position);
        holder.tvTenKpop.setText(kpop.getTvTenbhKpop());
        holder.imgKpop.setImageResource(kpop.getImgKpop());
        holder.frame_kpop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToPhatNhacKpop(kpop);
            }
        } );
    }
    private void onClickGoToPhatNhacKpop(Kpop kpop){
        Intent i = new Intent(context, KpopActivity.class );
        context.startActivity( i );
    }
    @Override
    public int getItemCount() {
        return mListKpop.size();
    }

    public class KpopViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgKpop;
        private TextView tvTenKpop;
        private FrameLayout frame_kpop;

        public KpopViewHolder(@NonNull View itemView) {
            super(itemView);
            imgKpop = itemView.findViewById(R.id.imgKpop);
            tvTenKpop = itemView.findViewById(R.id.tvTenKpop);
            frame_kpop = itemView.findViewById( R.id.frame_kpop );
        }
    }
}
