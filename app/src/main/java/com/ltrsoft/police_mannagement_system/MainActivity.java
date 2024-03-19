package com.ltrsoft.police_mannagement_system;

import
androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.ltrsoft.police_mannagement_system.navigation.Navigationfragment;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Navigationfragment navigationfragment=new Navigationfragment();
        getSupportFragmentManager()
                .beginTransaction().
                add(R.id.main_container,navigationfragment)
                .commit();
    }
}