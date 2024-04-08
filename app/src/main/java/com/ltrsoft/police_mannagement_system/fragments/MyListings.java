package com.ltrsoft.police_mannagement_system.fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.ltrsoft.police_mannagement_system.R;
public class MyListings extends Fragment {
    public MyListings() {}
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mylist, container, false);

        Toast.makeText(getContext(), "this is MyListings", Toast.LENGTH_SHORT).show();
        return view;
    }

}