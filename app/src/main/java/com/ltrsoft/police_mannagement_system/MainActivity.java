package com.ltrsoft.police_mannagement_system;

import
androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.ltrsoft.police_mannagement_system.Fragment.Login;
import com.ltrsoft.police_mannagement_system.navigation.Navigationfragment;
import com.ltrsoft.police_mannagement_system.utils.SessionManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Navigationfragment navigationfragment=new Navigationfragment();

        SessionManager sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.isLoggedIn()){
            getSupportFragmentManager()
                    .beginTransaction().
                    add(R.id.main_container,navigationfragment)
                    .commit();
        }else {
            getSupportFragmentManager()
                    .beginTransaction().
                    add(R.id.main_container,navigationfragment)
                    .commit();
        }

    }
}