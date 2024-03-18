package com.ltrsoft.police_mannagement_system;

import
androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ltrsoft.police_mannagement_system.Fragment.analysis.MainAnalysis;
import com.ltrsoft.police_mannagement_system.navigation.navigationfragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.demo);

        navigationfragment navigationfragment=new navigationfragment();
//        AcpanalyticalDashboardFragment acpanalyticalDashboardFragment=new AcpanalyticalDashboardFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container,new MainAnalysis()).commit();


    }
}