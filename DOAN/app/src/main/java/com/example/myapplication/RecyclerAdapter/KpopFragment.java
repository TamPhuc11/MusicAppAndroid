package com.example.myapplication.RecyclerAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.KpopAdapter;
import com.example.myapplication.Domain.Kpop;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KpopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KpopFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KpopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KpopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KpopFragment newInstance(String param1, String param2) {
        KpopFragment fragment = new KpopFragment();
        Bundle args = new Bundle();
        args.putString( ARG_PARAM1, param1 );
        args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }

    RecyclerView rcv_kpop;
    ArrayList<Kpop> kpopArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getString( ARG_PARAM1 );
            mParam2 = getArguments().getString( ARG_PARAM2 );
        }
        initKpopData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kpop, container, false);
        rcv_kpop = view.findViewById( R.id.rcv_kpop );
        KpopAdapter kpops = new KpopAdapter(kpopArrayList,getContext());
        rcv_kpop.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        rcv_kpop.setAdapter( kpops );
        return view;
    }
    void initKpopData() {
        kpopArrayList = new ArrayList<Kpop>();
        kpopArrayList.add( new Kpop( R.drawable.ditto ,"DITTO" ) );
        kpopArrayList.add( new Kpop( R.drawable.fl ,"FLOWERS" ) );
        kpopArrayList.add( new Kpop( R.drawable.ss ,"Super Shy" ) );
        kpopArrayList.add( new Kpop( R.drawable.hylt ,"How You Like That" ) );
        kpopArrayList.add( new Kpop( R.drawable.omg ,"OMG" ) );
    }
}