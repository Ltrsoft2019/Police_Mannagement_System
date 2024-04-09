package com.ltrsoft.police_mannagement_system.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.ACPDash;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.DySpDash;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.HierarchyAnalysis.ComplaintAnalysis;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.Login;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.PIDash;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.PSIDashboard;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.StationList;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.analysis.MainAnalysis;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.fragments.AllotedTask;
import com.ltrsoft.police_mannagement_system.fragments.Analysis;
import com.ltrsoft.police_mannagement_system.fragments.Analysis1;
import com.ltrsoft.police_mannagement_system.fragments.Analysis2;
import com.ltrsoft.police_mannagement_system.fragments.Analysis3;
import com.ltrsoft.police_mannagement_system.fragments.Analysis4;
import com.ltrsoft.police_mannagement_system.fragments.MyListings;
import com.ltrsoft.police_mannagement_system.fragments.PoliceAdd;
import com.ltrsoft.police_mannagement_system.utils.UserDataAccess;

public class Navigationfragment extends Fragment {
    private BottomNavigationView navigationView;
    NavigationView nav;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    String data, lang;
    ImageView imgr, editimg,float_drawer;
    TextView name;
    FloatingActionButton btn;
    View v1;
    private CardView feature_list;
    int position=0;
    private boolean flag=true;
    Fragment fragment ;
    TextView textView;
    public Navigationfragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sidenavigation, container, false);
        float_drawer = view.findViewById(R.id.float_drawer);
        feature_list = view.findViewById(R.id.feature_list);
        toolbar = view.findViewById(R.id.toolbar);
        btn=view.findViewById(R.id.floatingActionButton);
        navigationView = view.findViewById(R.id.ubotnav);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        nav = view.findViewById(R.id.naviga);
        drawerLayout = view.findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        float_drawer.setVisibility(View.GONE);

        loadFragment(new Analysis());
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id  = menuItem.getItemId();
                if (id==R.id.nav_home){
                    loadFragment(new Analysis());
                } else if (id==R.id.nav_history) {
                    loadFragment(new MyListings());
                }
                else if (id==R.id.nav_add) {
                    loadFragment(new PoliceAdd());
                }
                else if (id==R.id.nav_task) {
                    loadFragment(new AllotedTask());
                }else if (id==R.id.nav_report) {
                    loadFragment(new AllotedTask());
                }
                return false;
            }
        });
        return view;
    }

    private void loadFragment(Fragment fragment) {
    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        fragmentManager
                    .beginTransaction()
                    .replace(R.id.fraglayot,fragment)
                    .commit();
    }
}