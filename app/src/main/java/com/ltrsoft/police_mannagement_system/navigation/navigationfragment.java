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
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.police_mannagement_system.Fragment.AcpanalyticalDashboardFragment;
import com.ltrsoft.police_mannagement_system.Fragment.Common_police_fragment;
import com.ltrsoft.police_mannagement_system.Fragment.DySPanalyticaldashboard;
import com.ltrsoft.police_mannagement_system.Fragment.PIanalyticaldashboard;
import com.ltrsoft.police_mannagement_system.R;

import com.ltrsoft.police_mannagement_system.fragment.PSIanalyticaldashboard;

public class navigationfragment extends Fragment {
    NavigationView nav;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    String data, lang;
    ImageView imgr, editimg;
    TextView name;
    View v1;
    int position=0;

    public navigationfragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sidenavigation, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        nav = view.findViewById(R.id.naviga);
        drawerLayout = view.findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

//    header section

        v1 = nav.getHeaderView(0);
        name = v1.findViewById(R.id.pname);
        imgr = v1.findViewById(R.id.imgrev);
        editimg = v1.findViewById(R.id.etedit);

        if (position==0) {
            AcpanalyticalDashboardFragment acp = new AcpanalyticalDashboardFragment();
            getFragmentManager().beginTransaction().add(R.id.fraglayot, acp).commit();
        }
        if (position==2) {
            DySPanalyticaldashboard acp = new DySPanalyticaldashboard();
            getFragmentManager().beginTransaction().add(R.id.fraglayot, acp).commit();
        }
        if (position==3) {
            PIanalyticaldashboard acp = new PIanalyticaldashboard();
            getFragmentManager().beginTransaction().add(R.id.fraglayot, acp).commit();
        }
        if (position==4) {
            PSIanalyticaldashboard acp = new PSIanalyticaldashboard();
            getFragmentManager().beginTransaction().add(R.id.fraglayot, acp).commit();
        }
        if (position==5) {
            Common_police_fragment acp = new Common_police_fragment();
            getFragmentManager().beginTransaction().add(R.id.fraglayot, acp).commit();
        }

        return view;
    }
}