package com.ltrsoft.police_mannagement_system.fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.police_mannagement_system.R;
public class AssignComplaint extends Fragment {
    public AssignComplaint() {
    }

    private RecyclerView assigncmp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
        assigncmp = view.findViewById(R.id.assigncmp);
        return view;
    }
}