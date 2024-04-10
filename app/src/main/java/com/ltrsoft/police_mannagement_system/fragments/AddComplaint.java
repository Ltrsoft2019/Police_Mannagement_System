package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ltrsoft.police_mannagement_system.R;
public class AddComplaint extends Fragment {
    public AddComplaint() {}
    private View view;
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.form_designing, container, false);

        return view;
    }
}