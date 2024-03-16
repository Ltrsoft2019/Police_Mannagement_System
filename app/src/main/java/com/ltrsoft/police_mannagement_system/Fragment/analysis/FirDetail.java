package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltrsoft.police_mannagement_system.R;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;

public class FirDetail extends Fragment {
    public FirDetail() {}
    private PieChart pieChart;
    private View view;
    private BarChart barChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fir_detail, container, false);
        pieChart = view.findViewById(R.id.detail_pie);
        barChart = view.findViewById(R.id.detail_fir_barchart);




        return view;
    }
}