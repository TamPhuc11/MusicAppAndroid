package com.example.myapplication.RecyclerAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.NhacPhimAdapter;
import com.example.myapplication.Domain.NhacPhim;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NhacPhimFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NhacPhimFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NhacPhimFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NhacPhimFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NhacPhimFragment newInstance(String param1, String param2) {
        NhacPhimFragment fragment = new NhacPhimFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }
    RecyclerView rcv_nhacphim;
    ArrayList<NhacPhim> nhacphimArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
        initNPData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nhac_phim, container, false);
        rcv_nhacphim = view.findViewById( R.id.rcv_nhacphim );
        NhacPhimAdapter nps = new NhacPhimAdapter(nhacphimArrayList,getContext());
        rcv_nhacphim.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        rcv_nhacphim.setAdapter( nps );
        return view;
    }
    void initNPData() {
        nhacphimArrayList = new ArrayList<NhacPhim>();
        nhacphimArrayList.add( new NhacPhim( R.drawable.sck ,"Sao Cha Không" ) );
        nhacphimArrayList.add( new NhacPhim( R.drawable.sltk ,"Sau Lời Khước Từ" ) );
        nhacphimArrayList.add( new NhacPhim( R.drawable.cgrdk ,"Cha Già Rồi Đúng Không" ) );
        nhacphimArrayList.add( new NhacPhim( R.drawable.mctd ,"Mình Chia Tay Đi" ) );
        nhacphimArrayList.add( new NhacPhim( R.drawable.td ,"Từ Đó" ) );
    }
}