package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Fragment.InfoFragment;
import com.example.myapplication.Fragment.LibraryFragment;
import com.example.myapplication.Fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main);
        bottomNavigationView = findViewById( R.id.bottomNavigationView );
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fmNew;
            if(item.getItemId()==R.id.menuHome){
                fmNew =new HomeFragment();
                loadFragment( fmNew );
                return true;
            }
                if(item.getItemId()==R.id.menuSearch){
                    fmNew =new SearchFragment();
                    loadFragment( fmNew );
                    return true;
                }
                if(item.getItemId()==R.id.menuLibrary){
                    fmNew =new LibraryFragment();
                    loadFragment( fmNew );
                    return true;
                }
                if(item.getItemId()==R.id.menuInfo){
                    fmNew =new InfoFragment();
                    loadFragment( fmNew );
                    return true;
                }
                return true;
            }
        } );
    }
        public void loadFragment(Fragment fmNew){
            FragmentTransaction fmTran =getSupportFragmentManager().beginTransaction();
            fmTran.replace( R.id.frame_layout,fmNew );
            fmTran.addToBackStack( null );
            fmTran.commit();
        }
}