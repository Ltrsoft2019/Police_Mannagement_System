package com.ltrsoft.police_mannagement_system.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.GettingFirRecycler;

public class CommonConstable extends Fragment {
    public CommonConstable() {}

    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.common_constable, container, false);
        recyclerView=view.findViewById(R.id.fir_list_constable);
        Bundle bundle =getArguments();
        String KGID = bundle.getString("KGID");
        GettingFirRecycler gettingFirRecycler=new GettingFirRecycler(recyclerView,KGID);
        gettingFirRecycler.setrecyclerview();
        return view;
    }
}