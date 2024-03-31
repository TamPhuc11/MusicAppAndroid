package com.example.myapplication.RecyclerAdapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ItemAdapter;
import com.example.myapplication.Domain.Item;
import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RlvLiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RlvLiFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RlvLiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RlvLiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RlvLiFragment newInstance(String param1, String param2) {
        RlvLiFragment fragment = new RlvLiFragment();
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
        initSampleData();
    }
    RecyclerView recyclerView;
    ArrayList<Item> itemArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rlv_li, container, false);
        recyclerView = view.findViewById( R.id.recyclerView );
        ItemAdapter item = new ItemAdapter(itemArrayList,getContext());
        recyclerView.setAdapter( item );
        // ItemAdapter itemAdapter = new ItemAdapter(itemArrayList,getContext(),this);
        // recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        return view;
    }
    void initSampleData() {
        itemArrayList = new ArrayList<Item>();

        itemArrayList.add( new Item( R.drawable.bd,"Bạn Đời","Karik f.t GDucky" ) );
        itemArrayList.add( new Item( R.drawable.fl,"FLOWERS","JISOO" ) );
        itemArrayList.add( new Item( R.drawable.sltk,"Sau Lời Từ Khước","Phan Mạnh Quỳnh" ) );
        itemArrayList.add( new Item( R.drawable.td,"Từ Đó","Phan Mạnh Quỳnh" ) );
    }

}