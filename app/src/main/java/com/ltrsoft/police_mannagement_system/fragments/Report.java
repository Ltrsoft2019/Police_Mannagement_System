package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.R;

public class Report extends Fragment {
    public Report() {
        // Required empty public constructor
    }
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.report, container, false);
         Toast.makeText(getContext(), "this is Report fragment", Toast.LENGTH_SHORT).show();
         return view;
    }
}