package com.ltrsoft.police_mannagement_system.Fragment.analysis;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.data.Entry;
import com.ltrsoft.police_mannagement_system.R;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.List;

public class FirStageFilter extends Fragment {
    View view ;
    private PieChart pieChart;
    private Spinner firstages;
    private RecyclerView fir_list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.firstage, container, false);
        fir_list = view.findViewById(R.id.year_recycler);
        firstages = view.findViewById(R.id.spin_of_stage);
        pieChart = view.findViewById(R.id.stages_fir);

        setPie(12,23,34);

        return view;
    }
    private void setPie(int i, int i1, int i2) {
        pieChart.addPieSlice(
                new PieModel("Heinous", i, Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Non Heinous", 12,
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Total complaints", i1,
                        Color.parseColor("#EF5350")));
        pieChart.startAnimation();
    }
    public List<Entry> getEntries (){

        List<Entry>entries=new ArrayList<>();
        entries.add(new Entry(0f, 30f));
        entries.add(new Entry(1f, 20f));
        entries.add(new Entry(2f, 40f));
        entries.add(new Entry(3f, 50f));
        entries.add(new Entry(4f, 70f));
        entries.add(new Entry(5f, 90f));

        return entries;
    }
}
