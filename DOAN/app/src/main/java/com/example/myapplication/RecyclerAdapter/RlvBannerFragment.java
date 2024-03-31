package com.example.myapplication.RecyclerAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.BannerAdapter;
import com.example.myapplication.Domain.Banner;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RlvBannerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RlvBannerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RlvBannerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RlvBannerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RlvBannerFragment newInstance(String param1, String param2) {
        RlvBannerFragment fragment = new RlvBannerFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
        initBannerData();
    }
    RecyclerView rcv_banner;
    ArrayList<Banner> bannerArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rlv_banner, container, false);
        rcv_banner = view.findViewById( R.id.rcv_banner );
        BannerAdapter banners = new BannerAdapter(bannerArrayList,getContext());
        rcv_banner.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        rcv_banner.setAdapter( banners );
        return view;
    }
    void initBannerData() {
        bannerArrayList = new ArrayList<Banner>();
        bannerArrayList.add( new Banner( R.drawable.banner1 ) );
        bannerArrayList.add( new Banner( R.drawable.banner2 ) );
        bannerArrayList.add( new Banner( R.drawable.banner3 ) );
        bannerArrayList.add( new Banner( R.drawable.banner4 ) );
    }

}