package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.ltrsoft.police_mannagement_system.AnalysisFragment.analysis.MainAnalysis;
import com.ltrsoft.police_mannagement_system.Model.PiechartModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Piechartgraph;

import org.eazegraph.lib.charts.PieChart;

import java.util.ArrayList;

public class Analysis4 extends Fragment {

    public Analysis4() {
        // Required empty public constructor
    }
    private PieChart pieChart;
    private Spinner spinner;
    private LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.analysis4, container, false);
         pieChart=view.findViewById(R.id.piechart);
         spinner=view.findViewById(R.id.spinner);
         layout=view.findViewById(R.id.layout);
         //setspinner(spinner);
        ArrayList<PiechartModelclass>list=new ArrayList<>();
        list.add(new PiechartModelclass("Total Criminal",30,"#FFF424"));
        list.add(new PiechartModelclass("Total Warrant",20,"#00B2E2"));
        list.add(new PiechartModelclass("Total  Suspect",10,"#9467bd"));
        list.add(new PiechartModelclass("Total Victim",10,"#EA0075"));
        list.add(new PiechartModelclass("Total Witness",10,"#ff7f0e"));
        list.add(new PiechartModelclass("Evidance Collection",10,"#2ca02c"));
        Piechartgraph piechartgraph=new Piechartgraph(list,layout);
        piechartgraph.setpiewithoutcard(pieChart);
           return view;
    }
    private void setspinner(Spinner spinner) {
        ArrayList list1=new ArrayList();
        list1.add("2016");
        list1.add("2017");
        list1.add("2018");
        list1.add("2019");
        list1.add("2020");
        list1.add("2021");
        list1.add("2022");
        list1.add("2023");
        list1.add("2024");
        ArrayAdapter<String> adapter=new ArrayAdapter(getContext(), android.R.layout.simple_dropdown_item_1line,list1);
        spinner.setAdapter(adapter);
    }
}