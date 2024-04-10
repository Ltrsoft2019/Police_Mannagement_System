package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.police_mannagement_system.R;

public class Missing_Person extends Fragment {



    public Missing_Person() {

     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.missing__person, container, false);


    return  view;
    }
}