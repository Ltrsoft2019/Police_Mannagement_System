package com.ltrsoft.police_mannagement_system.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.ltrsoft.police_mannagement_system.R;

import java.util.ArrayList;


public class Analysis1 extends Fragment {
    public Analysis1() {
    }
    private LineChart lineChart;
    private TextView totalAllotedComplaintsTextView;
    private TextView totalSolvedComplaintsTextView;
    private TextView totalFirTextView;
    private TextView totalInvestigationTextView;
    private TextView totalSolvedNumberTextView;
    private TextView totalFirNumberTextView;
    private TextView totalInvestigationNumberTextView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.main_analysis, container, false);
        totalAllotedComplaintsTextView = view.findViewById(R.id.total_Alloted_complaints);
        totalSolvedComplaintsTextView = view.findViewById(R.id.total_solved_complaints);
        totalFirTextView = view.findViewById(R.id.total_Fir);
        totalInvestigationTextView = view.findViewById(R.id.total_investigsation);
        totalSolvedNumberTextView = view.findViewById(R.id.total_solved_number);
        totalFirNumberTextView = view.findViewById(R.id.total_fir);
        totalInvestigationNumberTextView = view.findViewById(R.id.total_investigation_number);
        lineChart=view.findViewById(R.id.linechart);
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 10));
        entries.add(new Entry(1, 20));
        entries.add(new Entry(2, 15));
        entries.add(new Entry(3, 25));
        entries.add(new Entry(4, 30));

        // Create a dataset from the data
        LineDataSet dataSet = new LineDataSet(entries, "Sample Data");

        // Create a LineData object with the dataset
        LineData lineData = new LineData(dataSet);

        // Set data to the chart
        lineChart.setData(lineData);

        // Customize chart settings as needed
        lineChart.getDescription().setEnabled(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);

        // Refresh the chart
        lineChart.invalidate();


        return view;
    }
}