package com.ltrsoft.police_mannagement_system.Fragment.analys;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ltrsoft.police_mannagement_system.R;

import org.eazegraph.lib.charts.PieChart;

public class PIAnalysis extends Fragment {
    private PieChart chart;
    private TextView male,female;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acp_layout, container, false);

        return view;
    }
}