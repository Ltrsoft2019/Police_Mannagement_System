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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.police_mannagement_system.Model.FirModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.FirAdapter;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;

public class FirTypeFilter extends Fragment {
    private PieChart pieChart;
    private Spinner firtype;
    private RecyclerView firs;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firtypeyearvise, container, false);
        firs=view.findViewById(R.id.year_recycler);
        firtype=view.findViewById(R.id.fir_types);
        pieChart=view.findViewById(R.id.piechart);

        ArrayList<FirModel> list=new ArrayList<>();
        list.add(new FirModel("1","wer","rwer","rwer"));
        list.add(new FirModel("1","wer","rwer","rwer"));
        list.add(new FirModel("1","wer","rwer","rwer"));
        list.add(new FirModel("1","wer","rwer","rwer"));
        list.add(new FirModel("1","wer","rwer","rwer"));
        list.add(new FirModel("1","wer","rwer","rwer"));
        list.add(new FirModel("1","wer","rwer","rwer"));
        list.add(new FirModel("1","wer","rwer","rwer"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        FirAdapter firAdapter = new FirAdapter(list);
        firs.setAdapter(firAdapter);
        firs.setLayoutManager(layoutManager);

        setPie(12,23,45);

        return view;
    }
    private void setPie(int i, int i1, int i2) {
        pieChart.addPieSlice(
                new PieModel(
                        "Heinous", i, Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "Non Heinous", i1,
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "Total complaints", i2,
                        Color.parseColor("#EF5350")));
        pieChart.startAnimation();
    }
}
