package com.ltrsoft.police_mannagement_system.fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.CommonAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class AssignComplaint extends Fragment {
    public AssignComplaint() {}
    private RecyclerView assigncmp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comonrecycle, container, false);
        assigncmp = view.findViewById(R.id.assigncmp);
        ArrayList<HashMap<String,String>>maps=new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            HashMap<String,String>map=new HashMap<>();
            map.put("map1","Complaint Subject : Drug case");
            map.put("map2","Complaint Date : 17/04/2003");
//            map.put("map3","Complaint Location :Latur");
//            map.put("map4","Complaint against: Ganesh Sagave");
            maps.add(map);
        }

        CommonAdapter adapter = new CommonAdapter(maps,R.drawable.complaint);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        assigncmp.setLayoutManager(layoutManager);
        assigncmp.setAdapter(adapter);

        return view;
    }
}