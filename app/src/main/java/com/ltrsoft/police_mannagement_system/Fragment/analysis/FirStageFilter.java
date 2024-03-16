package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.R;

import org.eazegraph.lib.charts.PieChart;

public class FirStageFilter extends Fragment {
    View view ;
    private PieChart pieChart;
    private Spinner firstages;
    private RecyclerView fir_list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.firstage, container, false);
        //pieChart = view.findViewById(R.id.fir_stage_pie);
        //firstages = view.findViewById(R.id.stages_list);
        fir_list = view.findViewById(R.id.year_recycler);



        return view;
    }
}
