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
import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.police_mannagement_system.Fragment.ACPDash;
import com.ltrsoft.police_mannagement_system.Fragment.DistrictList;
import com.ltrsoft.police_mannagement_system.Fragment.DySpDash;
import com.ltrsoft.police_mannagement_system.Fragment.PIDash;
import com.ltrsoft.police_mannagement_system.Fragment.PSIDashboard;
import com.ltrsoft.police_mannagement_system.Fragment.StationList;
import com.ltrsoft.police_mannagement_system.Fragment.analysis.MainAnalysis;
import com.ltrsoft.police_mannagement_system.R;
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

        navigationView = view.findViewById(R.id.ubotnav);
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

        UserDataAccess access = new UserDataAccess();
        String position=access.getPosition(getActivity());
        String kgid = access.getKgid(getActivity());
        Bundle bundle = new Bundle();
        bundle.putString("KGID",kgid);
        bundle.putString("IONAME",kgid);

//        Fragment fragment1 = ;

            if (position.equals("ACP")){
            Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
            fragment = new ACPDash();
            fragment.setArguments(bundle);
            loadFragment(fragment);
        } else if (position.equals("PI")) {
            Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
            fragment = new PIDash();
            fragment.setArguments(bundle);
            loadFragment(fragment);
        }else if (position.equals("PSI")) {
            Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
            fragment = new PSIDashboard();
            fragment.setArguments(bundle);
            loadFragment(fragment);
        }else if (position.equals("Dy.Sp")) {
            Toast.makeText(getContext(), "position"+position, Toast.LENGTH_SHORT).show();
            fragment = new DySpDash();
            fragment.setArguments(bundle);
            loadFragment(fragment);
        }
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id  = menuItem.getItemId();

                if (id==R.id.nav_home){
                    loadFragment(fragment);
                }
                else if (id==R.id.nav_history) {
                    MainAnalysis analysis = new MainAnalysis();
                    analysis.setArguments(bundle);
                    loadFragment(analysis);
                }
                else if (id==R.id.nav_add) {
                    DistrictList analysis = new DistrictList();
                    analysis.setArguments(bundle);
                    loadFragment(analysis);
                }
                else if (id==R.id.nav_task){
                    StationList stationList=new StationList();
                    stationList.setArguments(bundle);
                    loadFragment(stationList);
                }
                return false;
            }
        });
        return view;
    }

    private void loadFragment(Fragment fragment) {
    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        Fragment prevous = fragmentManager.findFragmentById(R.id.fraglayot);
        fragmentManager
                    .beginTransaction()
                    .replace(R.id.fraglayot,fragment)
                    .commit();
    }
}