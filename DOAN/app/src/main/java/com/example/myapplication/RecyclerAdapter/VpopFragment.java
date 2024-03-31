package com.example.myapplication.RecyclerAdapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.VpopAdapter;
import com.example.myapplication.Domain.Vpop;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VpopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VpopFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VpopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VpopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VpopFragment newInstance(String param1, String param2) {
        VpopFragment fragment = new VpopFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }
    RecyclerView rcv_vpop;
    ArrayList<Vpop> vpopArrayList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
        initVpopData();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vpop, container, false);
        rcv_vpop = view.findViewById( R.id.rcv_vpop );
       VpopAdapter vpops = new VpopAdapter(vpopArrayList,getContext());
        rcv_vpop.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        rcv_vpop.setAdapter( vpops );
        return view;
    }
    void initVpopData() {
       vpopArrayList = new ArrayList<Vpop>();
        vpopArrayList.add( new Vpop( R.drawable.ctcht ,"Chúng Ta Của Hiện Tại" ) );
        vpopArrayList.add( new Vpop( R.drawable.catena ,"Có Ai Thương Em Như Anh" ) );
        vpopArrayList.add( new Vpop( R.drawable.tard ,"Thích Anh Rồi Đấy" ) );
        vpopArrayList.add( new Vpop( R.drawable.dhxtdcn ,"Dành Hết Xuân Thì Để Chờ Nhau " ) );
        vpopArrayList.add( new Vpop( R.drawable.bl ,"Bận Lòng" ) );
        vpopArrayList.add( new Vpop( R.drawable.hmh ,"Hai Mươi Hai" ) );
    }
}