package com.ltrsoft.police_mannagement_system.navigation;

import static android.content.Context.MODE_PRIVATE;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.Login;
import com.ltrsoft.police_mannagement_system.AnalysisFragment.analysis.MainAnalysis;
import com.ltrsoft.police_mannagement_system.MainActivity;
import com.ltrsoft.police_mannagement_system.Model.FeedBack;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.fragments.AboutPage;
import com.ltrsoft.police_mannagement_system.fragments.AddComplaint;
import com.ltrsoft.police_mannagement_system.fragments.AllotedTask;
import com.ltrsoft.police_mannagement_system.fragments.Analysis;
import com.ltrsoft.police_mannagement_system.fragments.FeedBacks;
import com.ltrsoft.police_mannagement_system.fragments.MyListings;
import com.ltrsoft.police_mannagement_system.fragments.PoliceAdd;
import com.ltrsoft.police_mannagement_system.fragments.PoliceLogin;
import com.ltrsoft.police_mannagement_system.fragments.Profile;
import com.ltrsoft.police_mannagement_system.fragments.UnidentifiedBody;
import com.ltrsoft.police_mannagement_system.utils.SessionManager;

public class Navigationfragment extends Fragment {
    private BottomNavigationView navigationView;
    NavigationView nav;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    String data, lang;
    ImageView imgr, editimg, float_drawer;
    TextView name;
    FloatingActionButton btn, btn2;
    View v1;
    private CardView feature_list;
    int position = 0;
    private boolean flag = true;
    Fragment fragment;
    TextView textView;

    public Navigationfragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sidenavigation, container, false);
        float_drawer = view.findViewById(R.id.float_drawer);
        feature_list = view.findViewById(R.id.feature_list);
        toolbar = view.findViewById(R.id.toolbar);
        btn = view.findViewById(R.id.floatingActionButton);
        btn2 = view.findViewById(R.id.floatingActionButton2);
        navigationView = view.findViewById(R.id.ubotnav);
        nav = view.findViewById(R.id.naviga);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        drawerLayout = view.findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        float_drawer.setVisibility(View.VISIBLE);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.nav_home) {
                    loadFragment(new Analysis());
                } else if (id == R.id.nav_profile) {
                    loadFragment(new Profile());
                } else if (id == R.id.nav_contact) {
                    String url = "https://ltr-soft.com";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));//                    loadFragment();
                    startActivity(intent);
                } else if (id == R.id.nav_about) {
                    loadFragment(new AboutPage());
                } else if (id == R.id.nav_feedback) {
                    loadFragment(new FeedBacks());
                } else if (id == R.id.nav_logout) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Logout Dailoge");
                    builder.setMessage("Do You Want To Logout?");
                    builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SessionManager sessionManager = new SessionManager(getContext());
                            sessionManager.setLogin(false);
                            Intent main_activity_intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(main_activity_intent);
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fraglayot, new Login())
                        .addToBackStack(null)
                        .commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fraglayot, new MainAnalysis())
                        .addToBackStack(null)
                        .commit();
            }
        });
        loadFragment(new Analysis());
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.nav_home) {
                    loadFragment(new Analysis());
                } else if (id == R.id.nav_history) {
                    loadFragment(new MyListings());
                } else if (id == R.id.nav_add) {
                    loadFragment(new PoliceAdd());
                } else if (id == R.id.nav_task) {
                    loadFragment(new AllotedTask());
                } else if (id == R.id.nav_report) {
                    loadFragment(new AllotedTask());
                }
                menuItem.setChecked(true);
                return false;
            }
        });

        float_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return view;
    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.fraglayot, fragment)
                .commit();
    }
}