package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.utils.ActionBarTitle;

public class Report extends Fragment {
    public Report() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.report, container, false);
         ActionBarTitle.setTiltle("Report", (AppCompatActivity) getActivity());
         Toast.makeText(getContext(), "There is no any current Report", Toast.LENGTH_SHORT).show();
         return view;
    }
}