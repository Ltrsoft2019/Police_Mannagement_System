package com.ltrsoft.police_mannagement_system;

import
androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.Fragment.AcpanalyticalDashboardFragment;
 import com.ltrsoft.police_mannagement_system.navigation.navigationfragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_design);
//        setContentView(R.layout.demo);

//        navigationfragment navigationfragment=new navigationfragment();
//        AcpanalyticalDashboardFragment acpanalyticalDashboardFragment=new AcpanalyticalDashboardFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.main_container,acpanalyticalDashboardFragment).commit();


    }
}