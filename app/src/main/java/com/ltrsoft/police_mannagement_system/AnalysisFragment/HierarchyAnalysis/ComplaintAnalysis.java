package com.ltrsoft.police_mannagement_system.AnalysisFragment.HierarchyAnalysis;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarEntry;
import com.ltrsoft.police_mannagement_system.Model.BargraphModelclass;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.Uigraph.Fourbargraph;

import java.util.ArrayList;

public class ComplaintAnalysis extends Fragment {


    public ComplaintAnalysis() {

     }
    BarChart barChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.complaint_analysis, container, false);
      barChart=view.findViewById(R.id.barchart);
        ArrayList<ArrayList<BarEntry>> entriesList = new ArrayList<>();
        entriesList.add(getBarEntriesOne());
        entriesList.add(getBarEntriesTwo());
        entriesList.add(getBarEntriesThree()); // Add more as needed
        entriesList.add(getBarEntriesfour()); // Add more as needed
         ArrayList<BargraphModelclass>list=new ArrayList<>();
         list.add(new BargraphModelclass("#FFF424"));
        list.add(new BargraphModelclass("#00B2E2"));
        list.add(new BargraphModelclass("#B3DD31"));
        list.add(new BargraphModelclass("#EA0075"));

        String[] xAxisLabels = new String[]{"jan", "feb", "march", "april", "may", "june", "julai","aug",
        "sep","oct","nov","dec"};

         Fourbargraph.setBarChart(entriesList, barChart, xAxisLabels,list);
    return view;
    }
    private ArrayList<BarEntry> getBarEntriesOne() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 4));
        entries.add(new BarEntry(2f, 6));
        entries.add(new BarEntry(3f, 8));
        entries.add(new BarEntry(4f, 2));
        entries.add(new BarEntry(5f, 4));

        entries.add(new BarEntry(6f, 1));
        entries.add(new BarEntry(7f, 1));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(9f, 1));
        entries.add(new BarEntry(10f, 18));
        entries.add(new BarEntry(11f, 1));
        entries.add(new BarEntry(13f, 10));
         return entries;
    }

    private ArrayList<BarEntry> getBarEntriesTwo() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(2f, 16));
        entries.add(new BarEntry(3f, 18));
        entries.add(new BarEntry(4f, 12));
        entries.add(new BarEntry(5f, 14));

        entries.add(new BarEntry(6f, 10));
        entries.add(new BarEntry(7f, 13));
        entries.add(new BarEntry(8f, 15));
        entries.add(new BarEntry(9f, 17));
        entries.add(new BarEntry(10f, 1));
        entries.add(new BarEntry(11f, 16
        ));
        entries.add(new BarEntry(12f, 10));
         return entries;
    }

    private ArrayList<BarEntry> getBarEntriesThree() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(2f, 5));
        entries.add(new BarEntry(3f, 11));
        entries.add(new BarEntry(4f, 12));
        entries.add(new BarEntry(5f, 4));

        entries.add(new BarEntry(6f, 11));
        entries.add(new BarEntry(6f, 11));
        entries.add(new BarEntry(8f, 18));
        entries.add(new BarEntry(11f, 19));
        entries.add(new BarEntry(12f, 10));
        entries.add(new BarEntry(14f, 10));
        entries.add(new BarEntry(15f, 1));
         return entries;
    }
    private ArrayList<BarEntry> getBarEntriesfour() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(2f, 7));
        entries.add(new BarEntry(3f, 8));
        entries.add(new BarEntry(4f, 2));
        entries.add(new BarEntry(5f, 4));

        entries.add(new BarEntry(6f, 4));
        entries.add(new BarEntry(6f, 14));
        entries.add(new BarEntry(8f, 15));
        entries.add(new BarEntry(11f, 8));
        entries.add(new BarEntry(12f, 7));
        entries.add(new BarEntry(14f, 11));
        entries.add(new BarEntry(15f, 10));
        return entries;
    }
}