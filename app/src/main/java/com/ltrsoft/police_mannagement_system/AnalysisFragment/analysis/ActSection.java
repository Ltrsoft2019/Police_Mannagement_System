package com.ltrsoft.police_mannagement_system.AnalysisFragment.analysis;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ltrsoft.police_mannagement_system.Model.FirModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.FirAdapter;

import java.util.ArrayList;

public class ActSection extends Fragment {
    public ActSection() {}
    private Spinner acts;
    private RecyclerView firrecycler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.actsection, container, false);
        acts = view.findViewById(R.id.actsection_spinner);
        firrecycler = view.findViewById(R.id.firrecycler);

        ArrayList<String> list = new ArrayList<>();
        list.add("act1");
        list.add("act2");
        list.add("act3");
        list.add("act4");
        list.add("act5");
        list.add("act6");
        list.add("act7");
        list.add("act8");
        list.add("act10");
        list.add("act11");
        list.add("act12");
        list.add("act13");
        list.add("act14");
        list.add("act15");
        list.add("act16");

        ArrayAdapter<String>adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        acts.setAdapter(adapter);

        ArrayList<FirModel>firs = new ArrayList<>();

        firs.add(new FirModel("1","latur","shivaji chauk station","12312414"));
        firs.add(new FirModel("1","latur","shivaji chauk station","12312414"));
        firs.add(new FirModel("1","latur","shivaji chauk station","12312414"));
        firs.add(new FirModel("1","latur","shivaji chauk station","12312414"));
        firs.add(new FirModel("1","latur","shivaji chauk station","12312414"));
        firs.add(new FirModel("1","latur","shivaji chauk station","12312414"));
        firs.add(new FirModel("1","latur","shivaji chauk station","12312414"));
        firs.add(new FirModel("1","latur","shivaji chauk station","12312414"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        FirAdapter firAdapter = new FirAdapter(firs);
        firrecycler.setAdapter(firAdapter);
        firrecycler.setLayoutManager(layoutManager);

        return view;
    }
}