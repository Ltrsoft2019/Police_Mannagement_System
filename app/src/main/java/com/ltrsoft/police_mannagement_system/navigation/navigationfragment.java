package com.ltrsoft.police_mannagement_system.navigation;

import
        android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.police_mannagement_system.Fragment.analys.*;
import com.ltrsoft.police_mannagement_system.R;


public class navigationfragment extends Fragment {
    NavigationView nav;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    String data, lang;
    ImageView imgr, editimg,float_drawer;
    TextView name;
    View v1;
    private CardView feature_list;
    int position=0;
    private boolean flag=true;
    public navigationfragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sidenavigation, container, false);
        float_drawer = view.findViewById(R.id.float_drawer);
        feature_list = view.findViewById(R.id.feature_list);
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        nav = view.findViewById(R.id.naviga);
        drawerLayout = view.findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        float_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    feature_list.setVisibility(View.VISIBLE);
                    flag=false;
                }
                else {
                    feature_list.setVisibility(View.GONE);
                    flag=true;
                }
            }
        });
        v1 = nav.getHeaderView(0);
        name = v1.findViewById(R.id.pname);
        imgr = v1.findViewById(R.id.imgrev);
        editimg = v1.findViewById(R.id.etedit);
        if (position==0) {
            getFragmentManager().beginTransaction().add(R.id.fraglayot, new TotalACP()).commit();
        }

        return view;
    }
}