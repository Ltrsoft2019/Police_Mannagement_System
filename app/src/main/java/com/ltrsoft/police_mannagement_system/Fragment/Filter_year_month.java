package com.ltrsoft.police_mannagement_system.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;


import com.ltrsoft.police_mannagement_system.Model.YearModel;
import com.ltrsoft.police_mannagement_system.R;
import com.ltrsoft.police_mannagement_system.adapters.YearAdapter;

import java.util.ArrayList;

public class Filter_year_month extends Fragment {
    public Filter_year_month() {
    }
    BarChart barChart;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.year, container, false);
        barChart = view.findViewById(R.id.barchart);
        recyclerView=view.findViewById(R.id.year_recycler);
        setBar();
        setrecycler();
        return view;
    }

    private void setrecycler() {
        ArrayList<YearModel>models = new ArrayList<>();
        models.add(new YearModel("2016","12344"));
        models.add(new YearModel("2017","1234654"));
        models.add(new YearModel("2018","1265344"));
        models.add(new YearModel("2019","12345544"));
        models.add(new YearModel("2020","1234544"));
        models.add(new YearModel("2021","1234794"));
        models.add(new YearModel("2022","12344"));
        models.add(new YearModel("2023","12344"));
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        YearAdapter adapter = new YearAdapter(models);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private void setBar() {
        BarModel barModel1 = new BarModel("2016", 10f, Color.parseColor("#3366FF"));
        BarModel barModel2 = new BarModel("2017", 20f, Color.parseColor("#3366FF"));
        BarModel barModel3 = new BarModel("2018", 30f, Color.parseColor("#00C853"));
        BarModel barModel4 = new BarModel("2019", 25f, Color.parseColor("#00C853"));
        BarModel barModel5 = new BarModel("2020", 23f, Color.parseColor("#AA66CC"));
        BarModel barModel6 = new BarModel("2021", 25f, Color.parseColor("#AA66CC"));
        BarModel barModel7 = new BarModel("2022", 100f, Color.parseColor("#AA66CC"));
        BarModel barModel8 = new BarModel("2023", 25f, Color.parseColor("#AA66CC"));
        BarModel barModel9 = new BarModel("2024", 105f, Color.parseColor("#AA66CC"));

        barChart.addBar(barModel1);

        barChart.addBar(barModel2);
        barChart.addBar(barModel3);
        barChart.addBar(barModel4);
        barChart.addBar(barModel5);
        barChart.addBar(barModel6);
        barChart.addBar(barModel7);
        barChart.addBar(barModel8);
        barChart.addBar(barModel9);
        barChart.setBarWidth(0.00000001f);
        barChart.setElevation(.2f);
        barChart.startAnimation();
    }

}
